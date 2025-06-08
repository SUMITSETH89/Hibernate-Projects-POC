package com.sLsD.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
@Entity
@Table(name="tbl_person_details")
public class Person {
	
	@GenericGenerator(name = "incr",strategy = "increment")
	@GeneratedValue(generator = "incr")
	@Id
	@Column(name="PID")
	@NonNull
	private Long pid;
	@NonNull
	@Column(name="PNAME")
	private String pname;
	@NonNull
	@Column(name="address")
	private String paddrs;
	@Embedded
	private JobDetails jobDetails;
	
	public Person() {
		System.out.println("No Args Constructor::Person");
	}

}
