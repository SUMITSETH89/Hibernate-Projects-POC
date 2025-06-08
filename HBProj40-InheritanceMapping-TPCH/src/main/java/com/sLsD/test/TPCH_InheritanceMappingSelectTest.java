package com.sLsD.test;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sLsD.entities.Person;
import com.sLsD.util.HibernateUtil;

public class TPCH_InheritanceMappingSelectTest {
	
	public static void main(String[]args) {
		
		//Create Session
		Session sess = HibernateUtil.getSession();
		
		try(sess){
			//Create Query Object
			/*Query query = sess.createQuery("FROM Student");
			//Execute the Query
			List<Student> studentList = query.getResultList();
			
			//Process the Result
			studentList.forEach(sl->System.out.println(sl));
			
			Query query1 = sess.createQuery("FROM Employee",Employee.class);
			
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
        student0_.ID as id1_0_,
        student0_.NAME as name3_0_,
        student0_.ADDRESS as address4_0_,
        student0_.AGE as age5_0_,
        student0_.PROFESSION as profession6_0_,
        student0_.INSTITUTE as institute7_0_,
        student0_.COURSE as course8_0_,
        student0_.BATCH as batch9_0_,
        student0_.DURATION as duration10_0_ 
    from
        HB_INH_PERSON_TPCH student0_ 
    where
        student0_.PERSON_TYPE='student'
No Arg Constructor::Person
No Args Constructor:: Student
Student(instituteName=JIT, course=Computer Science, batch=2023, courseDuration=4)

Hibernate: 
    select
        employee0_.ID as id1_0_,
        employee0_.NAME as name3_0_,
        employee0_.ADDRESS as address4_0_,
        employee0_.AGE as age5_0_,
        employee0_.PROFESSION as profession6_0_,
        employee0_.COMPANY as company11_0_,
        employee0_.DESIGNATION as designation12_0_,
        employee0_.EXP as exp13_0_,
        employee0_.SAL as sal14_0_ 
    from
        HB_INH_PERSON_TPCH employee0_ 
    where
        employee0_.PERSON_TYPE='employee'
No Arg Constructor::Person
No Arg Constructor:: Employee
No Arg Constructor::Person
No Arg Constructor:: Employee
Employee(company=CDAC, designation=Java Developer, experience=3, salary=50000.0)
Employee(company=STTL, designation=Java Developer, experience=3, salary=50000.0)
 */
