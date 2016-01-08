package com.neu.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.neu.bean.Building3_Info;
import com.neu.connect.DB_Con;

public class Building3_DAO {

	//building3查询
	public List<Building3_Info> select(String com_name,String build_num,String unit_num,String room_num,String owner_name,String start_time,String end_time){
		
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
			
		List<Building3_Info> list = new ArrayList<Building3_Info>();
			
		try {
			st = con.createStatement();
			String sql = "select c.name name1,s.build_num,s.unit_num,s.room_num,s.sale_time,o.name name2,o.owner_num owner_num,o.population " +
					"from community c,sale_info s,owner o where s.owner_num=o.owner_num and s.com_num=c.num";
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
			if(!owner_name.equals("")){
			    sql += " and o.name='" + owner_name + "'";
			}
			if(!start_time.equals("")){
			    if(!end_time.equals("")){
			    	sql += " and to_char(s.sale_time,'YYYY-MM-DD') between '" + start_time + "' and '" + end_time + "'";
			    }
			    else{
			    	sql += " and to_char(s.sale_time,'YYYY-MM-DD') between '" + start_time + "' and '3000-01-01'";
			    }
			}
					
			System.out.println(sql);
			rs = st.executeQuery(sql);
			      
			while(rs.next()){
			    	
			    Building3_Info b3_info = new Building3_Info();
			    b3_info.setCom_name(rs.getString("name1").trim());
			    b3_info.setBuild_num(rs.getString("build_num").trim());
			    b3_info.setUnit_num(rs.getString("unit_num").trim());
			    b3_info.setRoom_num(rs.getString("room_num").trim());
			    b3_info.setOwner_name(rs.getString("name2").trim());
			    b3_info.setOwner_num(rs.getInt("owner_num"));
			    b3_info.setPopulation(rs.getInt("population"));
			    if(rs.getDate("sale_time")!=null)
			    b3_info.setDate(rs.getDate("sale_time").toString());
			   
			    list.add(b3_info);
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
			String sql = "delete from sale_info where com_num in(select num from community where name='" + com_name +
			"') and build_num='" + build_num + "' and unit_num='" + unit_num + "' and room_num='" + room_num + "'"; 
					
			st.executeUpdate(sql);
			
			System.out.println(sql);
			
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
	public void insert(String com_name,String build_num,String unit_num,String room_num,String owner_name,
			int owner_num,int population,String sale_time){
			
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
			st = con.createStatement();
			//查询产权人是否存在
			sql = "select count(*) from owner where owner='"+ owner_name + "' and owner_num=" + owner_num;
			int i=0;
			rs = st.executeQuery(sql);
			while(rs.next()){
				i++;
			}
			if(i==0) 
				return ;
				

			//添加记录
			sql = "insert into sale_info  values('" + com_name + "','" + build_num + "','" + unit_num + "','" + room_num + "'," 
			            + owner_num + ",'" + sale_time + "'"; 
			st.executeUpdate(sql);
			
			System.out.println(sql);
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
			
	}
	
	
}
