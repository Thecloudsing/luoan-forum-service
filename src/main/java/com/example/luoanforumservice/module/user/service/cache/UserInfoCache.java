package com.example.luoanforumservice.module.user.service.cache;

import com.example.luoanforumservice.common.constant.RedisKey;
import com.example.luoanforumservice.common.service.cache.AbstractRedisStringCache;
import com.example.luoanforumservice.module.user.dao.UserInfoDao;
import com.example.luoanforumservice.module.user.domain.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Description: 用户基本信息的缓存
 * Author: luoan
 * Date: 2023-06-27
 */
@Component
public class UserInfoCache extends AbstractRedisStringCache<Long, UserInfo> {
    @Autowired
    private UserInfoDao userDao;

    @Override
    protected String getKey(Long uid) {
        return RedisKey.getKey(RedisKey.USER_INFO_STRING, uid);
    }

    @Override
    protected Long getExpireSeconds() {
        return 5 * 60L;
    }

    @Override
    protected Map<Long, UserInfo> load(List<Long> uidList) {
        List<UserInfo> needLoadUserList = userDao.listByIds(uidList);
        return needLoadUserList.stream().collect(Collectors.toMap(UserInfo::getId, Function.identity()));
    }
}
