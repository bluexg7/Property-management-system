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

public class Charge2 extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        request.setCharacterEncoding("gb2312");	
		HttpSession session = request.getSession();
		String com_name = (String) session.getAttribute("char3_com_name");             //小区名
		String build_num = (String) session.getAttribute("char3_build_num");           //楼宇号
		String unit_num = (String) session.getAttribute("char3_unit_num");             //单元号
		String charge_type =(String) session.getAttribute("char3_charge_type");         //收费类型
		
		
		String charge_num = (String) session.getAttribute("char3_charge_num");                 //收费编号
		
		String room_num = (String) session.getAttribute("char3_room_num");             //房间号
		
		String charge_lasdate=null;;
		String charge_date=null;//java.sql.Date.valueOf((String) session.getAttribute("charge_date"));//截止付费时间
		int charge_price = 0;
		
		Charge1_DAO c1_dao = new Charge1_DAO();
		List<Charge1_Info> resultList = c1_dao.select(com_name,build_num,unit_num,room_num,charge_lasdate,charge_date,charge_price,charge_type,charge_num);
		
		
		List<Charge1_Info> list = resultList.subList(0,resultList.size());
		int s=list.size();
		
		request.setAttribute("list",list);
	
		request.getRequestDispatcher("../charge/charge2.jsp").forward(request,response);
	}


}
