package com.example.sweater.service;

import com.example.sweater.modul.Role;
import com.example.sweater.modul.User;
import com.example.sweater.repo.RoleRepo;
import com.example.sweater.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService /*implements UserDetailsService*/ {
//    @PersistenceContext
//    private EntityManager em;
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;
//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;

    public User /*Details*/ loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public User findUserById(Integer userId) {
        Optional<User> userFromDb = userRepo.findById(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> allUsers() {
        return userRepo.findAll();
    }

    public User saveUser(User user) {
        User newUser = new User();

        newUser.setRoles(Collections.singleton(new Role(1, "ROLE_USER")));
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setDateBirth(user.getDateBirth());
        return userRepo.save(newUser);
    }

    public boolean deleteUser(Integer userId) {
        if (userRepo.findById(userId).isPresent()) {
            userRepo.deleteById(userId);
            return true;
        }
        return false;
    }


}

