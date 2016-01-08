package com.neu.service.office;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Office1_DAO;

public class office1_Update extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String depart_name = request.getParameter("depart_namevalue");
		String office = request.getParameter("officevalue");
		String manager = request.getParameter("managervalue");
		String rule = request.getParameter("rulevalue");
		
		int depart_num = -1;
		if(request.getParameter("depart_numvalue")!= ""){
			depart_num = Integer.parseInt(request.getParameter("depart_numvalue"));
		}
		
		int staff = -1;
		if(request.getParameter("staffvalue")!= ""){
			staff = Integer.parseInt(request.getParameter("staffvalue"));
		}
		
		Office1_DAO off1dao = new Office1_DAO();
		off1dao.Office1Update(depart_num, depart_name, office, staff, manager, rule);
		
		request.getRequestDispatcher("../servlet/Office1?jump_type=first").forward(request,
				response);
		
	}
	
}
