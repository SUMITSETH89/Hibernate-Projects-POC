package com.sLsD;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.sLsD.util.HibernateUtil;

public class NativeSQLSelectScalarQueryType1 {
	
   public static void main(String[]args) {
	   //Try With Resource
	   try(Session sess = HibernateUtil.getSession();){
		   //Type#1:: Select Scalar Query Getting Specific Multiple Columns Values.
		   //Native SQL Queries are represented by createNativeQuery() method
		   NativeQuery query = sess.createNativeQuery("SELECT PNAME,PRICE FROM TBL_PRODUCT_DETAILS WHERE PRICE BETWEEN ? AND ?");
		   //Map Scalar Query Result With Hibernate Date Type
		   query.addScalar("PNAME",StandardBasicTypes.STRING);
		   query.addScalar("PRICE",StandardBasicTypes.DOUBLE);
		   //Set Parameter
		   query.setParameter(1,10000.00);
		   query.setParameter(2,50000.00);
		   
		   //Get The Result
		   List<Object[]> results = query.getResultList();
		   
		   results.forEach(obj->{
			   for(Object ob : obj) {
				   System.out.print(ob+" ");
			   }
			   
		   });
		   
		   
	   }catch(HibernateException he) {
		   he.printStackTrace();
	   }
   }

}
