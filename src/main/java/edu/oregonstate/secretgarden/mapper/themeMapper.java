package edu.oregonstate.secretgarden.mapper;

import edu.oregonstate.secretgarden.model.Theme;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface themeMapper {
    int deleteByPrimaryKey(Integer themeid);

    int insert(Theme record);

    int insertSelective(Theme record);

    Theme selectByPrimaryKey(Integer themeid);

    int updateByPrimaryKeySelective(Theme record);

    int updateByPrimaryKey(Theme record);
}