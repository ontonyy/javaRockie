package com.justony.justony_project.controller;

import com.justony.justony_project.model.User;
import com.justony.justony_project.model.request.RegisterRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class RegisterController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/register-form")
    public String openRegister(Map<String, Object> model) {
        RegisterRequest request = new RegisterRequest();
        model.put("professionList", new LinkedList<>(List.of("IT-specialist", "Electric", "Ehitaja")));
        model.put("request", request);
        return "register_form";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") RegisterRequest request,
                           Map<String, Object> model) {
        try {
            User user = User.buildByRequest(request);
            model.put("user", user);
            return "register";
        } catch (IllegalStateException ex) {
            model.put("exception", ex.getMessage());
            return "exception";
        }
    }

}
