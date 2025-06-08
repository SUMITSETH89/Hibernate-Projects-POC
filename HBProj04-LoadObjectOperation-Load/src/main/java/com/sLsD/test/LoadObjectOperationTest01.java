package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sLsD.entity.Product;
//Approach#1 Setting lazy attribute to false of <class> tag of Mapping File
public class LoadObjectOperationTest01 {
	
	public static void main(String[]args) {
		
		//Bootstrap Hibernate Framework
		Configuration cfg = new Configuration();
		//Name and Location of Hibernate Configuration File
		cfg.configure("com/sLsD/cfgs/hibernate.cfg.xml");
		
		
		//Create SessionFactory object having all the required Services
		try(SessionFactory factory = cfg.buildSessionFactory();
				Session sess = factory.openSession();){
			
			//Load Object Operation
			
			Product prod = sess.load(Product.class,1002l);//Performs Eager Loading of Object
			System.out.println("Class Name:: "+prod.getClass().getName()+" Super Class:: "+prod.getClass().getSuperclass());
		}catch(HibernateException he) {
			he.printStackTrace();
			System.out.println("Record Not Found");
		}
		
		
	}

}
