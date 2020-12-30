package com.example.railway.controller;

import com.example.railway.model.User;
import com.example.railway.service.TicketService;
import com.example.railway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestControllerV1 {

    private final UserService userService;

    private final TicketService ticketService;

    @Autowired
    public UserRestControllerV1(UserService userService, TicketService ticketService) {
        this.userService = userService;
        this.ticketService = ticketService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('write')")
    public List<User> getUsers() {
        return userService.allUsers();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('read')")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/on-train")
    @PreAuthorize("hasAuthority('write')")
    public List<User> getUsersOnTrain(@RequestParam(name = "trainNumber") String trainNumber) {
        return ticketService.getUsersByTrainNumber(trainNumber);
    }

    @GetMapping("/check-authority")
    @PreAuthorize("hasAuthority('write')")
    public void userCheck() {
    }

    @GetMapping("/get-name")
    @PreAuthorize("hasAuthority('read')")
    public String getUserName(@RequestParam(name = "login") String login) {
        return userService.getUserName(login);
    }
}