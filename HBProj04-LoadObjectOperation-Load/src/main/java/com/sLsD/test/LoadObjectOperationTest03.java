package com.sLsD.test;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sLsD.entity.Product;
import com.sLsD.proxy.IProduct;

//Approach#3:: Making sess.load() performing Lazy Loading even though the Entity class is taken as Final.
public class LoadObjectOperationTest03 {
	
	public static void main(String[]args) {
		
		//Bootstrap Hibernate Framework
		Configuration cfg = new Configuration();
		//Name and Location of Hibernate Configuration File
		cfg.configure("com/sLsD/cfgs/hibernate.cfg.xml");
		
		
		//Create SessionFactory object having all the required Services
		try(SessionFactory factory = cfg.buildSessionFactory();
				Session sess = factory.openSession();){
			
			//Load Object Operation
			//Product prod = sess.load(Product.class,1002l); ClassCastException
			IProduct prod = sess.load(Product.class,1002l);
			/*System.out.println("Class Name:: "+prod.getClass().getName()+" Super Class:: "+prod.getClass().getSuperclass()+
					            " Super Interfaces:: "+Arrays.toString(prod.getClass().getInterfaces()));
					            
			Class Name:: com.sLsD.entity.Product$HibernateProxy$Yuzib0mX 
			Super Class:: class java.lang.Object 
			Super Interfaces:: [interface com.sLsD.proxy.IProduct, interface org.hibernate.proxy.HibernateProxy, 
			                    interface org.hibernate.proxy.ProxyConfiguration]		            
		    */
			
			/*Method[] methodsArray = prod.getClass().getDeclaredMethods();
			for(Method method : methodsArray) {
				System.out.println(method.getName());
			}
			equals
			toString
			hashCode
			clone
			writeReplace
			getHibernateLazyInitializer
			$$_hibernate_set_interceptor
			getPid
			setQty
			getQty
			getPrice
			setPrice
			setPname
			getPname
			setPid
			
			*/
			//Performs Lazy Loading
			System.out.println("Id:: "+prod.getPid());
			System.out.println(prod);
			
		}catch(HibernateException he) {
			he.printStackTrace();
			System.out.println("Record Not Found");
		}
		
		
	}

}
