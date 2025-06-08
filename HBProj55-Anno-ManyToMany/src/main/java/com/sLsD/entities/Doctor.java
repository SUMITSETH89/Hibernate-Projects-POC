package com.sLsD.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name="HB_M2M_BI_DOCTOR")
@DynamicInsert(value=true)
@DynamicUpdate(value=true)
public class Doctor {
	
	@Id
	@SequenceGenerator(name="ps",sequenceName="HB_DOCTOR_M2M_SEQ",initialValue=100,allocationSize=5)
	@GeneratedValue(generator="ps",strategy=GenerationType.SEQUENCE)
	@Column(name="DOCID")
	@NonNull
	private Long docId;
	@Column(name="DOC_NAME",length = 15,nullable = false)
	@NonNull
	private String docName;
	@Column(name="SPECIALIZATION",length = 20,nullable = false)
	@NonNull
	private String specialization;
	@Column(name="HOSPITAL",length = 15,nullable = false)
	@NonNull
	private String hospital;
	@ManyToMany(targetEntity = Patient.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="ANNO_HB_DOCTORS_PATIENTS",
			   joinColumns = @JoinColumn(name="DID",referencedColumnName = "DOCID"),
			   foreignKey = @ForeignKey(name="FK_DID_DOCTOR"),
	           inverseJoinColumns = @JoinColumn(name = "PID",referencedColumnName = "PATIENTID"),
	           inverseForeignKey = @ForeignKey(name = "FK_PID_PATIENT"))
	@LazyCollection(LazyCollectionOption.EXTRA)
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
