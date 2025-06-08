package com.sLsD.test;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sLsD.entities.CardPayment;
import com.sLsD.util.HibernateUtil;

public class TPSC_InheritanceMappingSelectTest {
	
	//Make Payment By Card
	
	public static void main(String[]args) {
		
		//Transaction
		Transaction tx = null;
		//Create Session Object
		try(Session sess = HibernateUtil.getSession()){
			//Since it a insert persistence operation, it must
			//done with in the Transactional Environment
			
			//Perform Select and Update Operation
			Query query = sess.createQuery("FROM CardPayment ORDER BY txId");
			List<CardPayment> cpList = query.getResultList();
			cpList.forEach(System.out::println);
			
			//Begin the Transaction
			tx = sess.beginTransaction();
			
			//Modify the CardPayment Details Within Transactional Environment
			for(CardPayment cp : cpList) {
				cp.setAmount(27000.00);
			}
			
			//Commit the Transaction
			tx.commit();
			
		}catch(HibernateException he) {
			he.printStackTrace();
			
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Payment Failed");
			}
		}
	}
	
	

}
