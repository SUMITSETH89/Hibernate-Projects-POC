package com.sLsD.test;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sLsD.entity.Movie;
import com.sLsD.proxy.IMovie;
import com.sLsD.util.HibernateUtil;

public class LoadObjectOperations {
	
	public static void main(String[]args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session sess = HibernateUtil.getSession();
		//Try With Resource
		try(factory;sess){
			//Approach#1:: Making Lazy to false
			IMovie movie = sess.load(Movie.class,1002l);
			if(movie!=null) {
				System.out.println("Class Name:: "+movie.getClass().getName()+" Super Class Name:: "+movie.getClass().getSuperclass()
						+" Super Interfaces:: "+Arrays.toString(movie.getClass().getInterfaces()));
				//Performs Eager Loading
				System.out.println(movie.getMid());
			}
		}catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}


