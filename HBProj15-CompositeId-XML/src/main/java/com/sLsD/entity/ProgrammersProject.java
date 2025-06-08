package com.sLsD.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class ProgrammersProject {
	
	private ProgrammersProjectId id;
	@NonNull
	private String pgmrName;
	@NonNull
	private String projName;
	@NonNull
	private Double pgmrSalary;
	@NonNull
	private Double budget;
	
	public ProgrammersProject() {
		System.out.println("Zero Param Constructor:: ProgrammersProject");
	}

}
