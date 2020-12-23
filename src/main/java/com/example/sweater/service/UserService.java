package com.example.sweater.service;

import com.example.sweater.model.User;
import com.example.sweater.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> allUsers() {
        return userRepository.findAll();
    }

//    public User saveUser(User user) {
//        User newUser = new User();
//
//        newUser.setRoles(Collections.singleton(new Role(1, "ROLE_USER")));
//        newUser.setUsername(user.getUsername());
//        newUser.setPassword(user.getPassword());
//        newUser.setFirstName(user.getFirstName());
//        newUser.setLastName(user.getLastName());
//        newUser.setDateBirth(user.getDateBirth());
//        return userRepository.save(newUser);
//    }


}

