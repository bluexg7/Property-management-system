package com.neu.service.owner;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Owner3_DAO;

public class Owner3_Insert extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String addInfo = request.getParameter("addSolve");
		String str[] = addInfo.split("#");
		
		int owner_num = -1;
		if(request.getParameter("ownernum_info")!="")
		{
			owner_num = Integer.parseInt(str[0]) ;
		}
		String owner_name = str[1];
		int comm_num = -1;
		if(request.getParameter("commnum_info")!="")
		{
			comm_num = Integer.parseInt(str[2]) ;
		}

		Owner3_DAO Owner3 = new Owner3_DAO();
		Owner3.Owner3Insert(comm_num,owner_name,owner_num);
		
		
		request.setAttribute("jump_type","first");
		
		request.getRequestDispatcher("../servlet/Owner3?jump_type=first").forward(request,
				response);
		
	}

}
