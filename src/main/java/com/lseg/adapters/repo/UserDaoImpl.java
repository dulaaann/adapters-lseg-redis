package com.lseg.adapters.repo;

import com.lseg.adapters.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO{

    @Autowired
    private RedisTemplate redisTemplate;
    private static final String KEY = "REDIS-LSEG-USER";

    @Override
    public boolean saveUserInRedis(User user) {
        try {
            redisTemplate.opsForHash().put(KEY,user.getId(),user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<User> getAllUsers() {
        List<User> retrievedUsers= redisTemplate.opsForHash().values(KEY);
        return retrievedUsers;
    }
}
