package com.example.luoanforumservice.common.service.Impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.example.luoanforumservice.common.constant.RedisKey;
import com.example.luoanforumservice.common.service.TokenService;
import com.example.luoanforumservice.common.utils.JwtUtils;
import com.example.luoanforumservice.common.utils.OtherUtils;
import com.example.luoanforumservice.common.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Description: token服务类实现
 * Author: luoan
 * Date: 2023/6/27
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private JwtUtils jwtUtils;
    //token过期时间
    private static final Integer TOKEN_EXPIRE_DAYS;
    //token续期时间
    private static final Integer TOKEN_RENEWAL_DAYS;

    static {
        TOKEN_EXPIRE_DAYS = OtherUtils.posteriorPathway(Integer.valueOf(SpringUtil.getProperty("token.default_expire_days")), 5, Integer.class);
        TOKEN_RENEWAL_DAYS = OtherUtils.posteriorPathway(Integer.valueOf(SpringUtil.getProperty("token.default_renewal_days")), 2, Integer.class);
    }

    /**
     * 校验token是不是有效
     *
     * @param token
     * @return
     */
    @Override
    public boolean verify(String token) {
        Long uid = jwtUtils.getUidOrNull(token);
        if (Objects.isNull(uid)) {
            return false;
        }
        String key = RedisKey.getKey(RedisKey.USER_TOKEN_STRING, uid);
        String realToken = RedisUtils.getStr(key);
        return Objects.equals(token, realToken);//有可能token失效了，需要校验是不是和最新token一致
    }

    @Async
    @Override
    public void renewalTokenIfNecessary(String token) {
        Long uid = jwtUtils.getUidOrNull(token);
        if (Objects.isNull(uid)) {
            return;
        }
        String key = RedisKey.getKey(RedisKey.USER_TOKEN_STRING, uid);
        long expireDays = RedisUtils.getExpire(key, TimeUnit.DAYS);
        if (expireDays == -2) {//不存在的key
            return;
        }
        if (expireDays < TOKEN_RENEWAL_DAYS) {//小于一天的token帮忙续期
            RedisUtils.expire(key, TOKEN_EXPIRE_DAYS, TimeUnit.DAYS);
        }
    }

    @Override
    public String login(Long uid) {
        String key = RedisKey.getKey(RedisKey.USER_TOKEN_STRING, uid);
        String token = RedisUtils.getStr(key);
        if (StrUtil.isNotBlank(token)) {
            return token;
        }
        //获取用户token
        token = jwtUtils.createToken(uid);
        RedisUtils.set(key, token, TOKEN_EXPIRE_DAYS, TimeUnit.DAYS);//token过期用redis中心化控制，初期采用5天过期，剩1天自动续期的方案。后续可以用双token实现
        return token;
    }

    @Override
    public Long getValidUid(String token) {
        boolean verify = verify(token);
        return verify ? jwtUtils.getUidOrNull(token) : null;
    }
}
