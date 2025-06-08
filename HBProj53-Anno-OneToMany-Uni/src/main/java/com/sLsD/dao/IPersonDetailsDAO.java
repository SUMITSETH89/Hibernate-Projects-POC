package com.sLsD.dao;

import java.util.List;

import com.sLsD.entities.Person;

public interface IPersonDetailsDAO {
	
	public void saveDataUsingParent();
	public List<Person> loadDataUsingParent();
	public void addChildToExistingParent();
	public void deleteAllChildrenOfAParent();
	public void deleteOneChildFromCollectionOfChildsOfAParent();
	public void deleteParentAndItsChilds();
	

}
