package com.neu.service.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Security3_DAO;

public class Security3_Update extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          
		this.doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");

		int check_num = 0;
		if(request.getParameter("check_numvalue")!= ""){
			 check_num  = Integer.parseInt(request.getParameter("check_numvalue"));
		}

		int cleaner_num=0;
		if(request.getParameter("cleaner_numvalue")!= ""){
			cleaner_num = Integer.parseInt(request.getParameter("cleaner_numvalue"));
		}
		String checktype = request.getParameter("checktypevalue");
		String checkcontent = request.getParameter("checkcontentvalue");
		String checkdate = request.getParameter("checkdatevalue");
		String checker = request.getParameter("checkervalue");
	    
		//System.out.print("lay::"+layout);
		Security3_DAO c1_dao = new Security3_DAO();
		c1_dao.update(check_num,checktype,cleaner_num,checkcontent,checkdate,checker);
		
		request.getRequestDispatcher("../servlet/Security3?jump_type=first").forward(request,
				response);

		
	}

	

}
