package com.neu.service.office;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.bean.Office1_Info;
import com.neu.dao.Office1_DAO;

public class office1_Delete extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String key = request.getParameter("delSolve");
		String departInfo[] = key.split("#");
		System.out.print(key);
		
		Office1_DAO off1dao = new Office1_DAO();
		for(String r:departInfo){
			String str[] = r.split("-");
			off1dao.Office1Delete(Integer.parseInt(str[0]));
		}
		
		request.getRequestDispatcher("../servlet/Office1?jump_type=first").forward(request,response);
		
	}

}
