package com.neu.service.charge;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class Charge3_Select extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("gb2312");

		String char_com_name = request.getParameter("char_com_name");
		String char_build_num = request.getParameter("char_build_num");
		String char_unit_num = request.getParameter("char_unit_num");
		String char_room_num = request.getParameter("char_room_num");
		String charge_type = request.getParameter("charge_type");
		

		// 保存在session中备用
		HttpSession session = request.getSession();
		session.setAttribute("char4_com_name", char_com_name);
		session.setAttribute("char4_build_num", char_build_num);
		session.setAttribute("char4_unit_num", char_unit_num);
		
		session.setAttribute("char4_charge_type", charge_type);
		
		
		session.setAttribute("char4room_num", char_room_num);
		

		request.getRequestDispatcher("../servlet/Charge3?jump_type=first")
				.forward(request, response);

	}

}
