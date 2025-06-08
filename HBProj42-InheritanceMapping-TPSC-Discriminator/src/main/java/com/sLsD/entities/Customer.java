package com.sLsD.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//Sub-Class#3
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Customer extends Person {
	
	private String billNo;
	private Double billAmt;
	
	public Customer() {
		System.out.println("No Arg Constructor:: Customer");
	}

}
