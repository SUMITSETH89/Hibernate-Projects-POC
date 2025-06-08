package com.sLsD.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name="ANNO_FK_O2O_PASSPORT")
public class Passport {
	@Id
	@GenericGenerator(name="ci",strategy="identity")
	@GeneratedValue(generator="ci")
	@Column(name="PASSPORTNO")
	@NonNull
	private Long passportNo;
	@Column(name="ISSUED_ON",nullable = false)
	@NonNull
	private LocalDate issuedOn;
	@Column(name="EXPIRED_ON",nullable = false)
	@NonNull
	private LocalDate expiredOn;
	@Column(name="ORIGIN",length = 20,nullable = false)
	private String country;
	@OneToOne(targetEntity=Person.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="PERSON_ID",referencedColumnName="PID",nullable = false)
	private Person personDetails; //One-to-One Association
	
	public Passport() {
		System.out.println("No Args Constructor:: Passport");
	}

	@Override
	public String toString() {
		return "Passport [passportNo=" + passportNo + ", issuedOn=" + issuedOn + ", expiredOn=" + expiredOn
				+ ", country=" + country +"]";
	}
	
	
	
	

}
