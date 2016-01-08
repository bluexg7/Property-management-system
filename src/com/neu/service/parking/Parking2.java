package com.neu.service.parking;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.bean.Parking2_Info;
import com.neu.dao.Parking2_DAO;

public class Parking2 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  this.doPost(request, response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");	
		HttpSession session = request.getSession();
		
		String temp_parking_num=(String) session.getAttribute("parking_num");
		int parking_num=0;
		if(temp_parking_num!=null&&!temp_parking_num.equals("")){
			
			parking_num=Integer.parseInt(temp_parking_num.split(" ")[0]);//
		}
		
		String temp_parklot_num=(String) session.getAttribute("parklot_num");
		int parklot_num=0;
		if(temp_parklot_num!=null&&!temp_parklot_num.equals("")){
			
			parking_num=Integer.parseInt(temp_parklot_num.split(" ")[0]);//停车场编号
		}
		
		String temp_state_num=(String) session.getAttribute("state");
		int state=-1;
		if(temp_state_num!=null&&!temp_state_num.equals("")){
			
			state=Integer.parseInt(temp_state_num.split(" ")[0]);//车位状态
		}
		System.out.println("state:"+state);
		Parking2_DAO p2_dao = new Parking2_DAO();
		List<Parking2_Info> resultList = p2_dao.select(parking_num,parklot_num,state);
		
		
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
		List<Parking2_Info> list = resultList.subList((currentPage-1)*15,(currentPage*15<resultList.size()-1)?currentPage*15:resultList.size());
	    System.out.println("共查到停车位记录"+list.size()+"条");
	    System.out.println("********************************");
        request.setAttribute("park_list", list);
		request.getRequestDispatcher("../parking/parking2.jsp").forward(request,response);
	}
}
