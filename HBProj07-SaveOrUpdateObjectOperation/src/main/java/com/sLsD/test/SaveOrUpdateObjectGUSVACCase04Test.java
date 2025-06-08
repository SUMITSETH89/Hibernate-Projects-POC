package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sLsD.entity.Product;

/*With Generator and Unsaved-value Attribute Configuration
 * 
 * CASE#4: If Id Generator is not Configured and Unsaved-value is configured
 *         then sess.saveOrUpdate(-) method performs Insert Object Operation
 *         if Unsave-value is matching with Id Property value(If Id value is
 *         already there DB Table,then it throws ConstraintViolationException)
 *         otherwise Update the record by taking Id Value as the Criteria value.
 * */
public class SaveOrUpdateObjectGUSVACCase04Test {
	
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
			prod.setPid(2020l);
			prod.setPname("Boat Buds");
			prod.setPrice(2600.00);
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
