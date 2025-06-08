package com.sLsD.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDetails {
	
	private Long pid;
	private String pname;
	private Double price;
	private Double qty;
}
