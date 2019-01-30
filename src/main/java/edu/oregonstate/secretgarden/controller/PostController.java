package edu.oregonstate.secretgarden.controller;

import edu.oregonstate.secretgarden.model.Post;
import edu.oregonstate.secretgarden.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: Chendi Zhang
 * @date: 2019-01-30
 * @description:
 **/

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("/create")
    public Boolean createPost(int themeId, String title, String message, int userId, String postName) {

        Post post = new Post();
        post.setMessage(message);
        post.setPostname(postName);
        post.setUserid(userId);
        post.setThemeid(themeId);
        post.setTitle(title);
        post.setPosttime(new Date());

        try {
            return postService.insert(post) == 1;
        } catch (Exception e) {
            return false;
        }
    }
}
