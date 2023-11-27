package com.example.springboot_demo.controller;

import com.owen.common.core.Result;
import com.owen.common.core.log.LOG;
import com.owen.common.enums.ErrorCode;
import com.owen.common.exception.ApiException;
import com.owen.common.exception.ValidateException;
import com.owen.common.util.ReqUtil;
import com.owen.common.util.RequestUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 全局异常处理
 *
 * @author wenqiang
 * @date 2023/09/16 10:43
 **/
@RestControllerAdvice
public class ExceptionHandlerController {

    @Value("${spring.profiles.active}")
    private String env;

    public Result<?> handleOtherException(Exception e, HttpServletRequest request) {
        BindingResult bindingResult = getBindingResult(e);
        if (bindingResult != null) {
            String message = bindingResult.getAllErrors()
                    .stream()
                    .map(objectError ->{
                        LOG.error("字段{}，为空",getField(objectError) );
                        return objectError.getDefaultMessage();
                    })
                    .collect(Collectors.joining("、"));
        }
        if (e instanceof IllegalArgumentException || e instanceof IllegalStateException) {
            LOG.warn("arg error", e);
            return Result.error(ErrorCode.PARAM_ERROR.getCode(), e.getMessage());
        }
        if (e instanceof ValidateException) {
            ValidateException exception = (ValidateException) e;
            String message = String.join("、", exception.getMessages());
            return Result.error(ErrorCode.PARAM_ERROR.getCode(), message);
        }
        if (e instanceof ApiException) {
            ApiException exception = (ApiException) e;
            if (Objects.nonNull(exception.getData())) {
                return Result.error(exception.getCode(), exception.getMsg(),exception.getData());
            }
            return Result.error(exception.getCode(), exception.getMsg());
        }
        String ip = RequestUtil.getIp(request);
        String msg =
                "\n----------------请求信息-----------------" +
                        "\nIP:" + ip +
                        "\ncurl命令:\n" + ReqUtil.getCurl(request) +
                        "\n----------------------------------------";
        LOG.error("未知错误：{}", msg, e);
        return Result.error(ErrorCode.SYS_ERROR.getCode(), e.getMessage());
    }

    private static String getField(ObjectError objectError) {
        Object[] arguments = objectError.getArguments();
        if (ArrayUtils.isEmpty(arguments)) {
            return "";
        }
        Object argument = arguments[0];
        if (argument instanceof DefaultMessageSourceResolvable) {
            DefaultMessageSourceResolvable arg = (DefaultMessageSourceResolvable) argument;
            return arg.getDefaultMessage();
        } else {
            return String.valueOf(argument);
        }
    }

    private BindingResult getBindingResult(Exception e) {
        if (e instanceof BindException) {
            return ((BindException) e).getBindingResult();
        }
        if (e instanceof MethodArgumentNotValidException) {
            return ((MethodArgumentNotValidException) e).getBindingResult();
        }
        return null;
    }

}