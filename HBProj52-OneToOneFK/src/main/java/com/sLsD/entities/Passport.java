package com.sLsD.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Passport {
	
	private Long passportNo;
	private LocalDate issuedOn;
	private LocalDate expiredOn;
	private String country;
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
