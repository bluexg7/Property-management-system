package com.neu.service.parking;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.bean.Parking1_Info;
import com.neu.dao.Parking1_DAO;

public class Parking1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");	
		HttpSession session = request.getSession();
		
		int parklot_num=0;
		if(!session.getAttribute("parklot_num").toString().isEmpty())
			parklot_num=Integer.parseInt((String)session.getAttribute("parklot_num"));              //停车场编号
		String parklot_name = (String) session.getAttribute("parklot_name");           //停车场名称
		String location = (String) session.getAttribute("location");             //位置
		int charge=0;
		if(!session.getAttribute("charge").toString().isEmpty())
			charge=Integer.parseInt((String)session.getAttribute("charge"));     //楼层	
		
		Parking1_DAO p1_dao = new Parking1_DAO();
		List<Parking1_Info> resultList = p1_dao.select(parklot_num,parklot_name,location,charge);
		
		
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
		List<Parking1_Info> list = resultList.subList((currentPage-1)*15,(currentPage*15<resultList.size()-1)?currentPage*15:resultList.size());
	    System.out.println("共查到停车场记录"+list.size()+"条");
	    System.out.println("********************************");
        request.setAttribute("park_list", list);
		request.getRequestDispatcher("../parking/parking1.jsp").forward(request,response);
		
	}

}
