package com.neu.service.parking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Building1_DAO;
import com.neu.dao.Parking3_DAO;

public class Parking3_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String key = request.getParameter("delSolve");
		String recordInfo[] = key.split("#");
		
		Parking3_DAO p3_dao = new Parking3_DAO();
		for(String r:recordInfo){
			System.out.println("É¾³ý×âÓÃ¼ÇÂ¼£º"+r);
			p3_dao.delete(r);
		}
		
		request.getRequestDispatcher("../servlet/Parking3?jump_type=first").forward(request,response);
		
	}

}
