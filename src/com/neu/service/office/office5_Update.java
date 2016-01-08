package com.neu.service.office;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Office5_DAO;

public class office5_Update extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String staff_name = request.getParameter("staff_namevalue");
		String exam_name = request.getParameter("exam_namevalue");
		String date = request.getParameter("datevalue");
		
		int exam_num = -1;
		if(request.getParameter("exam_numvalue")!= ""){
			exam_num = Integer.parseInt(request.getParameter("exam_numvalue"));
		}
		
		int grade = -1;
		if(request.getParameter("gradevalue")!= ""){
			grade = Integer.parseInt(request.getParameter("gradevalue"));
		}
		
		Office5_DAO off2dao = new Office5_DAO();
		off2dao.Office5Update(exam_num, staff_name, exam_name, grade, date);
		
		request.getRequestDispatcher("../servlet/Office5?jump_type=first").forward(request,
				response);
		
	}
	
}
