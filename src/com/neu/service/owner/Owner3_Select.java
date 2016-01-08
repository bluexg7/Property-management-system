package com.neu.service.owner;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.bean.Owner3_Info;
import com.neu.dao.Owner3_DAO;

public class Owner3_Select extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
		}



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		

		String	comm_num = request.getParameter("comm_num");

		String name = request.getParameter("name");

		HttpSession session = request.getSession();
    	session.setAttribute("comm_num",comm_num);
        session.setAttribute("name",name );
		
		request.getRequestDispatcher("../servlet/Owner3?jump_type=first").forward(request,
				response);
		
	}


}
