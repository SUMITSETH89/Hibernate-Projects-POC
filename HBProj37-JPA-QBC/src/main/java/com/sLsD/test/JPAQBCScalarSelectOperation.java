package com.sLsD.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.sLsD.entity.ProductDetails;
import com.sLsD.util.HibernateUtil;

public class JPAQBCScalarSelectOperation {
	
	public static void main(String[]args) {
		
		Session sess = HibernateUtil.getSession();
		
		try(sess){
			
			//Case#1 JPA-QBC For getting Specific multiple columns values from the DB Table
			
			//Create CriteriaBuilder Object
			/*CriteriaBuilder ctBuilder = sess.getCriteriaBuilder();
			
			//Create CriteriaQuery object
			CriteriaQuery<Object[]>ctQuery = ctBuilder.createQuery(Object[].class);
			
			//Create Root Object to define query's FROM clause
			Root<ProductDetails> root = ctQuery.from(ProductDetails.class);
			
			//Create WHERE Clause
			ctQuery.multiselect(root.get("pname"),root.get("price"))
			       .where(ctBuilder.and(ctBuilder.ge(root.get("price"),ctBuilder.literal(5000.00)),
			    		                ctBuilder.le(root.get("price"),ctBuilder.literal(50000.00))));
			
			//Create Query
			Query query = sess.createQuery(ctQuery);
			
			//Process Result
			List<Object[]> objArray = query.getResultList();
			
			objArray.forEach(obj->{
				for(Object io : obj) {
					System.out.print(io+" ");
				}
				System.out.println();
			});	
			
			//Case#2 JPA-QBC For getting Specific Single Column Value from the DB Table
			
		   //Create Criteria Builder
		   CriteriaBuilder ctBuilder = sess.getCriteriaBuilder();
		   
		   //Create CriteriaQuery Object
		   CriteriaQuery<Object> ctQuery = ctBuilder.createQuery(Object.class);
		   
		   //Create Root Object to define query's From Clause
		   Root<ProductDetails> root = ctQuery.from(ProductDetails.class);
		   
		   //SELECT PNAME FROM TBL_PRODUCT_DETAILS WHERE PNAME LIKE 'S% ORDER BY PNAME'
           ctQuery.multiselect(root.get("pname"))
                  .where(ctBuilder.like(root.get("pname"),ctBuilder.literal("S%")))
                  .orderBy(ctBuilder.asc(root.get("pid")));
           
           //Create Query Object
           Query query = sess.createQuery(ctQuery);
      
           // Execute Query
           String prodName = (String)query.getSingleResult();
           
           //Process Result
           System.out.println("Product Name:: "+prodName.toUpperCase());*/
			
			//Case#3:: JPA-QBC Logic to perform multiple Aggregate Operations
			
			//Create Criteria Builder Object
			CriteriaBuilder ctBuilder = sess.getCriteriaBuilder();
			//Create Criteria Query Object
			CriteriaQuery<Object[]> ctQuery = ctBuilder.createQuery(Object[].class);
			
			//Create Root Object for Specifying FROM Clause
			Root<ProductDetails> root = ctQuery.from(ProductDetails.class);
			
			//Specify Specific Multiple Columns and WHERE Clause
			ctQuery.multiselect(ctBuilder.min(root.get("price")).alias("MIN_PRICE"),
					            ctBuilder.max(root.get("price")).alias("MAX_PRICE"),
					            ctBuilder.sum(root.get("price")).alias("TOTAL_PRICE"),
					            ctBuilder.avg(root.get("price")).alias("AVG_PRICE"),
					            ctBuilder.count(root.get("price")).alias("COUNT"));
			
			//Create Query Object
			Query query = sess.createQuery(ctQuery);
			
			//Execute JPA-QBC Query
			List<Object[]> aggResult = query.getResultList();
			
			//Process Result
			aggResult.forEach(result->{
				for(Object obj : result) {
					System.out.print(obj+"---");
				}
			});
			
           
		   
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
