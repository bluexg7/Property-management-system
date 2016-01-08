package com.neu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neu.bean.Parking2_Info;
import com.neu.connect.DB_Con;

public class Parking2_DAO {
	public List<Parking2_Info> select(int  parking_num,int  parklot_num,int state )
	{
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		List<Parking2_Info> list = new ArrayList<Parking2_Info>();
		try {
			st = con.createStatement();
			String sql = "select parking_num,parklot_num,state from park_space where 1=1";
		    if(parking_num!=0){
			    sql += " and parking_num=" + parking_num;
			    }
		    if(parklot_num!=0){
		    	sql += " and parklot_num=" + parklot_num;
		    }
		  	
		    if(state!=-1){
		       sql += " and state=" + state;	
		    }
		 	    
		    rs = st.executeQuery(sql);
		      
		    while(rs.next()){
		    	
		    	Parking2_Info p2_info = new Parking2_Info();		    	
		    	p2_info.setParking_num(rs.getInt("parking_num"));
		    	p2_info.setParklot_num(rs.getInt("parklot_num"));
		    	p2_info.setState(rs.getInt("state"));	
		    	list.add(p2_info);
		    	
		    }
		    
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
		return  list;				
	}//select 2015.7.15
	
	 public void insert(int parking_num,int parklot_num,int state){
			
			Connection con = DB_Con.getCon();
			ResultSet rs = null;
			Statement st = null;
			
			try {
				st = con.createStatement();
				//Ìí¼Ó
				String sql = "insert into park_space(parking_num,parklot_num,state) values(" 
					+ "'" + parking_num + "','" + parklot_num+ "','" +state+"'" + ")"; 
				System.out.println(sql);
				st.executeUpdate(sql);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DB_Con.close(rs, st, con);
			}
			
		}
	 public void delete(String parking_num){
			
			Connection con = DB_Con.getCon();
			ResultSet rs = null;
			Statement st = null;
			
			try {
				st = con.createStatement();
				String sql = "delete from park_space where parking_num='"+parking_num+"'";
				st.executeUpdate(sql);
			    
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DB_Con.close(rs, st, con);
			}
			
		}

	 public void update(int parking_num,int parklot_num, int state){
			
			Connection con = DB_Con.getCon();
			ResultSet rs = null;
			Statement st = null;	
			try {
				st = con.createStatement();
				String sql = "update park_space set parklot_num='"+parklot_num+"',state='"+state+"' "+"where parking_num='"+parking_num+"'"; 
				 
				System.out.println("update:"+sql);
				System.out.println("*************************************");
				st.executeUpdate(sql);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DB_Con.close(rs, st, con);
			}
			
		}//update 2015.7.16
}
