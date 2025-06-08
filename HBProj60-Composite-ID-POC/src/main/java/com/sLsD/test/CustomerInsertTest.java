package com.sLsD.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sLsD.entities.Customer;
import com.sLsD.entities.CustomerOrdersId;
import com.sLsD.util.HibernateUtil;

public class CustomerInsertTest {
	
	public static void main(String[]args) {
		//Transaction
		Transaction tx = null;
		try(Session session = HibernateUtil.getSession()){
			//Open Transaction 
			tx = session.beginTransaction();
			//Create Entity Object
			Customer cust = new Customer();
			//Since it is Composite Primary, we have provide Composite Primary property value manually.
			CustomerOrdersId compositeId = new CustomerOrdersId();
			compositeId.setCid(102l);
			compositeId.setOid(1001l);
			cust.setId(compositeId);
			cust.setProduct("Mobile");
			cust.setPrice(23000.00);
			cust.setAddress("New Delhi");
			cust.setDop(new Date(125,05,01));
			//Insert Customer
			session.save(cust);
			//Commit Transaction
			tx.commit();
			System.out.println("Customer Order's Data Persisted Successfully");
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				System.out.println("Customer Order's Not Persisted");
				tx.rollback();
			}
		}
	}

}
