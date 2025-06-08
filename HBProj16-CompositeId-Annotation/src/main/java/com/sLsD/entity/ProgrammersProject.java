package com.sLsD.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
@Entity
@Table(name="tbl_pgmr_proj")
@DynamicInsert(value = true)
@DynamicUpdate(value = true)
public class ProgrammersProject {
	
	@EmbeddedId()
	private ProgrammersProjectId id;
	@NonNull
	@Column(name = "PGMR_NAME",length = 30,nullable = false)
	private String pgmrName;
	@NonNull
	@Column(name= "PROJ_NAME",length = 30,nullable = false)
	private String projName;
	@NonNull
	@Column(name= "PGMR_SAL",nullable = false)
	private Double pgmrSalary;
	@NonNull
	@Column(name = "PROJ_BUDGET",nullable = false)
	private Double budget;
	
	public ProgrammersProject() {
		System.out.println("Zero Param Constructor:: ProgrammersProject");
	}

}
