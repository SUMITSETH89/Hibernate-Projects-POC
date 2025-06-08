package com.sLsD.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class ProgrammersProjectId implements Serializable {

	private static final long serialVersionUID = 1L;
	//Composite Id Properties
	@NonNull
	private Long pgmrId;
	@NonNull
	private Long projId;
	
	public ProgrammersProjectId() {
		System.out.println("Zero Param Constructor:: ProgrammersProjectId");
	}

}
