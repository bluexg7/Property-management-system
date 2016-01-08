package com.neu.service.building;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Building4_Select extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String com_name = request.getParameter("com_name");
		String build_num = request.getParameter("build_num");
		String unit_num = request.getParameter("unit_num");
		String room_num = request.getParameter("room_num");
		String de_type = request.getParameter("de_type");
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		
		//保存在session中备用
    	HttpSession session = request.getSession();
    	session.setAttribute("com_name",com_name);
    	session.setAttribute("build_num",build_num);
    	session.setAttribute("unit_num",unit_num);
    	session.setAttribute("room_num",room_num);
    	session.setAttribute("de_type",de_type);
    	session.setAttribute("start_time",start_time);
    	session.setAttribute("end_time",end_time);
      
		request.getRequestDispatcher("../servlet/Building4?jump_type=first").forward(request,
				response);
		
	}

}
