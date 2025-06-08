package com.sLsD.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sLsD.entities.Person;
import com.sLsD.entities.PhoneNumber;
import com.sLsD.util.HibernateUtil;

public class PersonDetailsDAOImpl implements IPersonDetailsDAO {

	@Override
	public void saveDataUsingParent() {
		
		//Transaction
				Transaction tx = null;
				try(Session sess = HibernateUtil.getSession()){
					
					//Begin Transaction
					tx = sess.beginTransaction();
					//Create Parent and Associated Child Object
					PhoneNumber no = new PhoneNumber();
					no.setMobileNumber(9990246749l);
					no.setNumberType("Personl");
					no.setOperator("JIO");
					
					PhoneNumber no1 = new PhoneNumber();
					no1.setMobileNumber(9939197845l);
					no1.setNumberType("Personl");
					no1.setOperator("Airtel");
					
					Person person = new Person();
					person.setPname("Sumit");
					person.setAddress("New Delhi");
					person.setNumList(List.of(no,no1));
					
					//Invoke save(-) to give Insert Persistence Instruction
					Long id = (Long)sess.save(person);
					//Commit Transaction
					tx.commit();
					System.out.println("Person With ID:: "+id+" Inserted Successfully");
				}catch(HibernateException he) {
					he.printStackTrace();
					if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
						System.out.println("Record Insertion Failed");
						tx.rollback();
					}
		  }
	}
	
	@Override
	public List<Person> loadDataUsingParent() {
		
		try(Session sess = HibernateUtil.getSession();){
			//Query Object Representing HQL Query
			Query<Person> query = sess.createQuery("FROM Person",Person.class);
			
			//Execute Query
			List<Person> personList = query.list();
			
			//Process the Result
			personList.forEach(p->{
				//Parent Object
				System.out.println(p.toString());
				/*if(p.getNumList().isEmpty()) {
					System.out.println("No Childs Are Associated To The Parent");
				}else {
					p.getNumList().forEach(nl->{
		            	  //Associated Child Object
		            	  System.out.println(nl.getClass().getName());
		              });
				}*/
				if(!p.getNumList().isEmpty()) {
					System.out.println(p.getNumList().size());
				}
				 
			});
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void addChildToExistingParent() {
		
		//Transaction 
		Transaction tx = null;
		try(Session sess = HibernateUtil.getSession()){
			
			//Begin Transaction
			tx = sess.beginTransaction();
			//Get Parent Object
			Person person = sess.get(Person.class, 1004l);
			
			if(person!=null) {
		    //Get Associated Children
			List<PhoneNumber> numList = person.getNumList();
			//Create Child Object
			PhoneNumber pn = new PhoneNumber();
			pn.setMobileNumber(8992780091l);
			pn.setNumberType("official");
			pn.setOperator("VI");
			//Add a new child
			numList.add(pn);
			}
			//Commit
			tx.commit();
			System.out.println("Child is added to existing childrens of Parent");
			
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				System.out.println("New Child Not Added");
				tx.rollback();
			}
		}
		
	}
	
	@Override
	public void deleteAllChildrenOfAParent() {
		
		//Transaction
		Transaction tx = null;
		//Create Session
		try(Session sess = HibernateUtil.getSession()){
			
			//Begin The Transaction
			tx = sess.beginTransaction();
			//Get Parent Entity/Object
			Person person = sess.get(Person.class,1004l);
			if(person!=null) {
				//Get Associated Children
				List<PhoneNumber> numList = person.getNumList();
				//Remove all the children
				numList.clear();
				//Save the Parent
				sess.save(person);//Invoking save(-) optional within a transaction i.e. Synchronization
				//Commit Transaction
				tx.commit();
				System.out.println("All Childs of a Parent Are Removed");
				
			}else {
				System.out.println("No Record Found");
				return;
			}
			
		}catch(HibernateException he) {
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				System.out.println("Problem In Removing Childs of A Parent");
				tx.rollback();
			}
		}
		
	}
	
	@Override
	public void deleteOneChildFromCollectionOfChildsOfAParent() {
		
		//Transaction
		Transaction tx = null;
		//Create Session
		try(Session sess = HibernateUtil.getSession()){
			
			//Begin The Transaction
			tx = sess.beginTransaction();
			//Get Parent Entity/Object
			Person person = sess.get(Person.class,1l);
			if(person!=null && person.getPid()!=null) {
				//Get Associated Children
				List<PhoneNumber> numList = person.getNumList();
				//Remove Specific Child of the Parent
				PhoneNumber ino = numList.remove(0);
				//Save the Parent
				sess.save(person);//Invoking save(-) optional within a transaction i.e. Synchronization
				//Commit Transaction
				tx.commit();
				System.out.println("The Child With ID:: "+ino.getRegNo()+" Removed From The List of Childs Of A Parent");
				
			}else {
				System.out.println("No Record Found");
				return;
			}
			
		}catch(HibernateException he) {
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				System.out.println("Problem In Removing Specific Child");
				tx.rollback();
			}
		}
		
		
	}
	
	@Override
	public void deleteParentAndItsChilds() {
		
		//Transaction
		Transaction tx = null;
		
		try(Session sess = HibernateUtil.getSession()){
			
			//Begin Transaction
			tx = sess.beginTransaction();
			//Load the parent
			Person person = sess.get(Person.class,1007l);
			if(person!=null) {
				//Give Delete Persistence Instruction 
				sess.delete(person);
			    // Commit Transaction
				tx.commit();
			}
			System.out.println("Parent Record Deleted");
			
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				System.out.println("Problem In Deleting Parent");
				tx.rollback();
			}
		}
		
	}

}
