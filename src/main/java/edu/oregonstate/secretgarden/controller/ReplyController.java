package edu.oregonstate.secretgarden.controller;

import edu.oregonstate.secretgarden.model.Post;
import edu.oregonstate.secretgarden.model.Reply;
import edu.oregonstate.secretgarden.service.PostService;
import edu.oregonstate.secretgarden.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Chendi Zhang
 * @date: 2019-01-31
 * @description:
 **/

@RestController
@RequestMapping("/reply")
@CrossOrigin(origins = "*")
public class ReplyController {


    private final PostService postService;
    private final ReplyService replyService;

    @Autowired
    public ReplyController(PostService postService, ReplyService replyService) {
        this.postService = postService;
        this.replyService = replyService;
    }


    @RequestMapping("/create")
    public Boolean createPost(int postId, String content, int replyLayerNum, int userId, String replyName) {

        try {
            // update the replyNumber in post
            Post post = postService.selectByPrimaryKey(postId);
            int totalReplies = post.getReplyNum();
            post.setReplyNum(totalReplies + 1);

            if (replyLayerNum > totalReplies) {
                return false; // reply num error
            }

            Reply reply = new Reply();
            reply.setContent(content);
            reply.setPostId(postId);
            reply.setLayerNum(totalReplies + 1);
            reply.setReplyLayerNum(replyLayerNum);
            reply.setUserId(userId);
            reply.setReplyName(replyName);

            postService.updateByPrimaryKey(post);

            return replyService.insert(reply) == 1;

        } catch (Exception e) {
            return false;
        }
    }
}
