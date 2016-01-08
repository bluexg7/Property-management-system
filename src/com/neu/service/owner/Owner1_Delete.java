package com.neu.service.owner;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.bean.Owner1_Info;
import com.neu.dao.Owner1_DAO;

public class Owner1_Delete extends HttpServlet {

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
		
		Owner1_DAO owner1 = new Owner1_DAO();
		for(String r:examInfo){
			String str[] = r.split("-");
			owner1.Owner1Delete(str[0]);
		}

		
		request.getRequestDispatcher("../servlet/Owner1?jump_type=first").forward(request,response);
		
	}

}
