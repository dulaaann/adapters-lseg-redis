package com.lseg.adapters.adp;

import com.lseg.adapters.entity.User;

import java.util.List;

public interface SupportAdapter {
    boolean saveUser(User user);
    List<User> getAllUsersFromRedis();
}
