package com.sLsD.entities;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Setter
@Getter
@AllArgsConstructor
public class LibraryMembership implements Serializable {
	
	private Long membershipId;
	private String college;
	private Integer validFor;
	private Date joiningDate;
	private Student studentDetails;
	
	public LibraryMembership() {
		System.out.println("Zero Param Constructor:: LibraryMembership");
	}
	
	@Override
	public String toString() {
		return String.format("MembershipId:: %d,College:: %s,Validity:: %d, JoiningDate:: %s",membershipId,college,validFor,joiningDate);
	}

}
