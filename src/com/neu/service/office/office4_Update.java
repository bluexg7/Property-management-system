package com.neu.service.office;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Office4_DAO;

public class office4_Update extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		String content = request.getParameter("contentvalue");
		
		String date = request.getParameter("datevalue");
		
		int train_num = -1;
		if(request.getParameter("train_numvalue")!= ""){
			train_num = Integer.parseInt(request.getParameter("train_numvalue"));
		}
		

		
		Office4_DAO off2dao = new Office4_DAO();
		off2dao.Office4Update(train_num, content, date);
		
		request.getRequestDispatcher("../servlet/Office4?jump_type=first").forward(request,
				response);
		
	}
	
}
