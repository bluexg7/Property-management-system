package com.neu.service.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Security1_DAO;

public class Security1_Insert extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String addInfo = request.getParameter("addSolve");
		String str[] = addInfo.split("#");
		int cleaner_num = 0;
		if(request.getParameter("cleaner_num")!= ""){
			cleaner_num = Integer.parseInt(str[0]);
		}
		String name = str[0];
		String id_num = str[1];
		String sex = str[2];
		String birthday = str[3];
		String position = str[4];
		String tele = str[5];
		int salary = 0;
		if(request.getParameter("salary")!= ""){
			salary = Integer.parseInt(str[6]);
		}
		String work_range = str[7];
		
		
		Security1_DAO c1_dao = new Security1_DAO();
		c1_dao.insert(cleaner_num,name,id_num,sex,birthday,position,tele,salary,work_range);
		
		
		request.setAttribute("jump_type","first");
		
		request.getRequestDispatcher("../servlet/Security1?jump_type=first").forward(request,
				response);
		
	}

}
