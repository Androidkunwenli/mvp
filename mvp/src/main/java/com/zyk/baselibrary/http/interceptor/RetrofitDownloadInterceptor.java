package com.zyk.baselibrary.http.interceptor;


import com.zyk.baselibrary.http.listener.RetrofitDownloadListener;
import com.zyk.baselibrary.http.responsebody.RetrofitResponseBody;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @Author: KK
 * @时间: 2020/4/10 9:13
 * @描述: 下载拦截器
 */
public class RetrofitDownloadInterceptor implements Interceptor {

    private RetrofitDownloadListener downloadListener;

    public RetrofitDownloadInterceptor(RetrofitDownloadListener downloadListener) {
        this.downloadListener = downloadListener;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        return response.newBuilder().body(
                new RetrofitResponseBody(response.body(), downloadListener)).build();
    }
}
