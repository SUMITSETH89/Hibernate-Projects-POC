package com.sLsD.test;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sLsD.entities.Person;
import com.sLsD.util.HibernateUtil;

public class ComponentMappingSelectTest {
	
	public static void main(String[]args) {
		
		//Create Session Object
		Session sess = HibernateUtil.getSession();
		//Try With Resource
		try(sess){
			
			//Case#1 Entity Select Operation Without Condition
			
			//Create Query
			//Query query = sess.createQuery("FROM Person");
			
			//Case#2 Entity Select Operation With Condition by Involving sub-property of main property
			Query query = sess.createQuery("FROM Person WHERE jobDetails.salary BETWEEN :sal1 AND :sal2");
			//Set Parameter
			query.setParameter("sal1",40000.00);
			query.setParameter("sal2",65000.00);
			
			//Execute Query
			List<Person> personList = query.getResultList();
			//Process Result
			personList.forEach(p->System.out.println(p));
						
		}catch(HibernateException he) {
			he.printStackTrace();
			
		}
	}

}
