package com.sLsD.test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.sLsD.entity.ProductDetails;
import com.sLsD.util.HibernateUtil;

public class PaginationTestCase2 {
	
	public static void main(String[]args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Page Size");
		int pageSize = scn.nextInt();
		
		//Close Scanner
		scn.close();
		
		//Create Session Factory object having all the required services
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//Open a new session
		Session sess = HibernateUtil.getSession();

		//Try With Catch
		try(factory;sess){
			//Get Total Records In DB Table
			Query query1 = sess.getNamedQuery("GET_COUNT");
			Long count = (Long)query1.getSingleResult();
			//Calculate Pages Count
			int pagesCount = (int)(count/pageSize);
			if(count%pageSize!=0) pagesCount++;
			
			//Create HQL Query For Pagination
			 Query<ProductDetails> query2 = sess.createQuery("FROM ProductDetails",ProductDetails.class);
			 int startPosition;
			 for(int pageNo = 1;pageNo<=pagesCount;pageNo++) {
			  System.out.println(pageNo+"/"+pagesCount+" Pages Records");
			 //Calculate Start Position/Index
			   startPosition = (pageNo*pageSize)-pageSize;
			   query2.setFirstResult(startPosition);//Start Index
			   query2.setMaxResults(pageSize);
			   
			   List<ProductDetails> prodDetailsList = query2.getResultList();
				//Process the Result
				prodDetailsList.forEach(System.out::println);
				System.out.println("============================");
				 
			 }//for	
		}catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
