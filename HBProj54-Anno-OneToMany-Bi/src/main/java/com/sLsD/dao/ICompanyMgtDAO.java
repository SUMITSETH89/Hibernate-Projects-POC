package com.sLsD.dao;

public interface ICompanyMgtDAO {
	
	public void saveDataUsingChild();
	public void saveDataUsingParent();
	public void fetchByParent();
	public void fetchByChildWithProxy();
	public void fetchByChildWithNoProxy();

}
