package edu.oregonstate.secretgarden.mapper;

import edu.oregonstate.secretgarden.model.Theme;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ThemeMapper {
    int deleteByPrimaryKey(Integer themeid);

    int insert(Theme record);

    int insertSelective(Theme record);

    Theme selectByPrimaryKey(Integer themeid);

    int updateByPrimaryKeySelective(Theme record);

    int updateByPrimaryKey(Theme record);

    List<Theme> getAll();
}