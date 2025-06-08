package com.sLsD.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.sLsD.entity.Product;
import com.sLsD.util.HibernateUtil;

public class ScalarHQLSelectQueryTest2 {
	
	public static void main(String[]args) {
		
		//Create SessionFactory Object having all the required Services
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//Create Session Object
		Session sess = HibernateUtil.getSession();
		//Try With Resource
		try(factory;sess){
			//Performing Scalar HQL Select Query
			
			//Query Object representing HQL Query
			Query<Object> query = sess.createQuery("SELECT pname FROM Product WHERE price>?1 and price<?2",Object.class);
			
			//Set Parameters
			query.setParameter(1,10000);
			query.setParameter(2, 60000);
			
			//Process Select HQL Query
			List<Object> singleColumn = query.list();
			
			//Process the Result Set
			if(singleColumn!=null && singleColumn.size()>0) {
				singleColumn.forEach(col->{
					System.out.println(col);
				});	
			}
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
