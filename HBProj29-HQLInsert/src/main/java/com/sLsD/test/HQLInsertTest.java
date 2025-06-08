package com.sLsD.test;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sLsD.util.HibernateUtil;

public class HQLInsertTest {
	
	public static void main(String[]args) {
		
		//Create SessionFactory having all the required services
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//Create Session
		Session sess = HibernateUtil.getSession();
		//Transaction 
		Transaction tx = null;
		//Try With Resource
		try(factory;sess){
			//Begin Transaction
			tx = sess.beginTransaction();
			//HQL/JPQL Insert Query
			Query query = sess.createQuery("INSERT INTO SpecialProduct(pId,pname,price,qty)"
					+ "SELECT p.pd,p.pname,p.price,p.qty FROM Product p WHERE ROWNUM<=10");
			//Execute Insert
			Integer insertCount = query.executeUpdate();
			//Commit Transaction
			tx.commit();
			System.out.println("No of Records Copied:: "+insertCount);
			
		}catch(HibernateException e) {
			e.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				System.out.println("Problem In HQL Insert Query Execution");
				tx.rollback();
			}
		}
	}
//Query query = sess.createQuery("INSERT INTO SpecialProduct(pId,pname,price,qty)values(?0,?1,?2,?3)"); Not Possible
}
