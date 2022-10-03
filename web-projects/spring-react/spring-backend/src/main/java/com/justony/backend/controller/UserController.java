package com.justony.backend.controller;

import com.justony.backend.dto.User;
import com.justony.backend.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired private UserRepository repository;

    @GetMapping("/all")
    @ResponseBody
    public List<User> getAllUsers() {
        System.out.println("user all");
        return repository.findAll();
    }
}
