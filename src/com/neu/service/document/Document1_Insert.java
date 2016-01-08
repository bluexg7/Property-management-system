package com.neu.service.document;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.neu.dao.Document1_DAO;
import com.neu.dao.Parking1_DAO;

public class Document1_Insert extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            this.doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		
		String addInfo = request.getParameter("addSolve");
		String str[] = addInfo.split("#");
		String path=str[0];    
		String doc_title=str[1];
	    String upload_person=str[2];
	    
	    Document1_DAO d1_dao = new Document1_DAO();
	    
	    String realpath = this.getServletContext().getRealPath("/upload");
	    
	    d1_dao.insert(path, doc_title, upload_person,realpath);
	    
        request.setAttribute("jump_type","first");
		
		request.getRequestDispatcher("../servlet/Document1?jump_type=first").forward(request,
				response);
		
	}

}
