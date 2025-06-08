package com.sLsD.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

//Root Class
@Setter
@Getter
@AllArgsConstructor
@ToString
@Entity
@Table(name="ANNO_INH_PAYMENT_TPSC")
@Inheritance(strategy=InheritanceType.JOINED)//To Specify Inheritance Mapping Strategy

public class Payment {
	
	@Id
	@GenericGenerator(name="incr",strategy = "increment")
	@GeneratedValue(generator = "incr")
	@NonNull
	@Column(name="TX_ID")
	private Long txId;
	
	@NonNull
	@Column(name="AMT")
	private Double amount;
	
	@NonNull
	@Column(name="TX_DATE")
	private LocalDateTime txDate;
	
	@CreationTimestamp
	@Column(name="CREATED_ON")
	private LocalDateTime recordCreatedOn;
	
	@UpdateTimestamp
	@Column(name="UPDATED_ON")
	private LocalDateTime recordModifiedOn;
	
	public Payment() {
		System.out.println("No Args Constructor:: Payment");
	}

}
