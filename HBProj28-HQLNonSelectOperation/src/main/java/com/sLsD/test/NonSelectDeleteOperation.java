package com.sLsD.test;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sLsD.util.HibernateUtil;

public class NonSelectDeleteOperation {
	
	public static void main(String[]args){
		
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
			Query query = sess.createQuery("DELETE FROM Product WHERE price BETWEEN ?2 AND ?3");
			//Set Parameters
			query.setParameter(2,1000);
			query.setParameter(3,5000);
			
			//Execute Non-Select HQL/JPQL Query
			Integer updateCount = query.executeUpdate();
			
			
			//Commit Transaction
			tx.commit();
			System.out.println(updateCount+"::No of Records Deleted");
			
		}catch(Exception he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				System.out.println("Delete Cannnot Be Performed");
				//Rollback
				tx.rollback();
			}
		}
	}

}
