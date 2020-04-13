package com.zyk.baselibrary.http;

public class BaseResponse<T> {
    private int error_code;
    private String reason;
    private T result;

    public int getCode() {
        return error_code;
    }

    public void setCode(int error_code) {
        this.error_code = error_code;
    }

    public String getMessage() {
        return reason;
    }

    public void setMessage(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
