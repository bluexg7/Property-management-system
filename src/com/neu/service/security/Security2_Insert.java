package com.neu.service.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Security2_DAO;

public class Security2_Insert extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("gb2312");
		
		String addInfo = request.getParameter("addSolve");
		String str[] = addInfo.split("#");
	    int cleaner_num=Integer.parseInt(str[0]);    
	    String work_content =str[1];
	    String tools=str[2];
	    String work_time=str[3];
	    
	    Security2_DAO c1_dao = new Security2_DAO();
	    c1_dao.insert(cleaner_num,work_content,tools,work_time);	
		request.setAttribute("jump_type","first");
		
		request.getRequestDispatcher("../servlet/Security2?jump_type=first").forward(request,
				response);
	}

	
}
