package com.sLsD.test;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sLsD.entities.Person;
import com.sLsD.util.HibernateUtil;

public class TPSH_InheritanceMappingSelectTest {
	
	public static void main(String[]args) {
		
		//Create Session
		Session sess = HibernateUtil.getSession();
		
		try(sess){
			//Create Query Object
			/*Query query = sess.createQuery("FROM Student");
			//Execute the Query
			List<Student> studentList = query.getResultList();
			
			//Process the Result
			studentList.forEach(sl->System.out.println(sl));*/
			
			/*Query query1 = sess.createQuery("FROM Employee",Employee.class);
			
			//Execute Query
			List<Employee> empList = query1.getResultList();
			
			//Process the Result
			empList.stream()
			       .forEach(e->System.out.println(e));*/
			Query query = sess.createQuery("FROM Person");
			
			//Execute the Query
			List<Person> personList = query.getResultList();
			//Process the Result
			personList.forEach(System.out::println);
				
		}catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}

/*
Hibernate: 
    select
        employee0_.PERSON_ID as id1_2_,
        employee0_1_.NAME as name2_2_,
        employee0_1_.ADDRESS as address3_2_,
        employee0_1_.AGE as age4_2_,
        employee0_1_.PROFESSION as profession5_2_,
        employee0_.COMPANY as company2_1_,
        employee0_.DESIGNATION as designation3_1_,
        employee0_.EXP as exp4_1_,
        employee0_.SAL as sal5_1_ 
    from
        HB_INH_EMPLOYEE_TPSH employee0_ 
    inner join
        HB_INH_PERSON_TPSH employee0_1_ 
            on employee0_.PERSON_ID=employee0_1_.ID */
