package com.neu.service.building;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.bean.Building1_Info;
import com.neu.dao.Building1_DAO;

public class Building1_Select extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		String com_name = request.getParameter("com_name");
		String build_num = request.getParameter("build_num");
		String unit_num = request.getParameter("unit_num");
		String room_num = request.getParameter("room_num");
		String sale_state = request.getParameter("sale_state");
		String layout = request.getParameter("layout");		
		String floor = request.getParameter("floor");	
		String room_size = request.getParameter("room_size");	
		String price = request.getParameter("price");
		
		
		//保存在session中备用
    	HttpSession session = request.getSession();
		
    	session.setAttribute("com_name",com_name);
        session.setAttribute("build_num",build_num );
        session.setAttribute("unit_num",unit_num);
        session.setAttribute("floor",floor);
        session.setAttribute("sale_state",sale_state);
        session.setAttribute("room_size",room_size);
        session.setAttribute("layout",layout);
        session.setAttribute("room_num",room_num);
        session.setAttribute("price",price );
        
		request.getRequestDispatcher("../servlet/Building1?jump_type=first").forward(request,
				response);
		
	}


}
