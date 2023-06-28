package com.example.luoanforumservice.common.config;

import com.example.luoanforumservice.common.interceptor.AuthorizationInterceptor;
import com.example.luoanforumservice.common.interceptor.BlackInterceptor;
import com.example.luoanforumservice.common.interceptor.CollectorInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description: 配置所有拦截器
 * Author: <a href="https://github.com/zongzibinbin">abin</a>
 * Date: 2023-04-05
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;
    @Autowired
    private CollectorInterceptor collectorInterceptor;
    @Autowired
    private BlackInterceptor blackInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor)
                .addPathPatterns("/capi/**");
        registry.addInterceptor(collectorInterceptor)
                .addPathPatterns("/capi/**");
        registry.addInterceptor(blackInterceptor)
                .addPathPatterns("/capi/**");
    }
}
