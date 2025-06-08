package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.sLsD.entity.Product;
import com.sLsD.util.HibernateUtil;

public class MergeObjectOperationTest01 {
	
	public static void main(String[]args) {
		
		//Create SessionFactory along with the required Services
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//Open a Session With DB
		Session sess = HibernateUtil.getSession();
		
		//Transaction
		Transaction tx = null;
		//Try With Resource
		try(factory;sess){
			//Begin Transaction
			tx = sess.beginTransaction();
			//Create Entity class object
			Product prod = new Product();
			prod.setPid(2022l);
			prod.setPname("ThinkPad");
			prod.setPrice(95000.00);
			prod.setQty(1.00);
			
			//Performing SaveOrUpdate Operation Using Merge Method
			Product prod1 = (Product)sess.merge(prod);//This method internally behaves as sess.saveOrUpdate();
			//Commit tx
			tx.commit();
			System.out.println("Given Object Data:: "+prod.hashCode());
			System.out.println("Received Object Data:: "+prod1.hashCode());
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
