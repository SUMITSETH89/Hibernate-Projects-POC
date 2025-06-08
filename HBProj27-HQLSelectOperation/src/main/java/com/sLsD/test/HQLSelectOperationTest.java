package com.sLsD.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.sLsD.entity.Product;
import com.sLsD.util.HibernateUtil;

public class HQLSelectOperationTest {
	
	public static void main(String[]args) {
		
		//Create SessionFactory Object having all the required Services
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//Create Session Object
		Session sess = HibernateUtil.getSession();
		//Try With Resource
		try(factory;sess){
			//Performing Entity HQL Select Query For all Columns Values.
			
			//Query Object representing HQL Query
			Query<Product> query = sess.createQuery("FROM Product WHERE ROWNUM<=5",Product.class);
			//Process Select HQL Query
			List<Product> prodList = query.list();
			//Process the Result Set
			if(prodList!=null && prodList.size()>0) {
				System.out.println("Condition Satisfied");
				
				prodList.forEach(prod->{
					System.out.println(prod);
				});	
			}
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
