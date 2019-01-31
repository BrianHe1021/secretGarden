package edu.oregonstate.secretgarden.mapper;

import edu.oregonstate.secretgarden.model.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    int deleteByPrimaryKey(Integer postid);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(Integer postid);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);

    List<Post>  getAllPosts();

    List<Post> getThemePosts(int themeId);
}