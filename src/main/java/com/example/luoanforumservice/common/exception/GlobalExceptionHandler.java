package com.example.luoanforumservice.common.exception;


import com.example.luoanforumservice.common.domain.vo.response.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * validation参数校验异常
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ApiResult methodArgumentNotValidExceptionExceptionHandler(MethodArgumentNotValidException e) {
        StringBuilder errorMsg = new StringBuilder();
        e.getBindingResult().getFieldErrors().forEach(x -> errorMsg.append(x.getField()).append(x.getDefaultMessage()).append(","));
        String message = errorMsg.toString();
        log.info("validation parameters error！The reason is:{}", message);
        return ApiResult.fail(-1, message.substring(0, message.length() - 1));
    }

    /**
     * validation参数校验异常
     */
    @ExceptionHandler(value = BindException.class)
    public ApiResult bindException(BindException e) {
        StringBuilder errorMsg = new StringBuilder();
        e.getBindingResult().getFieldErrors().forEach(x -> errorMsg.append(x.getField()).append(x.getDefaultMessage()).append(","));
        String message = errorMsg.toString();
        log.info("validation parameters error！The reason is:{}", message);
        return ApiResult.fail(-1, message.substring(0, message.length() - 1));
    }

    /**
     * 处理空指针的异常
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ApiResult exceptionHandler(NullPointerException e) {
        log.error("null point exception！The reason is:{}", e.getMessage(), e);
        return ApiResult.fail(CommonErrorEnum.SYSTEM_ERROR);
    }

    /**
     * 未知异常
     */
    @ExceptionHandler(value = Exception.class)
    public ApiResult systemExceptionHandler(Exception e) {
        log.error("system exception！The reason is：{}", e.getMessage(), e);
        return ApiResult.fail(CommonErrorEnum.SYSTEM_ERROR);
    }

    /**
     * 自定义校验异常（如参数校验等）
     */
    @ExceptionHandler(value = BusinessException.class)
    public ApiResult businessExceptionHandler(BusinessException e) {
        log.info("business exception！The reason is：{}", e.getMessage(), e);
        return ApiResult.fail(e.getErrorCode(), e.getMessage());
    }

    /**
     * 请求方式异常
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ApiResult httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e) {
        log.info("request method exception! The reason is: {}", e.getMessage());
        return ApiResult.fail(CommonErrorEnum.REQUEST_METHOD);
    }

    /**
     *  HttpMessageNotReadableException
     *  请求体RequestBody null异常
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ApiResult httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
        log.info("request body exception! The reason is: {}", e.getMessage());
        return ApiResult.fail(CommonErrorEnum.REQUEST_BODY);
    }

    /**
     * MaxUploadSizeExceededException
     * 上传文件大小超过限制
     */
    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
    public ApiResult maxUploadSizeExceededExceptionHandler(MaxUploadSizeExceededException e) {
        log.info("max upload size exception! The reason is: {}", e.getMessage());
        return ApiResult.fail(CommonErrorEnum.MAX_UPLOAD_SIZE);
    }
}