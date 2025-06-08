package com.sLsD.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Stock {
	
	
	private Long stockId;
	@NonNull
	private String stockName;
	@NonNull
	private Double price;
	@NonNull
	private String exchange;
	@NonNull
	private Date lastUpdated;
	
	public Stock() {
		System.out.println("No Arg Constructor:: Stock");
	}

}
