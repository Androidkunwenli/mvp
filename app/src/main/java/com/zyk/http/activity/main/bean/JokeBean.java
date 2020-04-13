package com.zyk.http.activity.main.bean;

/**
 * ***********************************
 *
 * @项目名称: Http
 * @Author KK
 * @邮箱: 13263181110@163.com
 * @创建时间: 2020/4/10 15:56
 * 用途: 笑話
 * ***********************************
 */
public class JokeBean {
    /**
     * content : 今天检查儿子的作业，看到他们的题目有几题是造句，第一题是用 不但……而且……造句。 一看到儿子写的答案我和老婆就笑了。。这小家伙写的：“我不但有屁股，而且还是两半！”。这不是高潮，还有第二题用 要么……要么 造句……看到这个的答案真的笑扒了，儿子是这样写的:“冰棍5毛，要么，要么？
     * hashId : 505D3BE5E4FA7DF863A455B5C89A7518
     * unixtime : 1433875926
     */

    private String content;
    private String hashId;
    private int unixtime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public int getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(int unixtime) {
        this.unixtime = unixtime;
    }
}
