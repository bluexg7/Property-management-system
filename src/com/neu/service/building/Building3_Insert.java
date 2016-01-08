package com.neu.service.building;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.neu.dao.Building3_DAO;

public class Building3_Insert extends HttpServlet {

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
		String room_num = str[3];
		String owner_name = str[4];
		int owner_num=0;
		if(!str[5].equals("")){
			owner_num = Integer.parseInt(str[5]);
		}
		int population=0;
		if(!str[6].equals("")){
			population = Integer.parseInt(str[6]);
		}
		String sale_time=str[7];

		Building3_DAO b3_dao = new Building3_DAO();
		b3_dao.insert(com_name,build_num,unit_num,room_num,owner_name,owner_num,population,sale_time);
		
		
		HttpSession session = request.getSession();
		
		request.getRequestDispatcher("../servlet/Building3?jump_type=first&to_page="+session.getAttribute("currentPage")).forward(request,
				response);
	
	}

}
