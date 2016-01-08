package com.neu.service.parking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Parking1_DAO;
import com.neu.dao.Parking2_DAO;

public class Parking2_Update extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		   this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		int parking_num=0;
		if(request.getParameter("spacevalue")!=null){
			parking_num = Integer.parseInt(request.getParameter("spacevalue"));
		}
		int parklot_num = 0;
		if(request.getParameter("lotvalue")!=""){
			 parklot_num  = Integer.parseInt(request.getParameter("lotvalue"));
		}

		int state =-1;
		if(request.getParameter("statevalue")!=""){
			state = Integer.parseInt(request.getParameter("statevalue"));
		}
		Parking2_DAO p2_dao = new Parking2_DAO();
		p2_dao.update(parking_num,parklot_num, state);
		
		request.getRequestDispatcher("../servlet/Parking2?jump_type=first").forward(request,
				response);

		
	}

}
