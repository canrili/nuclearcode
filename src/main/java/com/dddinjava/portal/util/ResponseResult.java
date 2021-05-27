package com.dddinjava.portal.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhaox
 */
@Getter
@Setter
@ToString
public class ResponseResult {

    private String code;
    private String message;
    private Object data;

    private ResponseResult() {
    }

    public ResponseResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
