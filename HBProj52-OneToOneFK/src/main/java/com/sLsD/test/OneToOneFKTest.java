package com.sLsD.test;

import com.sLsD.dao.IPersonPassportOTOFKDAO;
import com.sLsD.dao.PersonPassportDAOImpl;
import com.sLsD.util.HibernateUtil;

public class OneToOneFKTest {
	
	public static void main(String[]args) {
		IPersonPassportOTOFKDAO dao = new PersonPassportDAOImpl();
		dao.saveDateByChild();
		//Close Session Factory
		HibernateUtil.closeSessionFactory();
	}

}
