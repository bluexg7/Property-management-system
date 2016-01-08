package com.neu.service.office;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.bean.Office6_Info;
import com.neu.dao.Office6_DAO;

public class office6_Delete extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String key = request.getParameter("delSolve");
		String examInfo[] = key.split("#");
		System.out.print(key);
		
		Office6_DAO off6dao = new Office6_DAO();
		for(String r:examInfo){
			String str[] = r.split("-");
			off6dao.Office6Delete(Integer.parseInt(str[0]));
		}

		
		request.getRequestDispatcher("../servlet/Office6?jump_type=first").forward(request,response);
		
	}

}
