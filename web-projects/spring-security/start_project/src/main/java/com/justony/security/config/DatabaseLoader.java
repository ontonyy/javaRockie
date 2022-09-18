package com.justony.security.config;

import com.justony.security.models.Role;
import com.justony.security.models.User;
import com.justony.security.repos.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoader {
    private UsersRepository usersRepository;

    public DatabaseLoader(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Bean
    public CommandLineRunner initializeDatabase() {
        return args -> {
            User user1 = new User("ontony", "ZXC123", "Ontony Gavrilenko", true, Role.ADMIN);
            User user2 = new User("admin", "admin", "Admin Admin", false, Role.ADMIN);
            User user3 = new User("justony", "1234", "Just Tony", true, Role.USER);
            User user4 = new User("anton", "anton", "Anton Anton", true, Role.USER);

            usersRepository.save(user1);
            usersRepository.save(user2);
            usersRepository.save(user3);
            usersRepository.save(user4);
        };

    }
}
