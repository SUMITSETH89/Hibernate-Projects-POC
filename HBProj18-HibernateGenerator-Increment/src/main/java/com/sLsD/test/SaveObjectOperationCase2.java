package com.sLsD.test;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sLsD.entity.Product;
import com.sLsD.util.HibernateUtil;

public class SaveObjectOperationCase2 {

	//Case2:: If we call sess.save(-) method in a Loop,then First maxValue
	//        will come from DB table to generate Id value using <maxValue + 1>
	//        the remaining Id values will be generated using <generatedValue + 1>
	//        formula.
	public static void main(String[]args) {
		
		//Create Session Factory Object Having All the Required Services
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//Create Session Object
		Session sess = HibernateUtil.getSession();
		//Transaction
		Transaction tx = null;
		//Try With Resource
		try(factory;sess){
		//Begin Transaction
	    tx = sess.beginTransaction();
		//Id Values
	    Long[] idArray = new Long[5];
	    for(int i = 0;i<idArray.length;i++) {
	    	//Create Entity class object
		    Product prod = new Product();
		    prod.setpName("FossilXV-"+(i+1));
		    prod.setPrice(23000.00);
		    prod.setQty(1.0);
		    //sess.save(-) to give Insert Persistence Instruction 
		    idArray[i]= (Long)sess.save(prod);
	    }
	    //Commit
	    tx.commit();
	    System.out.println("Objects With Id::"+Arrays.toString(idArray)+" Inserted Successfully");
			
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Object Not Inserted");
			}
		}
	}

}
/*
 * Zero Param Constructor:: 990722659
Hibernate: 
    select
        max(PID) 
    from
        PRODUCT
Zero Param Constructor:: 1429610243
Zero Param Constructor:: 1478269879
Zero Param Constructor:: 328140385
Zero Param Constructor:: 556773329
Hibernate: 
    insert 
    into
        PRODUCT
        (PNAME, PRICE, QTY, PID) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        PRODUCT
        (PNAME, PRICE, QTY, PID) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        PRODUCT
        (PNAME, PRICE, QTY, PID) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        PRODUCT
        (PNAME, PRICE, QTY, PID) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        PRODUCT
        (PNAME, PRICE, QTY, PID) 
    values
        (?, ?, ?, ?)
Objects With Id::[2028, 2029, 2030, 2031, 2032] Inserted Successfully
 */
