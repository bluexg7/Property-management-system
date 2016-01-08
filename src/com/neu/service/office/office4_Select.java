package com.neu.service.office;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class office4_Select extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
		}



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");

		String train_num = request.getParameter("train_num");
		String train_date = request.getParameter("train_date");

		
		HttpSession session = request.getSession();
    	session.setAttribute("train_num",train_num);
        session.setAttribute("train_date",train_date );
	
		request.getRequestDispatcher("../servlet/Office4?jump_type=first").forward(request,
				response);
		
	}


}
