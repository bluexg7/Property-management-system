package com.neu.service.building;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.bean.Building1_Info;
import com.neu.dao.Building1_DAO;

public class Building1_Delete extends HttpServlet {

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
		
		Building1_DAO b1_dao = new Building1_DAO();
		for(String r:roomInfo){
			String str[] = r.split("-");
			b1_dao.delete(str[0], str[1], str[2], str[3]);
		}
		
		request.getRequestDispatcher("../servlet/Building1?jump_type=first").forward(request,response);
		
	}

}
