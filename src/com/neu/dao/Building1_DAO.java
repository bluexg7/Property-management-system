package com.neu.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.neu.bean.Building1_Info;
import com.neu.connect.DB_Con;

public class Building1_DAO{
	
	//building1查询
	public List<Building1_Info> select(String com_name,String build_num,String unit_num,String room_num,int floor,
			String sale_state,int room_size,String layout,long price){
	
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		List<Building1_Info> list = new ArrayList<Building1_Info>();
		
		try {
			st = con.createStatement();
			String sql = "select c.name,r.build_num,r.unit_num,r.room_num,r.floor,r.room_size,r.price,r.layout,r.sale_state from community c,room r where c.num=r.com_num";
			if(!com_name.equals("0")){
				sql += " and c.name='" + com_name + "'";
			}
			if(!build_num.equals("0")){
				sql += " and r.build_num='" + build_num + "'";
			}
		    if(!unit_num.equals("0")){
		    	sql += " and r.unit_num='" + unit_num + "'";
		    }
		    if(!room_num.equals("")){
		    	sql += " and r.room_num='" + room_num + "'";
		    }
		    if(floor != 0){
		    	sql += " and r.floor=" + floor;
		    }
		    if(!sale_state.equals("0")){
		    	sql += " and r.sale_state='" + sale_state + "'";
		    }
		    if(room_size != 0){
		    	sql += " and r.room_size=" + room_size;
		    }
		    if(!layout.equals("")){
		    	sql += " and r.layout='" + layout + "'";
		    }
		    if(price != 0){
		    	sql += " and r.price=" + price;
		    }

		    System.out.println(sql);
		    
		    rs = st.executeQuery(sql);
		      
		    while(rs.next()){
		    	
		    	Building1_Info b1_info = new Building1_Info();
		    	b1_info.setCom_name(rs.getString("name").trim());
		    	b1_info.setBuild_num(rs.getString("build_num").trim());
		    	b1_info.setUnit_num(rs.getString("unit_num").trim());
		    	b1_info.setRoom_num(rs.getString("room_num").trim());
		    	b1_info.setFloor(rs.getInt("floor"));
		    	b1_info.setRoom_size(rs.getInt("room_size"));
		    	b1_info.setPrice(rs.getInt("price"));
		    	b1_info.setLayout(rs.getString("layout").trim());
		    	b1_info.setSale_state(rs.getString("sale_state").trim());
		    	
		    	list.add(b1_info);
		    	
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
