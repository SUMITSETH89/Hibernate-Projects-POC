package com.sLsD.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.sLsD.entity.Product;
import com.sLsD.util.HibernateUtil;

public class ScalarHQLSelectQuerySingleRowMultipleColumnsTest1 {
	
	public static void main(String[]args) {
		
		//Create SessionFactory Object having all the required Services
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//Create Session Object
		Session sess = HibernateUtil.getSession();
		//Try With Resource
		try(factory;sess){
			//Performing Scalar HQL Select Query
			
			//Query Object representing HQL Query
			Query query = sess.createQuery("SELECT p.pname,p.price FROM Product p WHERE p.pid = ?1");
			//Set Parameters
			query.setParameter(1,2028);
			
			//Process Select HQL Query
			Object[] specificMultipleCol = (Object[])query.getSingleResult();
			
			//Process the Result Set
			for(Object obj : specificMultipleCol) {
				System.out.println(obj);
			}
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
