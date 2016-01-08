package com.neu.service.building;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.dao.Building2_DAO;

public class Building2_Insert extends HttpServlet {
	
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
		int unit_amount=0;
		if(!str[2].equals("")){
			unit_amount = Integer.parseInt(str[2]);
		}
		int floor_amount=0;
		if(!str[3].equals("")){
			floor_amount = Integer.parseInt(str[3]);
		}
		int room_amount=0;
		if(!str[4].equals("")){
			room_amount = Integer.parseInt(str[4]);
		}
		String period = str[5];
		
		Building2_DAO b2_dao = new Building2_DAO();
		b2_dao.insert(com_name,build_num,unit_amount,floor_amount,room_amount,period);
		
		
		HttpSession session = request.getSession();
		
		request.getRequestDispatcher("../servlet/Building2?jump_type=first&to_page="+session.getAttribute("currentPage")).forward(request,
				response);
	
	}

}
