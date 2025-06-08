package com.sLsD.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Setter
@Getter
@AllArgsConstructor
public class PhoneNumber implements Serializable {
	
	private Long regNo;
	private Long mobileNumber;
	private String numberType;
	private String operator;
	
	public PhoneNumber() {
		System.out.println("No Arg Constructor:: PhoneNumber");
	}
	
	@Override
	public String toString() {
		return String.format("Reg-No:: %d,Mobile-Number:: %d,Number-Type:: %s,Provider:: %s",regNo,mobileNumber,numberType,operator);
	}
	

}
