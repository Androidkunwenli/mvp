package com.zyk.http.activity.joke

import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.zyk.baselibrary.activity.BaseMvpActivity
import com.zyk.baselibrary.http.exception.ResponseException
import com.zyk.http.R
import com.zyk.http.activity.main.adapter.MainAdapter
import com.zyk.http.activity.main.bean.JokeBean
import kotlinx.android.synthetic.main.joke_activity.*
import kotlinx.android.synthetic.main.main_activity.*
import java.util.*

/**
 * ***********************************
 *
 * @项目名称: Http
 * @Author KK
 * @邮箱: 13263181110@163.com
 * @创建时间: 2020/4/10 17:28
 * 用途:笑话界面
 * ***********************************
 */
class JokeActivity : BaseMvpActivity<JokePresenterImpl>(), JokeContract.View {
    override fun initPresenter(): JokePresenterImpl {
        return JokePresenterImpl(this)
    }

    override fun initLayoutResID(): Int {
        return R.layout.joke_activity
    }

    private val mainAdapter = MainAdapter()

    override fun initView() {
        setSupportActionBar(tb_view)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        tb_view.setNavigationOnClickListener { finish() }
        recycle_list.layoutManager = LinearLayoutManager(context)
        recycle_list.adapter = mainAdapter
        presenter.getJoke()
    }

    override fun onJokeSuccess(jokeBean: ArrayList<JokeBean>) {
        mainAdapter.setNewInstance(jokeBean)
    }

    override fun onFriendError(e: ResponseException) {}
}