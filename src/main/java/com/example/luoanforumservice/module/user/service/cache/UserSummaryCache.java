package com.example.luoanforumservice.module.user.service.cache;

//import com.abin.mallchat.common.common.constant.RedisKey;
//import com.abin.mallchat.common.common.service.cache.AbstractRedisStringCache;
//import com.abin.mallchat.common.user.dao.UserBackpackDao;
//import com.abin.mallchat.common.user.domain.dto.SummeryInfoDTO;
//import com.abin.mallchat.common.user.domain.entity.*;
//import com.abin.mallchat.common.user.domain.enums.ItemTypeEnum;
//import com.example.luoanforumservice.module.user.domain.entity.UserInfo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.*;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
///**
// * Description: 用户所有信息的缓存
// * Author: luoan
// * Date: 2023-06-27
// */
//@Component
//public class UserSummaryCache extends AbstractRedisStringCache<Long, SummeryInfoDTO> {
//    @Autowired
//    private UserInfoCache userInfoCache;
//    @Override
//    protected String getKey(Long uid) {
//        return RedisKey.getKey(RedisKey.USER_SUMMARY_STRING, uid);
//    }
//
//    @Override
//    protected Long getExpireSeconds() {
//        return 10 * 60L;
//    }
//
//    @Override
//    protected Map<Long, SummeryInfoDTO> load(List<Long> uidList) {//后续可优化徽章信息也异步加载
//        //用户基本信息
//        Map<Long, User> userMap = userInfoCache.getBatch(uidList);
//        Map<Long, List<UserBackpack>> userBadgeMap = backpacks.stream().collect(Collectors.groupingBy(UserBackpack::getUid));
//        //用户最后一次更新时间
//        return uidList.stream().map(uid -> {
//            SummeryInfoDTO summeryInfoDTO = new SummeryInfoDTO();
//            UserInfo userInfo = userMap.get(uid);
//            if (Objects.isNull(userInfo)) {
//                return null;
//            }
//            List<UserBackpack> userBackpacks = userBadgeMap.getOrDefault(user.getId(), new ArrayList<>());
//            summeryInfoDTO.setUid(userInfo.getId());
//            summeryInfoDTO.setName(userInfo.getName());
//            summeryInfoDTO.setAvatar(userInfo.getAvatar());
//            summeryInfoDTO.setLocPlace(Optional.ofNullable(userInfo.getIpInfo()).map(IpInfo::getUpdateIpDetail).map(IpDetail::getCity).orElse(null));
//            summeryInfoDTO.setWearingItemId(userInfo.getItemId());
//            summeryInfoDTO.setItemIds(userBackpacks.stream().map(UserBackpack::getItemId).collect(Collectors.toList()));
//            return summeryInfoDTO;
//        })
//                .filter(Objects::nonNull)
//                .collect(Collectors.toMap(SummeryInfoDTO::getUid, Function.identity()));
//    }
//}
