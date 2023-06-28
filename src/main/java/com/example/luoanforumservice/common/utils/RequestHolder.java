package com.example.luoanforumservice.common.utils;


import com.example.luoanforumservice.common.domain.dto.RequestInfo;

/**
 * Description: 请求上下文
 * Author: luoan
 * Date: 2023-06-27
 */
public class RequestHolder {

    private static final ThreadLocal<RequestInfo> threadLocal = new ThreadLocal<>();

    public static void set(RequestInfo requestInfo) {
        threadLocal.set(requestInfo);
    }

    public static RequestInfo get() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }
}
