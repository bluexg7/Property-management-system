package com.neu.service.charge;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.neu.dao.Building1_DAO;
import com.neu.dao.Charge1_DAO;

public class Charge1_Update extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		String room = request.getParameter("roomValue");
		String r[] = room.split("-");
		String com_name = r[0];
		String build_num = r[1];
		String unit_num = r[2];
		String room_num = r[3];
		String charge_num = request.getParameter("charNumValue");
		String charge_type = request.getParameter("typeValue");
		String charge_amount = request.getParameter("amountValue");
		String charge_lasdate = request.getParameter("lasDateValue");
		String charge_date = request.getParameter("dateValue");
		Charge1_DAO c1_dao = new Charge1_DAO();
		c1_dao.update(com_name, build_num, unit_num, room_num,charge_num, charge_type, charge_amount, charge_lasdate, charge_date);
		
		request.getRequestDispatcher("../servlet/Charge1?jump_type=first").forward(request,
				response);
	}

	

}
