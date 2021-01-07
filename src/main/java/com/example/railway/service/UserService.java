package com.example.railway.service;

import com.example.railway.model.Role;
import com.example.railway.model.Status;
import com.example.railway.model.User;
import com.example.railway.repo.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }


    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public String validLogin(String login) {
        if (login.isEmpty() || login == null)
            return "Please enter your login";

        if (allUsers().stream().anyMatch(user -> user.getLogin().equals(login)))
            return "Login " + login + " is used";

        return "";
    }

    public User saveUser(User user) {
        User newUser = new User();

        newUser.setLogin(user.getLogin());
        newUser.setPassword(passwordEncoder().encode(user.getPassword()));
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setStatus(Status.ACTIVE);
        newUser.setRole(Role.USER);

        return userRepository.save(newUser);
    }

    public String getUserName(String login) {
        String firstName = userRepository.findByLogin(login).orElse(null).getFirstName();
        String lastName = userRepository.findByLogin(login).orElse(null).getLastName();
        return firstName + " " + lastName;
    }
}

