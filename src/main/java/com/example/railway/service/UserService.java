package com.example.railway.service;

import com.example.railway.model.User;
import com.example.railway.repo.UserRepository;
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

    public User saveUser(User user) {
        User newUser = new User();

        newUser.setLogin(user.getLogin());
        newUser.setPassword(user.getPassword());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());

        return userRepository.save(newUser);
    }

    public String getUserName (String login){
        String firstName = userRepository.findByLogin(login).orElse(null).getFirstName();
        String lastName = userRepository.findByLogin(login).orElse(null).getLastName();
        return firstName + " " + lastName;
    }


}

