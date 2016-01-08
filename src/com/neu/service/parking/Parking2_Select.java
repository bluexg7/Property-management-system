package com.neu.service.parking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Parking2_Select extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             
		   this.doPost(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String parking_num=request.getParameter("parking_num");
		String parklot_num=request.getParameter("parklot_num");
		String state = request.getParameter("state");


		//保存在session中备用
    	HttpSession session = request.getSession();
    	session.setAttribute("parking_num",parking_num);
        session.setAttribute("parklot_num",parklot_num);
        session.setAttribute("state",state);
        
        session.setAttribute("parking_num_tran",parking_num);//传送查询数据，保持查询状态使用
        session.setAttribute("parklot_num_tran",parklot_num);
        session.setAttribute("state_tran",state);
        
		request.getRequestDispatcher("../servlet/Parking2?jump_type=first").forward(request,
				response);

		
	}

	

}
