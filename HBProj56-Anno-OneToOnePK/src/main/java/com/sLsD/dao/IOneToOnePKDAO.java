package com.sLsD.dao;

public interface IOneToOnePKDAO {
	
	public void saveDataByParent();
	public void saveDataByChild();
	public void getDataByParent();
	public void getDataByChild();
	public void deleteRecordByParent();
	public void deleteRecordByChild();

}
