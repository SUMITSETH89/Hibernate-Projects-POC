package com.sLsD.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Entity
@DiscriminatorValue(value="cheque_pay")
@DynamicInsert
@DynamicUpdate
public class ChequePayment extends Payment {
	
	@Column(name="c_no")
	private Long chequeNo;
	@Column(name="C_TYPE",length = 10)
	private String chequeType;
	
	public ChequePayment() {
		System.out.println("No Args Constructor:: ChequePayment");
	}
	
	public String toString() {
		return String.format("ChequeNo:: %d,ChequeType:: %s,Super:: %s",chequeNo,chequeType,super.toString());
	}
	
	

}
