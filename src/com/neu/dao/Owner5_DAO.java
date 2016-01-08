package com.neu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neu.bean.Owner5_Info;
import com.neu.connect.DB_Con;


public class Owner5_DAO {

	public List Owner5Select(String complainer,String time) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		List<Owner5_Info> owner5 = new ArrayList<Owner5_Info>();
		try {
			st = con.createStatement();
			String sql = "select * from complaint where 1=1";

			if(!complainer.equals(""))
			{
				sql += " and complainer ='"
					+ complainer + "' ";
			}
			if(!time.equals(""))
			{
				sql +=  " and to_char(time,'yyyy-mm-dd') ='"+ time + "' ";
			}
			
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Owner5_Info own5 = new Owner5_Info();
				own5.setComplaint_num(rs.getInt("complaint_num"));
				own5.setComplainer(rs.getString("complainer"));
				own5.setContent(rs.getString("content"));
				own5.setTele(rs.getString("tele"));
				own5.setTime(rs.getDate("time").toString());		
				owner5.add(own5);
				

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		return owner5;

	}
	public void Office1Delete(int Depart_Num){
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;

		try {
			st = con.createStatement();
			String sql = "delect from DEPARTMENT where DEPART_Num ='"
				+ Depart_Num + "' ";
			
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
		PreparedStatement pmst = null;

		try {
			String sql = "insert into department values(?,?,?,?,?,?)";
			pmst = con.prepareStatement(sql);
			pmst.setInt(1, Depart_Num);
			pmst.setString(2, Depart_Name);
			pmst.setString(3, Office_Num);
			pmst.setInt(4,Staff_Num);
			pmst.setString(5, Manager);
			pmst.setString(6, Rule);
			pmst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, pmst, con);
		}
		
	}
	public void Office1Update(){
		
	}

}
