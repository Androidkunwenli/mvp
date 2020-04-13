package com.zyk.baselibrary.view;

import com.zyk.baselibrary.http.exception.ResponseException;

public interface BaseView {
    void onFriendError(ResponseException e);
}
