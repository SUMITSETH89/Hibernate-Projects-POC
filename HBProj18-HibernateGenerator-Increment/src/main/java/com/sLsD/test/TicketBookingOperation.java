package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sLsD.entity.Product;
import com.sLsD.util.HibernateUtil;

public class TicketBookingOperation implements Runnable {
	
	public TicketBookingOperation() {
		System.out.print("Zero Param Constructor::Ticket Booking Operation");
	}

	@Override
	public void run() {
		
		//Create Session Factory Object Having All the Required Services
				SessionFactory factory = HibernateUtil.getSessionFactory();
				//Create Session Object
				Session sess = HibernateUtil.getSession();
				//Transaction
				Transaction tx = null;
				//Try With Resource
				try(factory;sess){
				//Thread.sleep(5000);
				//Begin Transaction
			    tx = sess.beginTransaction();
				//Create Entity class object
			    Product prod = new Product();
			    prod.setpId(2030l);
			    prod.setpName("FossilXV-7");
			    prod.setPrice(34300.00);
			    prod.setQty(1.0);
			    //sess.save(-) to give Insert Persistence Instruction 
			    Long pid = (Long)sess.save(prod);
			    //Commit
			    tx.commit();
			    System.out.println("Object With Id::"+pid+" Inserted Successfully From Thread:: "+Thread.currentThread().getName());

				}catch(HibernateException he) {
					he.printStackTrace();
					if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
						tx.rollback();
						System.out.println("Object Not Inserted");
					}
				}

	}

}
