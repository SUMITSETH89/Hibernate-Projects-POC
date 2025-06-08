package com.sLsD;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.sLsD.util.HibernateUtil;

public class NativeSQLSelectScalarQueryType2 {
	
   public static void main(String[]args) {
	   //Try With Resource
	   try(Session sess = HibernateUtil.getSession();){
		   //Type#2:: Select Scalar Query Getting Specific Single Column Value.
		   //Native SQL Queries are represented by createNativeQuery() method
		   NativeQuery query = sess.createNativeQuery("SELECT AVG(PRICE) AS AVERAGE_PRICE FROM TBL_PRODUCT_DETAILS");
		   //Map Scalar Query Result With Hibernate Date Type
		    query.addScalar("AVERAGE_PRICE",StandardBasicTypes.DOUBLE);
		   //Get The Result
		   Object price = query.getSingleResult();
		   System.out.println(price);
		   
		   
	   }catch(HibernateException he) {
		   he.printStackTrace();
	   }
   }

}
