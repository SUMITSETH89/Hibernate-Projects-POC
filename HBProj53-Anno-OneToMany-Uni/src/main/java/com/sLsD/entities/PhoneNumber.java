package com.sLsD.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name="OTM_UNI_ANNO_PHONE_NUMBER")
public class PhoneNumber implements Serializable {
	
	@Id
	@SequenceGenerator(name = "dSeq",sequenceName = "HB_OTM_UNI_ANNO_PHNO_SEQ", allocationSize = 2,initialValue = 2000)
	@GeneratedValue(generator = "dSeq",strategy = GenerationType.SEQUENCE)
	@Column(name="REG_NO")
	private Long regNo;
	@Column(name="MOBILE_NO")
	private Long mobileNumber;
	@Column(name="No_TYPE",length = 15,nullable=false)
	private String numberType;
	@Column(name="PROVIDER",length = 15,nullable = false)
	private String operator;
	
	public PhoneNumber() {
		System.out.println("No Arg Constructor:: PhoneNumber");
	}
	
	@Override
	public String toString() {
		return String.format("Reg-No:: %d,Mobile-Number:: %d,Number-Type:: %s,Provider:: %s",regNo,mobileNumber,numberType,operator);
	}
	

}
