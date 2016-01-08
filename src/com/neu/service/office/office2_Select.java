package com.neu.service.office;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.bean.Office2_Info;
import com.neu.dao.Office2_DAO;

public class office2_Select extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
		}



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");

		String staff_num = request.getParameter("staff_num");
		String staff_name = request.getParameter("staff_name");
		String office_num=request.getParameter("office_num");
		String department = request.getParameter("department");
		String salary1 = request.getParameter("salary1");
		String salary2 = request.getParameter("salary2");

		
		HttpSession session = request.getSession();
    	session.setAttribute("staff_num",staff_num);
        session.setAttribute("staff_name",staff_name );
        session.setAttribute("office_num",office_num);
        session.setAttribute("department",department);
        session.setAttribute("salary1",salary1);
        session.setAttribute("salary2",salary2);


		
		request.getRequestDispatcher("../servlet/Office2?jump_type=first").forward(request,
				response);
		
	}


}
