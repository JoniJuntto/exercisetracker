package com.jonij.exercisetracker.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SportRepository extends CrudRepository<Sport, Long>{
	List<Sport> findByName(String name);
}
