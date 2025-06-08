package com.sLsD.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sLsD.entity.ProductDetails;
import com.sLsD.util.HibernateUtil;

public class JPAQBCSelectOperationWithCondition {
	
	public static void main(String[]args) {
		
		Session sess = HibernateUtil.getSession();
		
		//Try With Resource
		try(sess){
			
			//Main Object
			CriteriaBuilder ctBuilder = sess.getCriteriaBuilder();
			//Create Criteria Query Object
			//CriteriaQuery<ProductDetails>ctQuery = ctBuilder.createQuery(ProductDetails.class);
			CriteriaQuery<ProductDetails> ctQuery = ctBuilder.createQuery(ProductDetails.class);
			//Create Root Object Specifying FROM Clause
			Root<ProductDetails> root = ctQuery.from(ProductDetails.class);
			// Apply WHERE Condition
			/*ctQuery.select(root).where(ctBuilder.and(ctBuilder.ge(root.get("price"),5000.00)),
					                                 ctBuilder.le(root.get("price"),50000.00));*/
			
			/*ctQuery.select(root).where(root.get("pname").in("Dell Inspiron","Apple16 Pro","Moto Edge50"))
			                    .orderBy(ctBuilder.asc(root.get("price")));*/
			
			//SELECT * FROM TBL_PRODUCT_DETAILS WHERE PNAME LIKE 'S%'
			/*ctQuery.select(root).where(ctBuilder.like(root.get("pname"),ctBuilder.literal("%S")))
			                    .orderBy(ctBuilder.asc(root.get("price")));*/
			
			//Select the Product From Product Table Which is having Highest Price
			 //ctQuery.select(ctBuilder.max(root.get("price")));
			
			//SELECT THE PRODUCTS WHOSE PRICES ARE GREATER THAN THE AVERAGE PRICE.
			
			//Step#1 SubQuery to get Average Price
			Subquery<Double> subQuery = ctQuery.subquery(Double.class);
			Root<ProductDetails> subRoot = subQuery.from(ProductDetails.class);
			subQuery.select(ctBuilder.avg(subRoot.get("price")));
			
			//Step#2 Main Query to Get Products
			ctQuery.select(root).where(ctBuilder.gt(root.get("price"),subQuery));
			
			//Create Query Object
			Query query = sess.createQuery(ctQuery);
			
			//Execute Query
			List<ProductDetails> prodList = query.getResultList();
			//Double maxPrice = (Double)query.getSingleResult();
			
			//Process the Result
			prodList.forEach(System.out::println);
			//System.out.println("Maximum Product Price:: "+maxPrice);
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
