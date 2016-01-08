package com.neu.service.parking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Parking2_DAO;
import com.neu.dao.Parking3_DAO;

public class Parking2_Insert extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String addInfo = request.getParameter("addSolve");
		String str[] = addInfo.split("#");
	    int parking_num=Integer.parseInt(str[0]);
	    int parklot_num =Integer.parseInt(str[1]);
	    int state=Integer.parseInt(str[2]);
		
	    Parking2_DAO p2_dao = new Parking2_DAO();
	    p2_dao.insert(parking_num,parklot_num,state);	
		request.setAttribute("jump_type","first");
		
		request.getRequestDispatcher("../servlet/Parking2?jump_type=first").forward(request,
				response);

		
	}

	

}
