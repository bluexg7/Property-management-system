package com.neu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.neu.bean.Security2_Info;
import com.neu.connect.DB_Con;
public class Security2_DAO {
	
	public List<Security2_Info> select(int cleanerNum, String workContent, String tools, String workTime)
	{
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		List<Security2_Info> list = new ArrayList<Security2_Info>();
		try {
			st = con.createStatement();
			String sql = "select cleaner_num,work_content,tools,work_time from dailysecurity where 1=1";		
		    if(cleanerNum!=0){
		    	sql += " and cleaner_num=" + cleanerNum;
		    }
		    if(!workContent.equals("")){
		    	sql += " and work_content='" +workContent+"'";
		    }
		    if(!tools.equals("")){
		    	sql += " and tools='" + tools + "'";
		    }
		    if(!workTime.equals("")){
		    	sql += " and to_char(work_time,'yyyy-mm-dd')='" + workTime + "'";
		    }	    
		    rs = st.executeQuery(sql);
		      
		    while(rs.next()){
		    	
		    	Security2_Info c1_info = new Security2_Info();
		    	c1_info.setCleaner_num(rs.getString("cleaner_num").trim());
		    	c1_info.setWork_content(rs.getString("work_content").trim());
		    	c1_info.setTools(rs.getString("tools").trim());
		    	c1_info.setWork_time(rs.getDate("work_time").toString());
		    	//System.out.println(rs.getString("build_num").trim().length());     	
		    	list.add(c1_info);
		    	
		    }
		    
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
		return  list;				
	}//select 2015.7.14 
	public void update(int cleanerNum, String workContent, String tools, String workTime){
		
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;	
		try {
			st = con.createStatement();
			String sql = "update dailysecurity set cleaner_name='"+cleanerNum+"',work_content='"+workContent+"',tools='"+tools+"',work_time='"
			+workTime+"' "+"where cleaner_num='"+cleanerNum+"'"; 
			 
			System.out.println("update:"+sql);
			System.out.println("*************************************");
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
	}//update 2015.7.16
	 public void insert(int cleanerNum, String workContent, String tools, String workTime){
			
			Connection con = DB_Con.getCon();
			ResultSet rs = null;
			Statement st = null;
			
			try {
				st = con.createStatement();
				//Ìí¼Ó
				String sql = "insert into dailysecurity (cleaner_num,work_content,tools,work_time) values(" 
					+ "'" + cleanerNum + "','" + workContent + "','" +tools+ "','" + workTime+ "'"+ ")"; 
				System.out.println(sql);
				st.executeUpdate(sql);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DB_Con.close(rs, st, con);
			}
			
		}
	 
	 public void delete(String cleanerNum){
			
			Connection con = DB_Con.getCon();
			ResultSet rs = null;
			Statement st = null;
			
			try {
				st = con.createStatement();
				String sql = "delete from dailysecurity where cleaner_num='"+cleanerNum+"'";
				st.executeUpdate(sql);
			    
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DB_Con.close(rs, st, con);
			}
			
		}
	   
}
