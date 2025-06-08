package com.sLsD.proxy;

public interface IProduct {
	
	//Create Proxy Interface having setter and getter method declarations
	// based on Entity class properties.
	public void setPid(Long pid);
	public void setPname(String pname);
	public void setPrice(Double price);
	public void setQty(Double qty);
	public Long getPid();
	public String getPname();
	public Double getPrice();
	public Double getQty();

}
