package com.zyk.http.activity.main;


import com.zyk.baselibrary.view.BaseView;
import com.zyk.http.activity.main.bean.GetWeatherBean;
import com.zyk.http.activity.main.bean.JokeBean;
import com.zyk.http.activity.main.bean.JournalismBean;
import com.zyk.http.activity.main.bean.TwoBean;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public interface MainContract {
    interface View extends BaseView {
        void onFriendSuccess(List<JournalismBean> data);

        void onZipExecuteSuccess(TwoBean twoBean);

        void onWeatherSuccess(GetWeatherBean twoBean);

        void onJokeSuccess(ArrayList<JokeBean> jokeBean );
    }

    interface Presenter {
        void getJournalismData(int page, int count, String type);

        void getTwoData(int page, int count, String type);

        void getWeather(@NotNull String str);

        void getJoke();
    }
}
