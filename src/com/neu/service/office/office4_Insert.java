package com.neu.service.office;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Office4_DAO;

public class office4_Insert extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String addInfo = request.getParameter("addSolve");
		String str[] = addInfo.split("#");
		int train_num = -1;
		if(request.getParameter("train_numinfo")!="")
		{
			train_num = Integer.parseInt(str[0]) ;
		}
		
		String content = str[1];
		String date = str[2];
		

		

		Office4_DAO off4dao = new Office4_DAO();
		//off1dao.Office1Insert(Depart_Num, Depart_Name, Office_Num, Staff_Num, Manager, Rule)
		off4dao.Office4Insert(train_num, content, date);
		
		
		request.setAttribute("jump_type","first");
		
		request.getRequestDispatcher("../servlet/Office4?jump_type=first").forward(request,
				response);
		
	}

}
