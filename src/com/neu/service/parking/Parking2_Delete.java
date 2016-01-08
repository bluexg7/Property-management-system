package com.neu.service.parking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Parking1_DAO;
import com.neu.dao.Parking2_DAO;

public class Parking2_Delete extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		
		String key = request.getParameter("delSolve");
		String parkingInfo[] = key.split("#");
		
		Parking2_DAO p2_dao = new Parking2_DAO();
		for(String p:parkingInfo){
			System.out.println("É¾³ýÍ£³µÎ»¼ÇÂ¼£º"+p);
			p2_dao.delete(p);
		}
		
		request.getRequestDispatcher("../servlet/Parking2?jump_type=first").forward(request,response);
		
	}

}
