package com.neu.service.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Security1_DAO;

public class Security1_Update extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		int cleaner_num = 0;
		if(request.getParameter("cleaner_numvalue")!= ""){
			cleaner_num = Integer.parseInt(request.getParameter("cleaner_numvalue"));
		}
		String name = request.getParameter("namevalue");
		String id_num = request.getParameter("id_numvalue");
		String sex = request.getParameter("sexvalue");
		String birthday = request.getParameter("birthdayvalue");
		String position = request.getParameter("positionvalue");
		String tele = request.getParameter("televalue");
		int salary = Integer.parseInt(request.getParameter("salaryvalue"));
		String work_range = request.getParameter("work_rangevalue");
		
		
		Security1_DAO c1_dao = new Security1_DAO();
		c1_dao.update(cleaner_num,name,id_num,sex,birthday,position,tele,salary,work_range);
		
		request.getRequestDispatcher("../servlet/Security1?jump_type=first").forward(request,
				response);
		
	}
	
}
