package com.neu.service.office;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.bean.Office6_Info;
import com.neu.dao.Office6_DAO;

public class office6_Select extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
		}



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");

		String plan_state = request.getParameter("plan_state");
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		
		HttpSession session = request.getSession();
    	session.setAttribute("plan_state",plan_state);
    	session.setAttribute("start_time",start_time );
        session.setAttribute("end_time",end_time );
	
		request.getRequestDispatcher("../servlet/Office6?jump_type=first").forward(request,
				response);
		
	}


}
