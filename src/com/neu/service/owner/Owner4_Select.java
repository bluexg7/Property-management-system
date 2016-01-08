package com.neu.service.owner;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.bean.Owner4_Info;
import com.neu.dao.Owner4_DAO;

public class Owner4_Select extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
		}



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");


		String	com_num = request.getParameter("com_num");

		String meet_date = request.getParameter("meet_date");

	
		
		HttpSession session = request.getSession();
    	session.setAttribute("com_num",com_num);
        session.setAttribute("meet_date",meet_date );
		
		request.getRequestDispatcher("../servlet/Owner4?jump_type=first").forward(request,
				response);
		
	}


}
