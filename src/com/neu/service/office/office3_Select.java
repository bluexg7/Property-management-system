package com.neu.service.office;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.bean.Office3_Info;
import com.neu.dao.Office3_DAO;

public class office3_Select extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
		}



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		
		String staff_num = request.getParameter("staff_num");
		String staff_name = request.getParameter("staff_name");

		
		HttpSession session = request.getSession();
    	session.setAttribute("staff_num",staff_num);
        session.setAttribute("staff_name",staff_name );


		
		request.getRequestDispatcher("../servlet/Office3?jump_type=first").forward(request,
				response);
		
	}


}
