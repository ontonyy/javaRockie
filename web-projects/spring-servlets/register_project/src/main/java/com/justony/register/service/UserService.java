package com.justony.register.service;

import com.justony.register.model.User;
import com.justony.register.model.request.LoginRequest;
import com.justony.register.model.request.RegisterRequest;
import com.justony.register.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {
    @Autowired private UserRepository userRepository;

    public User createAndSaveUser(RegisterRequest request) {
        User user = User.buildByRequest(request);
        return userRepository.saveAndFlush(user);
    }

    public User getUserByUsername(String username) {
        if (userRepository.existsByUsername(username)) {
            return userRepository.getUserByUsername(username);
        } else {
            throw new IllegalStateException(String.format("User not found by username(%s)", username));
        }
    }

    public User getUserByEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            return userRepository.getUserByEmail(email);
        } else {
            throw new IllegalStateException(String.format("User not found by email(%s)", email));
        }
    }

    public User getUserByRequest(LoginRequest request) {
        User user;
        if (request.getUsernameOrEmail().contains("@")) {
            user = getUserByEmail(request.getUsernameOrEmail());
        } else {
            user = getUserByUsername(request.getUsernameOrEmail());
        }
        if (user.checkPasswordCorrect(request.getPassword())) return user;
        else return null;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUsers() { userRepository.deleteAll();}

    public List<String> getProfessionList() {
        return new LinkedList<>(
                List.of("Doctor", "Pilot", "Sportsman", "IT-specialist", "Electric", "Builder", "Cock")
        );
    }

    public List<User> getUsersByProfession(String profession) {
        return userRepository.getUsersByProfession(profession);
    }
}
