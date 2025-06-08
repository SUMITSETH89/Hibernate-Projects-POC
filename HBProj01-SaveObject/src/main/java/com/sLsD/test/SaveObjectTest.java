package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sLsD.entity.Product;

public class SaveObjectTest {
	
	public static void main(String[]args) throws InterruptedException {
		
		//Activates the Hibernate Framework
		Configuration cfg = new Configuration();
		// Specify the Hibernate cfg File name and location
		cfg.configure("com/sLsD/cfgs/hibernate.cfg.xml");
		//Create Session Factory
		SessionFactory factory = cfg.buildSessionFactory();
		//Create Session object
		Session sess = factory.openSession();
		Transaction tx = null;
		try {
			//Internally invokes conn.setAutoCommit(false) i.e. to disable AutoCommit mode on DB
			tx = sess.beginTransaction();
			//Create Entity class object
			//Thread.sleep(2000);
			Product prod = new Product();
			prod.setpId(2001l);
			prod.setpName("Samsung Phone");
			prod.setPrice(72000.00);
			prod.setQty(1.00);
			sess.save(prod);
			//Internally Invokes conn.commit()
			Thread.sleep(8000);
			tx.commit();
			System.out.println("Object is Persisted Successfully");
			
		}catch(HibernateException he) {
			he.printStackTrace();
			//Internally Invokes conn.rollback() to rollback the result of the query
			tx.rollback();
			System.out.println("Object Is Not Saved(Record Not Inserted)");
		}
		
		//Close Session
		sess.close();
		//Close Session Factory
		factory.close();
		
		
	}

}
