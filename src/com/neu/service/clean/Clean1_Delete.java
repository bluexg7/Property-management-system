package com.neu.service.clean;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Clean1_DAO;

public class Clean1_Delete extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String key = request.getParameter("delSolve");
		String cleanerInfo[] = key.split("#");
		System.out.println("del");
		Clean1_DAO c1_dao = new Clean1_DAO();
		for(String c:cleanerInfo){
			c1_dao.delete(Integer.parseInt(c));
		}		
		request.getRequestDispatcher("../servlet/Clean1?jump_type=first").forward(request,response);
		
	}

}
