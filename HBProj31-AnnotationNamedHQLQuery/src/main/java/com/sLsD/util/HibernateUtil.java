package com.sLsD.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory factory = null;
	
	static {
		System.out.println("Hibernate Util:: Static Block");
		//Bootstrap Hibernate Framework
		Configuration cfg = new Configuration();
		//Specify the name and location of hibernate.cfg.xml file
		cfg.configure("com/sLsD/cfgs/hibernate.cfg.xml");
		//Create SessionFactory having all the required Services
		factory = cfg.buildSessionFactory();
		
	}
	
	public static SessionFactory getSessionFactory() {
		return factory!=null?factory:null;
	}
	
	public static Session getSession() {
		return factory!=null?factory.openSession():null;
	}
	
	 

}
