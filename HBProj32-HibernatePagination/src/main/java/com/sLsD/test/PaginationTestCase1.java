package com.sLsD.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.sLsD.entity.ProductDetails;
import com.sLsD.util.HibernateUtil;

public class PaginationTestCase1 {
	
	public static void main(String[]args) {
		
		//Create Session Factory object having all the required services
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//Open a new session
		Session sess = HibernateUtil.getSession();
		//Try With Catch
		try(factory;sess){
			//Create HQL Query
			Query<ProductDetails> query = sess.createQuery("FROM ProductDetails",ProductDetails.class);
			//Set Start Position/Index
			query.setFirstResult(0);//Start Index
			query.setMaxResults(2);
			List<ProductDetails> prodDetailsList = query.getResultList();
			//Process the Result
			prodDetailsList.forEach(System.out::println);
		}catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
