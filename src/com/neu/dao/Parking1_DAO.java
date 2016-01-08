package com.neu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.neu.bean.Parking1_Info;
import com.neu.connect.DB_Con;
public class Parking1_DAO {
	
	public List<Parking1_Info> select(int parklot_num,String parklot_name,String location,int charge)
	{
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		List<Parking1_Info> list = new ArrayList<Parking1_Info>();
		try {
			st = con.createStatement();
			String sql = "select parklot_num,parklot_name,location,charge,maxinum from parking where 1=1";		
		    if(parklot_num!=0){
		    	sql += " and parklot_num=" + parklot_num;
		    }
		    if(!parklot_name.equals("")){
		    	sql += " and parklot_name='" +parklot_name+"'";
		    }
		    if(!location.equals("")){
		    	sql += " and location='" + location + "'";
		    }
		    if(charge != 0){
		    	sql += " and charge=" + charge;
		    }		    
		    rs = st.executeQuery(sql);
		      
		    while(rs.next()){
		    	
		    	Parking1_Info p1_info = new Parking1_Info();
		    	p1_info.setParklot_num(rs.getString("parklot_num").trim());
		    	p1_info.setParklot_name(rs.getString("parklot_name").trim());
		    	p1_info.setLocation(rs.getString("location").trim());
		    	p1_info.setMaxinum(rs.getInt("maxinum"));
		    	p1_info.setCharge(rs.getInt("charge"));
		    	//System.out.println(rs.getString("build_num").trim().length());     	
		    	list.add(p1_info);
		    	
		    }
		    
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
		return  list;				
	}//select 2015.7.14 
	public void update(int parklot_num, String parklot_name, String location,int maxinum,int charge){
		
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;	
		try {
			st = con.createStatement();
			String sql = "update parking set parklot_name='"+parklot_name+"',location='"+location+"',charge='"+charge+"',maxinum='"
			+maxinum+"' "+"where parklot_num='"+parklot_num+"'"; 
			 
			System.out.println("update:"+sql);
			System.out.println("*************************************");
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
	}//update 2015.7.16
	 public void insert(int parklot_num,String parklot_name,String location,int maxinum,int charge){
			
			Connection con = DB_Con.getCon();
			ResultSet rs = null;
			Statement st = null;
			
			try {
				st = con.createStatement();
				//Ìí¼Ó
				String sql = "insert into parking (parklot_num,parklot_name,location,maxinum,charge) values(" 
					+ "'" + parklot_num + "','" + parklot_name + "','" +location+ "','" + maxinum+ "','" +charge 
					+ "'" + ")"; 
				System.out.println(sql);
				st.executeUpdate(sql);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DB_Con.close(rs, st, con);
			}
			
		}
	 
	 public void delete(String parklot_num){
			
			Connection con = DB_Con.getCon();
			ResultSet rs = null;
			Statement st = null;
			
			try {
				st = con.createStatement();
				String sql = "delete from parking where parklot_num='"+parklot_num+"'";
				st.executeUpdate(sql);
			    
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DB_Con.close(rs, st, con);
			}
			
		}
	   
}
