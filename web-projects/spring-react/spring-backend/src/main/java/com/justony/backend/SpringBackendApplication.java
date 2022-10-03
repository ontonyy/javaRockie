package com.justony.backend;

import com.justony.backend.dto.User;
import com.justony.backend.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBackendApplication implements CommandLineRunner {
	@Autowired private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new User("Antonion", "onion@mail.ru"));
		repository.save(new User("Maximillian", "max@gmail.com"));
		repository.save(new User("Vladislav", "vlad@gmail.com"));
		repository.save(new User("Grekis", "grek@gmail.com"));
	}
}
