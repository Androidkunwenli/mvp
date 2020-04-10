package com.zyk.http.activity;

import com.zyk.baselibrary.presenter.BasePresenter;
import com.zyk.baselibrary.http.exception.ResponseException;
import com.zyk.baselibrary.http.RetrofitManager;
import com.zyk.baselibrary.http.observer.LoadingObserver;
import com.zyk.baselibrary.http.RequestManager;
import com.zyk.http.activity.bean.JournalismBean;
import com.zyk.http.main.WanAndroidApis;

import java.util.List;


public class MainPresenterImpl extends BasePresenter<MainContract.View> implements MainContract.Presenter {
    public MainPresenterImpl(MainContract.View view) {
        super(view);
    }


    @Override
    public void getFriendData(int page, int count, String type) {
        RequestManager.getInstance().execute(this,
                RetrofitManager.getInstance().create(WanAndroidApis.class).getJoke(page, count, type),
                new LoadingObserver<List<JournalismBean>>(context, true, true) {
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
}
