package com.neu.service.office;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Office2_DAO;

public class Office2_Insert extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String addInfo = request.getParameter("addSolve");
		String str[] = addInfo.split("#");
		int staff_num = -1;
		if(request.getParameter("staff_numinfo")!="")
		{
			staff_num = Integer.parseInt(str[0]) ;
		}
		
		String staff_name = str[1];
		String department = str[2];
		int age = -1;
		if(request.getParameter("age_info")!="")
		{
			age = Integer.parseInt(str[3]) ;
		}
		String hometown = str[4];
		int salary = -1;
		if(request.getParameter("salary_info")!= ""){
			salary = Integer.parseInt(str[5]);
		}
		
		String tel = str[6];
		

		

		
		Office2_DAO off2dao = new Office2_DAO();
		//off1dao.Office1Insert(Depart_Num, Depart_Name, Office_Num, Staff_Num, Manager, Rule)
		off2dao.Office2Insert(staff_num, staff_name, department, age, hometown, salary, tel);
		
		
		request.setAttribute("jump_type","first");
		
		request.getRequestDispatcher("../servlet/Office2?jump_type=first").forward(request,
				response);
		
	}

}
