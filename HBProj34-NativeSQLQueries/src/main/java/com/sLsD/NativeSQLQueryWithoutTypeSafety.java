package com.sLsD;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.sLsD.util.HibernateUtil;

public class NativeSQLQueryWithoutTypeSafety {
	
   public static void main(String[]args) {
	   //Try With Resource
	   try(Session sess = HibernateUtil.getSession();){
		   
		   //Native Query Represents Native SQL Query
		   NativeQuery query = sess.createNativeQuery("SELECT * FROM TBL_PRODUCT_DETAILS");
		   
		   //A List of Object Array 
		   //The lenght of the Individual Array is Equal to the number of DB table Columns.
		   //The size of the List is equal to the number of Records in DB Table.
		   List<Object[]> objectArray = query.getResultList();
		   
		   //Process the List
		   //Here forEach(-) method returns Individual Object[].
		   objectArray.forEach(obj->{
			   for(Object io : obj) {
				 System.out.print(io+"  ");
			   }
			   System.out.println();
		   });
		   
	   }catch(HibernateException he) {
		   he.printStackTrace();
	   }
   }

}
