package com.neu.service.building;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Building2_DAO;


public class Building2_Update extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		this.doPost(request, response);
	}
		
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String room = request.getParameter("build_info");
		String r[] = room.split("-");
		String com_name = r[0];   
		String build_num = r[1]; 
		
		String period = request.getParameter("period");
		int unit_amount = 0;
		if(request.getParameter("unit_amount")!= ""){
			unit_amount = Integer.parseInt(request.getParameter("unit_amount"));
		}
		int floor_amount = 0;
		if(request.getParameter("floor_amount")!= ""){
			floor_amount = Integer.parseInt(request.getParameter("floor_amount"));
		}
		int room_amount = 0;
		if(request.getParameter("room_amount")!= ""){
			room_amount = Integer.parseInt(request.getParameter("room_amount"));
		}
		
		
		Building2_DAO b2_dao = new Building2_DAO();
		b2_dao.update(com_name, build_num, period,unit_amount,floor_amount,room_amount);
		
		
		request.getRequestDispatcher("../servlet/Building2?jump_type=first").forward(request,
				response);
		
	}
	
}
