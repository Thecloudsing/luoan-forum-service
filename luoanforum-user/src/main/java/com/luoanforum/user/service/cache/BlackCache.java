package com.luoanforum.user.service.cache;

import com.luoanforum.user.dao.IBlackDao;
import com.luoanforum.user.dao.IUserBlackDao;
import com.luoanforum.user.domain.entity.Black;
import com.luoanforum.user.domain.entity.UserBlack;
import com.luoanforum.user.domain.enums.BlackStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class BlackCache {
    /**
     * 黑名单dao
     */
    @Autowired
    private IBlackDao blackDao;
    /**
     * 用户黑名单dao
     */
    @Autowired
    private IUserBlackDao userBlackDao;

    /**
     * 获取黑名单缓存
     * @return Map<Integer, Set<String>>
     */
    @Cacheable(cacheNames = "black", key = "'blacklist'")
    public Map<Integer, Set<String>> getBlackMap() {
        return blackDao.list().stream()
                .filter(black -> BlackStatusEnum.of(black.getStatus()) == BlackStatusEnum.BLACK)
                .collect(Collectors.groupingBy(Black::getType))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue().stream().map(Black::getTarget).collect(Collectors.toSet())));
    }

    /**
     * 清除黑名单缓存
     * @return null
     */
    @CacheEvict(cacheNames = "black", key = "'blacklist'")
    public Map<Integer, Set<String>> evictBlackMap() {
        return null;
    }

    /**
     * 获取用户黑名单缓存
     * @param uid 用户id
     * @return Map<Integer, Set<String>>
     */
    @Cacheable(cacheNames = "black", key = "'userBlacklist'+#uid")
    public Map<Integer, Set<String>> getUserBlack(Integer uid) {
       return userBlackDao.list().stream()
                .filter(userBlack -> BlackStatusEnum.of(userBlack.getStatus()) == BlackStatusEnum.BLACK)
                .filter(userBlack -> Objects.equals(userBlack.getUid(), uid))
                .collect(Collectors.groupingBy(UserBlack::getType))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue().stream().map(UserBlack::getTarget).collect(Collectors.toSet())));
    }

    /**
     * 清除用户黑名单缓存
     * @param uid 用户id
     * @return null
     */
    @CacheEvict(cacheNames = "black", key = "'userBlacklist'+#uid")
    public Map<Integer, Set<String>> evictUserBlack(Integer uid) {
        return null;
    }
}
