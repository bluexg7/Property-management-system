package com.neu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neu.bean.Building4_Info;
import com.neu.connect.DB_Con;

public class Building4_DAO {
	
	//building3查询
	public List<Building4_Info> select(String com_name,String build_num,String unit_num,String room_num,String de_type,String start_time,String end_time){
		
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
			
		List<Building4_Info> list = new ArrayList<Building4_Info>();
			
		try {
			st = con.createStatement();
			String sql = "select c.name,d.build_num,d.unit_num,d.room_num,d.type,d.time from community c,decoration d where c.num=d.com_num";
			if(!com_name.equals("0")){
				sql += " and c.name='" + com_name + "'";
			}
			if(!build_num.equals("0")){
				sql += " and d.build_num='" + build_num + "'";
			}
			if(!unit_num.equals("0")){
				sql += " and d.unit_num='" + unit_num + "'";
			}
			if(!room_num.equals("")){
				sql += " and d.room_num='" + room_num + "'";
			}
			if(!de_type.equals("0")){
				sql += " and d.type='" + de_type + "'";
			}
			if(!start_time.equals("")){
			    if(!end_time.equals("")){
			    	sql += " and to_char(d.time,'YYYY-MM-DD') between '" + start_time + "' and '" + end_time + "'";
			    }
			    else{
			    	sql += " and to_char(d.time,'YYYY-MM-DD') between '" + start_time + "' and '3000-01-01'";
			    }
			}
					
			System.out.println(sql);
			rs = st.executeQuery(sql);
			      
			while(rs.next()){
			    	
			    Building4_Info b4_info = new Building4_Info();
			    b4_info.setCom_name(rs.getString("name").trim());
			    b4_info.setBuild_num(rs.getString("build_num").trim());
			    b4_info.setUnit_num(rs.getString("unit_num").trim());
			    b4_info.setRoom_num(rs.getString("room_num").trim());
			    b4_info.setDe_type(rs.getString("type").trim());
			    if(rs.getDate("time")!=null)
			    	b4_info.setDate(rs.getDate("time").toString());
			   
			    list.add(b4_info);
			 }
			    
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
			
		return  list;
	}
		
		
	//building1删除
	public void delete(String com_name,String build_num,String unit_num,String room_num){
			
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
			
		try {
			st = con.createStatement();
			String sql = "delete from room where com_num in(select num from community where name='" + com_name +
			"') and build_num='" + build_num + "' and unit_num='" + unit_num + "' and room_num='" + room_num + "'"; 
					
			st.executeUpdate(sql);
			    
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
			
	}
		
		
	//building1更新
	public void update(String com_name,String build_num,String unit_num,String room_num,int floor,
			String sale_state,int room_size,String layout,long price){
			
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
			
		try {
			st = con.createStatement();
			String sql = "update room set sale_state='" + sale_state + "',room_size=" + room_size + ",layout='" + layout + "',price=" + price 
			+ " where room.com_num in(select num from community where name='"+ com_name + "') and room.build_num='" + build_num 
			+ "' and room.unit_num='" + unit_num + "' and room_num='" + room_num + "'"; 
				 
			System.out.println(sql);
			st.executeUpdate(sql);
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
			
	}
		
		
	//building1插入
	public void insert(String com_name,String build_num,String unit_num,String room_num,int floor,
			String sale_state,int room_size,String layout,long price){
			
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
			
		try {
			st = con.createStatement();
			//查询小区号
			String sql = "select num from community where name='"+ com_name + "'";
			rs = st.executeQuery(sql);
				
			String com_num = null;
			while(rs.next()){
				com_num = rs.getString("num");
			}
			//添加
			sql = "insert into room(com_num,build_num,unit_num,room_num,sale_state,room_size,price,layout,floor) values(" 
				+ "'" + com_num + "','" + build_num + "','" + unit_num + "','" + room_num + "','" + sale_state + "'," + room_size 
				+ "," + price + ",'" + layout + "'," + floor + ")"; 
			st.executeUpdate(sql);
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
			
	}
	
	

}
