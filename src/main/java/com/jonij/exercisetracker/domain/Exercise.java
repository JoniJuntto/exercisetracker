package com.jonij.exercisetracker.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.bytebuddy.asm.Advice.Local;

@Entity
public class Exercise {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String notes;
	private Integer time; 
	private LocalDate timestamp;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name= "sportid")
	private Sport sport;
	
	public Exercise() {}
	public Exercise(String notes, Integer time, Sport sport, LocalDate timestamp) {
		super();
		this.notes = notes;
		this.time = time;
		this.sport = sport;
		this.timestamp = timestamp;

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public Sport getSport() {
		return sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public LocalDate getTimestamp(){
		return timestamp;
	}
	public void setTimestamp(LocalDate timestamp){
		this.timestamp = LocalDate.now();
	}
	@Override
	public String toString() {
		return "Exercise [id=" + id + ", notes=" + notes + ", sport=" + sport + ", time=" + time + ", timestamp="
				+ timestamp + "]";
	}

	
	
}
