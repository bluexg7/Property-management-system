package com.neu.service.parking;
/* 1515.7.15
 * 
 * 
 * */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.bean.Parking2_Info;
import com.neu.bean.Parking3_Info;
import com.neu.dao.Parking2_DAO;
import com.neu.dao.Parking3_DAO;

public class Parking3 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        
		HttpSession session = request.getSession();
		String temp_record_num=(String) session.getAttribute("record_num");
		int record_num=0;
		if(temp_record_num!=null)
		 record_num=Integer.parseInt(temp_record_num);//记录编号
		
		String temp_parking_num=(String) session.getAttribute("parking_num");
		int parking_num=0;
		if(temp_parking_num!=null&&!temp_parking_num.equals("")){
			
			parking_num=Integer.parseInt(temp_parking_num.split(" ")[0]);//
		}
			
		String car_owner= (String) session.getAttribute("car_owner"); //车主	
		String start_time=(String) session.getAttribute("start_time");     //起始租用时间
		Parking3_DAO p3_dao = new Parking3_DAO();
		List<Parking3_Info> resultList = p3_dao.select(record_num,parking_num,car_owner,start_time);
		
		
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
		List<Parking3_Info> list = resultList.subList((currentPage-1)*15,(currentPage*15<resultList.size()-1)?currentPage*15:resultList.size());
	    System.out.println("共查到租车位记录"+list.size()+"条");
	    System.out.println("********************************");
        request.setAttribute("park_list", list);
		request.getRequestDispatcher("../parking/parking3.jsp").forward(request,response);
	}

	
}
