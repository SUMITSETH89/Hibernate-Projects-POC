package com.sLsD.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sLsD.entities.Department;
import com.sLsD.entities.Employee;
import com.sLsD.entities.IDepartmentProxy;
import com.sLsD.util.HibernateUtil;

public class CompanyMgtDAOImpl implements ICompanyMgtDAO {

	@Override
	public void saveDataUsingChild() {
		
		//Transaction
		Transaction tx = null;
		try(Session sess = HibernateUtil.getSession()){
			//Begin Transaction
			tx = sess.beginTransaction();
			//Create Parent And Associated Child Objects
			Department dept = new Department();
			dept.setDeptName("Research");
			dept.setDeptHead("Banglore");
			
			//Associated Childs
			Set<Employee> empList = new HashSet<Employee>();
			Employee emp = new Employee();
			emp.setEname("Sumit");
			emp.setDesignation("Scientist-A");
			emp.setSalary(50000.00);
			emp.setDept(dept);
			//Child#1
			empList.add(emp);
			
			emp = new Employee();
			emp.setEname("Anand");
			emp.setDesignation("Scientist-B");
			emp.setSalary(77000.00);
			emp.setDept(dept);
			//Child#2
			empList.add(emp);
			
			emp = new Employee();
			emp.setEname("Harshit");
			emp.setDesignation("Scientist-C");
			emp.setSalary(60000.00);
			emp.setDept(dept);
			//Child#3
			empList.add(emp);
			
			//Add Childs to Parent
			dept.setEmployees(empList);
			
			//Save Though Child
			Iterator<Employee> e = empList.iterator();
			List<Long> idList = new ArrayList<Long>();
			while(e.hasNext()) {
				Long id = (Long)sess.save(e.next());
				idList.add(id);
			}
			
			//commit Transaction
			tx.commit();
			
			System.out.println("Childs With ID's:: "+idList+" Persisted Successfully");
	
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				System.out.println("Problem In Persisting Records");
				tx.rollback();
			}
		}
		
	}
	
	@Override
	public void saveDataUsingParent() {
		
		//Transaction
				Transaction tx = null;
				try(Session sess = HibernateUtil.getSession()){
					//Begin Transaction
					tx = sess.beginTransaction();
					//Create Parent And Associated Child Objects
					Department dept = new Department();
					dept.setDeptName("HR");
					dept.setDeptHead("New Delhi");
					
					//Associated Childs
					Employee emp = new Employee();
					emp.setEname("Mahendra");
					emp.setDesignation("HR Executive");
					emp.setSalary(50000.00);
					emp.setDept(dept);
					
					Employee emp2 = new Employee();
					emp2.setEname("Sauravh");
					emp2.setDesignation("HR Executive");
					emp2.setSalary(77000.00);
					emp2.setDept(dept);
					
					Employee emp3 = new Employee();
					emp3.setEname("Amit");
					emp3.setDesignation("HR Executive");
					emp3.setSalary(60000.00);
					emp3.setDept(dept);
					
					//Add Childs to Parent
					dept.setEmployees(Set.of(emp,emp2,emp3));
					
					//Save Data Using Parent
					Long id = (Long)sess.save(dept);
					//commit Transaction
					tx.commit();
					
					System.out.println("Parent With ID:: "+id+" And Associated Childs Persisted Successfully");
			
				}catch(HibernateException he) {
					he.printStackTrace();
					if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
						System.out.println("Problem In Persisting Records");
						tx.rollback();
					}
				}
		
	}

	@Override
	public void fetchByParent() {
		/*Following values to lazy attribute while performing
		 * select operation in one-to-many association using
		 * parent object.
		 * 1) lazy = true(default)
		 * 2) lazy = false
		 * 3) lazy = extra
		 */
		try(Session sess = HibernateUtil.getSession()){
			//Query object represents HQL Query
			Query query = sess.createQuery("FROM Department");
			//Execute Query
			List<Department> deptList = query.getResultList();
			//Process The Result
			deptList.forEach(p->{
				System.out.println(p);
				System.out.println(p.getEmployees().size());
			});
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}
	}

	@Override
	public void fetchByChildWithProxy() {
		
		/*Following values to lazy attribute while performing
		 * select operation in many-to-one association using
		 * child object.
		 * 1) lazy = proxy(default)
		 * 2) lazy = false
		 * 3) lazy = no-proxy
		 */
		
		try(Session sess = HibernateUtil.getSession()){
			//Query object represents HQL Query
			Query<Employee> query = sess.createQuery("FROM Employee",Employee.class);
			//Execute Query
			List<Employee> empList = query.getResultList();
			empList.forEach(emp->{
				System.out.println(emp);
				//System.out.println("ProxyClass"+emp.getDept().getClass().getSuperclass().getName());
			});
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}
		
	}
	
	@Override
	public void fetchByChildWithNoProxy() {
		/*Code Improvisation in One-to-Many/Many-to-One Association
		 * Example having lazy = no-proxy
		 * Step#1:: Set many-to-one lazy attribute to no-proxy in Employee.hbm.xml file.
		 * Step#2:: Create a proxy Interface having all the Corresponding Properties methods of the Parent class.
		 * Step#3:: Make the parent class implementing proxy interface.
		 * Step#4:: Specify the proxy interface in the proxy attribute of class tag of
		 *  Department.hbm.xml file.
		 * Step#5:: Perform Select operation using child object
		 */
		try(Session sess = HibernateUtil.getSession()){
			
			//Create Query object representing HQL Query
			Query<Employee> query = sess.createQuery("FROM Employee",Employee.class);
			//Execute Query
			List<Employee> empList = query.getResultList();
			//Process the Result
		    empList.forEach(emp->{
		    	System.out.println(emp);
		    	IDepartmentProxy dept = emp.getDept();
		    	System.out.println("ClassName:: "+dept.getClass().getName()+" SuperClass:: "+dept.getClass().getSuperclass());
		    });
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}
		
		
		
	}
	
	

}
