package com.neu.service.system;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.System1_DAO;

public class System1_Insert extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		

		System1_DAO sys1= new System1_DAO();
		//off1dao.Office1Insert(Depart_Num, Depart_Name, Office_Num, Staff_Num, Manager, Rule)
		sys1.System1Insert();
		
		
		request.setAttribute("jump_type","first");
		
		request.getRequestDispatcher("../servlet/System1?jump_type=first").forward(request,
				response);
		
	}

}
