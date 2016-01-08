package com.neu.service.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.bean.Security2_Info;
import com.neu.dao.Security2_DAO;

public class Security2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");	
		HttpSession session = request.getSession();
		System.out.println("111");
		
		int cleaner_num=0;
		if(!session.getAttribute("cleaner_num").toString().isEmpty()&&!session.getAttribute("cleaner_num").toString().equals("0"))
			cleaner_num=Integer.parseInt((String)session.getAttribute("cleaner_num"));              //保洁员编号
		String work_content = (String) session.getAttribute("work_content");           //工作内容
		String tools = (String) session.getAttribute("tools");             //工具
		String work_time = (String) session.getAttribute("work_time");           //工作时间
		
		Security2_DAO c1_dao = new Security2_DAO();
		List<Security2_Info> resultList = c1_dao.select(cleaner_num,work_content,tools,work_time);
		
		
		/*****分页处理******/
		//设置要查询的页号
		int currentPage = (Integer)session.getAttribute("currentPage");
		if(request.getParameter("jump_type").equals("first")){
			currentPage = 1;
		}
		else if(request.getParameter("jump_type").equals("back")){
			if(((Integer)session.getAttribute("currentPage")).intValue()>=2)
				currentPage = ((Integer)session.getAttribute("currentPage")).intValue()-1;
		}
		else if(request.getParameter("jump_type").equals("next")){
			 if(((Integer)session.getAttribute("currentPage")).intValue()<((Integer)session.getAttribute("pageCount")/15+((Integer)session.getAttribute("pageCount")%15!=0?1:0)))
				currentPage =((Integer)session.getAttribute("currentPage")).intValue()+1;
		}
		else if(request.getParameter("jump_type").equals("last")){
			currentPage = ((Integer)session.getAttribute("pageCount")/15+((Integer)session.getAttribute("pageCount")%15!=0?1:0));
		}
		else{
			currentPage = Integer.parseInt(request.getParameter("to_page"));
			System.out.println("page" + currentPage);
		}
		session.setAttribute("currentPage",currentPage);
		
		//查询的记录总条数
		session.setAttribute("pageCount",resultList.size());
		//查询结果的一页
		List<Security2_Info> list = resultList.subList((currentPage-1)*15,(currentPage*15<resultList.size()-1)?currentPage*15:resultList.size());
	    System.out.println("共查到日常保洁记录"+list.size()+"条");
	    System.out.println("********************************");
        request.setAttribute("dailyclean_list", list);
		request.getRequestDispatcher("../security/security2.jsp").forward(request,response);
		
	}

}
