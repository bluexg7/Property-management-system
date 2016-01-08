package com.neu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neu.bean.Owner2_Info;
import com.neu.connect.DB_Con;


public class Owner2_DAO {

	public List Owner2Select(int prpc_num,String meeting_date) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		List<Owner2_Info> owner2 = new ArrayList<Owner2_Info>();
		try {
			st = con.createStatement();
			String sql = "select * from prpc where 1=1";

			if(prpc_num!=-1 )
			{
				sql += " and prpc_num ='"
					+ prpc_num + "' ";
			}
			if(!meeting_date.equals(""))
			{
				sql +=  " and to_char(meetting_date,'yyyy-mm-dd') ='"+ meeting_date + "' ";
			}
			
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Owner2_Info own2 = new Owner2_Info();
				own2.setPrpc_num(rs.getInt("prpc_num"));
				own2.setPrpc_content(rs.getString("content"));
				own2.setExpect_amount(rs.getInt("expect_amount"));
				own2.setFact_amount(rs.getInt("fact_amount"));
				own2.setAbsent_info(rs.getString("absent_info"));
				own2.setMeeting_date(rs.getDate("MEETTING_DATE").toString());
		
				owner2.add(own2);
				

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		return owner2;

	}
	public void Owner2Delete(String prpc_num) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;

		try {
			st = con.createStatement();
			String sql = "delete from prpc where prpc_num ='" + prpc_num
					+ "' ";
			st.executeUpdate(sql);
			System.out.println(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}

	}

	public void Owner2Insert( int prpc_num,String content,int expect,int fact ,String absent,String date) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;

		try {
			st = con.createStatement();
			String sql = "insert into prpc values( '" + prpc_num + "','"
					+ expect + "','" + fact
					+ "','" + absent
					+ "','" + content + "',to_date('" + date + "','yyyy-MM-dd'))";
			System.out.println(sql);
			st.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}

	}

	public void Owner2Update(int prpc_num,String content,int expect,int fact ,String absent,String date ) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		try {
			st = con.createStatement();
			String sql = "update prpc set expect_amount='" + expect
					+ "',fact_amount='" + fact
					+ "',absent_info='" + absent
					+ "',meetting_date= to_date('" + date
					+ "','yyyy-MM-dd') ,content='" + content
					+ "'where prpc_num = '" + prpc_num + "'";
			System.out.println(sql);
			st.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}

	}

}
