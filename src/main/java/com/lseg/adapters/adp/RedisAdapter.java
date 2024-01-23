package com.lseg.adapters.adp;

import com.lseg.adapters.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RedisAdapter implements SupportAdapter {
    @Autowired
    private RedisTemplate redisTemplate;
    private static final String KEY = "REDIS-LSEG-USER";
    @Override
    public boolean saveUser(User user) {
        try {
            redisTemplate.opsForHash().put(KEY,user.getId(),user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> getAllUsersFromRedis() {
        List<User> retrievedUsers= redisTemplate.opsForHash().values(KEY);
        return retrievedUsers;
    }
}
