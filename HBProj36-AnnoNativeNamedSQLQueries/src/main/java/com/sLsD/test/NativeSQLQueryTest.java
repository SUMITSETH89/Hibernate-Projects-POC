package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.sLsD.util.HibernateUtil;

public class NativeSQLQueryTest {
	
	public static void main(String[]args) {
		//Transaction tx = null;
		//Try With Resource V7
		try(Session sess = HibernateUtil.getSession()){
		//Create Native SQL Query Object
		/*NativeQuery query = sess.getNamedNativeQuery("GET_PRODS_BY_PRICE_RANGE");
		//Set Entity Type
		query.addEntity(ProductDetails.class);
		//Set Parameters
		query.setParameter(1,10000.00);
		query.setParameter(2,50000.00);
		
		//Execute the query
		List<ProductDetails> prodList = query.getResultList();
		//Process the result
		prodList.forEach(System.out::println);*/
		
		//Begin Transaction
			/* tx = sess.beginTransaction();
		//Create Native SQL Query Object
		  NativeQuery query = sess.getNamedNativeQuery("HIKE_PRICE_BY_PROD_NAME");
		//Set Parameters
		  query.setParameter("p1",46000.00);
		  query.setParameter("p2","Dell Inspiron");
		
		//Execute the Query
		Integer result = query.executeUpdate();
		//Commit Transaction
		tx.commit();
		System.out.println(result+" Product Updated");*/
			
	    //Create NamedNativeQuery
		NativeQuery query = sess.getNamedNativeQuery("MAX_PRICE_PROD");
			//Map Result to Hibernate Date Type
			query.addScalar("higest_price",StandardBasicTypes.DOUBLE);
			//Execute Query
			Double maxPrice = (Double)query.getSingleResult();
			
		//Create NamedNativeQuery
			query = sess.getNamedNativeQuery("AVG_PROD_PRICE");
			//Map Result to Hibernate Data Type
			query.addScalar("average_price",StandardBasicTypes.DOUBLE);
			//Execute Query
			Double avgPrice = (Double)query.getSingleResult();
			
	     System.out.println("Highest Price:: "+maxPrice+" Average Price:: "+avgPrice);
		}catch(HibernateException he) {
			he.printStackTrace();
			/*if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				System.out.println("Product Not Updated");
				tx.rollback();
			}*/
		}
	}

}
