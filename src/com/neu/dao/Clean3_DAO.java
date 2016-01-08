package com.neu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.neu.bean.Clean3_Info;
import com.neu.connect.DB_Con;
public class Clean3_DAO {
	
	public List<Clean3_Info> select(int check_num,String checktype)
	{
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		List<Clean3_Info> list = new ArrayList<Clean3_Info>();
		try {
			st = con.createStatement();
			String sql = "select check_num,checktype,cleaner_num,checkcontent,checkdate,checker from clean_check where 1=1";		
		    if(check_num!=0){
		    	sql += " and check_num=" + check_num;
		    }
		    if(!checktype.equals("0")){
		    	sql += " and checktype='" +checktype+"'";
		    }    
		    
		    System.out.println(sql);
		    rs = st.executeQuery(sql);
		      
		    while(rs.next()){
		    	
		    	Clean3_Info c1_info = new Clean3_Info();
		    	c1_info.setCheck_num(rs.getString("check_num").trim());
		    	c1_info.setChecktype(rs.getString("checktype").trim());
		    	c1_info.setCleaner_num(rs.getString("cleaner_num").trim());
		    	c1_info.setCheckcontent(rs.getString("checkcontent"));
		    	c1_info.setCheckdate(rs.getDate("checkdate").toString());
		    	c1_info.setChecker(rs.getString("checker")); 	
		    	list.add(c1_info);
		    	
		    }
		    
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
		return  list;				
	}//select 2015.7.14 
	public void update(int check_num, String checktype, int cleaner_num,String checkcontent,String checkdate,String checker){
		
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;	
		try {
			st = con.createStatement();
			String sql = "update clean_check set checktype='"+checktype+"',cleaner_num='"+cleaner_num+"',checkcontent='"+checkcontent+"',checkdate='"
			+checkdate+"',checker='"+checker+"' "+"where check_num='"+check_num+"'"; 
			 
			System.out.println("update:"+sql);
			System.out.println("*************************************");
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
	}//update 2015.7.16
	 public void insert(int check_num, String checktype, int cleaner_num,String checkcontent,String checkdate,String checker){
			
			Connection con = DB_Con.getCon();
			ResultSet rs = null;
			Statement st = null;
			
			try {
				st = con.createStatement();
				//Ìí¼Ó
				String sql = "insert into clean_check (check_num,checktype,cleaner_num,checkcontent,checkdate,checker) values(" + "'" + check_num + "','" + checktype + "','" +cleaner_num+ "','" + checkcontent+ "','" +checkdate + "','" + checker+ "'" + ")"; 
				System.out.println(sql);
				st.executeUpdate(sql);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DB_Con.close(rs, st, con);
			}
			
		}
	 
	 public void delete(String check_num){
			
			Connection con = DB_Con.getCon();
			ResultSet rs = null;
			Statement st = null;
			
			try {
				st = con.createStatement();
				String sql = "delete from clean_check where check_num='"+check_num+"'";
				st.executeUpdate(sql);
			    
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DB_Con.close(rs, st, con);
			}
			
		}
	   
}
