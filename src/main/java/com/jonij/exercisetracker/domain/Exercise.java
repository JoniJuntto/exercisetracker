package com.jonij.exercisetracker.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Exercise {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nickname;
	private Integer time; 
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name= "sportid")
	private Sport sport;
	
	public Exercise() {}
	public Exercise(String nickname, Integer time, Sport sport) {
		super();
		this.nickname = nickname;
		this.time = time;
		this.sport = sport;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	@Override
	public String toString() {
		return "Exercise [id=" + id + ", nickname=" + nickname + ", time=" + time + ", sport=" + sport + "]";
	}
	
}
