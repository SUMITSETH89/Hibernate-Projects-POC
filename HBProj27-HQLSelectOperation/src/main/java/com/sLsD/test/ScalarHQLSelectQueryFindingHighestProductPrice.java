package com.sLsD.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.sLsD.entity.Product;
import com.sLsD.util.HibernateUtil;

public class ScalarHQLSelectQueryFindingHighestProductPrice {
	
	public static void main(String[]args) {
		
		//Create SessionFactory Object having all the required Services
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//Create Session Object
		Session sess = HibernateUtil.getSession();
		//Try With Resource
		try(factory;sess){
			//Performing Scalar HQL Select Query
			
			//Query Object representing HQL Query
			Query query = sess.createQuery("SELECT price FROM Product p WHERE 1 = "
					+ "(SELECT COUNT(*) FROM Product prod WHERE prod.price>=p.price)");
			
			Integer price = (Integer)query.getSingleResult();
			//Process the Result Set
			System.out.println("Maximum Price Product:: "+price);
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
