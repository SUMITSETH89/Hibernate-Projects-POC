package com.sLsD.test;

import com.sLsD.dao.HospitalDAOImpl;
import com.sLsD.dao.IHospitalDAO;
import com.sLsD.util.HibernateUtil;

public class ManyToManyAssociationTest {
	
	public static void main(String[]args) {
		IHospitalDAO dao = new HospitalDAOImpl();
		//dao.saveDataByParent();
		//dao.saveDataByChild();
		dao.loadDataByParent();
		//Close Session Factory
		HibernateUtil.closeSessionFactory();
	}

}
