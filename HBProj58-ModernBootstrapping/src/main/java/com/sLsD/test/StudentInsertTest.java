package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sLsD.entities.Student;
import com.sLsD.util.HibernateUtil;

public class StudentInsertTest {
	
	public static void main(String[]args) {
		//Transaction
		 Transaction tx = null;
		 
		try(Session sess = HibernateUtil.getSession()){
			
			//Begin Transaction
			tx = sess.beginTransaction();
			//Create Entity class object
			Student student = new Student();
			student.setSname("Harshit");
			student.setInstitute("RU");
			student.setCourse("Electronics");
			student.setDuration(3);
			
			//Save Student
			Long id = (Long)sess.save(student);
			//Commit Transaction
			tx.commit();
			System.out.println("Student With Id:: "+id+" Persisted Successfully");
			
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Student not persisted successfully");
			}
		}
	}

}
