package com.neu.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.dao.UI_DAO;


public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String usname = new String(request.getParameter("usname").getBytes(
				"iso-8859-1"), "gb18030");
		String psword = request.getParameter("psword");

		UI_DAO UsLogin = new UI_DAO();
		boolean f = UsLogin.login(usname, psword);

		if (f) {
			HttpSession session = request.getSession();
			session.setAttribute("usname", usname);
			response.sendRedirect("../main.jsp");
		} else {		
			request.setAttribute("errmsg", "*用户名不存在或密码错误");
			request.getRequestDispatcher("../login.jsp").forward(request,
					response);
		}

	}

}
