package com.sLsD.entities;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Patient {
	
	@NonNull
	private Long patientId;
	@NonNull
	private String patientName;
	@NonNull
	private Integer age;
	@NonNull
	private String ailment;
	@NonNull
	private Set<Doctor> doctors;
	
	public Patient() {
		System.out.println("No Arg Constructor:: Patient");
	}
	
	public String toString() {
		return String.format("PID:: %d,PatientName:: %s,Age:: %d,Ailment:: %s",patientId,patientName,age,ailment);
	}

}
