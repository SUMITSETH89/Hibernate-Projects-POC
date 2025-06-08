package com.sLsD.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sLsD.entities.Person;
import com.sLsD.util.HibernateUtil;

public class CollectionMappingSaveOperation {
	
	public static void main(String[]args) {
		
		//Transaction
		Transaction tx = null;
		//Session Object
		try(Session sess = HibernateUtil.getSession()){
			
			//Begin Transaction
			tx = sess.beginTransaction();
			//Create Entity class object having Collection Properties
			Person person = new Person();
			person.setPname("Sumit");
			person.setAddress("New Delhi");
			person.setNickNames(List.of("Self","Learner","Thinker","Confused"));
			person.setFriends(List.of("Harshit","Vivek","Mahendra","Anand","Amit","Sauravh"));
			person.setContacts(Set.of(9990246749l,9939197845l,8801105671l));
			person.setIdDetails(Map.of("Aadhar",880120045892l,"PAN",8989l,"PassportNo",6719l));
			
			//Invoke save(-) method to Insert Persistence Instruction
			Long id = (Long)sess.save(person);
			//Commit transaction
			tx.commit();
			System.out.println("Person Details With Id:: "+id+" Inserted Successfully");
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				System.out.println("Person Details Not Inserted");
				tx.rollback();
			}
		}
	}

}
