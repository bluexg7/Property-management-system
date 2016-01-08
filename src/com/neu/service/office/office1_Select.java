package com.neu.service.office;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.bean.Office1_Info;
import com.neu.dao.Office1_DAO;

public class office1_Select extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
		}



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		
		String department = request.getParameter("department");
		String office_num = request.getParameter("office_num");
		
		HttpSession session = request.getSession();
    	session.setAttribute("department",department);
        session.setAttribute("office_num",office_num );
		
		request.getRequestDispatcher("../servlet/Office1?jump_type=first").forward(request,
				response);
		
	}


}
