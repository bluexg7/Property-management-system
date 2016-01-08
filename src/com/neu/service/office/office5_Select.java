package com.neu.service.office;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.bean.Office5_Info;
import com.neu.dao.Office5_DAO;

public class office5_Select extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
		}



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");

		String exam_name = request.getParameter("exam_name");
		String staff_num = request.getParameter("staff_num");

		
		HttpSession session = request.getSession();
    	session.setAttribute("exam_name",exam_name);
        session.setAttribute("staff_num",staff_num );
	
		request.getRequestDispatcher("../servlet/Office5?jump_type=first").forward(request,
				response);
		
	}


}
