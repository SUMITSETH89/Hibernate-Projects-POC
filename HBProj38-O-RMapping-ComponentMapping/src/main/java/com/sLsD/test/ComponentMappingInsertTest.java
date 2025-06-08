package com.sLsD.test;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sLsD.entities.JobDetails;
import com.sLsD.entities.Person;
import com.sLsD.util.HibernateUtil;

public class ComponentMappingInsertTest {
	
	public static void main(String[]args) {
		
		//Create Session Object
		Session sess = HibernateUtil.getSession();
		//Transaction 
		Transaction tx = null;
		//Try With Resource
		try(sess){
			//Begin Transaction
			tx = sess.beginTransaction();
			//Create Entity Object
			Person person = new Person();
			person.setPname("Amit");
			person.setPaddrs("Mumbai");
			person.setJobDetails(new JobDetails("IT","Java Developer","HCL",33,84000.00));
			
			//Invoke save(-) to give save persistence instruction
			Long id = (Long)sess.save(person);
			//Commit Transaction
			tx.commit();
			System.out.println("Person With Id:: "+id+" Saved Successfully");
			
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				System.out.println("Data Not Persisted");
				tx.rollback();
			}
		}
	}

}
