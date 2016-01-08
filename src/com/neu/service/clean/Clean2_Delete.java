package com.neu.service.clean;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Clean2_DAO;

public class Clean2_Delete extends HttpServlet {

	
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	     request.setCharacterEncoding("gb2312");
		
		String key = request.getParameter("delSolve");
		String dailycleanInfo[] = key.split("#");
		
		Clean2_DAO c1_dao = new Clean2_DAO();
		for(String p:dailycleanInfo){
			System.out.println("删除日常保洁记录："+p);
			c1_dao.delete(p);
		}
		
		request.getRequestDispatcher("../servlet/Clean2?jump_type=first").forward(request,response);
			
	}

	

}
