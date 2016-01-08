package com.neu.service.system;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.bean.System1_Info;
import com.neu.dao.System1_DAO;

public class System1_Delete extends HttpServlet {

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
		
		System1_DAO sys1 = new System1_DAO();
		for(String r:examInfo){
			String str[] = r.split("-");
			sys1.System1Delete(Integer.parseInt(str[0].trim()));
		}

		
		request.getRequestDispatcher("../servlet/System1?jump_type=first").forward(request,response);
		
	}

}
