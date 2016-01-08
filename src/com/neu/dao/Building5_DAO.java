package com.neu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neu.bean.Building4_Info;
import com.neu.bean.Building5_Info;
import com.neu.connect.DB_Con;

public class Building5_DAO {
	
	//building3≤È—Ø
	public List<Building5_Info> select(String com_name,String build_num,String unit_num,String room_num){
		
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
			
		List<Building5_Info> list = new ArrayList<Building5_Info>();
			
		try {
			st = con.createStatement();
			String sql = "select c.name name1,s.build_num,s.unit_num,s.room_num,o.name name2 from community c,sale_info s,owner o where c.num=s.com_num and s.owner_num=o.owner_num";
			if(!com_name.equals("0")){
				sql += " and c.name='" + com_name + "'";
			}
			if(!build_num.equals("0")){
				sql += " and s.build_num='" + build_num + "'";
			}
			if(!unit_num.equals("0")){
				sql += " and s.unit_num='" + unit_num + "'";
			}
			if(!room_num.equals("")){
				sql += " and s.room_num='" + room_num + "'";
			}
					
			rs = st.executeQuery(sql);
			      
			int i=0;
			while(rs.next()){
			    	
			    Building5_Info b5_info = new Building5_Info();
			    b5_info.setCom_name(rs.getString("name1").trim());
			    b5_info.setBuild_num(rs.getString("build_num").trim());
			    b5_info.setUnit_num(rs.getString("unit_num").trim());
			    b5_info.setRoom_num(rs.getString("room_num").trim());
			    b5_info.setOwner_name(rs.getString("name2"));
			    b5_info.setCount(i);
			    list.add(b5_info);
			    i++;
			 }
			    
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
			
		return  list;
	}
	
}
