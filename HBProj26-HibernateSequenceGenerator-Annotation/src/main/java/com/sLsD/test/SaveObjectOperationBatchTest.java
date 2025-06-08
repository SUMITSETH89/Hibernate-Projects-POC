package com.sLsD.test;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sLsD.entity.Product;
import com.sLsD.util.HibernateUtil;

public class SaveObjectOperationBatchTest {
	
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
	    
	    //Inserting Entity Object Data in batch
	    Long[] ids = new Long[5];
	    for(int i=0;i<ids.length;i++) {
	    	//Create Entity class object
	    	Product prod = new Product();
	 	    prod.setPname("Samsung M"+(i+1)+"0");
	 	    prod.setPrice(15000.00*(i+2));
	 	    prod.setQty(1.0);
	 	   System.out.println("Entity Class Object Created And Values Set");
	 	    //sess.save(-) to give Insert Persistence Instruction 
	 	    ids[i] = (Long)sess.save(prod);
	    }
		
	    //Commit
	    tx.commit();
	    System.out.println("Object With Id::"+Arrays.toString(ids)+" Inserted Successfully");
			
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Object Not Inserted");
			}
		}
	}

}
