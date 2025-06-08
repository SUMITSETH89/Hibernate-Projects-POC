package com.sLsD;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.sLsD.entity.ProductDetails;
import com.sLsD.util.HibernateUtil;

public class NativeSQLQueryWithTypeSafety {
	
   public static void main(String[]args) {
	   //Try With Resource
	   try(Session sess = HibernateUtil.getSession();){
		   
		   //Native Query Represents Native SQL Query
		   NativeQuery query = sess.createNativeQuery("SELECT * FROM TBL_PRODUCT_DETAILS");
		   
		   //For Type Safety
		   query.addEntity(ProductDetails.class);
		   
		   //Get Result Set
		   List<ProductDetails> prodDetailsList = query.getResultList();
		   
		   //Process the Result
		   prodDetailsList.forEach(System.out::println);
		   
	   }catch(HibernateException he) {
		   he.printStackTrace();
	   }
   }

}
