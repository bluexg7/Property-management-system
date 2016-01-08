package com.neu.service.office;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Office2_DAO;

public class office2_Update extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String staff_name = request.getParameter("staff_namevalue");
		String depart = request.getParameter("departvalue");
		String hometown = request.getParameter("hometownvalue");
		String tel = request.getParameter("telvalue");
		
		int staff_num = -1;
		if(request.getParameter("staff_numvalue")!= ""){
			staff_num = Integer.parseInt(request.getParameter("staff_numvalue"));
		}
		int salary = -1;
		if(request.getParameter("salaryvalue")!= ""){
			salary = Integer.parseInt(request.getParameter("salaryvalue"));
		}
		int presalary = -1;
		if(request.getParameter("prevalue")!= ""){
			presalary = Integer.parseInt(request.getParameter("prevalue"));
		}
		
		int age = -1;
		if(request.getParameter("agevalue")!= ""){
			age = Integer.parseInt(request.getParameter("agevalue"));
		}
		
		Office2_DAO off2dao = new Office2_DAO();
		off2dao.Office2Update(staff_num, staff_name, depart, age, hometown, presalary,salary, tel);
		
		request.getRequestDispatcher("../servlet/Office2?jump_type=first").forward(request,
				response);
		
	}
	
}
