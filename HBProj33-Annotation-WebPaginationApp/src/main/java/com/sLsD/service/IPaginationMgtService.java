package com.sLsD.service;

import java.util.List;

import com.sLsD.entity.ProductDetails;

public interface IPaginationMgtService {
	
	public int getPagesCount(Integer pageSize);
	public List<ProductDetails> getPageDate(Integer pageNo,Integer pageSize);
	

}
