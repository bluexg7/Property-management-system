package com.neu.service.clean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Clean3_DAO;

public class Clean3_Insert extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("gb2312");
		
		String addInfo = request.getParameter("addSolve");
		String str[] = addInfo.split("#");
	    int check_num=Integer.parseInt(str[0]);
	    String checktype =str[1];
	    int cleaner_num=Integer.parseInt(str[2]);  
	    String checkcontent =str[3];
	    String checkdate=str[4];
	    String checker =str[5];

	    
	    Clean3_DAO c1_dao = new Clean3_DAO();
	    c1_dao.insert(check_num,checktype,cleaner_num,checkcontent,checkdate,checker);	
		request.setAttribute("jump_type","first");
		
		request.getRequestDispatcher("../servlet/Clean3?jump_type=first").forward(request,
				response);
	}

	
}
