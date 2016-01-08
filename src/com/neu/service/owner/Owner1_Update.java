package com.neu.service.owner;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Owner1_DAO;

public class Owner1_Update extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		int ownernum = -1;
		if(request.getParameter("ownernumvalue")!="")
		{
			ownernum = Integer.parseInt(request.getParameter("ownernumvalue"));
		}
		
		String ownername = request.getParameter("namevalue");
		String idnum = request.getParameter("idnumvalue");
		String birthday = request.getParameter("birthdayvalue");
		String sex = request.getParameter("sexvalue");
		String hometown = request.getParameter("hometownvalue");
		String tel = request.getParameter("televalue");
		int population = -1;
		if(request.getParameter("populationvalue")!="")
		population = Integer.parseInt(request.getParameter("populationvalue"));
		

		
		Owner1_DAO owner1 = new Owner1_DAO();
		owner1.Owner1Update(ownernum, ownername, idnum, birthday, sex, hometown, tel, population);
		
		request.getRequestDispatcher("../servlet/Owner1?jump_type=first").forward(request,
				response);
		
	}
	
}
