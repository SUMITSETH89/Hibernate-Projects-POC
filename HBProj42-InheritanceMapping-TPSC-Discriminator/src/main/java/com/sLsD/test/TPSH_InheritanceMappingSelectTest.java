package com.sLsD.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.sLsD.entities.Employee;
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
			
			String query = "select * from hb_inh_person_tpsc p\r\n"
					+ "inner join\r\n"
					+ "hb_inh_employee_tpsc e\r\n"
					+ "on p.id = e.person_id\r\n"
					+ "where p.person_type = ?1";
			
			NativeQuery query1 = sess.createNativeQuery(query);
			
			//Set Parameter
			query1.setParameter(1,"employee");
			//Execute Query
			List<Object[]> personList = query1.getResultList();
			
			//Process the Result
			personList.forEach(obj->{
				for(Object io : obj)
				System.out.println(io);
			});
			/*Query query = sess.createQuery("FROM Person");
			
			//Execute the Query
			List<Person> personList = query.getResultList();
			//Process the Result
			personList.forEach(System.out::println);*/
				
		}catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}

/*
 */
