package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sLsD.entity.ProgrammersProject;
import com.sLsD.entity.ProgrammersProjectId;
import com.sLsD.util.HibernateUtil;

public class CompositeIdAnnotationSaveTest {
	
	public static void main(String[]args) {
		
		//Create SessionFactory Object having all the required Services
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//Open Session
		Session sess = HibernateUtil.getSession();
		//Transaction 
		Transaction tx = null;
		//Try With Resource
		try(factory;sess){
			
			//Begin Transaction
			tx = sess.beginTransaction();
			//Assigned Composite Primary Id Properties Values
			ProgrammersProjectId id = new ProgrammersProjectId();
			id.setPgmrId(103l);
			id.setProjId(1010l);
			
			//Create Entity class object
			ProgrammersProject proj = new ProgrammersProject();
			proj.setId(id);
			proj.setPgmrName("Sauravh");
			proj.setProjName("HAJ");
			proj.setPgmrSalary(45000.00);
			proj.setBudget(10000000.00);
			
			//Save Object Operation
			sess.save(proj);
			//Commit Transaction
			tx.commit();
			System.out.println("Object Saved Successfully:: "+proj.getId());
			
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				System.out.println("Object Not Saved");
				tx.rollback();
			}
		}
	}

}
