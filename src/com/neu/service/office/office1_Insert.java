package com.neu.service.office;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Office1_DAO;

public class office1_Insert extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String addInfo = request.getParameter("addSolve");
		String str[] = addInfo.split("#");
		int depart_num = -1;
		if(request.getParameter("depart_num")!="")
		{
			depart_num = Integer.parseInt(str[0]) ;
		}
		
		String depart_name = str[1];
		String office_num = str[2];
		String manager = str[4];
		String rule = str[5];

		int staff_num = 0;
		if(request.getParameter("staff_num")!= ""){
			staff_num = Integer.parseInt(str[3]);
		}

		
		Office1_DAO off1dao = new Office1_DAO();
		//off1dao.Office1Insert(Depart_Num, Depart_Name, Office_Num, Staff_Num, Manager, Rule)
		off1dao.Office1Insert(depart_num, depart_name, office_num, staff_num, manager, rule);
		
		
		request.setAttribute("jump_type","first");
		
		request.getRequestDispatcher("../servlet/Office1?jump_type=first").forward(request,
				response);
		
	}

}
