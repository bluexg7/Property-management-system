package com.neu.service.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Security2_DAO;

public class Security2_Delete extends HttpServlet {

	
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	     request.setCharacterEncoding("gb2312");
		
		String key = request.getParameter("delSolve");
		String dailycleanInfo[] = key.split("#");
		
		Security2_DAO c1_dao = new Security2_DAO();
		for(String p:dailycleanInfo){
			System.out.println("删除日常保洁记录："+p);
			c1_dao.delete(p);
		}
		
		request.getRequestDispatcher("../servlet/Security2?jump_type=first").forward(request,response);
			
	}

	

}
