package com.neu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neu.bean.Owner6_Info;
import com.neu.connect.DB_Con;


public class Owner6_DAO {

	public List Owner6Select(String suggestor,String time) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		List<Owner6_Info> owner6 = new ArrayList<Owner6_Info>();
		try {
			st = con.createStatement();
			String sql = "select * from suggestion where 1=1";

			if(!suggestor.equals(""))
			{
				sql += " and suggestor ='"
					+ suggestor + "' ";
			}
			if(!time.equals(""))
			{
				sql +=  " and to_char(sug_date,'yyyy-mm-dd') ='"+ time + "' ";
			}
			
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Owner6_Info own6 = new Owner6_Info();
				own6.setSug_num(rs.getInt("sug_num"));
				own6.setSuggestor(rs.getString("suggestor"));
				own6.setWholeimpress(rs.getString("wholeimpress"));
				own6.setCleaning(rs.getString("cleaning"));
				own6.setSecurity(rs.getString("security"));
				own6.setMaintain(rs.getString("maintain"));
				own6.setCarmanage(rs.getString("carmanage"));
				own6.setGreen(rs.getString("green"));
				own6.setCulture(rs.getString("culture"));
				own6.setTele(rs.getString("tele"));
				own6.setSug_date(rs.getDate("sug_date").toString());
				owner6.add(own6);
				

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		return owner6;

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
