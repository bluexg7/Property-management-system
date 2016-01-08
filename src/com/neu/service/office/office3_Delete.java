package com.neu.service.office;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.bean.Office3_Info;
import com.neu.dao.Office3_DAO;

public class office3_Delete extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String key = request.getParameter("delSolve");
		String changeInfo[] = key.split("#");
		System.out.print(key);
		
		Office3_DAO off3dao = new Office3_DAO();
		for(String r:changeInfo){
			String str[] = r.split("-");
			off3dao.Office3Delete(Integer.parseInt(str[0]));
		}
		
		request.getRequestDispatcher("../servlet/Office3?jump_type=first").forward(request,response);
		
	}

}
