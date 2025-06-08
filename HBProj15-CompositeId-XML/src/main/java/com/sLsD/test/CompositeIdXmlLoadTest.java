package com.sLsD.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sLsD.entity.ProgrammersProject;
import com.sLsD.entity.ProgrammersProjectId;
import com.sLsD.util.HibernateUtil;

public class CompositeIdXmlLoadTest {
	
	public static void main(String[]args) {
		
		//Create SessionFactory Object having all required Services
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//Open Session
		Session sess = HibernateUtil.getSession();
		//Try With Resource
		try(factory;sess){
			
			//Create Composite Id Class Object
			ProgrammersProjectId id = new ProgrammersProjectId();
			id.setPgmrId(100l);
			id.setProjId(1003l);
			
			//Load Object Operation
			ProgrammersProject proj = sess.get(ProgrammersProject.class,id);
			if(proj!=null) {
				System.out.println(proj);
			}
			
		}catch(HibernateException he) {
			he.printStackTrace();
			System.out.println("Record With Given Id Not Found");
		}
	}

}
