package com.sLsD.test;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sLsD.util.HibernateUtil;

public class NonSelectUpdateOperation {
	
	public static void main(String[]args) {
		
		//Create SessionFactory object having all the required Services
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//Create Session
		Session sess = HibernateUtil.getSession();
		//Transaction
		Transaction tx = null;
		//Try With Resources
		try(factory;sess){
			//Begin Transaction
			tx = sess.beginTransaction();
			//Query Object Representing HQL/JPQL Query
			Query query = sess.createQuery("UPDATE Product SET price = ?1 WHERE price BETWEEN ?2 AND ?3");
			//Set Parameters
			query.setParameter(1,20000);
			query.setParameter(2,10000);
			query.setParameter(3,50000);
			
			//Execute Non-Select HQL/JPQL Query
			Integer updateCount = query.executeUpdate();
			
			//Commit Transaction
			tx.commit();
			System.out.println(updateCount+"::No of Records Updated");
			
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				System.out.println("Update Cannnot Be Performed");
				//Rollback
				tx.rollback();
			}
		}
	}

}
