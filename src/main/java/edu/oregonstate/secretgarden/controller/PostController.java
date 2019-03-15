package edu.oregonstate.secretgarden.controller;

import edu.oregonstate.secretgarden.model.Post;
import edu.oregonstate.secretgarden.model.PostReplys;
import edu.oregonstate.secretgarden.model.Reply;
import edu.oregonstate.secretgarden.model.Theme;
import edu.oregonstate.secretgarden.service.PostService;
import edu.oregonstate.secretgarden.service.ReplyService;
import edu.oregonstate.secretgarden.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author: Chendi Zhang
 * @date: 2019-01-30
 * @description:
 **/

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "*")
public class PostController {

    private final PostService postService;
    private final ThemeService themeService;
    private final ReplyService replyService;

    @Autowired
    public PostController(PostService postService, ThemeService themeService, ReplyService replyService) {
        this.postService = postService;
        this.themeService = themeService;
        this.replyService = replyService;
    }

    @RequestMapping("/create")
    public Boolean createPost(int themeId, String title, String message, int userId, String postName) {

        try {

            Post post = new Post();
            post.setMessage(message);
            post.setPostName(postName);
            post.setUserId(userId);
            post.setThemeId(themeId);
            post.setTitle(title);
            post.setPostTime(new Date());

            // update the postNumber in theme
            Theme theme = themeService.selectByPrimaryKey(themeId);
            theme.setPostNum(theme.getPostNum() + 1);
            themeService.updateByPrimaryKey(theme);

            return postService.insert(post) == 1;

        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping("/getAll")
    public List<Post> getAllPosts() {
        return postService.getAll();
    }

    @RequestMapping("/getThemePosts")
    public List<Post> getThemePosts(int themeId) {
        return postService.getThemePosts(themeId);
    }

    @RequestMapping("/getPostById")
    public Post getPostById(int postId) {
        return postService.selectByPrimaryKey(postId);
    }

    @RequestMapping("/getUserPosts")
    public List<Post> getUserPosts(int userId) {
        return postService.getUserPosts(userId);
    }

    @RequestMapping("/getPostReplyById")
    public PostReplys getPostReplyById(int postId) {

        PostReplys postReplys = new PostReplys();
        try {
            postReplys.setPost(getPostById(postId));
            postReplys.setReplyList(replyService.getPostReplys(postId));
        } catch (Exception e) {
            return null;
        }


        return postReplys;
    }

    @RequestMapping("/getReplysByPostId")
    public List<Reply> getReplysByPostId(int postId) {
        List<Reply> posts;
        try {
            posts = replyService.getPostReplys(postId);

        } catch (Exception e) {
            return null;
        }
        return posts;
    }
}
