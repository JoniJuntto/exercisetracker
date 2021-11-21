package com.jonij.exercisetracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jonij.exercisetracker.domain.ExerciseRepository;
import com.jonij.exercisetracker.domain.SportRepository;
import com.jonij.exercisetracker.domain.UserRepository;
import com.jonij.exercisetracker.ExercisetrackerApplication;
import com.jonij.exercisetracker.domain.User;
import com.jonij.exercisetracker.domain.Sport;
import com.jonij.exercisetracker.domain.Exercise;

@SpringBootApplication
public class ExercisetrackerApplication {
	private static final Logger log = LoggerFactory.getLogger(ExercisetrackerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ExercisetrackerApplication.class, args);
	}
	@Bean
	public CommandLineRunner studentDemo(ExerciseRepository erepository, SportRepository srepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of Exercises for examples");
			srepository.save(new Sport("Football"));
			srepository.save(new Sport("Running"));
			srepository.save(new Sport("Swimming"));
			
			erepository.save(new Exercise("Sporttaaja", 12,  srepository.findByName("Football").get(0)));
			erepository.save(new Exercise("Urheilija",  34, srepository.findByName("Swimming").get(0)));	
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all exercises");
			for (Exercise exercise : erepository.findAll()) {
				log.info(exercise.toString());
			}

		};
	}

}
