package com.neu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neu.bean.Office1_Info;
import com.neu.connect.DB_Con;


public class Office1_DAO {

	public List Office1Select(String Depart_Name,String Office_Num) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		List<Office1_Info> office1 = new ArrayList<Office1_Info>();
		try {
			st = con.createStatement();
			String sql = "select * from DEPARTMENT where 1=1";

			if(!Office_Num.equals(""))
			{
				sql += " and Office_Num ='"
					+ Office_Num + "' ";
			}
			if(!Depart_Name.equals("0"))
				sql +=  " and DEPART_NAME ='"+ Depart_Name + "' ";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Office1_Info off1 = new Office1_Info();
				off1.setDepart_Name(rs.getString("DEPART_NAME").trim());
				off1.setDepart_Num(rs.getInt("DEPART_NUM"));
				off1.setOffice_Num(rs.getString("OFFICE_NUM").trim());
				off1.setStaff_Num(rs.getInt("Staff_amount"));
				off1.setManager(rs.getString("MANAGER").trim());
				off1.setRule(rs.getString("RULE").trim());
				office1.add(off1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		return office1;

	}
	public void Office1Delete(int Depart_Num){
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;

		try {
			st = con.createStatement();
			String sql = "delete from DEPARTMENT where DEPART_Num ='"
				+ Depart_Num + "' ";
			System.out.println(sql);
			st.executeUpdate(sql);
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
	}
	
	public void Office1Insert(int Depart_Num,String Depart_Name,String Office_Num,int Staff_Num,String Manager,String Rule){
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		try {
			st = con.createStatement();
			String sql = "insert into department values(" 
				+ "'" + Depart_Num + "','" + Depart_Name + "','" + Office_Num + "','" + Staff_Num + "','" + Manager + "','" + Rule 
				+ "')" ;
			System.out.println(sql);
			st.executeUpdate(sql);
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
	}
	public void Office1Update(int Depart_Num,String Depart_Name,String Office_Num,int Staff_Num,String Manager,String Rule){
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		try {
			st = con.createStatement();
			String sql = "update department set depart_name='" + Depart_Name + "',office_num='" + Office_Num + "',staff_amount='" + Staff_Num 
			+ "',manager='"+Manager+"',rule='"+Rule+"' where depart_num = '" + Depart_Num + "'" ;
			System.out.println(sql);
			st.executeUpdate(sql);
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
		
	}

}
