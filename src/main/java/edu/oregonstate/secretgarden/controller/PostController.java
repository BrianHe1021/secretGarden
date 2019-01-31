package edu.oregonstate.secretgarden.controller;

import edu.oregonstate.secretgarden.model.Post;
import edu.oregonstate.secretgarden.service.PostService;
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

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("/create")
    public Boolean createPost(int themeId, String title, String message, int userId, String postName) {

        try {

            Post post = new Post();
            post.setMessage(message);
            post.setPostname(postName);
            post.setUserid(userId);
            post.setThemeid(themeId);
            post.setTitle(title);
            post.setPosttime(new Date());

            return postService.insert(post) == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping("getAll")
    public List<Post> getAllPosts() {
        return postService.getAll();
    }

    @RequestMapping("getThemePosts")
    public List<Post> getThemePosts(int themeId) {
        return postService.getThemePosts(themeId);
    }
}
