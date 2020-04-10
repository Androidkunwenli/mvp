package com.zyk.baselibrary.http.exception;

import android.net.ParseException;

import com.google.gson.JsonParseException;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

import java.net.ConnectException;

import retrofit2.HttpException;

/**
 * @Author: KK
 * @时间: 2020/4/10 9:18
 * @描述: 异常管理类
 */
public class ExceptionHandler {

    public static ResponseException handle(Throwable e) {
        ResponseException responseException;
        if (e instanceof ApiException) {
            ApiException apiException = (ApiException) e;
            responseException = new ResponseException(apiException, apiException.getErrorCode(), apiException.getMessage());
        } else if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            switch (httpException.code()) {
                case Code.UNAUTHORIZED:
                case Code.FORBIDDEN:
                case Code.NOT_FOUND:
                case Code.REQUEST_TIMEOUT:
                case Code.GATEWAY_TIMEOUT:
                case Code.INTERNAL_SERVER_ERROR:
                case Code.BAD_GATEWAY:
                case Code.SERVICE_UNAVAILABLE:
                default:
                    responseException = new ResponseException(e, Code.HTTP_ERROR + ":" + httpException.code(), "网络连接错误");
                    break;
            }
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            responseException = new ResponseException(e, Code.PARSE_ERROR, "解析错误");
        } else if (e instanceof ConnectException) {
            responseException = new ResponseException(e, Code.NET_ERROR, "连接失败");
        } else if (e instanceof ConnectTimeoutException || e instanceof java.net.SocketTimeoutException) {
            responseException = new ResponseException(e, Code.TIMEOUT_ERROR, "网络连接超时");
        } else if (e instanceof javax.net.ssl.SSLHandshakeException) {
            responseException = new ResponseException(e, Code.SSL_ERROR, "证书验证失败");
        } else {
            responseException = new ResponseException(e, Code.UNKNOWN_ERROR, "未知错误");
        }
        return responseException;
    }
}
