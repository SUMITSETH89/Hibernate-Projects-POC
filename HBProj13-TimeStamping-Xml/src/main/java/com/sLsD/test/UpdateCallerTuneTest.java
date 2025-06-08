package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sLsD.entity.Stock;
import com.sLsD.util.HibernateUtil;

public class UpdateCallerTuneTest {
	
public static void main(String[]args) {
		
		//SessionFactory object having all required services
		SessionFactory factory = HibernateUtil.getSessionFactory();
	    //Open Session
		Session sess = HibernateUtil.getSession();
		//Transaction 
		Transaction tx = null;
		//Try with Resource
		try(factory;sess){
			//Begin Transaction
			tx = sess.beginTransaction();
			//Load the Object 
			Stock stock = sess.get(Stock.class,2l);
			if(stock==null) {
				System.out.println("Object Not Found");
				return;
			}else {
			//Modify the Object Data With In Transaction Without Calling Update Method.
				stock.setExchange("NSC");
			}
			//Commit Tx
			tx.commit();
			System.out.println("Stock Updated Successfully On:: "+stock.getLastUpdated());
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				System.out.println("Object Not Updated");
				tx.rollback();
			}
			
		}
	}


}
