package com.sLsD.dao;

import java.util.List;

import com.sLsD.entity.ProductDetails;

public interface IPaginationDAO {

	public Long getTotalRecordsCount();
	
	public List<ProductDetails> getPageData(Integer startPosition,Integer pageSize);
	
}
