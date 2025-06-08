package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sLsD.entity.CallerTune;
import com.sLsD.util.HibernateUtil;

public class SaveCallerTuneTest {
	
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
			//Create Entity class object
			CallerTune tune = new CallerTune();
			tune.setTuneId(4l);
			tune.setTuneName("ABC");
			tune.setMovieName("XYZ");
			//save object operation
			Long tid = (Long)sess.save(tune);
			//Commit Tx
			tx.commit();
			System.out.println("Object With Tune Id:: "+tid+" Saved Successfully");
			
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				System.out.println("Object Not Saved");
				tx.rollback();
			}
			
		}
	}

}
