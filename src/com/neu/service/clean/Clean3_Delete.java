package com.neu.service.clean;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Clean3_DAO;

public class Clean3_Delete extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	     request.setCharacterEncoding("gb2312");
		
		String key = request.getParameter("delSolve");
		String cleancheckInfo[] = key.split("#");
		
		Clean3_DAO c1_dao = new Clean3_DAO();
		for(String c:cleancheckInfo){
			System.out.println("É¾³ýÍ£³µ³¡¼ÇÂ¼£º"+c);
			c1_dao.delete(c);
		}
		
		request.getRequestDispatcher("../servlet/Clean3?jump_type=first").forward(request,response);
			
	}

	

}
