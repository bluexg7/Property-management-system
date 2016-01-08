package com.neu.service.office;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Office5_DAO;

public class office5_Insert extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String addInfo = request.getParameter("addSolve");
		String str[] = addInfo.split("#");
		int exam_num = -1;
		if(request.getParameter("exam_numinfo")!="")
		{
			exam_num = Integer.parseInt(str[0]) ;
		}
		
		String staff_name = str[1];
		String exam_name = str[2];
		int grade = -1;
		if(request.getParameter("grade_info")!="")
		{
			grade = Integer.parseInt(str[3]) ;
		}
		String date = str[4];
		

		

		Office5_DAO off2dao = new Office5_DAO();
		//off1dao.Office1Insert(Depart_Num, Depart_Name, Office_Num, Staff_Num, Manager, Rule)
		off2dao.Office5Insert(exam_num, staff_name, exam_name, grade, date);
		
		
		request.setAttribute("jump_type","first");
		
		request.getRequestDispatcher("../servlet/Office5?jump_type=first").forward(request,
				response);
		
	}

}
