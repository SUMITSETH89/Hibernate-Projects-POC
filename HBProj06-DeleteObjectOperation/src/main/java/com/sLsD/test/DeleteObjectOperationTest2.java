package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sLsD.entity.Product;

public class DeleteObjectOperationTest2 {
	
	public static void main(String[]args) {
		
		//Start Hibernate Framework
		Configuration cfg = new Configuration();
		//Specify the name and location of hibernate.cfg.xml
		cfg.configure("com/sLsD/cfgs/hibernate.cfg.xml");
		
		//Create SessionFactory having all the required Services
		SessionFactory factory = cfg.buildSessionFactory();
		//Create a new Session
		Session sess = factory.openSession();
		
		//Transaction
		Transaction tx = null;
		//Try With Resource
		try(factory;sess){
			//Load the Object
			Product prod = sess.get(Product.class,2003l);
			if(prod==null) {
				System.out.println("No Record Found");
				return;
			}else {
				//Delete Operation must be performed within the Transactional Environment
				tx = sess.beginTransaction();
				//Delete the Record based on the given Id
				sess.delete(prod);
				tx.commit();
				System.out.println("Record Deleted");
			}
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Record Not Deleted");
			}
		}
	}

}
