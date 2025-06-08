package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sLsD.entity.Product;

public class LoadObjectOperationTest {
	
	public static void main(String[]args) {
		
		//Bootstrap Hibernate Framework
		Configuration cfg = new Configuration();
		//Name and Location of Hibernate Configuration File
		cfg.configure("com/sLsD/cfgs/hibernate.cfg.xml");
		
		
		//Create SessionFactory object having all the required Services
		try(SessionFactory factory = cfg.buildSessionFactory();
				Session sess = factory.openSession();){
			
			//Load Object Operation
			
			Product prod = sess.load(Product.class,1002l);
			System.out.println("Class Name:: "+prod.getClass().getName()+" Super Class:: "+prod.getClass().getSuperclass());
			System.out.println("Id:: "+prod.getPid());
			try {
				Thread.sleep(5000);
				System.out.println(prod);
			}catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}catch(HibernateException he) {
			he.printStackTrace();
			System.out.println("Record Not Found");
		}
		
		
	}

}
