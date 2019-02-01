package edu.oregonstate.secretgarden.model;

public class ReplyKey extends BaseModelObject {
    private Integer postId;

    private Integer layerNum;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getLayerNum() {
        return layerNum;
    }

    public void setLayerNum(Integer layerNum) {
        this.layerNum = layerNum;
    }
}