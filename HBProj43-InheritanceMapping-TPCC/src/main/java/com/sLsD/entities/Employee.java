package com.sLsD.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//Sub-Class#2
@Setter
@Getter
@AllArgsConstructor
public class Employee extends Person {

	private String company;
	private String designation;
	private Integer experience;
	private Double salary;
	
	public Employee() {
		System.out.println("No Arg Constructor:: Employee");
	}

	@Override
	public String toString() {
		return "Employee [company=" + company + ", designation=" + designation + ", experience=" + experience
				+ ", salary=" + salary + "Person= "+super.toString()+"]";
	}

	
	
	
}
