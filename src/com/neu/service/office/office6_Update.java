package com.neu.service.office;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Office6_DAO;

public class office6_Update extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String content = request.getParameter("contentvalue");
		String state = request.getParameter("statevalue");
		String workload = request.getParameter("workloadvalue");
		String starttime = request.getParameter("starttimevalue");
		
		int num = -1;
		if(request.getParameter("numvalue")!= ""){
			num = Integer.parseInt(request.getParameter("numvalue"));
		}

		
		Office6_DAO off6dao = new Office6_DAO();
		off6dao.Office6Update(num, content, state, workload, starttime);
		
		request.getRequestDispatcher("../servlet/Office6?jump_type=first").forward(request,
				response);
		
	}
	
}
