package com.sLsD.proxy;

public interface IMovie {
	
	//Declare all the setter and getter methods based on the Entity class Properties
	
	public Long getMid();
	public void setMid(Long mid);
	public String getMname();
	public void setMname(String mname);
	public String getActor();
	public void setActor(String actor);
	public Double getBudget();
	public void setBudget(Double budget);

}
