package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sLsD.entity.Movie;
import com.sLsD.util.HibernateUtil;

public class SaveObjectOperations {
	
	public static void main(String[]args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session sess = HibernateUtil.getSession();
		//Transaction
		Transaction tx = null;
		//Try With Resource
		try(factory;sess){
			//Begin Transaction
			tx = sess.beginTransaction();
			//Create Entity class object
			Movie movie = new Movie();
			movie.setMid(1003l);
			movie.setMname("Sawdesh");
			movie.setActor("Sharukh");
			movie.setBudget(null);
			//Save Object Operation
			Long mid = (Long)sess.save(movie);
			//Commit
			tx.commit();
			System.out.println("Movie With The Id:: "+mid+" Persisted Successfully");
			
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Movie Not Persisted");
			}
		}
	}

}
