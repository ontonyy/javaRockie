package com.justony.register.controller;

import com.justony.register.model.User;
import com.justony.register.model.request.LoginRequest;
import com.justony.register.model.request.RegisterRequest;
import com.justony.register.model.request.SortRequest;
import com.justony.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired private UserService service;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/users")
    public String getAllUsers(@ModelAttribute("profession") SortRequest request,
            Map<String, Object> model) {

        List<User> users = service.sortUsersByRequest(request);

        List<String> professions = service.getProfessionList();
        professions.set(0, "All");

        String defaultProfession = service.getDefaultProfession(request.getProfessionName());
        professions.remove(defaultProfession);

        model.put("users", users);
        model.put("sortRequest", new SortRequest());
        model.put("defaultProfession", defaultProfession);
        model.put("professionList", professions);
        model.put("monthList", service.getMonthList());
        model.put("dayList", service.getDayList());

        return "users_table";
    }


    @GetMapping("/register-form")
    public String openRegister(Map<String, Object> model) {
        List<String> professions = service.getProfessionList();
        professions.set(0, "Choose one");
        model.put("professionList", professions);
        model.put("request", new RegisterRequest());
        return "register_form";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") RegisterRequest request,
                           Map<String, Object> model) {
        try {
            User user = service.createAndSaveUser(request);
            model.put("user", user);
            return "register";
        } catch (IllegalStateException ex) {
            List<String> professions = service.getProfessionList();
            professions.set(0, "Choose one");

            model.put("professionList", professions);
            model.put("request", request);
            model.put("message", ex.getMessage());
            return "register_form";
        }
    }

    @GetMapping("/login-form")
    public String openLogin(Map<String, Object> model) {
        LoginRequest request = new LoginRequest();
        model.put("request", request);
        return "login_form";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") LoginRequest request,
                           Map<String, Object> model) {
        try {
            User user = service.getUserByRequest(request);
            model.put("user", user);
            return "login";
        } catch (IllegalStateException ex) {
            model.put("request", request);
            model.put("message", ex.getMessage());
        }
        return "login_form";
    }

    @RequestMapping("/delete-users")
    public String deleteUsers(Map<String, Object> model) {
        service.deleteUsers();
        model.put("users", service.getAllUsers());
        return "redirect:/users";
    }
}
