package com.sLsD.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sLsD.entities.Person;
import com.sLsD.util.HibernateUtil;

public class CollectionMappingSelectOperationTest {
	
	public static void main(String[]args) {
		
		try(Session sess = HibernateUtil.getSession()){
			
			//Create CriteriaBuilder Object
			CriteriaBuilder ctBuilder = sess.getCriteriaBuilder();
			//Create CriteriaQuery Object
			CriteriaQuery<Person> ctQuery = ctBuilder.createQuery(Person.class);
			//Root Object to specify the base Table Name
			Root<Person> root = ctQuery.from(Person.class);
			//Order by clause
			ctQuery.orderBy(ctBuilder.asc(root.get("pid")));
			
			//Create Query Object
			Query query = sess.createQuery(ctQuery);
			//Execute Query
			List<Person> personList = query.getResultList();
			//Process the Result Set
			personList.forEach(p->{
				System.out.println(p);
			});
		}catch(HibernateException he) {
			he.printStackTrace();
		}
		
		
	}

}
