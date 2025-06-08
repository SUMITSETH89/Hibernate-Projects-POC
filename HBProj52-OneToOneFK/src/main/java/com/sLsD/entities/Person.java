package com.sLsD.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Person {
	
	private Long pid;
	private String pname;
	private String address;
	
	
	public Person() {
		System.out.println("No Arg Constructor:: Person");
	}
	

}
