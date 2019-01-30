package edu.oregonstate.secretgarden.service;

import edu.oregonstate.secretgarden.model.User;

public interface UserService extends BaseService<User, Integer> {

    User getUserByEmail(String email);
}
