package com.neu.service.parking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Building1_DAO;
import com.neu.dao.Parking3_DAO;

public class Parking3_Insert extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
              
		  this.doPost(request, response);
		   
	} 


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String addInfo = request.getParameter("addSolve");
		String str[] = addInfo.split("#");
	    int record_num=Integer.parseInt(str[0]);
	    int parking_num =Integer.parseInt(str[1]);
	    String owner=str[2];
	    String tele=str[3];
	    String start_time=str[4];
	    String plan_time=str[5];
	    int charge=Integer.parseInt(str[6]);
	    String charger=str[7];
		
	    Parking3_DAO p3_dao = new Parking3_DAO();
	    p3_dao.insert(record_num,parking_num,owner,tele,start_time,plan_time,charge,charger);	
		request.setAttribute("jump_type","first");
		
		request.getRequestDispatcher("../servlet/Parking3?jump_type=first").forward(request,
				response);
		
	}	

}
