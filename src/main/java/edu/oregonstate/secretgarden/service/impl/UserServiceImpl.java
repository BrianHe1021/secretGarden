package edu.oregonstate.secretgarden.service.impl;

import edu.oregonstate.secretgarden.mapper.UserMapper;
import edu.oregonstate.secretgarden.model.User;
import edu.oregonstate.secretgarden.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Chendi Zhang
 * @date: 2019-01-30
 * @description:
 **/

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public User selectByPrimaryKey(Integer integer) {
        return userMapper.selectByPrimaryKey(integer);
    }

    @Override
    public int updateByPrimaryKey(User object) {
        return userMapper.updateByPrimaryKey(object);
    }

    @Override
    public int deleteByPrimaryKey(Integer integer) {
        return userMapper.deleteByPrimaryKey(integer);
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.selectByEmail(email);
    }
}
