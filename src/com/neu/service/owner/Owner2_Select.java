package com.neu.service.owner;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.bean.Owner2_Info;
import com.neu.dao.Owner2_DAO;

public class Owner2_Select extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
		}



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");


		String	prpc_num = request.getParameter("prpc_num");

		String meeting_date = request.getParameter("meeting_date");

	
		
		HttpSession session = request.getSession();
    	session.setAttribute("prpc_num",prpc_num);
        session.setAttribute("meeting_date",meeting_date );
		
		request.getRequestDispatcher("../servlet/Owner2?jump_type=first").forward(request,
				response);
		
	}


}
