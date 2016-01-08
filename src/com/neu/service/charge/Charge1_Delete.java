package com.neu.service.charge;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.neu.dao.Charge1_DAO;

public class Charge1_Delete extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("gb2312");

		String key = request.getParameter("delSolve");
		System.out.println(key);
		String roomInfo[] = key.split("#");
		System.out.println(roomInfo[0]);
		Charge1_DAO b1_dao = new Charge1_DAO();
		for(String r:roomInfo){
			String str = r;
			b1_dao.delete(str);
		}
		
		request.getRequestDispatcher("../servlet/Charge1?jump_type=first").forward(request,response);
	}

	

}
