package com.sLsD.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sLsD.entity.ProductDetails;
import com.sLsD.util.HibernateUtil;

public class JPAQBCSelectOperationTest {
	
	public static void main(String[]args) {
		
		Session sess = HibernateUtil.getSession();
		
		//Try With Resource
		try(sess){
			
			//Main Object
			CriteriaBuilder ctBuilder = sess.getCriteriaBuilder();
			//Create Criteria Query Object
			CriteriaQuery<ProductDetails>ctQuery = ctBuilder.createQuery(ProductDetails.class);
			//Create Root Object Specifying FROM Clause
			Root<ProductDetails> root = ctQuery.from(ProductDetails.class);
			
			//Create Query Object
			Query query = sess.createQuery(ctQuery);
			
			//Execute Query
			List<ProductDetails> prodList = query.getResultList();
			
			//Process the Result
			prodList.forEach(System.out::println);
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
