package com.sLsD.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Student {
	
	@NonNull
	private Long sid;
	@NonNull
	private String sname;
	@NonNull
	private String institute;
	@NonNull
	private String course;
	@NonNull
	private Integer duration;
	
	public Student() {
		System.out.println("No Arg Constructor:: Student");
	}
	

}
