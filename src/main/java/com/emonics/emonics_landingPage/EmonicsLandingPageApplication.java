package com.emonics.emonics_landingPage;

import com.emonics.emonics_landingPage.entities.User;
import com.emonics.emonics_landingPage.service.contracts.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmonicsLandingPageApplication {

	@Autowired
	private UserDAO userDAO;

	public static void main(String[] args) {
		SpringApplication.run(EmonicsLandingPageApplication.class, args);
	}


	@Bean
	public CommandLineRunner runner(){
		return args -> {

		};
	}

	public void generateData(){
		//User user = new User(null,"Fernando Salmeron", "fernando@gs.com", "Java,Docker","chales");
		//userDAO.save(user);
	}
}
