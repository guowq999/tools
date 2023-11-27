package com.owen.common.core;

import java.io.Serializable;

/**
 * 用于返回ajax json/jsonb对象给前端，实际返回数据放入wrapper中。
 *
 * @author wenqiang
 * @date 2023/09/16 10:48
 **/
public final class Result<T> implements Serializable {

    private static final long serialVersionUID = 266696159469987136L;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public static Result ok() {
        Result result = new Result();
        return result;
    }

    public static <T> Result<T> ok(T obj) {
        Result result = new Result(obj);
        return result;
    }

    public static <T> Result<T> ok(int successCode,T obj) {
        Result result = new Result(obj);
        result.code = successCode;
        return result;
    }

    public static <T> Result<T> ok(T obj, String message) {
        Result result = new Result(obj);
        result.message = message;
        return result;
    }

    public static Result error(int errorCode, String message) {
        Result result = new Result();
        result.code = errorCode;
        result.message = message;
        return result;
    }

    public static Result error(int errorCode, String message ,Object data) {
        Result result = new Result();
        result.code = errorCode;
        result.message = message;
        result.data = data;
        return result;
    }

    /**
     * 返回的状态或错误码，0代表成功, 其他非0的都是失败；
     *
     * @mock 0
     */
    private int code = 0;


    /**
     * 失败情况下返回失败的原因
     *
     * @mock success
     */
    private String message;


    /**
     * 实际返回的数据实体
     */
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}