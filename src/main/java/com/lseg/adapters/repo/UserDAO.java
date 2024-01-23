package com.lseg.adapters.repo;

import com.lseg.adapters.entity.User;

import java.util.List;

public interface UserDAO {
    boolean saveUserInRedis(User user);

    List<User> getAllUsers();
}
