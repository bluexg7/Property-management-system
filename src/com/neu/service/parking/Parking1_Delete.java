package com.neu.service.parking;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Parking1_DAO;

public class Parking1_Delete extends HttpServlet {

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
		
		String key = request.getParameter("delSolve");
		String parklotInfo[] = key.split("#");
		
		Parking1_DAO p1_dao = new Parking1_DAO();
		for(String p:parklotInfo){
			System.out.println("É¾³ýÍ£³µ³¡¼ÇÂ¼£º"+p);
			p1_dao.delete(p);
		}
		
		request.getRequestDispatcher("../servlet/Parking1?jump_type=first").forward(request,response);
			
	}

	

}
