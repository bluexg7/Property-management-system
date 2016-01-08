package com.neu.service.building;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Building1_DAO;

public class Building1_Update extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String room = request.getParameter("roomvalue");
		String r[] = room.split("-");
		String com_name = r[0];
		String build_num = r[1];
		String unit_num = r[2];
		String room_num = r[3];
		int floor = Integer.parseInt(request.getParameter("floorvalue"));
		String sale_state = request.getParameter("selledvalue");
		int room_size = 0;
		if(request.getParameter("sizevalue")!= ""){
			room_size = Integer.parseInt(request.getParameter("sizevalue"));
		}
		String layout = request.getParameter("layoutvalue");
		
		long price = 0;
		if(request.getParameter("pricevalue")!= ""){
			price = Integer.parseInt(request.getParameter("pricevalue"));
		}
		
		Building1_DAO b1_dao = new Building1_DAO();
		b1_dao.update(com_name, build_num, unit_num, room_num,floor, sale_state, room_size, layout, price);
		
		request.getRequestDispatcher("../servlet/Building1?jump_type=first").forward(request,
				response);
		
	}
	
}
