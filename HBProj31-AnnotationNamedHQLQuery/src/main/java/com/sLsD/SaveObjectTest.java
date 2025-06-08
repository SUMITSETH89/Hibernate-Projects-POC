package com.sLsD;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sLsD.entity.ProductDetails;
import com.sLsD.util.HibernateUtil;

public class SaveObjectTest {
	
	//Client Application
	
	public static void main(String[]args) {
		
		//Create SessionFactory object having all the required Services
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//Create Session Object
		Session sess = HibernateUtil.getSession();
		
		//Transaction
		Transaction tx = null;
		
		//Try With Resource
		try(factory;sess){
			
			//Open Session
			tx = sess.beginTransaction();
			//Create Entity Class Object
			ProductDetails details = new ProductDetails();
			details.setPname("Apple16 Pro");
			details.setPrice(154000.00);
			details.setQty(1.0);
			//Invoke sess.save(-) to give Insert Persistence Instruction
			Long Id = (Long)sess.save(details);
			//Commit Transaction
			tx.commit();
			System.out.println("Object With Id Persisted:: "+Id);
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null ||tx.getRollbackOnly()) {
				System.out.println("Object Cannot Be Persisted");
				tx.rollback();
			}
		}
	}

}
