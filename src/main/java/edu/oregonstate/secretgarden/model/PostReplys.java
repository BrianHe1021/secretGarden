package edu.oregonstate.secretgarden.model;

import java.util.List;

/**
 * @author: Chendi Zhang
 * @date: 2019-03-11
 * @description:
 **/

public class PostReplys extends BaseModelObject {

    private Post post;
    private List<Reply> replyList;
    
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }
}
