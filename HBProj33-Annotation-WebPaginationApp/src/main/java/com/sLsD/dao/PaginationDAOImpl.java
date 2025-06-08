package com.sLsD.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sLsD.entity.ProductDetails;
import com.sLsD.util.HibernateUtil;

public class PaginationDAOImpl implements IPaginationDAO {
	
	public PaginationDAOImpl() {
		System.out.println("PaginationDAOImpl::Zero Param Constructor");
	}

	@Override
	public Long getTotalRecordsCount() {
		
		try(Session sess = HibernateUtil.getSession()){
			//Query Object
			Query query = sess.getNamedQuery("TOTAL_RECORD_COUNT");
			Long count =  (Long)query.getSingleResult();
			return count;
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<ProductDetails> getPageData(Integer startPosition, Integer pageSize) {
		try(Session sess = HibernateUtil.getSession()){
			
			//Query Object For Pagination
			Query<ProductDetails> query = sess.getNamedQuery("GET_PRODUCT_DETAILS_RECORDS");
			//Set Pagination Parameters
			query.setFirstResult(startPosition);
			query.setMaxResults(pageSize);
			//Get Result Set
			List<ProductDetails> prodDetailsList = query.getResultList();
			return prodDetailsList.size()!=0?prodDetailsList:new ArrayList<ProductDetails>();
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}
		
		return null;
	}

}
