package com.neu.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.neu.bean.Security1_Info;
import com.neu.connect.DB_Con;

public class Security1_DAO{
	
	//clean1查询
	@SuppressWarnings("deprecation")
	public List<Security1_Info> select(int cleaner_num,String name,String position,String work_range){
	
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		List<Security1_Info> list = new ArrayList<Security1_Info>();
		
		try {
			st = con.createStatement();
			String sql = "select c.cleaner_num,c.name,c.id_num,c.sex,c.birthday,c.position,c.tele,c.salary,c.work_range from security_info c where 1=1";
			if(cleaner_num!=0){
		    	sql += " and cleaner_num=" + cleaner_num;
		    }
		    if(!name.equals("")){
		    	sql += " and name='" +name+"'";
		    }
		    if(!position.equals("0")){
		    	sql += " and position='" + position + "'";
		    }
		    if(!work_range.equals("0")){
		    	sql += " and work_range='" + work_range + "'";
		    }	    
		    System.out.println(sql);
		    
		    rs = st.executeQuery(sql);
		    Date dt=new Date();
		    while(rs.next()){
		    	
		    	Security1_Info c1_info = new Security1_Info();
		    	c1_info.setCleaner_num(rs.getInt("cleaner_num"));
		    	c1_info.setName(rs.getString("name").trim());
		    	//System.out.println(rs.getString("name").trim());
		    	c1_info.setId_num(rs.getString("id_num").trim());
		    	c1_info.setSex(rs.getString("sex").trim());
		    	int age=dt.getYear()-rs.getDate("birthday").getYear();
		    	c1_info.setBirthday(String.valueOf(age));
		    	c1_info.setPosition(rs.getString("position").trim());
		    	c1_info.setTele(rs.getString("tele").trim());
		    	c1_info.setSalary(rs.getInt("salary"));
		    	c1_info.setWork_range(rs.getString("work_range").trim());
		    	
		    	System.out.println(c1_info);
		    	
		    	list.add(c1_info);
		    	
		    }
		    
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
		return  list;
	}
	
	
	//clean1删除
	public void delete(int cleaner_num){
		
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		try {
			st = con.createStatement();
			String sql = "delete from security_info where cleaner_num ='"+cleaner_num+"'"; 
			
			System.out.println("测试: "+sql);
			
			st.executeUpdate(sql);
		    
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
	}
	
	
	//clean1更新
	public void update(int cleaner_num,String name,String id_num,String sex,String birthday,
			String position,String tele,int salary,String work_range){
		
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		try {
			st = con.createStatement();
			String sql = "update security_info set cleaner_num='" + cleaner_num + "',name=" + name + ",id_num='" + id_num + "',sex=" + sex 
			+ " ',birthday='" + birthday + "',position='" + position + "',tele='" + tele + "',salary='" + salary + "',work_range='" + work_range + "'"; 
			 
			System.out.println(sql);
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
	}
	
	
	//clean1插入
	public void insert(int cleaner_num,String name,String id_num,String sex,String birthday,
			String position,String tele,int salary,String work_range){
		
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		try {
			st = con.createStatement();
			
			//添加
			String sql = "insert into security_info(cleaner_num,name,id_num,sex,birthday,position,tele,salary,work_range) values(" 
				+ "'" + cleaner_num + "','" + name + "','" + id_num + "','" + sex + "','" + birthday + "'," + position 
				+ "," + tele + ",'" + salary + "'," + work_range + ")"; 
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
	}	
}
	


