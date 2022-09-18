package com.justony.security.controller;

import com.justony.security.models.Role;
import com.justony.security.models.User;
import com.justony.security.repos.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired private UsersRepository usersRepository;

    @GetMapping("/main")
    public String main() {
        return "user/user_main";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "logout",	required = false) String logout,
                        @RequestParam(value = "error", required = false) String error,
                        Map<String, Object> model) {
        model.put("error", error);
        model.put("logout", logout);
        return "user/user_login";
    }

    @GetMapping("/register")
    public String registration() {
        return "user/user_register";
    }

    @PostMapping("/register")
    public String addUser(User user, Map<String, Object> model) {
        System.out.println(user);
        User foundUser = usersRepository.findByUsername(user.getUsername());
        if (foundUser != null) {
            model.put("message", "User exists!");
            return "user/user_register";
        }

        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setActive(true);
        user.setRole(Role.USER);

        usersRepository.saveAndFlush(user);
        return "redirect:/user/login";
    }
}
