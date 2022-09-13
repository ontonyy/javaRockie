package com.justony.register.model;

import com.justony.register.model.request.RegisterRequest;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NonNull @Column(name = "username")
    private String username;

    @NonNull @Column(name = "email")
    private String email;

    @NonNull @Column(name = "password")
    private String password;

    @NonNull @Column(name = "profession")
    private String profession;

    @NonNull @Column(name = "note")
    private String note;

    @NonNull @Column(name = "birthday") @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    @NonNull @Column(name = "married")
    private boolean married;

    private String year;
    private String month;
    private String day;

    public boolean checkPasswordCorrect(String password) {
        if (this.password.equals(password)) {
            return true;
        } else {
            throw new IllegalStateException("Password is incorrect!");
        }
    }

    public static User buildByRequest(RegisterRequest request) {
        User user = new User();

        String birthday = request.getBirthday();

        user.setUsername(user.checkAndReturnUsername(request.getUsername()));
        user.setEmail(user.checkAndReturnEmail(request.getEmail()));
        user.setPassword(user.checkAndReturnPassword(request.getPassword()));
        user.setProfession(user.checkProfession(request.getProfession()));
        user.setBirthday(user.checkAndReturnBirthday(birthday));
        user.setMarried(request.isMarried());
        user.setNote(request.getNote());

        user.setYear(birthday.split("-")[0]);
        user.setMonth(birthday.split("-")[1]);
        user.setDay(birthday.split("-")[2]);

        return user;
    }

    private String checkProfession(String profession) {
        if (!profession.equals("Choose one")) {
            return profession;
        } else {
            throw new IllegalStateException("Your profession is weird(Choose one)");
        }
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

    public String getBirthday() {
        String pattern = "yyyy-MM-dd";

        DateFormat df = new SimpleDateFormat(pattern);

        return df.format(birthday);
    }
}
