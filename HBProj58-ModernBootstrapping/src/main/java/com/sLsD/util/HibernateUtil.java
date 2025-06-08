package com.sLsD.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import com.sLsD.service.jdbc.connection.CustomConnectionProviderServiceImpl;

public class HibernateUtil {
	
	private static SessionFactory factory = null;
	
	/*Approach#1
	static {
		System.out.println("Hibernate Util:: Static Block");
		//Bootstrap Hibernate Framework
		Configuration cfg = new Configuration();
		//Specify the name and location of hibernate.cfg.xml file
		cfg.configure("com/sLsD/cfgs/hibernate.cfg.xml");
		cfg.addResource("com/sLsD/entities/Student.hbm.xml");
		//Create ServiceRegistry Builder
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		//Create Service Registry
		StandardServiceRegistry registry = builder.applySettings(cfg.getProperties()).build();
		//Create SessionFactory having all the required Services
		factory = cfg.buildSessionFactory(registry);
		
	}*/
	
	/*Approach#2 With CustomConnectionProvider*
	static {
		
		System.out.println("Hibernate Util:: Static Block");
		//Bootstrap Hibernate Framework
		Configuration cfg = new Configuration();
		//Create ServiceRegistry Builder
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		//Add Custom Service
		builder.addService(ConnectionProvider.class,new CustomConnectionProviderServiceImpl());
		//Create Service Registry
		StandardServiceRegistry registry = builder.configure("com/sLsD/cfgs/hibernate.cfg.xml").build();
		System.out.println("ConnectionProvider:: "+registry.getService(ConnectionProvider.class));
		//Create SessionFactory having all the required Services
		factory = cfg.buildSessionFactory(registry);
		
	}*/
	
	/*Approach#3 With Custom Connection Provider Using Hikari CP*/
	static {
			
			System.out.println("Hibernate Util:: Static Block");
			//Bootstrap Hibernate Framework
			Configuration cfg = new Configuration();
			//Create ServiceRegistry Builder
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			//Add Custom Service
			builder.addService(ConnectionProvider.class,new CustomConnectionProviderServiceImpl());
			//Create Service Registry
			StandardServiceRegistry registry = builder.configure("com/sLsD/cfgs/hibernate.cfg.xml").build();
			System.out.println("ConnectionProvider:: "+registry.getService(ConnectionProvider.class));
			//Create SessionFactory having all the required Services
			factory = cfg.buildSessionFactory(registry);
			
		}
	
	public static SessionFactory getSessionFactory() {
		return factory!=null?factory:null;
	}
	
	public static Session getSession() {
		return factory!=null?factory.openSession():null;
	}
	
	public static void closeSessionFactory() {
		if(factory!=null) {
			//Close Factory
			factory.close();
		}
	}
	
	 

}
