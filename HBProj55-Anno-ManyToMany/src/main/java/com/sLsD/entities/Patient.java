package com.sLsD.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name="HB_M2M_BI_PATIENT")
@DynamicInsert(value=true)
@DynamicUpdate(value=true)
public class Patient {
	
	@Id
	@SequenceGenerator(name="cs",sequenceName="HB_M2M_PATIENT_SEQ",initialValue=1000,allocationSize=1)
	@GeneratedValue(generator="cs",strategy=GenerationType.SEQUENCE)
	@Column(name="PATIENTID")
	@NonNull
	private Long patientId;
	@Column(name="PNAME",length = 20,nullable = false)
	@NonNull
	private String patientName;
	@Column(name="AGE",nullable = false,precision = 3,scale = 0)
	@NonNull
	private Integer age;
	@Column(name="DIAGIONISED_WITH",length = 20,nullable = false)
	@NonNull
	private String ailment;
	@ManyToMany(targetEntity = Doctor.class,cascade = CascadeType.ALL,fetch=FetchType.EAGER,mappedBy = "patients")
	@LazyCollection(LazyCollectionOption.EXTRA)
	@NonNull
	private Set<Doctor> doctors;
	
	public Patient() {
		System.out.println("No Arg Constructor:: Patient");
	}
	
	public String toString() {
		return String.format("PID:: %d,PatientName:: %s,Age:: %d,Ailment:: %s",patientId,patientName,age,ailment);
	}

}
