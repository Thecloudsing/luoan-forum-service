package com.example.luoanforumservice.common.exception;

import cn.hutool.http.ContentType;
import cn.hutool.json.JSONUtil;
import com.example.luoanforumservice.common.domain.vo.response.ApiResult;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Description: 业务校验异常码
 * Author: luoan
 * Date: 2023-06-27
 */
@AllArgsConstructor
@Getter
public enum HttpErrorEnum implements ErrorEnum {
    ACCESS_DENIED(401, "登录失效，请重新登录"),
    ;
    private Integer httpCode;
    private String msg;

    @Override
    public Integer getErrorCode() {
        return httpCode;
    }

    @Override
    public String getErrorMsg() {
        return msg;
    }

    public static final Charset UTF_8 = StandardCharsets.UTF_8;
    public void sendHttpError(HttpServletResponse response) throws IOException {
        response.setStatus(this.getErrorCode());
        ApiResult responseData = ApiResult.fail(this);
        response.setContentType(ContentType.JSON.toString(UTF_8));
        response.getWriter().write(JSONUtil.toJsonStr(responseData));
    }
}
