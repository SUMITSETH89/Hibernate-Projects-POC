package com.sLsD.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class JobDetails {
	
	private String job;
	private String designation;
	private String company;
	private Integer age;
	private Double salary;
	
	public JobDetails() {
		super();
		System.out.println("No Args Constructor::JobDetails");
	}
	
	public JobDetails(String job,String designation,String company,Integer age,Double salary) {
		this();
		this.job = job;
		this.designation = designation;
		this.company = company;
		this.age = age;
		this.salary = salary;
	}
	

}
