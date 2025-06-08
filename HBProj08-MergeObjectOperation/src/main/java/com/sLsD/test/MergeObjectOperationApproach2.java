package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.sLsD.entity.Product;
import com.sLsD.util.HibernateUtil;

public class MergeObjectOperationApproach2 {
	
	public static void main(String[]args) {
		
		//Create SessionFactory along with the required Services
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//Open a Session With DB
		Session sess = HibernateUtil.getSession();
		
		//Transaction
		Transaction tx = null;
		//Try With Resource
		try(factory;sess){
			//Begin Transaction
			tx = sess.beginTransaction();
			//Load the Object
			Product prod = sess.get(Product.class,2022l);
			if(prod!=null) {
				System.out.println(prod);
			}
			//Create Another Entity class object to perform another Persistence Operation
			Product prod1 = new Product();
			prod1.setPid(2022l);
			prod1.setPname("GoldSpoon");
			prod1.setPrice(195000.00);
			prod1.setQty(1.00);
			
		    //Update Object
			sess.update(prod1);//Tries to put another object of Entity class 
							   //having same Id Value in L1/Level1 Cache.
							   //This process throws org.hibernate.NonUniqueObjectException: 
							   // A different object with the same identifier value was already 
							   //associated with the session
			//Commit tx
			tx.commit();
			
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Record Not Inserted Or Updated");
			}
		}
	}

}
