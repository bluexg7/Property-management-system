package com.neu.service.office;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Office6_DAO;

public class office6_Insert extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String addInfo = request.getParameter("addSolve");
		String str[] = addInfo.split("#");
		int num = -1;
		if(request.getParameter("num_info")!="")
		{
			num = Integer.parseInt(str[0]) ;
		}
		
		String content = str[1];
		String state = str[2];

		String workload = str[3];
		String start_time = str[4];

		

		Office6_DAO off6dao = new Office6_DAO();
		//off1dao.Office1Insert(Depart_Num, Depart_Name, Office_Num, Staff_Num, Manager, Rule)
		off6dao.Office6Insert(num, content, state, workload, start_time);
		
		
		request.setAttribute("jump_type","first");
		
		request.getRequestDispatcher("../servlet/Office6?jump_type=first").forward(request,
				response);
		
	}

}
