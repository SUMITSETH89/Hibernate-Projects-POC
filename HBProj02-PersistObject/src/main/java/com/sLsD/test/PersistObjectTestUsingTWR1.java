package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sLsD.entity.Product;

public class PersistObjectTestUsingTWR1 {
	
	public static void main(String[]args) {
		Transaction tx = null;
		//Activates Hibernate Framework
		Configuration cfg = new Configuration();
		//Specify the name and location of Hibernate.cfg.xml
		cfg.configure("com/sLsD/cfgs/hibernate.cfg.xml");
		//try(ObjectCreation)Java7/8
		try(SessionFactory factory = cfg.buildSessionFactory();
				 Session sess = factory.openSession();){
			
			//Internally invokes conn.setAutoCommit(false)
			tx = sess.beginTransaction();
			//Create Entity class object
			Product prod = new Product();
			prod.setpName("Samsung A20");
			prod.setPrice(13500.00);
			prod.setQty(1.0);
			sess.persist(prod);
			//Commit 
			tx.commit();
			System.out.println("Object Is Persisted Successfully");	
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getRollbackOnly() && tx.getStatus()!=null) {
				tx.rollback();
				System.out.println("Object Not Persisted");
			}
		}
	}

}
