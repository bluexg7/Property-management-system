package com.neu.service.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.bean.Security1_Info;
import com.neu.dao.Security1_DAO;

public class Security1_Select extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String cleaner_num = request.getParameter("cleaner_num");
		String name = request.getParameter("name");
		String position = request.getParameter("position");
		String work_range = request.getParameter("work_range");
		
		//保存在session中备用
    	HttpSession session = request.getSession();
    	session.setAttribute("cleaner_num",cleaner_num);
        session.setAttribute("name",name);
        session.setAttribute("position",position);
        session.setAttribute("work_range",work_range);
        request.getRequestDispatcher("../servlet/Security1?jump_type=first").forward(request,
				response);
		
	}


}
