package com.sLsD.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sLsD.entities.Passport;
import com.sLsD.entities.Person;
import com.sLsD.util.HibernateUtil;

public class PersonPassportDAOImpl implements IPersonPassportOTOFKDAO {

	@Override
	public void saveDateByChild() {
		
		//Transaction
				Transaction tx = null;
				
				try(Session sess = HibernateUtil.getSession()){
					
					//Create Person Object
					Person person = new Person();
					person.setPname("Amit");
					person.setAddress("New Delhi");
					
					//Passport Object
					Passport pt = new Passport();
					pt.setIssuedOn(LocalDate.now());
					pt.setExpiredOn(LocalDate.of(2030,01,31));
					pt.setCountry("INDIA");
					pt.setPersonDetails(person);
					
					//Set Child To Parent
					person.setPersonPassport(pt);
					
					//Begin Transaction
					tx = sess.beginTransaction();
					//Save object by child
					Long result = (Long)sess.save(pt);
					//Commit Transaction
					tx.commit();
					System.out.println("Passport Object Saved Successfully With Id:: "+result);
					
				}catch(HibernateException he) {
					he.printStackTrace();
				   if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
					   System.out.println("Problem In Persisting Data By Parent");
					   tx.rollback();
				   }
				}
				
	}//method
	
	@Override
	public void loadDataByChild() {
		
		try(Session sess = HibernateUtil.getSession()){
			
			//Get Associated Child
			Query query = sess.createQuery("FROM Passport");
			List<Passport> passport = query.getResultList();
			passport.forEach(pass->{
				System.out.print("Child:: "+pass);
				System.out.print("Parent:: "+pass.getPersonDetails());
			});
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}
		
	}

}
