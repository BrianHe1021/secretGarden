package edu.oregonstate.secretgarden.service.impl;

import edu.oregonstate.secretgarden.mapper.ThemeMapper;
import edu.oregonstate.secretgarden.model.Theme;
import edu.oregonstate.secretgarden.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Chendi Zhang
 * @date: 2019-01-30
 * @description:
 **/

@Service
public class ThemeServiceImpl implements ThemeService {

    private final ThemeMapper themeMapper;

    @Autowired
    public ThemeServiceImpl(ThemeMapper themeMapper) {
        this.themeMapper = themeMapper;
    }

    @Override
    public List<Theme> getAllThemes() {
        return themeMapper.getAll();
    }

    @Override
    public int insert(Theme record) {
        return themeMapper.insert(record);
    }

    @Override
    public Theme selectByPrimaryKey(Integer integer) {
        return themeMapper.selectByPrimaryKey(integer);
    }

    @Override
    public int updateByPrimaryKey(Theme object) {
        return themeMapper.updateByPrimaryKey(object);
    }

    @Override
    public int deleteByPrimaryKey(Integer integer) {
        return themeMapper.deleteByPrimaryKey(integer);
    }
}
