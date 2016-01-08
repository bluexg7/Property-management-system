package com.neu.service.charge;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.Building1_DAO;
import com.neu.dao.Charge1_DAO;

public class Charge1_Insert extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("gb2312");		
		String addInfo = request.getParameter("addSolve");
		String str[] = addInfo.split("#");
		String charge_num = str[0];
		String com_name = str[1];
		String build_num = str[2];
		String unit_num= str[3];
		String room_num = str[4];
		String las_date = str[5];
		String date = str[6];
		String amount = str[7];
		String charge_type = str[8];
		Charge1_DAO c1_dao = new Charge1_DAO();
		c1_dao.insert(charge_num,com_name, build_num, unit_num, room_num,las_date,date, charge_type, amount);
		
		
		request.setAttribute("jump_type","first");
		
		request.getRequestDispatcher("../servlet/Charge1?jump_type=first").forward(request,
				response);
		
	}	
}
