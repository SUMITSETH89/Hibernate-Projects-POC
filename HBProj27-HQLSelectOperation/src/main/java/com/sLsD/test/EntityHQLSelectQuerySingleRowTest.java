package com.sLsD.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.sLsD.entity.Product;
import com.sLsD.util.HibernateUtil;

public class EntityHQLSelectQuerySingleRowTest {
	
	public static void main(String[]args) {
		
		//Create SessionFactory Object having all the required Services
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//Create Session Object
		Session sess = HibernateUtil.getSession();
		//Try With Resource
		try(factory;sess){
			//Performing Entity HQL Select Query Single Row.
			
			//Query Object representing HQL Query
			Query<Product> query = sess.createQuery("FROM Product WHERE pid=:pid",Product.class);
			
			//Set Parameter
			query.setParameter("pid",7858l);
			
			//Process Select HQL Query
			Product prod = query.getSingleResult();
			//Process the Result Set
			if(prod!=null) {
				System.out.println(prod);
			}
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
