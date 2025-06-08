package com.sLsD.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Proxy;

import com.sLsD.proxy.IMovie;

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
//Approach#1:: Setting Lazy attribute to true
//@Proxy(lazy = false)

//Approach#2:: Making the Entity class final

//Approach#3:: Making Entity class implementing Proxy Interface
@Proxy(proxyClass = com.sLsD.proxy.IMovie.class)
public final class Movie implements IMovie {
	
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
