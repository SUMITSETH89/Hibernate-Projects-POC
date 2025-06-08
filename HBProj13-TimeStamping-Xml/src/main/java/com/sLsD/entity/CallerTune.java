package com.sLsD.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class CallerTune {
	
	private Long tuneId;
	private String tuneName;
	private String movieName;
	private Integer updationCount;
	
	public CallerTune() {
		System.out.println("Zero Param Constructor::Caller Tune");
	}
	
	

}
