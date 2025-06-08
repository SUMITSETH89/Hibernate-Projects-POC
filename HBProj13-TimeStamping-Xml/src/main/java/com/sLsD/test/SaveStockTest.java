package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sLsD.entity.Stock;
import com.sLsD.util.HibernateUtil;

public class SaveStockTest {
	
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
			//Create Entity class object
			Stock stock = new Stock();
			stock.setStockName("infosys");
			stock.setPrice(10219.34);
			stock.setExchange("BSC");
			//Save Object Operation
			Long sid = (Long) sess.save(stock);
			//Commit Tx
			tx.commit();
			System.out.println("Object With Stock Id:: "+sid+" Saved Successfully");
			System.out.println("Object Saved/Inserted On:: "+stock.getLastUpdated());
			
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				System.out.println("Object Not Saved");
				tx.rollback();
			}
			
		}
	}

}
