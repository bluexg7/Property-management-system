package com.neu.service.parking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Parking1_Select extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		    this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
    
		String parklot_num=request.getParameter("parklot_num").split(" ")[0];
		
		String charge=request.getParameter("charge");
			
		String parklot_name= request.getParameter("parklot_name");
		String location= request.getParameter("location");
	
		//保存在session中备用
    	HttpSession session = request.getSession();
    	session.setAttribute("parklot_num",parklot_num);
        session.setAttribute("parklot_name",parklot_name);
        session.setAttribute("location",location);
        session.setAttribute("charge",charge);
        
        session.setAttribute("parklot_num_tran",parklot_num);//查询的时候用于传递值给jsp去显示
        session.setAttribute("parklot_name_tran",parklot_name);
        session.setAttribute("location_tran",location);
        session.setAttribute("charge_tran",charge);
        
		request.getRequestDispatcher("../servlet/Parking1?jump_type=first").forward(request,
				response);
		
	}

}

