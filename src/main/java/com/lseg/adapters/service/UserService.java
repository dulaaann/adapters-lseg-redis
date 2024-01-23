package com.lseg.adapters.service;

import com.lseg.adapters.entity.User;

import java.util.List;

public interface UserService {
    boolean saveUser(User user);

    List<User> getAllUsersFromRedis();
}
