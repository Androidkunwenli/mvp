package com.zyk.http.activity;


import com.zyk.baselibrary.view.BaseView;
import com.zyk.baselibrary.http.exception.ResponseException;
import com.zyk.http.activity.bean.JournalismBean;

import java.util.List;


public interface MainContract {
    interface View extends BaseView {
        void onFriendSuccess(List<JournalismBean> data);

        void onFriendError(ResponseException e);

    }

    interface Presenter {
        void getFriendData(int i, int i1, String s);
    }
}
