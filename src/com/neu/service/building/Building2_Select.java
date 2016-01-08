package com.neu.service.building;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Building2_Select extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String com_name = request.getParameter("com_name");
		String build_num = request.getParameter("build_num");
		String period = request.getParameter("period");
		
		//保存在session中备用
    	HttpSession session = request.getSession();
    	session.setAttribute("com_name",com_name);
        session.setAttribute("build_num",build_num );
        session.setAttribute("period",period);
      
		request.getRequestDispatcher("../servlet/Building2?jump_type=first").forward(request,
				response);
		
	}
	
}
