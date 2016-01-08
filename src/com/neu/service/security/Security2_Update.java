package com.neu.service.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Security2_DAO;

public class Security2_Update extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          
		this.doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");

		int cleaner_num = 0;
		if(request.getParameter("cleaner_numvalue")!= ""){
			 cleaner_num  = Integer.parseInt(request.getParameter("cleaner_numvalue"));
		}

		String work_content = request.getParameter("work_contentvalue");
		String tools = request.getParameter("toolsvalue");
		String work_time = request.getParameter("work_timevalue");
	    
		//System.out.print("lay::"+layout);
		Security2_DAO c1_dao = new Security2_DAO();
		c1_dao.update(cleaner_num, work_content, tools,work_time);
		
		request.getRequestDispatcher("../servlet/Security2?jump_type=first").forward(request,
				response);

		
	}

	

}
