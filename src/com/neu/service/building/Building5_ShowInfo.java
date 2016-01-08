package com.neu.service.building;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.bean.Building1_Info;
import com.neu.bean.Building5_Info;
import com.neu.bean.Owner1_Info;
import com.neu.connect.DB_Con;

public class Building5_ShowInfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		String type = request.getParameter("type");
		int index = Integer.parseInt(request.getParameter("id"));
		
		HttpSession session = request.getSession();
		List<Building5_Info> list = (List<Building5_Info>) session.getAttribute("list");
		String com_name = list.get(index%15).getCom_name();
		String build_num = list.get(index%15).getBuild_num();
		String unit_num = list.get(index%15).getUnit_num();	
		String room_num = list.get(index%15).getRoom_num();
		String owner_name=list.get(index%15).getOwner_name();
		
		if(type.equals("1")){
			
			List<Building1_Info> list1 = new ArrayList<Building1_Info>();
			try {
				st = con.createStatement();
				//查询小区号
				String sql = "select num from community where name='"+ com_name + "'";
				rs = st.executeQuery(sql);
					
				String com_num = null;
				while(rs.next()){
					com_num = rs.getString("num").trim();
				}
				
				sql = "select build_num,unit_num,room_num,floor,room_size,price,layout,sale_state from room where com_num='" + com_num + "' and build_num='" + build_num + "' and unit_num='" 
				   + unit_num + "' and room_num='" + room_num + "'";
				
				rs = st.executeQuery(sql);
				
				while(rs.next()){
				    
				    Building1_Info b1_info = new Building1_Info();
				    b1_info.setCom_name(com_name);
				    b1_info.setBuild_num(rs.getString("build_num").trim());
				    b1_info.setUnit_num(rs.getString("unit_num").trim());
				    b1_info.setRoom_num(rs.getString("room_num").trim());
				    b1_info.setFloor(rs.getInt("floor"));
				    b1_info.setRoom_size(rs.getInt("room_size"));
				    b1_info.setPrice(rs.getInt("price"));
				    b1_info.setLayout(rs.getString("layout").trim());
				    b1_info.setSale_state(rs.getString("sale_state").trim());
				    	
				   list1.add(b1_info);
			   }
			   
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			//查询结果的一页
			request.setAttribute("list1",list1);
			
			request.getRequestDispatcher("../building/showRoomInfo.jsp").forward(request,response);
			
			
		}////if
		if(type.equals("2")){
			
			List<Owner1_Info> list2 = new ArrayList<Owner1_Info>();
			try {
				st = con.createStatement();
				//查询小区号
				String sql = "select num from community where name='"+ com_name + "'";
				rs = st.executeQuery(sql);
					
				String com_num = null;
				while(rs.next()){
					com_num = rs.getString("num").trim();
				}
				
				sql = "select owner_num from sale_info where com_num='" + com_num + "' and build_num='" + build_num + "' and unit_num='" 
				   + unit_num + "' and room_num='" + room_num + "'";
				rs = st.executeQuery(sql);
				int owner_num = 0;
				while(rs.next()){
					owner_num = rs.getInt("owner_num");
				}
				
				sql = "select * from owner where owner_num=" + owner_num;
				rs = st.executeQuery(sql);
				
				
				while(rs.next()){
					
					Owner1_Info o1_info = new Owner1_Info();
					o1_info.setOwner_num(rs.getInt("owner_num"));
					o1_info.setOwner_name(rs.getString("name"));
					o1_info.setId_num(rs.getString("id_num"));
					o1_info.setBirthday(rs.getDate("birthday").toString());
					o1_info.setOwner_sex(rs.getString("sex"));
					o1_info.setHometown(rs.getString("hometown"));
					o1_info.setTele(rs.getString("tele"));
					o1_info.setPopulation(rs.getInt("population"));
					
					list2.add(o1_info);
					
				}
			   
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			//查询结果的一页
			request.setAttribute("list2",list2);
			
			request.getRequestDispatcher("../building/showOwnerInfo.jsp").forward(request,response);

		}
		if(type.equals("3")){
			
		}
		if(type.equals("4")){
			
		}
		if(type.equals("5")){
			
		}
		
		
	}


}
