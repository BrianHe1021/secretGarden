package edu.oregonstate.secretgarden.model;

public class Reply extends ReplyKey {
    private Integer userid;

    private String replyname;

    private Integer replylayernum;

    private String content;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getReplyname() {
        return replyname;
    }

    public void setReplyname(String replyname) {
        this.replyname = replyname == null ? null : replyname.trim();
    }

    public Integer getReplylayernum() {
        return replylayernum;
    }

    public void setReplylayernum(Integer replylayernum) {
        this.replylayernum = replylayernum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}