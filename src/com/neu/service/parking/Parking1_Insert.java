package com.neu.service.parking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Parking1_DAO;
import com.neu.dao.Parking3_DAO;

public class Parking1_Insert extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("gb2312");
		
		String addInfo = request.getParameter("addSolve");
		String str[] = addInfo.split("#");
	    int parklot_num=Integer.parseInt(str[0]);    
	    String parklot_name =str[1];
	    String location=str[2];
	    int maxinum=Integer.parseInt(str[3]);
	    int charge=Integer.parseInt(str[4]);
	    
	    Parking1_DAO p1_dao = new Parking1_DAO();
	    p1_dao.insert(parklot_num,parklot_name,location,maxinum,charge);	
		request.setAttribute("jump_type","first");
		
		request.getRequestDispatcher("../servlet/Parking1?jump_type=first").forward(request,
				response);
	}

	
}
