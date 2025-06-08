package com.sLsD.entities;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Setter
@Getter
@AllArgsConstructor
public class Person implements Serializable {
	
	private Long pid;
	private String pname;
	private String address;
	private List<PhoneNumber> numList;
	
	
	public Person() {
		System.out.println("No Arg Constructor:: Person");
	}
	
	@Override
	public String toString() {
		return String.format("PID:: %d,PNAME:: %s,ADDRESS:: %s",pid,pname,address);
	}
	

}
