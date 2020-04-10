package com.zyk.http.main;


import com.zyk.baselibrary.http.BaseResponse;
import com.zyk.http.activity.bean.JournalismBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WanAndroidApis {
    @GET("getJoke")
    Observable<BaseResponse<List<JournalismBean>>> getJoke(@Query("page") int page, @Query("count") int count, @Query("type") String type);
}
