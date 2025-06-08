package com.sLsD.entities;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString(exclude = "employees")
public class Department implements IDepartmentProxy {
	
	@NonNull
	private Long deptNo;
	@NonNull
	private String deptName;
	@NonNull
	private String deptHead;
	@NonNull
	private Set<Employee> employees;
	
	public Department() {
		System.out.println("No Arg Constructor:: Department");
	}

}
