package com.example.luoanforumservice.module.user.service.cache;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Pair;
import com.example.luoanforumservice.common.constant.RedisKey;
import com.example.luoanforumservice.common.domain.vo.request.CursorPageBaseReq;
import com.example.luoanforumservice.common.domain.vo.response.CursorPageBaseResp;
import com.example.luoanforumservice.common.utils.CursorUtils;
import com.example.luoanforumservice.common.utils.RedisUtils;
import com.example.luoanforumservice.module.user.dao.BlackDao;
import com.example.luoanforumservice.module.user.dao.RoleDao;
import com.example.luoanforumservice.module.user.dao.UserInfoDao;
import com.example.luoanforumservice.module.user.dao.UserRoleDao;
import com.example.luoanforumservice.module.user.domain.entity.Black;
import com.example.luoanforumservice.module.user.domain.entity.UserInfo;
import com.example.luoanforumservice.module.user.domain.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Description: 用户相关缓存
 * Author: luoan
 * Date: 2023-06-27
 */
@Component
public class UserCache {

    @Autowired
    private CursorUtils cursorUtils;
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private BlackDao blackDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserRoleDao userRoleDao;

    public Long getOnlineNum() {
        String onlineKey = RedisKey.getKey(RedisKey.ONLINE_UID_ZET);
        return RedisUtils.zCard(onlineKey);
    }

    public Long getOfflineNum() {
        String offlineKey = RedisKey.getKey(RedisKey.OFFLINE_UID_ZET);
        return RedisUtils.zCard(offlineKey);
    }

    //移除用户
    public void remove(Long uid) {
        String onlineKey = RedisKey.getKey(RedisKey.ONLINE_UID_ZET);
        String offlineKey = RedisKey.getKey(RedisKey.OFFLINE_UID_ZET);
        //移除离线表
        RedisUtils.zRemove(offlineKey, uid);
        //移除上线表
        RedisUtils.zRemove(onlineKey, uid);
    }

    //用户上线
    public void online(Long uid, Date optTime) {
        String onlineKey = RedisKey.getKey(RedisKey.ONLINE_UID_ZET);
        String offlineKey = RedisKey.getKey(RedisKey.OFFLINE_UID_ZET);
        //移除离线表
        RedisUtils.zRemove(offlineKey, uid);
        //更新上线表
        RedisUtils.zAdd(onlineKey, uid, optTime.getTime());
    }

    public boolean isOnline(Long uid) {
        String onlineKey = RedisKey.getKey(RedisKey.ONLINE_UID_ZET);
        return RedisUtils.zIsMember(onlineKey, uid);
    }

    //用户下线
    public void offline(Long uid, Date optTime) {
        String onlineKey = RedisKey.getKey(RedisKey.ONLINE_UID_ZET);
        String offlineKey = RedisKey.getKey(RedisKey.OFFLINE_UID_ZET);
        //移除上线线表
        RedisUtils.zRemove(onlineKey, uid);
        //更新上线表
        RedisUtils.zAdd(offlineKey, uid, optTime.getTime());
    }

    public CursorPageBaseResp<Pair<Long, Double>> getOnlineCursorPage(CursorPageBaseReq pageBaseReq) {
        return cursorUtils.getCursorPageByRedis(pageBaseReq, RedisKey.getKey(RedisKey.ONLINE_UID_ZET), Long::parseLong);
    }

    public CursorPageBaseResp<Pair<Long, Double>> getOfflineCursorPage(CursorPageBaseReq pageBaseReq) {
        return cursorUtils.getCursorPageByRedis(pageBaseReq, RedisKey.getKey(RedisKey.OFFLINE_UID_ZET), Long::parseLong);
    }

    public List<Long> getUserModifyTime(List<Long> uidList) {
        List<String> keys = uidList.stream().map(uid -> RedisKey.getKey(RedisKey.USER_MODIFY_STRING, uid)).collect(Collectors.toList());
        return RedisUtils.mget(keys, Long.class);
    }

    public void refreshUserModifyTime(Long uid) {
        String key = RedisKey.getKey(RedisKey.USER_MODIFY_STRING, uid);
        RedisUtils.set(key, new Date().getTime());
    }

    /**
     * 获取用户信息，盘路缓存模式
     */
    public UserInfo getUserInfo(Long uid) {//todo 后期做二级缓存
        return getUserInfoBatch(Collections.singleton(uid)).get(uid);
    }

    /**
     * 获取用户信息，盘路缓存模式
     */
    public Map<Long, UserInfo> getUserInfoBatch(Set<Long> uids) {
        List<String> keys = uids.stream().map(a -> RedisKey.getKey(RedisKey.USER_INFO_STRING, a)).collect(Collectors.toList());
        List<UserInfo> mget = RedisUtils.mget(keys, UserInfo.class);
        Map<Long, UserInfo> map = mget.stream().filter(Objects::nonNull).collect(Collectors.toMap(UserInfo::getId, Function.identity()));
        //还需要load更新的uid
        List<Long> needLoadUidList = uids.stream().filter(a -> !map.containsKey(a)).collect(Collectors.toList());
        if (CollUtil.isNotEmpty(needLoadUidList)) {
            List<UserInfo> needLoadUserList = userInfoDao.listByIds(needLoadUidList);
            Map<String, UserInfo> redisMap = needLoadUserList.stream().collect(Collectors.toMap(a -> RedisKey.getKey(RedisKey.USER_INFO_STRING, a.getId()), Function.identity()));
            RedisUtils.mset(redisMap, 5 * 60);
            map.putAll(needLoadUserList.stream().collect(Collectors.toMap(UserInfo::getId, Function.identity())));
        }
        return map;
    }

    public void userInfoChange(Long uid) {
        delUserInfo(uid);
        refreshUserModifyTime(uid);
    }

    public void delUserInfo(Long uid) {
        String key = RedisKey.getKey(RedisKey.USER_INFO_STRING, uid);
        RedisUtils.del(key);
    }

    @Cacheable(cacheNames = "user", key = "'blackList'")
    public Map<Integer, Set<String>> getBlackMap() {
        Map<Integer, List<Black>> collect = blackDao.list().stream().collect(Collectors.groupingBy(Black::getType));
        Map<Integer, Set<String>> result = new HashMap<>(collect.size());
        for (Map.Entry<Integer, List<Black>> entry : collect.entrySet()) {
            result.put(entry.getKey(), entry.getValue().stream().map(Black::getTarget).collect(Collectors.toSet()));
        }
        return result;
    }

    @CacheEvict(cacheNames = "user", key = "'blackList'")
    public Map<Integer, Set<String>> evictBlackMap() {
        return null;
    }

    @Cacheable(cacheNames = "user", key = "'roles'+#uid")
    public Set<Long> getRoleSet(Long uid) {
        List<UserRole> userRoles = userRoleDao.listByUid(uid);
        return userRoles.stream()
                .map(UserRole::getRoleId)
                .collect(Collectors.toSet());
    }
}