package com.owen.common.exception;

import com.owen.common.enums.ErrorCode;
import lombok.Getter;

/**
 * @author wenqiang
 * @date 2023/09/15 13:41
 **/
@Getter
public class ApiException extends RuntimeException {
    private static final long serialVersionUID = 2793490843413553866L;


    private Object data;
    private final int code;
    private final String msg;

    public ApiException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public ApiException(String msg) {
        this(ErrorCode.SYS_ERROR.getCode(), msg);
    }

    public ApiException(int code, String msg,Object data) {
        super(msg);
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}