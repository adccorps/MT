package com.mt.exception;

import com.mt.constants.Code;


/**
 * 自定义runtime异常
 */
public class ResultException extends RuntimeException {
    private static final long serialVersionUID = 1L;

     private String msg ;
    private int code ;

    public ResultException(Code code) {
        super(code.msg);
        this.msg = code.msg;
        this.code = code.code;
    }

    public ResultException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public ResultException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    @Deprecated
    public ResultException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    @Deprecated
    public ResultException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

}
