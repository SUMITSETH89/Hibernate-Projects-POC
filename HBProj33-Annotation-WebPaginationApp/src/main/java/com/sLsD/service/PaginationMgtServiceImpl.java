package com.sLsD.service;

import java.util.ArrayList;
import java.util.List;

import com.sLsD.dao.IPaginationDAO;
import com.sLsD.dao.PaginationDAOImpl;
import com.sLsD.entity.ProductDetails;

public class PaginationMgtServiceImpl implements IPaginationMgtService {
	
	//Dependency Injection HAS-A Relation
	private IPaginationDAO dao;
	
	public PaginationMgtServiceImpl() {
        System.out.println("PaginationMgtServiceImpl::Zero Param Constructor");
		this.dao = new PaginationDAOImpl();
	}

	@Override
	public int getPagesCount(Integer pageSize) {
		try {
			//Get Total Records
			int totalRecords = dao.getTotalRecordsCount().intValue();
			//To get PageCounts
			Integer pagesCount = totalRecords/pageSize;
			if(totalRecords%pageSize!=0) pagesCount++;
			return pagesCount;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<ProductDetails> getPageDate(Integer pageNo, Integer pageSize) {
		
		try {
			//Get Start Position of Every Page
			int startPosition = (pageNo*pageSize) - pageSize;
			//Use DAO 
			List<ProductDetails> detailsList = dao.getPageData(startPosition, pageSize);
			return detailsList.size()!=0?detailsList:new ArrayList<ProductDetails>();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
