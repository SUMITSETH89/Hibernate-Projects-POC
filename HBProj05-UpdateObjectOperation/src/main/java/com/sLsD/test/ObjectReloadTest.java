package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sLsD.entity.Product;

public class ObjectReloadTest {
	
	public static void main(String[]args) {
		
		//Start Hibernate Framework
		Configuration cfg = new Configuration();
		//Specify the name and location of hiberante.cfg.xml file
		cfg.configure("com/sLsD/cfgs/hibernate.cfg.xml");
		
		//Create SessionFactory object having all the required services
		SessionFactory factory = cfg.buildSessionFactory();
		
		//Create a Session
		Session sess = factory.openSession();

		//Try With Resource
		try(factory;sess){
			
			//Load the object
			Product prod = sess.get(Product.class, 2004l);
			if(prod == null) {
				//Here we can find out whether the record is available or not before updating the record.
				System.out.println("Record Not Found");
				return;
			}else {
				
				System.out.println(prod);
				try {
					//Stop Application Excution
					Thread.sleep(20000);
					sess.refresh(prod);
					System.out.println(prod);//Reload the object data from DB Table Record by re-generating Select SQL Query.
					
				}catch(InterruptedException ie) {
					ie.printStackTrace();
				}
				
			}
			
		}catch(HibernateException he) {
			he.printStackTrace();
			
		}
	}

}
