package com.sLsD.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString(exclude = "dept")
public class Employee {
	
	@NonNull
	private Long empId;
	@NonNull
	private String ename;
	@NonNull
	private String designation;
	@NonNull
	private Double salary;
	@NonNull
	private IDepartmentProxy dept;
	
	public Employee() {
		System.out.println("No Args Constructor:: Employee");
	}

}
