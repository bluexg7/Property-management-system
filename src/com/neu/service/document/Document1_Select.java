package com.neu.service.document;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Document1_Select extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      
		request.setCharacterEncoding("gb2312");
		String doc_num=request.getParameter("doc_num").split(" ")[0];
		
		String doc_title=request.getParameter("doc_title");
			
		String upload_person= request.getParameter("upload_person");
		String start_time= request.getParameter("start_time");
		String end_time= request.getParameter("end_time");
	
		//保存在session中备用
    	HttpSession session = request.getSession();
    	session.setAttribute("doc_num",doc_num);
        session.setAttribute("doc_title",doc_title);
        session.setAttribute("upload_person",upload_person);
        session.setAttribute("start_time",start_time);
        session.setAttribute("end_time",end_time);
        
        session.setAttribute("doc_num_tran",doc_num);//查询的时候用于传递值给jsp去显示
        session.setAttribute("doc_title_tran",doc_title);
        session.setAttribute("upload_person_tran",upload_person);
        session.setAttribute("start_time_tran",start_time);
        session.setAttribute("end_time_tran",end_time);
        
		request.getRequestDispatcher("../servlet/Document1?jump_type=first").forward(request,
				response);
		
	}

}
