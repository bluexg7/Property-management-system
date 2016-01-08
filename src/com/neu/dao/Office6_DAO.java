package com.neu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neu.bean.Office6_Info;
import com.neu.connect.DB_Con;

public class Office6_DAO {

	public List Office6Select(String plan_state, String start_time,
			String end_time) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		List<Office6_Info> office6 = new ArrayList<Office6_Info>();

		try {
			st = con.createStatement();
			String sql = "select * from work_plan where 1=1";

			if (!start_time.equals("")) {
				sql += " and start_time >= to_date('" + start_time
						+ "','yyyy-mm-dd')";
			}
			if (!end_time.equals("")) {
				sql += " and start_time <= to_date('" + end_time
						+ "','yyyy-mm-dd')";
			}
//			System.out.println(plan_state);
			if (!plan_state.equals("")) {
				sql += " and state ='" + plan_state + "' ";
			}

			System.out.println(sql);
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Office6_Info off6 = new Office6_Info();
				off6.setPlan_num(rs.getInt("plan_num"));
				off6.setPlan_content(rs.getString("plan_content"));
				off6.setPlan_state(rs.getString("state"));
				off6.setWorkload(rs.getString("workload"));
				if (rs.getDate("start_time") != null)
					off6.setStart_time(rs.getDate("start_time").toString());

				office6.add(off6);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		return office6;

	}

	public void Office6Delete(int plan_num) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;

		try {
			st = con.createStatement();
			String sql = "delete from work_plan where plan_num ='" + plan_num
					+ "' ";
			st.executeUpdate(sql);
			System.out.println(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}

	}

	public void Office6Insert(int plan_num,String content,String state,String workload,String starttime ) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;

		try {
			st = con.createStatement();
			String sql = "insert into work_plan values( '" + plan_num + "','"
					+ content + "','" + state
					+ "','" + workload
					+ "',to_date('" + starttime + "','yyyy-MM-dd'))";
			System.out.println(sql);
			st.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}

	}

	public void Office6Update(int plan_num,String content,String state,String workload,String starttime) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		try {
			st = con.createStatement();
			String sql = "update work_plan set plan_content='" + content
					+ "',state='" + state
					+ "',workload='" + workload
					+ "',start_time= to_date('" + starttime
					+ "','yyyy-MM-dd')where plan_num = '" + plan_num + "'";
			System.out.println(sql);
			st.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}

	}

}
