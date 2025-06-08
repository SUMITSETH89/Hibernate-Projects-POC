package com.sLsD.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Embeddable
public class JobDetails {
	
	@Column(name="JOB")
	@NonNull
	private String job;
	@Column(name="DESIGNATION")
	@NonNull
	private String designation;
	@Column(name="COMPANY")
	@NonNull
	private String company;
	@Column(name="AGE")
	@NonNull
	private Integer age;
	@Column(name="SAL")
	@NonNull
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
