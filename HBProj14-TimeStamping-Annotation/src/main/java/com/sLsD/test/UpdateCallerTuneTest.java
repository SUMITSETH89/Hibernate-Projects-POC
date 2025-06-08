package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sLsD.entity.CallerTune;
import com.sLsD.util.HibernateUtil;

public class UpdateCallerTuneTest {
	
public static void main(String[]args) {
		
		//SessionFactory object having all required services
		SessionFactory factory = HibernateUtil.getSessionFactory();
	    //Open Session
		Session sess = HibernateUtil.getSession();
		//Transaction 
		Transaction tx = null;
		//Try with Resource
		try(factory;sess){
			//Begin Transaction
			tx = sess.beginTransaction();
			//Load the Object 
			CallerTune tune = sess.get(CallerTune.class,1l);
			if(tune==null) {
				System.out.println("Object Not Found");
				return;
			}else {
			//Modify the Object Data With In Transaction Without Calling Update Method.
				if(tune.getUpdationCount()<2) {
					tune.setTuneName("ABXXX");
					tune.setMovieName("TUTUTU");
				}else {
					System.out.println("Object Cannot Be Updated More Than Twice");
					return;
				}
				
			}
			//Commit Tx
			tx.commit();
			System.out.println("Tune Updated Successfully");
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				System.out.println("Object Not Saved");
				tx.rollback();
			}
			
		}
	}


}
