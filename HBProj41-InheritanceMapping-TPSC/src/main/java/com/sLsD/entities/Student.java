package com.sLsD.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//Sub-Class#1
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Student extends Person {
    
	private String instituteName;
	private String course;
	private Integer batch;
	private Integer courseDuration;
	
	public Student() {
		System.out.println("No Args Constructor:: Student");
	}
	
}
