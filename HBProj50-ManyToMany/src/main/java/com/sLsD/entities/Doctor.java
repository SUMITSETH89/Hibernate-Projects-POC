package com.sLsD.entities;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Doctor {
	
	@NonNull
	private Long docId;
	@NonNull
	private String docName;
	@NonNull
	private String specialization;
	@NonNull
	private String hospital;
	@NonNull
	private Set<Patient> patients;
	
	public Doctor() {
		System.out.println("No Param Constructor:: Doctor");
	}
	
	@Override
	public String toString() {
		return String.format("DoctorID::%d,Name:: %s,Specialization::%s,Hospital:: %s",docId,docName,specialization,hospital);
	}

}
