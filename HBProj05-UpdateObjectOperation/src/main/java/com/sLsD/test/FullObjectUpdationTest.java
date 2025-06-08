package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sLsD.entity.Product;

public class FullObjectUpdationTest {
	
	public static void main(String[]args) {
		
		//Bootstrap Hiberante Framework
		Configuration cfg = new Configuration();
		//Provide the name and location of hibernate.cfg.xml file
		cfg.configure("com/sLsD/cfgs/hibernate.cfg.xml");
		//Create SessionFactory object having all the required Services.
		SessionFactory factory = cfg.buildSessionFactory();
		//Create Session With DB
		Session sess = factory.openSession();
		
		//Transaction
		Transaction tx = null;
	    //Try With Resource
		try(factory;sess){
			//Start Transaction
			tx = sess.beginTransaction();
			//Create Entity Class object having valid values.
			Product prod = new Product();//throws org.hibernate.TransientObjectException
			prod.setPid(1005l);
			prod.setPname("Motorola");
			prod.setPrice(24000.00);
			prod.setQty(2.0);
			//Update the Record
			sess.update(prod);
			//Commit the transaction
			tx.commit();
			System.out.println("Full Object Updated");
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Record Not Updated");
			}
			tx.rollback();
			
		}
	}

}
