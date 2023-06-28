package com.example.luoanforumservice.common.interceptor;

import com.example.luoanforumservice.common.annotation.Authorization;
import com.example.luoanforumservice.common.constant.MDCKey;
import com.example.luoanforumservice.common.exception.HttpErrorEnum;
import com.example.luoanforumservice.common.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Optional;

/**
 * Description:
 * Author: luoan
 * Date: 2023/6/27
 */

@Order(-2)
@Slf4j
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String AUTHORIZATION_SCHEMA = "Bearer ";
    public static final String ATTRIBUTE_UID = "uid";
    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = getToken(request);
        Long validUid = tokenService.getValidUid(token);
        if (Objects.nonNull(validUid)) {//有登录态
            request.setAttribute(ATTRIBUTE_UID, validUid);
        } else if(notPublic(handler)) {//又没有登录态，又不是公开路径，直接401
            HttpErrorEnum.ACCESS_DENIED.sendHttpError(response);
        }
        MDC.put(MDCKey.UID, String.valueOf(validUid));
        return true;
    }

    /**
     * 判断是不是公共方法，可以未登录访问的
     *
     * @param handler 切面处理器
     * @return boolean
     */
    private boolean notPublic(Object handler) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(Authorization.class)) {
            Authorization annotation = method.getAnnotation(Authorization.class);
            //不是是公开路径
            return annotation.enableAuth();
        }
        return false;
    }

    private String getToken(HttpServletRequest request) {
        String header = request.getHeader(AUTHORIZATION_HEADER);
        return Optional.ofNullable(header)
                .filter(h -> h.startsWith(AUTHORIZATION_SCHEMA))
                .map(h -> h.substring(AUTHORIZATION_SCHEMA.length()))
                .orElse(null);
    }
}
