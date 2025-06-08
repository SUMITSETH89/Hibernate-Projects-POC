package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sLsD.entity.Product;
import com.sLsD.util.HibernateUtil;

public class SaveObjectOperationTestInBatch {
	
	public static void main(String[]args) {
		
		//Create Session Factory Object Having All the Required Services
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//Create Session Object
		Session sess = HibernateUtil.getSession();
		//Transaction
		Transaction tx = null;
		//Try With Resource
		try(factory;sess){
		//Begin Transaction
	    tx = sess.beginTransaction();
		//Create Entity class object
	    Product prod = new Product();
	    prod.setpName("Samsung S25");
	    prod.setPrice(144000.00);
	    prod.setQty(1.0);
	    //sess.save(-) to give Insert Persistence Instruction 
	    Long pid = (Long)sess.save(prod);
	    try {
	    	//Hold the Application Execution and Start execution of the same application on Multiple JVM Instances.
	    	Thread.sleep(8000);
	    	//Commit
		    tx.commit();
	    }catch(InterruptedException ie) {
	    	ie.printStackTrace();
	    }
	    
	    System.out.println("Object With Id::"+pid+" Inserted Successfully");
			
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Object Not Inserted");
			}
		}
	}

}
