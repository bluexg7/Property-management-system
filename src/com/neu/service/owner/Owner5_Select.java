package com.neu.service.owner;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.bean.Owner5_Info;
import com.neu.dao.Owner5_DAO;

public class Owner5_Select extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
		}



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		String complainer = request.getParameter("complainer");
		String time = request.getParameter("time");

		
		Owner5_DAO own5dao = new Owner5_DAO();
		List<Owner5_Info> owner5 = own5dao.Owner5Select(complainer, time);
		

		request.setAttribute("owner5", owner5);

		
		request.getRequestDispatcher("../owner/owner5.jsp").forward(request,
				response);
		
	}


}
