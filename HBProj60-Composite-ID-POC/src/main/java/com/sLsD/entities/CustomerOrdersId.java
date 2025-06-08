package com.sLsD.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
@Embeddable
public class CustomerOrdersId implements Serializable {
	
	@NonNull
	@Column(name="CUST_ID")
	private Long cid;
	@NonNull
	@Column(name="ORDER_ID")
	private Long oid;
	
	
	public CustomerOrdersId() {
		System.out.println("No Args Constructor:: CustomerOrdersId");
	}
	
	
	

}
