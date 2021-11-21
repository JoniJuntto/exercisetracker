package com.jonij.exercisetracker.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jonij.exercisetracker.domain.Exercise;
import com.jonij.exercisetracker.domain.ExerciseRepository;
import com.jonij.exercisetracker.domain.SportRepository;

@Controller
public class ExerciseController {
	@Autowired
	private ExerciseRepository repository;
	
	@Autowired
	private SportRepository srepository;
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/exerciselist")
    public String exerciseList(Model model) {	
        model.addAttribute("exercises", repository.findAll());
        return "exerciselist";
    }
  
	// RESTful service to get all students
    @RequestMapping(value="/exercises")
    public @ResponseBody List<Exercise> exerciseListRest() {	
        return (List<Exercise>) repository.findAll();
    }    

	// RESTful service to get student by id
    @RequestMapping(value="/exercise/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Exercise> findExerciseRest(@PathVariable("id") Long exerciseId) {	
    	return repository.findById(exerciseId);
    }       
    
    // Add new student
    @RequestMapping(value = "/add")
    public String addExercise(Model model){
    	model.addAttribute("exercise", new Exercise());
    	model.addAttribute("sports", srepository.findAll());
        return "addexercise";
    }     
    
    // Save new student
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Exercise exercise){
        repository.save(exercise);
        return "redirect:exerciselist";
    }    

    // Delete student
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteExercise(@PathVariable("id") Long exerciseId, Model model) {
    	repository.deleteById(exerciseId);
        return "redirect:../exerciselist";
    }  
}
