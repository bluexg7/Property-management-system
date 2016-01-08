package com.neu.service.parking;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Parking3_DAO;

public class Parking3_Update extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 this.doPost(request, response);

	}	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("gb2312");

		int record_num = 0;
		if(request.getParameter("ridvalue")!= ""){
			record_num = Integer.parseInt(request.getParameter("ridvalue"));
		}
		int parking_num = 0;
		if(request.getParameter("pidvalue")!= ""){
			 parking_num  = Integer.parseInt(request.getParameter("pidvalue"));
		}
		String car_owner = request.getParameter("ownervalue");
		String tele = request.getParameter("televalue");
		String start_time = request.getParameter("startvalue");
		int plan_time= Integer.parseInt(request.getParameter("planvalue"));
		int charge =Integer.parseInt(request.getParameter("chargevalue"));
		String charger = request.getParameter("chargervalue");
	
		//System.out.print("lay::"+layout);
		Parking3_DAO p3_dao = new Parking3_DAO();
		p3_dao.update(record_num, parking_num, car_owner, tele,start_time,
				plan_time ,charge, charger);
		
		request.getRequestDispatcher("../servlet/Parking3?jump_type=first").forward(request,
				response);
		
	}//doPost

}
