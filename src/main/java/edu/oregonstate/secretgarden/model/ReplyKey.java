package edu.oregonstate.secretgarden.model;

public class ReplyKey extends BaseModelObject {
    private Integer postid;

    private Integer layernum;

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public Integer getLayernum() {
        return layernum;
    }

    public void setLayernum(Integer layernum) {
        this.layernum = layernum;
    }
}