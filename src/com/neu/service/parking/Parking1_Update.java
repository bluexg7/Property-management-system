package com.neu.service.parking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Parking1_DAO;
import com.neu.dao.Parking3_DAO;

public class Parking1_Update extends HttpServlet {

	
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

		int parklot_num = 0;
		if(request.getParameter("pidvalue")!= ""){
			 parklot_num  = Integer.parseInt(request.getParameter("pidvalue"));
		}

		int charge=0;
		if(request.getParameter("chargevalue")!= ""){
			charge = Integer.parseInt(request.getParameter("chargevalue"));
		}
		int maxinum =0;
		if(request.getParameter("maxvalue")!= ""){
			maxinum  = Integer.parseInt(request.getParameter("maxvalue"));
		}
		String parklot_name = request.getParameter("lotnamevalue");
		String location = request.getParameter("locvalue");
	    
		//System.out.print("lay::"+layout);
		Parking1_DAO p1_dao = new Parking1_DAO();
		p1_dao.update(parklot_num, parklot_name, location,maxinum,charge);
		
		request.getRequestDispatcher("../servlet/Parking1?jump_type=first").forward(request,
				response);

		
	}

	

}
