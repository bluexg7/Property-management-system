package com.neu.service.owner;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Owner4_DAO;

public class Owner4_Insert extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String addInfo = request.getParameter("addSolve");
		String str[] = addInfo.split("#");
		
		int prpc_num = -1;
		if(request.getParameter("meetnum_info")!="")
		{
			prpc_num = Integer.parseInt(str[0]) ;
		}
		String content = str[1];
		int expect = -1;
		if(request.getParameter("expect_info")!="")
		{
			expect = Integer.parseInt(str[2]) ;
		}

		int fact = -1;
		if(request.getParameter("fact_info")!="")
		{
			fact = Integer.parseInt(str[3]) ;
		}
		String absent = str[4];
		String date = str[5];
		

		

		Owner4_DAO Owner4 = new Owner4_DAO();
		Owner4.Owner4Insert(prpc_num, content, expect, fact, absent, date);
		
		
		request.setAttribute("jump_type","first");
		
		request.getRequestDispatcher("../servlet/Owner4?jump_type=first").forward(request,
				response);
		
	}

}
