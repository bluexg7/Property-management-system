package com.neu.service.document;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Document1_DAO;
import com.neu.dao.Parking3_DAO;

public class Document1_Delete extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  
		   this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("gb2312");
		
		String key = request.getParameter("delSolve");
		String Info[] = key.split("#");
		
		Document1_DAO d1_dao = new Document1_DAO();
		for(String I:Info){
			System.out.println("É¾³ýÎÄµµ¼ÇÂ¼£º"+I);
			d1_dao.delete(I);
		}
		
		request.getRequestDispatcher("../servlet/Document1?jump_type=first").forward(request,response);
		
	}

}
