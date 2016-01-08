package com.neu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.neu.connect.DB_Con;

public class UI_DAO {
	
	public boolean login(String usname,String psword) {

		Connection con = DB_Con.getCon();
		boolean flag = false;
		ResultSet rs = null;
		Statement st = null;
		try {
			st = con.createStatement();
			String sql = "select * from MANAGER where username ='" + usname
					+ "' and password ='" + psword + "'";
			
			rs = st.executeQuery(sql);
			if (rs.next()) {
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		return flag;

	}
}
