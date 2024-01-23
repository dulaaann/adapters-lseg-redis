package com.lseg.adapters.adp;

import com.lseg.adapters.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBAdapter implements SupportAdapter{
    @Override
    public boolean saveUser(User user) {
        return false;
    }

    @Override
    public List<User> getAllUsersFromRedis() {
        return null;
    }
}
