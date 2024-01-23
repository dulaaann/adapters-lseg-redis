package com.lseg.adapters.service.impl;

import com.lseg.adapters.adp.RedisAdapter;
import com.lseg.adapters.entity.User;
import com.lseg.adapters.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisAdapter redisAdapter;

    @Override
    public boolean saveUser(User user) {
        return redisAdapter.saveUser(user);
    }

    @Override
    public List<User> getAllUsersFromRedis() {
       //List<User> allUsers = userDAO.getAllUsers();
        return redisAdapter.getAllUsersFromRedis();
    }
}
