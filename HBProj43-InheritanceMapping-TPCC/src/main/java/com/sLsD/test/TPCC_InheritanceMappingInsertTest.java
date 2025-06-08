package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sLsD.entities.Customer;
import com.sLsD.entities.Employee;
import com.sLsD.entities.Person;
import com.sLsD.entities.Student;
import com.sLsD.util.HibernateUtil;

public class TPCC_InheritanceMappingInsertTest {
	
	public static void main(String[]args) {
		
		//Create Session
		Session sess = HibernateUtil.getSession();
		//Transaction
		Transaction tx = null;
		
		//Try With Resource
		try(sess){
			//Begin Transaction
			tx = sess.beginTransaction();
			
			//Create Super Class Object
			/*Person person = new Person();
			person.setName("Sumit");
			person.setAddress("Muzaffarpur");
			person.setAge(36);
			person.setProfession("Java Developer");*/
			
			//Create Student Object
			/*Student student = new Student();
			student.setName("Amit");
			student.setAddress("New Delhi");
			student.setAge(21);
			student.setProfession("Student");
			student.setInstituteName("JIT");
			student.setCourse("Computer Science");
			student.setBatch(2023);
			student.setCourseDuration(4);*/
			
			//Create Employee Object
			Employee emp = new Employee();
			emp.setName("Sauravh");
			emp.setAddress("New Delhi");
			emp.setAge(28);
			emp.setProfession("IT");
			emp.setCompany("STTL");
			emp.setDesignation("Java Developer");
			emp.setExperience(3);
			emp.setSalary(50000.00);
			
			//Create Customer Object
			/*Customer cust = new Customer();
			cust.setName("Harshit");
			cust.setAddress("Noida");
			cust.setAge(26);
			cust.setProfession("Mgt");
			cust.setBillNo("AZ20250413");
			cust.setBillAmt(2198.00);*/
			
			//Invoke sess.save(-) method to give save persistence instruction
			//Long pid =(Long)sess.save(person);
			//Long sid =(Long)sess.save(student);
			Long empId=(Long)sess.save(emp);
			//Long custId=(Long)sess.save(cust);
			
			//Commit Transaction
			tx.commit();
			
			//System.out.println("Person With Id:: "+pid+" Saved Successfully");
			//System.out.println("Student With Id:: "+sid+" Saved Successfully");
			System.out.println("Employee With Id:: "+empId+" Saved Successfully");
			//System.out.println("Customer With Id:: "+custId+" Saved Successfully");
			
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null||tx.getStatus()!=null||tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Data Not Saved");
			}
		}
	}

}
