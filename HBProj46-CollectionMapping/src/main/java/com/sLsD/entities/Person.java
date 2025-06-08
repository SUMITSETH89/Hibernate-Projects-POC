package com.sLsD.entities;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Person {
	
	
	private Long pid;
	@NonNull
	private String pname;
	@NonNull
	private String address;
	@NonNull
	private List<String> nickNames;
	@NonNull
	private List<String> friends;
	@NonNull
	private Set<Long> contacts;
	@NonNull
	private Map<String,Long>idDetails;
	
	public Person() {
		System.out.println("Zero Param Constructor:: Person");
	}

}
