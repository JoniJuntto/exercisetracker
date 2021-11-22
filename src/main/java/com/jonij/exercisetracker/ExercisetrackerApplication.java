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

import java.time.LocalDate;

import com.jonij.exercisetracker.ExercisetrackerApplication;
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
			srepository.save(new Sport("Hockey"));
			srepository.save(new Sport("Tennis"));
			srepository.save(new Sport("Weight lifting"));
			srepository.save(new Sport("Basketball"));
			srepository.save(new Sport("Baseball"));
			srepository.save(new Sport("Volleyball"));
			srepository.save(new Sport("Yoga"));
			srepository.save(new Sport("Stretching"));
			srepository.save(new Sport("Biking"));
			srepository.save(new Sport("Dancing"));
			srepository.save(new Sport("Rugby"));
			
			erepository.save(new Exercise("Heartrate higher than usual", 12,  srepository.findByName("Football").get(0), LocalDate.of(2021, 11, 20)));
			erepository.save(new Exercise("Felt easy, feeling good!",  34, srepository.findByName("Swimming").get(0), LocalDate.of(2021,11,21)));	
			
			
			log.info("fetch all exercises");
			for (Exercise exercise : erepository.findAll()) {
				log.info(exercise.toString());
			}

		};
	}

}
