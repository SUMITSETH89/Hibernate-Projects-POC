package com.sLsD.controller;

import java.io.IOException;
import java.util.List;

import com.sLsD.entity.ProductDetails;
import com.sLsD.service.IPaginationMgtService;
import com.sLsD.service.PaginationMgtServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class MainControllerServlet extends HttpServlet {
	
	private IPaginationMgtService service;
	
	@Override
	public void init() {
	 System.out.println("Init No Param Life Cycle Invoked");
	 this.service = new PaginationMgtServiceImpl();
	 
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pageSize = req.getParameter("pageSize");
		String pgNo = req.getParameter("pgNo");
		
		HttpSession session = req.getSession(true);
		int pageNo = 0;
		if(pageSize!=null) {//if Submit Button is Clicked i.e pageSize!=null but pgNo = null;
			session.setAttribute("pageSize",pageSize);
			pageNo = 1;
		}else {
			//Here pageSize is equal to null i.e. get it from session object
			pageNo = Integer.parseInt(pgNo);
			if(session.getAttribute("pageSize")!=null) {
				pageSize = (String)session.getAttribute("pageSize");
			}else {
				pageSize = "3";//Default Page Size
			}
		}//else
		
		try {
			
			int pagesCount = service.getPagesCount(Integer.parseInt(pageSize));
			List<ProductDetails> detailsList = service.getPageDate(pageNo,Integer.parseInt(pageSize));
			//Keep Result in Request Scope
			req.setAttribute("prodList",detailsList);
			req.setAttribute("pgCount",pagesCount);
			//Create Request Dispatcher Object
			RequestDispatcher rd = req.getRequestDispatcher("/show_report.jsp");
			//Forward Request
			rd.forward(req, resp);	
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("Error",e.getMessage());
			RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
			rd.forward(req, resp);
		}
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
