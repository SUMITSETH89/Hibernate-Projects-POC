package com.sLsD.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
@Table(name="ANNO_FK_O2O_PERSON")
public class Person {
	@Id
	@SequenceGenerator(name="ps",sequenceName="HB_OTO_FK_SEQ",initialValue=1000,allocationSize=1)
	@GeneratedValue(generator="ps",strategy=GenerationType.SEQUENCE)
	@Column(name="PID")
	@NonNull
	private Long pid;
	@Column(name="PNAME",length = 15,nullable = false)
	@NonNull
	private String pname;
	@Column(name="ADDRESS",length = 30,nullable = false)
	@NonNull
	private String address;
	@OneToOne(targetEntity=Passport.class,cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "personDetails")
	private Passport personPassport;
	
	
	public Person() {
		System.out.println("No Arg Constructor:: Person");
	}
	

}
