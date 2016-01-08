package com.neu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import com.neu.bean.Building2_Info;
import com.neu.connect.DB_Con;

public class Building2_DAO{
		
	//building2查询
	public List<Building2_Info> select(String com_name,String build_num,String period){
		
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
			
		List<Building2_Info> list = new ArrayList<Building2_Info>();
			
		try {
			st = con.createStatement();
			
			String sql = "select c.name,b.build_num,b.unit_amount,b.floor_amount,b.room_amount,b.period from community c,building b where c.num=b.com_num";
			if(!com_name.equals("0")){
				sql += " and c.name='" + com_name + "'";
			}
			if(!build_num.equals("0")){
				sql += " and b.build_num='" + build_num + "'";
			}
			if(!period.equals("0")){
			    sql += " and b.period='" + period + "'";
			}
			
			System.out.println(sql);
			    
			rs = st.executeQuery(sql);
			      
			while(rs.next()){
			    	
			    Building2_Info b2_info = new Building2_Info();
			    b2_info.setCom_name(rs.getString("name").trim());
			    b2_info.setBuild_num(rs.getString("build_num").trim());
			    b2_info.setUnit_amount(rs.getInt("unit_amount"));
			    b2_info.setFloor_amount(rs.getInt("floor_amount"));
			    b2_info.setRoom_amount(rs.getInt("room_amount"));
			    b2_info.setPeriod(rs.getString("period"));
			   
			    list.add(b2_info);
			 }
			    
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
			
		return  list;
	}
		
		
	//building2删除
	public void delete(String com_name,String build_num){
			
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
			
		try {
			st = con.createStatement();
			String sql = "delete from building where com_num in(select num from community where name='" + com_name +
			"') and build_num='" + build_num + "'"; 
					
			st.executeUpdate(sql);
			    
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
			
	}
		
		
	//building1更新
	public void update(String com_name,String build_num,String period,int unit_amount,int floor_amount,int room_amount){
			
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
			
		try {
			st = con.createStatement();
			String com_num = null;
			String sql = "select num from community where name='"+com_name+"'";
			rs = st.executeQuery(sql);
			while(rs.next()){
				com_num = rs.getString("num").trim();
			}
			
			sql = "update building set unit_amount="+unit_amount+",floor_amount="+floor_amount+",room_amount="+room_amount 
			       + " where com_num='"+com_num + "' and build_num='"+build_num+"' and period='"+period+"'";
			
			System.out.println(sql);
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
			
	}
		
		
	//building2插入
	public void insert(String com_name,String build_num,int unit_amount,int floor_amount,int room_amount,String period){
			
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
				com_num = rs.getString("num").trim();
			}
			//添加
			sql = "insert into building(com_num,build_num,unit_amount,floor_amount,room_amount,period) values(" 
				+ "'" + com_num + "','" + build_num + "'," + unit_amount + "," + floor_amount + "," + room_amount + ",'" + period + "')"; 
			
			st.executeUpdate(sql);
			
			
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
			
	}
		

}

