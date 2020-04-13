package com.zyk.http.main;


import com.zyk.baselibrary.http.BaseResponse;
import com.zyk.http.activity.main.bean.GetWeatherBean;
import com.zyk.http.activity.main.bean.JokeBean;
import com.zyk.http.activity.main.bean.JournalismBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WanAndroidApis {
    @GET("getJoke")
    Observable<BaseResponse<List<JournalismBean>>> getJoke(@Query("page") int page, @Query("count") int count, @Query("type") String type);

    @POST("getWeather")
    @FormUrlEncoded
    Observable<BaseResponse<GetWeatherBean>> getWeather(@Field("city") String city);

    @GET("joke/randJoke.php")
    Observable<BaseResponse<ArrayList<JokeBean>>> getJoke(@Query("key") String key);
}
