package com.johnnyboy.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.johnnyboy.workshopmongo.domain.User;
import com.johnnyboy.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
				
		User helenita = new User(null, "Helenita Rodriguez", "helenrodri@gmail.com");
		User james = new User(null, "James Western", "jamesalton@gmail.com");
		User javier = new User(null, "Javier Domenicano", "javierbobito@gmail.com");
		
		userRepository.saveAll(Arrays.asList(helenita, james,javier));
		
	}

}
