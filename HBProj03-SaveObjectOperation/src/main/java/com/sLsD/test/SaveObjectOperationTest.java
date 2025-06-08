package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sLsD.entity.Product;

public class SaveObjectOperationTest {
	
	public static void main(String[]args) {
		
		//Bootstrap Hibernate Framework
		Configuration cfg = new Configuration();
		//Name and Location of Hibernate Configuration File
		cfg.configure("com/sLsD/cfgs/hibernate.cfg.xml");
		
		
		//Create SessionFactory object having all the required Services
		SessionFactory factory = cfg.buildSessionFactory();
		Session sess = factory.openSession();
		
		try(factory;sess){
			
			//Load Object Operation
			Product prod = sess.get(Product.class,Long.valueOf(1005));
			if(prod==null) {
				System.out.println("Record Not Found");
			}else {
				System.out.println(prod);
			}
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}
		
		
	}

}
