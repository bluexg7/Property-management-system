package com.neu.service.building;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Building1_DAO;

public class Building1_Insert extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String addInfo = request.getParameter("addSolve");
		String str[] = addInfo.split("#");
		String com_name = str[0];
		String build_num = str[1];
		String unit_num = str[2];
		int floor = Integer.parseInt(str[3])/100;
		String sale_state = str[7];
		int room_size = 0;
		if(!str[4].equals("")){
			room_size = Integer.parseInt(str[4]);
		}
		String layout = str[5];
		String room_num = str[3];
		long price = 0;
		if(!str[6].equals("")){
			price = Integer.parseInt(str[6]);
		}
		
		Building1_DAO b1_dao = new Building1_DAO();
		b1_dao.insert(com_name, build_num, unit_num, room_num,floor, sale_state, room_size, layout, price);
		
		
		request.setAttribute("jump_type","first");
		
		request.getRequestDispatcher("../servlet/Building1?jump_type=first").forward(request,
				response);
		
	}

}
