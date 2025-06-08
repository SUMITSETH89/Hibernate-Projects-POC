package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sLsD.entity.Product;

public class SaveOrUpdateObjectWGUSVACTest {
	
	public static void main(String[]args) {
		
		//Bootstrap HB F/w
		Configuration cfg = new Configuration();
		//Specify the name and Location of hibernate.cfg.xml file
		cfg.configure("com/sLsD/cfgs/hibernate.cfg.xml");
		
		//Create SessionFactory along with the required Services
		SessionFactory factory = cfg.buildSessionFactory();
		//Open a Session With DB
		Session sess = factory.openSession();
		
		//Transaction
		Transaction tx = null;
		//Try With Resource
		try(factory;sess){
			//Begin Transaction
			tx = sess.beginTransaction();
			//Create Entity class object
			Product prod = new Product();
			prod.setPid(2017l);
			prod.setPname("LG Oven");
			prod.setPrice(8800.00);
			prod.setQty(1.00);
			
			//Give SaveOrUpdate Persistence Instruction
			sess.saveOrUpdate(prod);
			//Commit tx
			tx.commit();
			System.out.println("Record Inserted Or Updated");
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Record Not Inserted Or Updated");
			}
		}
	}

}
