package com.sLsD.entity;

import java.io.Serializable;

import com.sLsD.proxy.IProduct;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//Entity/Model/Persistence/Domain Class
//@Data
@Getter
@Setter
@AllArgsConstructor
public final class Product implements Serializable,IProduct {
	
	private static final long serialVersionUID = -3580554353916264518L;
	
	private Long pid;
	private String pname;
	private Double price;
	private Double qty;
	
	public Product() {
		System.out.println("Zero Param Constructor"+this.hashCode());
	}

	@Override
	public String toString() {
		System.out.println("Product To String Method");
		return String.format("%d %s %.2f %.2f",pid,pname,price,qty);
	}
}
