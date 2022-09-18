package com.justony.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/main")
    public String main() {
        return "admin/admin_main";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "logout",	required = false) String logout,
                        @RequestParam(value = "error", required = false) String error,
                        Map<String, Object> model) {
        model.put("error", error);
        model.put("logout", logout);
        return "admin/admin_login";
    }
}
