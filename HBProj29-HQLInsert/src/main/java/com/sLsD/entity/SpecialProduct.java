package com.sLsD.entity;

import java.io.Serializable;

//Entity/Model/Persistence/Domain Class
public class SpecialProduct implements Serializable {
	
	private static final long serialVersionUID = -3580554353916264518L;
	
	private Long pId;
	private String pname;
	private Integer price;
	private Integer qty;
	
	public SpecialProduct() {
		System.out.println("Zero Param Constructor Special Product");
		//System.out.println(toString());
	}
	
	public Long getpId() {
		return pId;
	}
	public void setpId(Long pId) {
		this.pId = pId;
	}
	
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		System.out.println("SpecialProduct.setPrice()");
		this.price = price;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		System.out.println("SpecialProduct.setQty()");
		this.qty = qty;
	}

	public String toString() {
		return String.format("PID:: %d, PNAME:: %s, PRICE:: %d, Quantity:: %d",pId,pname,price,qty);
	}
	
	
	
	
	

}
