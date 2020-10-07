package com.example.sweater.controllers;

import com.example.sweater.modul.User;
import com.example.sweater.service.UserService;
import com.example.sweater.service.ScheduleService;
import com.example.sweater.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public User lastUser = new User();


    @GetMapping("/allUser")
    @ResponseBody
    public List<User> showAllPassenger(){
        return userService.allUsers();
    }

    @PostMapping("/saveUser")
    @ResponseBody
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
    public User getLastUser(){
        return lastUser;
    }
}