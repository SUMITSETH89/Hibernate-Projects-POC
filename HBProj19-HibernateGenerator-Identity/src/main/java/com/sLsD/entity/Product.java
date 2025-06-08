package com.sLsD.entity;

import java.io.Serializable;

//Entity/Model/Persistence/Domain Class
public class Product implements Serializable {
	
	private static final long serialVersionUID = -3580554353916264518L;
	
	private Long pId;
	private String pName;
	private Double price;
	private Double qty;
	
	public Product() {
		System.out.println("Zero Param Constructor:: "+this.hashCode());
		//System.out.println(toString());
	}
	
	public Long getpId() {
		return pId;
	}
	public void setpId(Long pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getQty() {
		return qty;
	}
	public void setQty(Double qty) {
		this.qty = qty;
	}
	
	public String toString() {
		return String.format("PID:: %d, PNAME:: %s, PRICE:: %d, Quantity:: %d",pId,pName,price,qty);
	}
	
	
	
	
	

}
