package com.neu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neu.bean.Charge1_Info;
import com.neu.connect.DB_Con;










public class Charge1_DAO {
	
	
	
	
	
	public  List<Charge1_Info> select(String com_name,String build_num,String unit_num,String room_num,String charge_lasdate,
			String charge_date,int charge_price,String charge_type ,String charge_num){
			
		
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		List<Charge1_Info> list = new ArrayList<Charge1_Info>();
		try {
			st = con.createStatement();
			String sql = "select char_num ,room_num ,type,pay_time,deadline,com_num ,build_num ,unit_num ,amount from charge c  where 1=1";
			if(!com_name.equals("0")){
				sql += " and c.com_num='" + com_name + "'";
			}
			if(!build_num.equals("0")){
				sql += " and c.build_num='" + build_num + "'";
			}
		    if(!unit_num.equals("0")){
		    	sql += " and c.unit_num='" + unit_num + "'";
		    }
		    if(!room_num.equals("0")){
		   	sql += " and c.room_num='" + room_num + "'";
		   }
		   if(!charge_type.equals("0")){
		    	sql += " and c.type='" + charge_type + "'";
		    }
		   if(!charge_num.equals("")){
			   sql+="and c.char_num='"+charge_num+"'";
		   }
		    rs = st.executeQuery(sql);		    
		    while(rs.next()){
		    	
		    	Charge1_Info c1_info = new Charge1_Info();
		    	c1_info.setCom_name(rs.getString("com_num").trim());
		    	c1_info.setBuild_num(rs.getString("build_num").trim());
		    	//System.out.println(rs.getString("build_num").trim().length());
		    	c1_info.setUnit_num(rs.getString("unit_num").trim());
		    	c1_info.setRoom_num(rs.getString("room_num").trim());
		    	c1_info.setCharge_type(rs.getString("type"));
		    	c1_info.setCharge_date(rs.getDate("deadline").toString());
		    	c1_info.setCharge_price(rs.getInt("amount"));
		    	c1_info.setCharge_lasdate(rs.getDate("pay_time").toString());
		    	c1_info.setCharge_num(rs.getString("char_num").trim());
		    	
		    	list.add(c1_info);
		    	
		    }  
		    
		    
		    
		    
		    
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			DB_Con.close(rs, st, con);
		}
		
		
		
		
		
		
		
		
				return list;
		
		
	}
	
	public void delete(String charge_num){
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		try {
			st = con.createStatement();
			String sql = "delete from charge where char_num='" + charge_num + "'"; 				
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}	
	}
	
	
	
	
	
	public void insert(String charge_num,String com_name,String build_num,
			String unit_num,String room_num,String las_date,
			String date,String charge_type,String amount){
		
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;		
		try {
			st = con.createStatement();
			String sql = "insert into charge values("+"'" +charge_num+"'"+","+"'"+room_num+"'"+","+"'"+charge_type+"'"+","+"to_date("+"'"+las_date+"'"+",'yyyy-mm-dd'),"+
			"to_date("+"'"+date+"'"+",'yyyy-mm-dd'),"+"'"+com_name+"'"+","+"'"+build_num+"'"+","+"'"+unit_num+"'"+","+"'"+amount+"'"+") ";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
	}
	
	
	
	
	
	
	
	public  List<Charge1_Info> select_charge4(String com_name,String build_num,String unit_num,String room_num,String charge_type ){
			
		
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		List<Charge1_Info> list = new ArrayList<Charge1_Info>();
		try {
			st = con.createStatement();
			String sql = "select room_num,com_num,build_num,unit_num,type,sum(amount) from charge c where 1=1";
			if(!com_name.equals("0")){
				sql += " and c.com_num='" + com_name + "'";
			}
			if(!build_num.equals("0")){
				sql += " and c.build_num='" + build_num + "'";
			}
		    if(!unit_num.equals("0")){
		    	sql += " and c.unit_num='" + unit_num + "'";
		    }
		    if(!room_num.equals("0")){
		   	sql += " and c.room_num='" + room_num + "'";
		   }
		   if(!charge_type.equals("0")){
		    	sql += " and c.type='" + charge_type + "'";
		    }
		   sql+="group by room_num,com_num,build_num,unit_num,type";
		    rs = st.executeQuery(sql);		    
		    while(rs.next()){
		    	
		    	Charge1_Info c1_info = new Charge1_Info();
		    	c1_info.setCom_name(rs.getString("com_num").trim());
		    	c1_info.setBuild_num(rs.getString("build_num").trim());
		    	//System.out.println(rs.getString("build_num").trim().length());
		    	c1_info.setUnit_num(rs.getString("unit_num").trim());
		    	c1_info.setRoom_num(rs.getString("room_num").trim());
		    	c1_info.setCharge_type(rs.getString("type"));
		    	
		    	c1_info.setCharge_price(rs.getInt("sum(amount)"));
		    	
		    	
		    	
		    	list.add(c1_info);
		    	
		    }  
		    
		    
		    
		    
		    
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			DB_Con.close(rs, st, con);
		}
		
		
		
		
		
		
		
		
				return list;
		
		
	}
	
	
	
	
	
	
	
	
	public void update(String com_name,String build_num,String unit_num,String room_num,String charge_num,
			String charge_type,String charge_amount,String charge_lasdate,String charge_date){
		
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		try {
			st = con.createStatement();
			String sql = "update charge set room_num='" + room_num + "',com_num='" + com_name + "',build_num='" + build_num +"',amount='"+charge_amount
			+ "',unit_num='" + unit_num+"',type='"+charge_type+"',deadline=to_date('"+charge_date+"','yyyy-mm-dd'),pay_time=to_date('"+charge_lasdate+"','yyyy-mm-dd') where char_num='"+charge_num+"'";
			
			 
			System.out.println(sql);
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
