package com.sLsD.test;

import java.time.LocalDateTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sLsD.entities.CardPayment;
import com.sLsD.util.HibernateUtil;

public class TPCH_InheritanceMappingInsertTest {
	
	//Make Payment By Card
	
	public static void main(String[]args) {
		
		//Transaction
		Transaction tx = null;
		//Create Session Object
		try(Session sess = HibernateUtil.getSession()){
			//Since it a insert persistence operation, it must
			//done with in the Transactional Environment
			
			//Begin the Transaction
			tx = sess.beginTransaction();
			
			//Create Sub-Class Object
			CardPayment cp = new CardPayment();
			//Common Properties
			cp.setAmount(34989.00);
			cp.setTxDate(LocalDateTime.now());
			//Specific Properties
			cp.setCardNo(8008122931890011l);
			cp.setCardType("Debit");
			cp.setGateway("Master");
			//Invoke save(-) to give Insert Persistence Instruction
			Long id = (Long)sess.save(cp);
			//Commit the Transaction
			tx.commit();
			System.out.println("Payment With Id:: "+id+" Persisted Successfully");
			
		}catch(HibernateException he) {
			he.printStackTrace();
			
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Payment Failed");
			}
		}
	}
	
	

}
