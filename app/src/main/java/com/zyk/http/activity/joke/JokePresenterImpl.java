package com.zyk.http.activity.joke;

import com.zyk.baselibrary.http.RequestManager;
import com.zyk.baselibrary.http.RetrofitManager;
import com.zyk.baselibrary.http.exception.ResponseException;
import com.zyk.baselibrary.http.observer.BaseObserver;
import com.zyk.baselibrary.http.observer.LoadingObserver;
import com.zyk.baselibrary.presenter.BasePresenter;
import com.zyk.http.activity.main.bean.GetWeatherBean;
import com.zyk.http.activity.main.bean.JokeBean;
import com.zyk.http.activity.main.bean.JournalismBean;
import com.zyk.http.activity.main.bean.TwoBean;
import com.zyk.http.main.WanAndroidApis;

import java.util.ArrayList;

/**
 * @Author: KK
 * @时间: 2020/4/10 15:08
 * @描述: 请求接口 和请求两个接口实例
 */
public class JokePresenterImpl extends BasePresenter<JokeContract.View> implements JokeContract.Presenter {
    public JokePresenterImpl(JokeContract.View view) {
        super(view);
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
