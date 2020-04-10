package com.zyk.baselibrary.http.listener;

/**
 * @Author: KK
 * @时间: 2020/4/10 9:14
 * @描述: 下载监听
 */
public interface RetrofitDownloadListener {

    void onStartDownload();

    void onProgress(int progress);

    void onFinishDownload();

    void onFail(String errorInfo);
}
