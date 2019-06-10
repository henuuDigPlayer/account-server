package com.lindj.boot.util;

/**
 * @author lindj
 * @date 2019/5/29 0029
 * @description
 */
public class BusinessException extends RuntimeException {


    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException() {
        super();
    }
}
