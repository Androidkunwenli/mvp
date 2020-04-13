package com.zyk.http.activity.main.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.zyk.http.R
import com.zyk.http.activity.main.bean.JokeBean

class MainAdapter : BaseQuickAdapter<JokeBean, BaseViewHolder>(R.layout.item_joke) {
    override fun convert(holder: BaseViewHolder, item: JokeBean) {
        holder.setText(R.id.tv_content, item.content)
    }
}
