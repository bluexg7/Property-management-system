package com.neu.service.charge;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.bean.Charge1_Info;
import com.neu.dao.Charge1_DAO;



public class Charge1 extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        request.setCharacterEncoding("gb2312");	
		HttpSession session = request.getSession();
		session.setAttribute("Present_Location","[收费管理]-[收费记录]");
		
		String com_name = (String) session.getAttribute("char_com_name");             //小区名
		String build_num = (String) session.getAttribute("char_build_num");           //楼宇号
		String unit_num = (String) session.getAttribute("char_unit_num");             //单元号
		String charge_type =(String) session.getAttribute("charge_type");         //收费类型
		
		
		String charge_num = (String) session.getAttribute("charge_num");                 //收费编号
		
		String room_num = (String) session.getAttribute("char_room_num");             //房间号
		
		String charge_lasdate=null;;
		String charge_date=null;//java.sql.Date.valueOf((String) session.getAttribute("charge_date"));//截止付费时间
		int charge_price = 0;
		//if(!session.getAttribute("charge_price").equals("")){                           //房价
		//	charge_price = Integer.parseInt((String) session.getAttribute("charge_price"));
		//}
			
		
		
		Charge1_DAO c1_dao = new Charge1_DAO();
		List<Charge1_Info> resultList = c1_dao.select(com_name,build_num,unit_num,room_num,charge_lasdate,charge_date,charge_price,charge_type,charge_num);
		
		
		
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
		List<Charge1_Info> list = resultList.subList((currentPage-1)*15,(currentPage*15<resultList.size()-1)?currentPage*15:resultList.size());
		int s=list.size();
		
			
	
		request.setAttribute("list",list);
	
		request.getRequestDispatcher("../charge/charge1.jsp").forward(request,response);
	}


}
