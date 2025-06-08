package com.sLsD.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sLsD.entities.LibraryMembership;
import com.sLsD.entities.Student;
import com.sLsD.util.HibernateUtil;

public class OneToOnePKDAOImpl implements IOneToOnePKDAO {

	@Override
	public void saveDataByParent() {
	
		//Transaction 
		Transaction tx = null;
	    try(Session sess = HibernateUtil.getSession()){
	    	
	    	//Create Parent Object
	    	Student s1 = new Student();
	    	s1.setSname("Sumit");
	    	s1.setCourse("MCA");
	    	s1.setSaddr("Noida");
	    	
	    	//Create Child Object
	    	LibraryMembership lm1 = new LibraryMembership();
	    	lm1.setCollege("ASODL");
	    	lm1.setValidFor(3);
	    	lm1.setJoiningDate(new Date(118,05,01));
	    	
	    	//OneToOne Parent
	    	s1.setLibraryDetails(lm1);
	    	//OneToOne Child
	    	lm1.setStudentDetails(s1);
	    	
	    	//Begin Transaction
	    	tx = sess.beginTransaction();
	    	//Save Using Parent
	    	Long result = (Long)sess.save(s1);
	    	//Commit Transaction
	    	tx.commit();
	    	System.out.println("Student With Id:: "+result+" And His LibraryMembership Details Persisted Successfully");
	    	
	    }catch(HibernateException he) {
	    	he.printStackTrace();
	    	if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
	    		tx.rollback();
	    		System.out.println("Data Not Inserted By Using Parent Object");
	    	}
	    }
		
	}

	@Override
	public void saveDataByChild() {
		//Transaction 
				Transaction tx = null;
			    try(Session sess = HibernateUtil.getSession()){
			    	
			    	//Create Parent Object
			    	Student s1 = new Student();
			    	s1.setSname("Anand");
			    	s1.setCourse("B-Tech");
			    	s1.setSaddr("Bhopal");
			    	
			    	//Create Child Object
			    	LibraryMembership lm1 = new LibraryMembership();
			    	lm1.setCollege("JIT");
			    	lm1.setValidFor(3);
			    	lm1.setJoiningDate(new Date(117,04,01));
			    	
			    	//OneToOneParent
			    	s1.setLibraryDetails(lm1);
			    	//OneToOne Child
			    	lm1.setStudentDetails(s1);
			    	
			    	//Begin Transaction
			    	tx = sess.beginTransaction();
			    	//Save Using Child
			    	Long result = (Long)sess.save(lm1);
			    	//Commit Transaction
			    	tx.commit();
			    	System.out.println("Library Membership With Id:: "+result+" And His Student Details Persisted Successfully");
			    	
			    }catch(HibernateException he) {
			    	he.printStackTrace();
			    	if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
			    		tx.rollback();
			    		System.out.println("Data Not Inserted By Using Parent Object");
			    	}
			    }
		
	}

	@Override
	public void getDataByParent() {
		
		try(Session sess = HibernateUtil.getSession()){
		//Perform Select Operation By Using Native Query
		Query<Student> query = sess.createQuery("FROM Student ORDER BY sno",Student.class);
		//Send and Execute Query
		List<Student> stuList = query.list();
		//Process the Result
		stuList.forEach(student->{
		  System.out.println("Parent:: "+student);
		  System.out.println("Child:: "+student.getLibraryDetails().getClass().getName());
		  
		});
		
		}catch(HibernateException he) {
			he.printStackTrace();
		}
		
		
	}

	@Override
	public void getDataByChild() {
		try(Session sess = HibernateUtil.getSession()){
			//Perform Select Operation By Using Native Query
			Query<LibraryMembership> query = sess.createNativeQuery("SELECT * FROM OTOPK_LIBRARY_MEMBERSHIP", LibraryMembership.class);
			//Send and Execute Query
			List<LibraryMembership> stuList = query.list();
			//Process the Result
			stuList.forEach(lm->{
			  System.out.println(lm);
			  System.out.println("Proxy Class In the Form Associated Childs:: "+lm.getStudentDetails().getClass().getName());
			});
			
			}catch(HibernateException he) {
				he.printStackTrace();
			}
	}

	@Override
	public void deleteRecordByParent() {
		//Transaction 
		Transaction tx = null;
		try(Session sess = HibernateUtil.getSession()){
			//Get The Associated Parent By Id
			Student student = sess.get(Student.class,111l);
			if(student!=null) {
				tx = sess.beginTransaction();
				//Delete By Parent
				sess.delete(student);
				//Commit
				tx.commit();
				System.out.println("Parent and Associated Child Object Deleted");
				
			}else {
				System.out.println("Record Not Found With The Given Id");
				return;
			}
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				System.out.println("Problem In Deleting");
				tx.rollback();
			}
			
		}
		
	}

	@Override
	public void deleteRecordByChild() {
		// TODO Auto-generated method stub
		
	}

}
