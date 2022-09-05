package com.justony.justony_project.model;

import com.justony.justony_project.model.request.RegisterRequest;
import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class User {
    private String username;
    private String email;
    private String password;
    private String profession;
    private String note;
    private Date birthday;
    private boolean married;

    public String getBirthday() {
        String pattern = "yyyy-MM-dd";

        DateFormat df = new SimpleDateFormat(pattern);

        return df.format(birthday);
    }

    public static User buildByRequest(RegisterRequest request) {
        User user = new User();

        user.setUsername(user.checkAndReturnUsername(request.getUsername()));
        user.setEmail(user.checkAndReturnEmail(request.getEmail()));
        user.setPassword(user.checkAndReturnPassword(request.getPassword()));
        user.setProfession(request.getProfession());
        user.setBirthday(user.checkAndReturnBirthday(request.getBirthday()));
        user.setMarried(request.isMarried());
        user.setNote(request.getNote());

        return user;
    }

    private String checkAndReturnUsername(String username) {
        if (username.length() > 0) {
            return username;
        } else {
            throw new IllegalStateException("Username is empty!!!");
        }
    }

    private String checkAndReturnEmail(String email) {
        if (email.contains("@") && email.length() > 3) {
            String namePart = email.split("@")[0];
            String mailPart = email.split("@")[1];
            if (namePart.length() > 0 && mailPart.contains(".")) {
                if (mailPart.split("\\.").length > 1 && mailPart.split("\\.")[1].length() > 0) {
                    return email;
                }
            }
        }
        throw new IllegalStateException("Email is invalid!!!");
    }

    private String checkAndReturnPassword(String password) {
        Pattern p = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])");
        Matcher m = p.matcher(password);
        if (m.find()) {
            return password;
        } else {
            throw new IllegalStateException("Password is incorrect!!!");
        }
    }

    private Date checkAndReturnBirthday(String date) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.parse(date);
        } catch (Exception e) {
            throw new IllegalStateException("Cannot convert birthday... " + e.getMessage());
        }
    }
}
