package com.neu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neu.bean.Owner4_Info;
import com.neu.connect.DB_Con;


public class Owner4_DAO {

	public List Owner4Select(int prpc_num,String meeting_date) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		List<Owner4_Info> owner4 = new ArrayList<Owner4_Info>();
		try {
			st = con.createStatement();
			String sql = "select * from com_meeting where 1=1";

			if(prpc_num!=-1 )
			{
				sql += " and com_num ='"
					+ prpc_num + "' ";
			}
			if(!meeting_date.equals(""))
			{
				sql +=  " and to_char(meet_date,'yyyy-mm-dd') ='"+ meeting_date + "' ";
			}
			
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Owner4_Info own4 = new Owner4_Info();
				own4.setCom_num(rs.getInt("com_num"));
				own4.setCom_content(rs.getString("content"));
				own4.setExpect_amount(rs.getInt("expect_amount"));
				own4.setFact_amount(rs.getInt("fact_amount"));
				own4.setAbsent_info(rs.getString("absent_info"));
				own4.setMeet_date(rs.getDate("meet_date").toString());
		
				owner4.add(own4);
				

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		return owner4;

	}
	public void Owner4Delete(String com_num) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;

		try {
			st = con.createStatement();
			String sql = "delete from com_meeting where com_num ='" + com_num
					+ "' ";
			st.executeUpdate(sql);
			System.out.println(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}

	}

	public void Owner4Insert( int com_num,String content,int expect,int fact ,String absent,String date) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;

		try {
			st = con.createStatement();
			String sql = "insert into com_meeting values( '" + com_num + "','"
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

	public void Owner4Update(int com_num,String content,int expect,int fact ,String absent,String date ) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		try {
			st = con.createStatement();
			String sql = "update com_meeting set expect_amount='" + expect
					+ "',fact_amount='" + fact
					+ "',absent_info='" + absent
					+ "',meet_date= to_date('" + date
					+ "','yyyy-MM-dd') ,content='" + content
					+ "'where com_num = '" + com_num + "'";
			System.out.println(sql);
			st.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}

	}

}
