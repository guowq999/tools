package com.owen.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wenqiang
 * @date 2023/09/15 13:42
 **/
@AllArgsConstructor
@Getter
public enum ErrorCode {
    TOKEN_CODE(100, "需要重新登录"),

    TOKEN_CODE_EXPIRE(101, "token已过期"),

    AUTH_ERROR(401, "认证失败"),

    SYS_ERROR(500, "系统错误"),

    PARAM_ERROR(400,"参数错误"),

    NO_DATA_ERROR(404, "未找到资源"),

    UNKNOWN_ERROR(499, "未知错误"),

    //要弹窗形式返回错误信息的，都使用303
    CANCEL_FAIL(303, "作废失败"),

    LOCK_FAIL(501, "加锁失败"),
    FAILED(601,"操作失败");

    private final int code;

    private final String message;
}