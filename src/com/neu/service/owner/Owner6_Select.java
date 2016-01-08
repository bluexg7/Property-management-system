package com.neu.service.owner;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.bean.Owner6_Info;
import com.neu.dao.Owner6_DAO;

public class Owner6_Select extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
		}



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		String suggestor = request.getParameter("suggestor");
		String time = request.getParameter("time");

		
		Owner6_DAO own6dao = new Owner6_DAO();
		List<Owner6_Info> owner6 = own6dao.Owner6Select(suggestor, time);
		

		request.setAttribute("owner6", owner6);

		
		request.getRequestDispatcher("../owner/owner6.jsp").forward(request,
				response);
		
	}


}
