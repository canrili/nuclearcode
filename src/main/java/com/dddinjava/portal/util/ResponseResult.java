package com.dddinjava.portal.util;

import lombok.*;

import java.io.Serializable;

/**
 * 返回类
 * @author zhaox
 */
@Getter
@ToString
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 5575757166198807319L;
    /**
     * code：true 操作功能, false 操作失败
     */
    @NonNull
    private Boolean code;

    /**
     * 消息
     */
    @NonNull
    private String message;

    /**
     * 数据
     */
    private T data;

    /**
     * 全参数
     * @param code
     * @param message
     * @param data
     */
    public ResponseResult(@NonNull Boolean code, @NonNull String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     *
     * 成功
     * @param message
     * @param data
     */
    public ResponseResult(@NonNull String message, T data) {
        this.code = true;
        this.message = message;
        this.data = data;
    }

    /**
     * 失败
     * @param message
     */
    public ResponseResult(@NonNull String message) {
        this.code = false;
        this.message = message;
    }
}
