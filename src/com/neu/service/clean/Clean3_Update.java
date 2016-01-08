package com.neu.service.clean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Clean3_DAO;

public class Clean3_Update extends HttpServlet {

	
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
		Clean3_DAO c1_dao = new Clean3_DAO();
		c1_dao.update(check_num,checktype,cleaner_num,checkcontent,checkdate,checker);
		
		request.getRequestDispatcher("../servlet/Clean3?jump_type=first").forward(request,
				response);

		
	}

	

}
