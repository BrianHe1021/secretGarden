package edu.oregonstate.secretgarden.service.impl;

import edu.oregonstate.secretgarden.mapper.PostMapper;
import edu.oregonstate.secretgarden.model.Post;
import edu.oregonstate.secretgarden.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Chendi Zhang
 * @date: 2019-01-30
 * @description:
 **/

@Service
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;

    @Autowired
    public PostServiceImpl(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public int insert(Post record) {
        return postMapper.insert(record);
    }

    @Override
    public Post selectByPrimaryKey(Integer integer) {
        return postMapper.selectByPrimaryKey(integer);
    }

    @Override
    public int updateByPrimaryKey(Post object) {
        return postMapper.updateByPrimaryKey(object);
    }

    @Override
    public int deleteByPrimaryKey(Integer integer) {
        return postMapper.deleteByPrimaryKey(integer);
    }

    @Override
    public List<Post> getAll() {
        return postMapper.getAllPosts();
    }

    @Override
    public List<Post> getThemePosts(int themeId) {
        return postMapper.getThemePosts(themeId);
    }
}
