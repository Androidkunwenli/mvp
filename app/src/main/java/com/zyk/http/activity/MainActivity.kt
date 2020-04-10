package com.zyk.http.activity

import android.util.Log
import com.google.gson.Gson
import com.zyk.baselibrary.activity.BaseMvpActivity
import com.zyk.baselibrary.http.exception.ResponseException
import com.zyk.http.R
import com.zyk.http.activity.bean.JournalismBean
import kotlinx.android.synthetic.main.main_activity.*


class MainActivity : BaseMvpActivity<MainPresenterImpl>(), MainContract.View {

    override fun initLayoutResID(): Int {
        return R.layout.main_activity
    }

    override fun initPresenter(): MainPresenterImpl {
        return MainPresenterImpl(this)
    }

    override fun initView() {
        tv_request.setOnClickListener {
            presenter.getFriendData(1, 10, "video")
        }
    }


    override fun onFriendSuccess(data: List<JournalismBean?>?) {
        Log.e("friend", "success")
        tv_content.text = Gson().toJson(data)
    }

    override fun onFriendError(e: ResponseException?) {
        Log.e("friend", "error")
    }


}