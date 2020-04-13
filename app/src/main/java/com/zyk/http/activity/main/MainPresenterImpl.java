package com.zyk.http.activity.main;

import com.zyk.baselibrary.http.observer.BaseObserver;
import com.zyk.baselibrary.presenter.BasePresenter;
import com.zyk.baselibrary.http.exception.ResponseException;
import com.zyk.baselibrary.http.RetrofitManager;
import com.zyk.baselibrary.http.RequestManager;
import com.zyk.http.activity.main.bean.GetWeatherBean;
import com.zyk.http.activity.main.bean.JokeBean;
import com.zyk.http.activity.main.bean.JournalismBean;
import com.zyk.http.activity.main.bean.TwoBean;
import com.zyk.http.main.WanAndroidApis;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: KK
 * @时间: 2020/4/10 15:08
 * @描述: 请求接口 和请求两个接口实例
 */
public class MainPresenterImpl extends BasePresenter<MainContract.View> implements MainContract.Presenter {
    public MainPresenterImpl(MainContract.View view) {
        super(view);
    }

    public void getJournalismData(int page, int count, String type) {
        RequestManager.getInstance().execute(this,
                RetrofitManager.getInstance().create(WanAndroidApis.class).getJoke(page, count, type),
                new BaseObserver<List<JournalismBean>>(true) {
                    @Override
                    protected void onSuccess(List<JournalismBean> data) {
                        view.onFriendSuccess(data);
                    }

                    @Override
                    protected void onError(ResponseException e) {
                        view.onFriendError(e);
                    }
                });
    }

    @Override
    public void getTwoData(int page, int count, String type) {
        RequestManager.getInstance().zipExecute(this,
                RetrofitManager.getInstance().create(WanAndroidApis.class).getJoke(page, count, type),
                RetrofitManager.getInstance().create(WanAndroidApis.class).getJoke(page, count, type),
                (baseResponse, baseResponse1) -> new TwoBean(baseResponse.getResult(), baseResponse1.getResult())
                , new BaseObserver<TwoBean>(true) {
                    @Override
                    protected void onSuccess(TwoBean twoBean) {
                        view.onZipExecuteSuccess(twoBean);
                    }

                    @Override
                    protected void onError(ResponseException e) {
                        view.onFriendError(e);
                    }
                }
        );
    }

    @Override
    public void getWeather(@NotNull String str) {
        RequestManager.getInstance().execute(this,
                RetrofitManager.getInstance().create(WanAndroidApis.class).getWeather(str),
                new BaseObserver<GetWeatherBean>(true) {
                    @Override
                    protected void onSuccess(GetWeatherBean data) {
                        view.onWeatherSuccess(data);
                    }

                    @Override
                    protected void onError(ResponseException e) {
                        view.onFriendError(e);
                    }
                });
    }

    @Override
    public void getJoke() {
        RequestManager.getInstance().execute(this,
                RetrofitManager.getInstance().create(WanAndroidApis.class)
                        .getJoke("3a2265504a587249569c2e2510868ebd"),
                new BaseObserver<ArrayList<JokeBean>>(true) {
                    @Override
                    protected void onSuccess(ArrayList<JokeBean> data) {
                        view.onJokeSuccess(data);
                    }

                    @Override
                    protected void onError(ResponseException e) {
                        view.onFriendError(e);
                    }
                });

    }
}
