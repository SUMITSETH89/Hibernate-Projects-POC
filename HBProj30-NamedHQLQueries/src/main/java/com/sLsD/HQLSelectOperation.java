package com.sLsD;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sLsD.entity.ProductDetails;
import com.sLsD.util.HibernateUtil;

public class HQLSelectOperation {
	
	//Client Application
	
	public static void main(String[]args) throws InterruptedException {
		
		//Create SessionFactory object having all the required Services
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//Create Session Object
		Session sess = HibernateUtil.getSession();
		//Transaction
		Transaction tx = null;
		//Try With Resource
		try(factory;sess){
		//Query Object Representing HQL/JPQL Query
		Query<ProductDetails> details = sess.getNamedQuery("GET_PRODUCT_DETAILS_RECORDS");
		//Get Product Details
		//List<ProductDetails> prodList = details.list();
		List<ProductDetails> prodList = details.getResultList();
		//ProcessProduct
		prodList.forEach(System.out::println);	
		
		//Update By Id
		tx = sess.beginTransaction();
		details = sess.getNamedQuery("UPDATE_PRODUCT_BY_ID");
		//Set Parameter
		details.setParameter(1,29385.38);
		details.setParameter(2,2l);
		Integer updateCount = details.executeUpdate();
		//Commit Transaction
		tx.commit();
		System.out.println(updateCount+":: Has been Updated");
		
		try(Session sess1 = HibernateUtil.getSession();){
			//Select Updated Result
			details = sess1.getNamedQuery("GET_PRODUCT_DETAILS_RECORDS");
			prodList = details.getResultList();
			//Process Product
			prodList.forEach(prod->System.out.println(prod));
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}
		
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				System.out.println("Record Not Updated");
				tx.rollback();
			}
		}
	}

}
