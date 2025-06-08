package com.sLsD.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

//Entity/Model/Persistence/Domain Class
@Data
@AllArgsConstructor
public class Product implements Serializable {
	
	private static final long serialVersionUID = -3580554353916264518L;
	
	private Long pid;
	private String pname;
	private Double price;
	private Double qty;
	
	public Product() {
		System.out.println("Zero Param Constructor");
	}
	
		
	
	
	
	

}
