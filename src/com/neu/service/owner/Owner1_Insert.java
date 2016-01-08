package com.neu.service.owner;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Owner1_DAO;

public class Owner1_Insert extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String addInfo = request.getParameter("addSolve");
		String str[] = addInfo.split("#");
		
		int ownernum = -1;
		if(request.getParameter("ownernum_info")!="")
		{
			ownernum = Integer.parseInt(str[0]) ;
		}
		String ownername = str[1];
		String idnum = str[2];
		String birthday = str[3];
		String sex = str[4];
		String hometown = str[5];
		String tel = str[6];
		
		int population = -1;
		if(request.getParameter("population_info")!="")
		{
			population = Integer.parseInt(str[7]) ;
		}

		

		Owner1_DAO owner1 = new Owner1_DAO();
		owner1.Owner1Insert(ownernum,ownername, idnum, birthday, sex, hometown,tel,population);
		
		
		request.setAttribute("jump_type","first");
		
		request.getRequestDispatcher("../servlet/Owner1?jump_type=first").forward(request,
				response);
		
	}

}
