package com.zyk.http.activity.main.bean;

import java.util.List;

/**
 * ***********************************
 *
 * @项目名称: Http
 * @Author KK
 * @邮箱: 13263181110@163.com
 * @创建时间: 2020/4/10 14:57
 * 用途:
 * ***********************************
 */
public class TwoBean {
    List<JournalismBean> mJournalismBeans;
    List<JournalismBean> mJournalismBeans1;

    public TwoBean(List<JournalismBean> journalismBeans, List<JournalismBean> journalismBeans1) {
        mJournalismBeans = journalismBeans;
        mJournalismBeans1 = journalismBeans1;
    }

    public List<JournalismBean> getJournalismBeans() {
        return mJournalismBeans;
    }

    public void setJournalismBeans(List<JournalismBean> journalismBeans) {
        mJournalismBeans = journalismBeans;
    }

    public List<JournalismBean> getJournalismBeans1() {
        return mJournalismBeans1;
    }

    public void setJournalismBeans1(List<JournalismBean> journalismBeans1) {
        mJournalismBeans1 = journalismBeans1;
    }
}
