package com.example.sweater.controllers;

import com.example.sweater.modul.User;
import com.example.sweater.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    public User lastUser = new User();


    @GetMapping("/allUser")
    public List<User> showAllPassenger() {
        return userService.allUsers();
    }

    @PostMapping("/saveUser")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/saveLastUser")
    @ResponseBody
    public User saveLastUser(@RequestBody User user) {
        return lastUser = user;
    }

    @GetMapping("/getLastUser")
    @ResponseBody
    public User getLastUser() {
        return lastUser;
    }
}