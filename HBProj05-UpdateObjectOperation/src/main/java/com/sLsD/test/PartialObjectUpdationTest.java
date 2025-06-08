package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sLsD.entity.Product;

public class PartialObjectUpdationTest {
	
	public static void main(String[]args) {
		
		//Start Hibernate Framework
		Configuration cfg = new Configuration();
		//Specify the name and location of hiberante.cfg.xml file
		cfg.configure("com/sLsD/cfgs/hibernate.cfg.xml");
		
		//Create SessionFactory object having all the required services
		SessionFactory factory = cfg.buildSessionFactory();
		
		//Create a Session
		Session sess = factory.openSession();
		
		//Transaction
		Transaction tx = null;
		
		//Try With Resource
		try(factory;sess){
			
			//Load the object
			Product prod = sess.get(Product.class, 1002l);
			if(prod == null) {
				//Here we can find out whether the record is available or not before updating the record.
				System.out.println("Record Not Found");
				return;
			}else {
				
				//Begin Transaction
				tx = sess.beginTransaction();
				prod.setPrice(28000.00);
				//Here sess.update(-) method is using Pre-generated Update SQL Query
				//by involving all the columns,though we are updating partially.
				//To make Hibernate F/w using dynamically generated Update SQL Query
				// by involving only required properties we need to place 'dynamic-update = true'
				// in the <class> tag of Mapping file.
				sess.update(prod);
				//Commit Transaction
				tx.commit();
				System.out.println("Partial Object Is Updated");
				
			}
			
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Record Not Updated");
			}
		}
	}

}
