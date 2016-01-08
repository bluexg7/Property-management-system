package com.neu.service.parking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Parking3_Select extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");

		String parking_num=request.getParameter("parking_num");
		String car_owner = request.getParameter("car_owner");
		String start_time= request.getParameter("start_time");

		//保存在session中备用
    	HttpSession session = request.getSession();
    	session.setAttribute("parking_num",parking_num);
        session.setAttribute("car_owner",car_owner);
        session.setAttribute("start_time",start_time);
        
        session.setAttribute("cal",start_time);
        session.setAttribute("tenant",car_owner);
        session.setAttribute("keepPark",parking_num);
        
		request.getRequestDispatcher("../servlet/Parking3?jump_type=first").forward(request,
				response);
		
	}

}
