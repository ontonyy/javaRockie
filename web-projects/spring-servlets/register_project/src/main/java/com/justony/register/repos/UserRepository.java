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
}
