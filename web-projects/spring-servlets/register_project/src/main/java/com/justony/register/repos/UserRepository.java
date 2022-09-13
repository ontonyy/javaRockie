package com.justony.register.repos;

import com.justony.register.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    List<User> getUsersByProfession(String profession);

    List<User> getUsersByYear(String year);
    List<User> getUsersByMonth(String month);
    List<User> getUsersByDay(String day);
    List<User> getUsersByYearAndMonth(String year, String month);
    List<User> getUsersByYearAndDay(String year, String day);
    List<User> getUsersByMonthAndDay(String month, String day);

    List<User> getUsersByProfessionAndYear(String profession, String year);
    List<User> getUsersByProfessionAndMonth(String profession, String month);
    List<User> getUsersByProfessionAndDay(String profession, String day);
    List<User> getUsersByProfessionAndYearAndMonth(String profession, String year, String month);
    List<User> getUsersByProfessionAndYearAndDay(String profession, String year, String day);
    List<User> getUsersByProfessionAndMonthAndDay(String profession, String month, String day);


}
