package com.neu.service.system;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.System1_DAO;

public class System1_Reduction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String sysdmp = request.getParameter("sysdmpvalue");
		String syslog = request.getParameter("syslogvalue");
	
		System1_DAO sys1 = new System1_DAO();
		sys1.System1Reduction(sysdmp, syslog);
		
		request.getRequestDispatcher("../servlet/System1?jump_type=first").forward(request,
				response);
		
	}
	
}
