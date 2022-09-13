package com.justony.register.service;

import com.justony.register.model.User;
import com.justony.register.model.request.LoginRequest;
import com.justony.register.model.request.RegisterRequest;
import com.justony.register.model.request.SortRequest;
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

    public List<String> getMonthList() {
        return new LinkedList<>(
                List.of("", "January(1)", "February(2)", "March(3)", "April(4)", "May(5)", "June(6)",
                        "July(7)", "August(8)", "September(9)", "October(10)", "November(11)", "December(12)")
        );
    }

    public String formatMonth(String month) {
        if (!month.equals("")) {
            String splitMonth = month.split("\\(")[1].split("\\)")[0];
            if (splitMonth.length() == 1) {
                splitMonth = "0" + splitMonth;
            }
            return splitMonth;
        } else {
            return month;
        }
    }

    public String formatDay(String day) {
        if (day.length() == 1) {
            day = "0" + day;
        }
        return day;
    }

    public List<String> getDayList() {
        List<String> days = new LinkedList<>();
        days.add("");
        for (int i = 1; i < 32; i++) {
            days.add(String.valueOf(i));
        }
        return days;
    }

    public List<User> getUsersByProfession(String profession) {
        return userRepository.getUsersByProfession(profession);
    }

    public String getDefaultProfession(String profession) {
        String defaultProfession = "All";
        if (profession != null) {
            if (!profession.equals("All")) {
                defaultProfession = profession;
            }
        }
        return defaultProfession;
    }

    public List<User> sortUsersByRequest(SortRequest request) {
        if (request.getProfessionName() != null && request.getDateYear() != null
                && request.getDateMonth() != null && request.getDateDay() != null) {

            return sortUsersByProfessionAndDate(request.getProfessionName(), request.getDateYear(), request.getDateMonth(), request.getDateDay());
        } else {
            return userRepository.findAll();
        }
    }

    public List<User> sortUsersByProfessionAndDate(String profession, String year, String month, String day) {
        List<User> users = userRepository.findAll();
        if (!profession.equals("All")) {
            users = getUsersByProfession(profession);
        }
        if (year.equals("") && month.equals("") && day.equals("")) {
            return users;
        }

        month = formatMonth(month);
        day = formatDay(day);

        List<User> sorted = new LinkedList<>();
        for (User user : users) {
            if (!year.equals("")) {
                if (!month.equals("")) {
                    if (user.getYear().equals(year) && user.getMonth().equals(month)) {
                        sorted.add(user);
                    }
                } else if (!day.equals("")) {
                    if (user.getYear().equals(year) && user.getDay().equals(day)) {
                        sorted.add(user);
                    }
                } else {
                    if (user.getYear().equals(year)) {
                        sorted.add(user);
                    }
                }

            } else if (!month.equals("")) {
                if (!day.equals("")) {
                    if (user.getMonth().equals(month) && user.getDay().equals(day)) {
                        sorted.add(user);
                    }
                } else {
                    if (user.getMonth().equals(month)) {
                        sorted.add(user);
                    }
                }
            } else if (!day.equals("")) {
                if (user.getDay().equals(day)) {
                    sorted.add(user);
                }
            }
            System.out.println(year + "-" + month + "-" + day);
            System.out.println(user.getYear() + "-" + user.getMonth() + "-" + user.getDay());
        }
        return sorted;
    }
}
