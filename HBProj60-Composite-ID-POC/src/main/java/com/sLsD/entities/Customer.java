package com.sLsD.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "CUSTOMERS_ORDERS")
@DynamicInsert(value=true)
@DynamicUpdate(value=true)
public class Customer {
	
	@NonNull
	@EmbeddedId
	private CustomerOrdersId id;
	@NonNull
	@Column(name="PRODUCT",length = 20,nullable = false)
	private String product;
	@NonNull
	@Column(name="PRICE",precision = 7,scale = 2,nullable = false)
	private Double price;
	@NonNull
	@Column(name="ADDRESS",length = 30,nullable = false)
	private String address;
	@NonNull
	@Column(name="PURCHASE_DATE",nullable = false)
	private Date dop;
	
	
	public Customer() {
		System.out.println("No Arg Constructor:: Customer");
	}

}
