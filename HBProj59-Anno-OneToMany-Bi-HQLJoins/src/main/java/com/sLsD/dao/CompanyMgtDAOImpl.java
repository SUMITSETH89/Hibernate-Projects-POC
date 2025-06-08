package com.sLsD.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sLsD.util.HibernateUtil;

public class CompanyMgtDAOImpl implements ICompanyMgtDAO {

	@Override
	public void loadDataUsingJoinParentToChild() {
		
		try(Session sess = HibernateUtil.getSession()){
			//HQL Join From Parent To Child
			//Create Query
			//Query query = sess.createQuery("SELECT d.deptNo,d.deptName,d.deptHead,e.empId,e.ename,e.salary FROM Department d INNER JOIN d.employees e");
			//Query query = sess.createQuery("SELECT d.deptNo,d.deptName,d.deptHead,e.empId,e.ename,e.salary FROM Department d LEFT OUTER JOIN d.employees e");
			//Query query = sess.createQuery("SELECT d.deptNo,d.deptName,d.deptHead,e.empId,e.ename,e.salary FROM Department d RIGHT OUTER JOIN d.employees e");
			Query query = sess.createQuery("SELECT d.deptNo,d.deptName,d.deptHead,e.empId,e.ename,e.salary FROM Department d FULL JOIN d.employees e");

			//Execute HQL Query
			List<Object[]> deptList = query.getResultList();
			//Process Result Set
			deptList.forEach(dept->{
				for(Object obj : dept) {
					System.out.print(obj+" ");
				}
				System.out.println();
			});
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}
		
		
	}

	@Override
	public void loadDataUsingJoinChildToParent() {
		
		try(Session sess = HibernateUtil.getSession()){
			//HQL Join From Parent To Child
			//Create Query
			//Query query = sess.createQuery("SELECT e.empId,e.ename,e.salary,e.designation,d.deptNo,d.deptName,d.deptHead FROM Employee e INNER JOIN e.dept d");
			Query query = sess.createQuery("SELECT e.empId,e.ename,e.salary,e.designation,d.deptNo,d.deptName,d.deptHead FROM Employee e LEFT OUTER JOIN e.dept d");
			//Query query = sess.createQuery("SELECT e.empId,e.ename,e.salary,e.designation,d.deptNo,d.deptName,d.deptHead FROM Employee e RIGHT OUTER JOIN e.dept d");
			//Query query = sess.createQuery("SELECT e.empId,e.ename,e.salary,e.designation,d.deptNo,d.deptName,d.deptHead FROM Employee e FULL JOIN e.dept d");

			//Execute HQL Query
			List<Object[]> empList = query.getResultList();
			//Process Result Set
			empList.forEach(emp->{
				for(Object obj : emp) {
					System.out.print(obj+" ");
				}
				System.out.println();
			});
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}
		
		
		
	}

}
