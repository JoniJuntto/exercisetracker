package com.jonij.exercisetracker.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
	List <Exercise> findByNickname(String nickname);
}
