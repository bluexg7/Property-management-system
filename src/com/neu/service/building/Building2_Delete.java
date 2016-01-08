package com.neu.service.building;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.dao.Building2_DAO;

public class Building2_Delete extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String key = request.getParameter("delSolve");
		String roomInfo[] = key.split("#");
		
		Building2_DAO b2_dao = new Building2_DAO();
		for(String r:roomInfo){
			String str[] = r.split("-");
			b2_dao.delete(str[0], str[1]);
		}
		
		HttpSession session = request.getSession();
		request.getRequestDispatcher("../servlet/Building2?jump_type=jump_to&to_page="+session.getAttribute("currentPage")).forward(request,response);
		
	}

}
