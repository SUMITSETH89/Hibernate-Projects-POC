package com.sLsD;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sLsD.entity.ProductDetails;
import com.sLsD.util.HibernateUtil;

public class NativeSQLQueryTest {
	
   public static void main(String[]args) {
	   //Try With Resource
	   try(Session sess = HibernateUtil.getSession();){
		   
		   //Native SQL Queries are represented by createNativeQuery() method
		   Query<ProductDetails> query = sess.createNativeQuery("SELECT * FROM TBL_PRODUCT_DETAILS", ProductDetails.class);
		
		   //Execute SQL Query
		   List<ProductDetails> prodList = query.list();
		   
		   //Process the result
		   prodList.forEach(System.out::println);
		   
	   }catch(HibernateException he) {
		   he.printStackTrace();
	   }
   }

}
