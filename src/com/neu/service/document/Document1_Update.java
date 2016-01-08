package com.neu.service.document;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Document1_DAO;
import com.neu.dao.Parking1_DAO;

public class Document1_Update extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          
		request.setCharacterEncoding("gb2312");

		int doc_num = 0;
		if(request.getParameter("didvalue")!= ""){
			 doc_num  = Integer.parseInt(request.getParameter("didvalue"));
		}

		String doc_title = request.getParameter("namevalue");
		String person = request.getParameter("personvalue");
	    
		//System.out.print("lay::"+layout);
		Document1_DAO d1_dao = new Document1_DAO();
		d1_dao.update(doc_num,doc_title,person);
		
		request.getRequestDispatcher("../servlet/Document1?jump_type=first").forward(request,
				response);

		
	}

}
