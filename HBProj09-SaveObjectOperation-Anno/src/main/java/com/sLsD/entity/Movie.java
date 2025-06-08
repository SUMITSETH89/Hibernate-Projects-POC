package com.sLsD.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//Entity class with Mapping Annotations
@Entity
@Table(name = "tbl_movie_info")
@Setter
@Getter
@AllArgsConstructor
@ToString
@DynamicInsert
public class Movie {
	
	@Id
	@Column(name="MID")
	private Long mid;
	@Column(name="MNAME")
	private String mname;
	@Column(name="ACTOR")
	private String actor;
	@Column(name="BUDGET")
	//@Transient
	private Double budget;
	
	public Movie() {
		System.out.println("No Arg Constructor::Movie");
	}

}
