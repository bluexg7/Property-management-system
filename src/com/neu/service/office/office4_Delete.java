package com.neu.service.office;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.bean.Office4_Info;
import com.neu.dao.Office4_DAO;

public class office4_Delete extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String key = request.getParameter("delSolve");
		String trainInfo[] = key.split("#");
		System.out.print(key);
		
		Office4_DAO off4dao = new Office4_DAO();
		for(String r:trainInfo){
			String str[] = r.split("-");
			off4dao.Office4Delete(Integer.parseInt(str[0]));
		}

		
		request.getRequestDispatcher("../servlet/Office4?jump_type=first").forward(request,response);
		
	}

}
