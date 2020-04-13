package com.zyk.http.activity.joke;


import com.zyk.baselibrary.view.BaseView;
import com.zyk.http.activity.main.bean.GetWeatherBean;
import com.zyk.http.activity.main.bean.JokeBean;
import com.zyk.http.activity.main.bean.JournalismBean;
import com.zyk.http.activity.main.bean.TwoBean;

import java.util.ArrayList;


public interface JokeContract {
    interface View extends BaseView {

        void onJokeSuccess(ArrayList<JokeBean> jokeBean);
    }

    interface Presenter {

        void getJoke();
    }
}
