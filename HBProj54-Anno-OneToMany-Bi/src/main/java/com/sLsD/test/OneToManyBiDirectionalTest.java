package com.sLsD.test;

import com.sLsD.dao.CompanyMgtDAOImpl;
import com.sLsD.dao.ICompanyMgtDAO;
import com.sLsD.util.HibernateUtil;

public class OneToManyBiDirectionalTest {
	
	public static void main(String[]args) {
		ICompanyMgtDAO dao = new CompanyMgtDAOImpl();
		//dao.saveDataUsingChild();
		//dao.saveDataUsingParent();
		//dao.fetchByParent();
		//dao.fetchByChildWithProxy();
		//dao.fetchByChildWithNoProxy();
		//Close Session Factory
		HibernateUtil.closeSessionFactory();
	}

}
