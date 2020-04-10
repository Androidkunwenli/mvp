package com.zyk.baselibrary.http.exception;

/**
*@Author: KK
*@时间:   2020/4/10 9:18
*@描述:   自定义的接口异常类
*/
public class ApiException extends RuntimeException {

    private int errorCode;

    public ApiException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
