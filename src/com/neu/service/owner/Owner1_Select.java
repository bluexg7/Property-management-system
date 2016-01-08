package com.neu.service.owner;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.bean.Owner1_Info;
import com.neu.dao.Owner1_DAO;

public class Owner1_Select extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
		}



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		String owner_name = request.getParameter("owner_name");
		String owner_sex = request.getParameter("owner_sex");
		
		HttpSession session = request.getSession();
    	session.setAttribute("owner_name",owner_name);
        session.setAttribute("owner_sex",owner_sex );
		
		request.getRequestDispatcher("../servlet/Owner1?jump_type=first").forward(request,
				response);
		
	}


}
