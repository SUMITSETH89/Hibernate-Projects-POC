package com.sLsD.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
@Embeddable
//Id Class
public class ProgrammersProjectId implements Serializable {

	private static final long serialVersionUID = 1L;
	//Composite Id Properties
	@NonNull
	@Column(name="PGMRID")
	private Long pgmrId;
	@NonNull
	@Column(name="PROJID")
	private Long projId;
	
	public ProgrammersProjectId() {
		System.out.println("Zero Param Constructor:: ProgrammersProjectId");
	}

}
