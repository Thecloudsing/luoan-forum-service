package com.example.luoanforumservice.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Description: 通用异常码
 * Author: luoan
 * Date: 2023-06-27
 */
@AllArgsConstructor
@Getter
public enum CommonErrorEnum implements ErrorEnum {

    SYSTEM_ERROR(-1, "系统出小差了，请稍后再试哦~~"),
    PARAM_VALID(-2, "参数校验失败"),
    FREQUENCY_LIMIT(-3, "请求太频繁了，请稍后再试哦~~"),
    LOCK_LIMIT(-4, "请求太频繁了，请稍后再试哦~~"),
    REQUEST_METHOD(-5, "请求方式出错，请换个方式重试"),
    REQUEST_BODY(-6, "请求体找不到"),
    MAX_UPLOAD_SIZE(-7, "上传文件大小超过最大限制")
    ;
    private final Integer code;
    private final String msg;

    @Override
    public Integer getErrorCode() {
        return this.code;
    }

    @Override
    public String getErrorMsg() {
        return this.msg;
    }
}
