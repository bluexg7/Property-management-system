package com.neu.service.office;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.bean.Office2_Info;
import com.neu.dao.Office2_DAO;

public class office2_Delete extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String key = request.getParameter("delSolve");
		String staffInfo[] = key.split("#");
		System.out.print(key);
		
		Office2_DAO off2dao = new Office2_DAO();
		for(String r:staffInfo){
			String str[] = r.split(" ");
			off2dao.Office2Delete(Integer.parseInt(str[0]));
		}
		
		request.getRequestDispatcher("../servlet/Office2?jump_type=first").forward(request,response);
		
	}

}
