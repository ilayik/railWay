package com.example.sweater.service;

import com.example.sweater.model.Role;
import com.example.sweater.model.User;
import com.example.sweater.repo.RoleRepo;
import com.example.sweater.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;


    public List<User> allUsers() {
        return userRepo.findAll();
    }

    public User saveUser(User user) {
        User newUser = new User();

        newUser.setRoles(Collections.singleton(new Role(1, "ROLE_USER")));
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setDateBirth(user.getDateBirth());
        return userRepo.save(newUser);
    }
    



}

