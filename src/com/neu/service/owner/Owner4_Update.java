package com.neu.service.owner;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Owner4_DAO;

public class Owner4_Update extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		int com_num = -1;
		if(request.getParameter("meetnumvalue")!="")
		{
			com_num = Integer.parseInt(request.getParameter("meetnumvalue").trim());
		}
		
		String content = request.getParameter("contentvalue");
		
		int expect = -1;
		if(request.getParameter("expectamountvalue")!="")
		{
			expect = Integer.parseInt(request.getParameter("expectamountvalue").trim());
		}
		int fact = -1;
		if(request.getParameter("factamountvalue")!="")
		{
			fact = Integer.parseInt(request.getParameter("factamountvalue").trim());
		}
		String absent = request.getParameter("absentvalue");
		String date = request.getParameter("datevalue");

		
		Owner4_DAO Owner4 = new Owner4_DAO();
		Owner4.Owner4Update(com_num, content, expect, fact, absent, date);
		
		request.getRequestDispatcher("../servlet/Owner4?jump_type=first").forward(request,
				response);
		
	}
	
}
