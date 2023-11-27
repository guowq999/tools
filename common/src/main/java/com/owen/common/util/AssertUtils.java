package com.owen.common.util;

import com.owen.common.enums.ErrorCode;
import com.owen.common.exception.ApiException;

import java.text.MessageFormat;

/**
 * @author wenqiang
 * @date 2023/09/15 13:40
 **/
public class AssertUtils {
    public static void isNull(Object obj, String message) {
        if (obj == null) {
            throw new ApiException(ErrorCode.FAILED.getCode(), message);
        }
    }

    public static void isNull(String message, Object... objs) {
        if (objs == null) {
            throw new ApiException(ErrorCode.FAILED.getCode(), message);
        }
        for (Object obj : objs) {
            if (obj == null) {
                throw new ApiException(ErrorCode.FAILED.getCode(), message);
            }
        }
    }

    public static void isNull(Object obj, String str, Object... objs) {
        if (obj == null) {
            throw new ApiException(ErrorCode.FAILED.getCode(), MessageFormat.format(str, objs));
        }
    }

    public static void isTure(boolean expression, String message) {
        if (expression) {
            throw new ApiException(ErrorCode.FAILED.getCode(), message);
        }
    }

    public static void isFalse(boolean expression, String message) {
        if (!expression) {
            throw new ApiException(ErrorCode.FAILED.getCode(), message);
        }
    }

    public static void isTure(boolean expression, ErrorCode exception, String message) {
        if (expression) {
            throw new ApiException(exception.getCode(), message);
        }
    }

    public static void isFalse(boolean expression, ErrorCode exception, String message) {
        if (!expression) {
            throw new ApiException(exception.getCode(), message);
        }
    }
}