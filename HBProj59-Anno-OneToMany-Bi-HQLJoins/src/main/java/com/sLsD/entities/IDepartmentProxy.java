package com.sLsD.entities;

import java.util.Set;

public interface IDepartmentProxy {
	
	public void setDeptNo(Long deptNo);
	public Long getDeptNo();
	public void setDeptName(String deptName);
	public String getDeptName();
	public void setDeptHead(String deptHead);
	public String getDeptHead();
	public void setEmployees(Set<Employee> employees);
	public Set<Employee> getEmployees();

}
