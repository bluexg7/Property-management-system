package com.neu.service.clean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Clean3_Select extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		    this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
    
		String check_num=request.getParameter("check_num").split(" ")[0];
		
		String checktype=request.getParameter("checktype");
			
	
		//保存在session中备用
    	HttpSession session = request.getSession();
    	session.setAttribute("check_num",check_num);
        session.setAttribute("checktype",checktype);
        
        session.setAttribute("check_num_tran",check_num);//查询的时候用于传递值给jsp去显示
        session.setAttribute("checktype_tran",checktype);
        
        
		request.getRequestDispatcher("../servlet/Clean3?jump_type=first").forward(request,
				response);
		
	}

}

