package com.sLsD.test;

import com.sLsD.dao.IOneToOnePKDAO;
import com.sLsD.dao.OneToOnePKDAOImpl;
import com.sLsD.util.HibernateUtil;

public class OneToOnePKTest {
	
	public static void main(String[]args) {
		IOneToOnePKDAO dao = new OneToOnePKDAOImpl();
		//dao.saveDataByParent();
		//dao.saveDataByChild();
		//dao.getDataByParent();
		dao.getDataByChild();
		//Close Session Factory
		HibernateUtil.closeSessionFactory();
	}
}
