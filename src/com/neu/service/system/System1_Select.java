package com.neu.service.system;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class System1_Select extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
		}



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		
		String datebegin = request.getParameter("datebegin");
		String dateend = request.getParameter("dateend");
		
		HttpSession session = request.getSession();
    	session.setAttribute("datebegin",datebegin);
        session.setAttribute("dateend",dateend );
		
		request.getRequestDispatcher("../servlet/System1?jump_type=first").forward(request,
				response);
		
	}


}
