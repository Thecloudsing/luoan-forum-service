package com.example.luoanforumservice.common.interceptor;

import com.example.luoanforumservice.common.constant.MDCKey;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.io.IOException;
import java.util.UUID;

/**
 * Description: 设置链路追踪的值，初期单体项目先简单用
 * Author: luoan
 * Date: 2023-06-27
 */
@Slf4j
@WebFilter(urlPatterns = "/*")
public class HttpTraceIdFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String tid = UUID.randomUUID().toString();
        MDC.put(MDCKey.TID, tid);
        chain.doFilter(request, response);
    }

}
