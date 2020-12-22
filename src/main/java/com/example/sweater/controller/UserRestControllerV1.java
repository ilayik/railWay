package com.example.sweater.controller;

import com.example.sweater.model.User;
import com.example.sweater.service.TicketService;
import com.example.sweater.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestControllerV1 {

    private final UserService userService;

    private final TicketService  ticketService;

    public User lastUser = new User();

    @Autowired
    public UserRestControllerV1(UserService userService, TicketService ticketService) {
        this.userService = userService;
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.allUsers();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/save-last")
    public User addLastUser(@RequestBody User user) {
        return lastUser = user;
    }

    @GetMapping("/get-last")
    public User getLastUser() {
        return lastUser;
    }


    @GetMapping("/on-train")
    public List<User> getUsersOnTrain(@RequestParam(name = "trainNumber") String trainNumber) {
        return ticketService.getUsersByTrainNumber(trainNumber);
    }
}