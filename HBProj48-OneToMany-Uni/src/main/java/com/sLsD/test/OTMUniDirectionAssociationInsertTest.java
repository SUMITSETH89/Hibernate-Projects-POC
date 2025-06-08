package com.sLsD.test;

import com.sLsD.dao.IPersonDetailsDAO;
import com.sLsD.dao.PersonDetailsDAOImpl;
import com.sLsD.util.HibernateUtil;

public class OTMUniDirectionAssociationInsertTest {
	
	public static void main(String[]args) {
		
		IPersonDetailsDAO dao = new PersonDetailsDAOImpl();
		//Invoke Method
		//dao.saveDataUsingParent();
		dao.loadDataUsingParent();
		//dao.addChildToExistingParent();
		//dao.deleteAllChildrenOfAParent();
		//dao.deleteOneChildFromCollectionOfChildsOfAParent();
		//dao.deleteParentAndItsChilds();
		//Close Session Factory
		HibernateUtil.closeSessionFactory();
	}

}
