package com.neu.service.office;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.bean.Office5_Info;
import com.neu.dao.Office5_DAO;

public class office5_Delete extends HttpServlet {

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
		
		Office5_DAO off5dao = new Office5_DAO();
		for(String r:examInfo){
			String str[] = r.split("-");
			off5dao.Office5Delete(Integer.parseInt(str[0]));
		}

		
		request.getRequestDispatcher("../servlet/Office5?jump_type=first").forward(request,response);
		
	}

}
