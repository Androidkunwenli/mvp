package com.zyk.http.activity.main

import android.content.Intent
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.zyk.baselibrary.activity.BaseMvpActivity
import com.zyk.baselibrary.http.exception.ResponseException
import com.zyk.http.R
import com.zyk.http.activity.joke.JokeActivity
import com.zyk.http.activity.main.adapter.MainAdapter
import com.zyk.http.activity.main.bean.GetWeatherBean
import com.zyk.http.activity.main.bean.JokeBean
import com.zyk.http.activity.main.bean.JournalismBean
import com.zyk.http.activity.main.bean.TwoBean
import kotlinx.android.synthetic.main.main_activity.*

/**
 *@Author: KK
 *@时间:   2020/4/10 14:51
 *@描述:   首页
 */
class MainActivity : BaseMvpActivity<MainPresenterImpl>(), MainContract.View {

    override fun initLayoutResID(): Int {
        return R.layout.main_activity
    }

    override fun initPresenter(): MainPresenterImpl {
        return MainPresenterImpl(this)
    }

    private val mainAdapter = MainAdapter()

    override fun initView() {
        bt_request.setOnClickListener {
            //
//            presenter.getJournalismData(1, 10, "video")
//            presenter.getTwoData(1, 50, "video")
//            presenter.getWeather("石家庄")
//            presenter.getJoke()
            startActivity(Intent(this, JokeActivity::class.java))
        }
    }


    override fun onFriendSuccess(data: List<JournalismBean?>?) {
        Log.e("friend", "success")
    }

    override fun onZipExecuteSuccess(twoBean: TwoBean?) {
    }

    override fun onWeatherSuccess(getWeatherBean: GetWeatherBean) {
    }

    override fun onJokeSuccess(jokeBean: ArrayList<JokeBean>) {
        mainAdapter.setNewInstance(jokeBean)
    }

    override fun onFriendError(e: ResponseException?) {
        Log.e("friend", e.toString())
    }
}