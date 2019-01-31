package edu.oregonstate.secretgarden.service;

import edu.oregonstate.secretgarden.model.Post;

import java.util.List;

/**
 * @author: Chendi Zhang
 * @date: 2019-01-30
 * @description:
 **/

public interface PostService extends BaseService<Post, Integer> {
    List<Post> getAll();

    List<Post> getThemePosts(int themeId);

    List<Post> getUserPosts(int userId);
}
