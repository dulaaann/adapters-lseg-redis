package com.lseg.adapters.controller;

import com.lseg.adapters.entity.User;
import com.lseg.adapters.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/redis")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save-user")
    public String saveUser(@RequestBody User user){
        boolean result = userService.saveUser(user);
        if (result) return "data saved";
        else return "error";
    }

    @GetMapping
    public List<User> getAllUsers(){
       List<User> allUsers = userService.getAllUsersFromRedis();
        return allUsers;
    }
}
