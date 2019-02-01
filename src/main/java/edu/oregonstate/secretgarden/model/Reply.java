package edu.oregonstate.secretgarden.model;

public class Reply extends ReplyKey {
    private Integer userId;

    private String replyName;

    private Integer replyLayerNum;

    private String content;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReplyName() {
        return replyName;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName == null ? null : replyName.trim();
    }

    public Integer getReplyLayerNum() {
        return replyLayerNum;
    }

    public void setReplyLayerNum(Integer replyLayerNum) {
        this.replyLayerNum = replyLayerNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}