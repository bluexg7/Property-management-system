package com.neu.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Con {

	@SuppressWarnings("finally")
	public static Connection getCon() {
		
		String url = "jdbc:oracle:thin:@10.25.240.39:1521:ORACLE";
		String user = "scott";
		String password = "tiger";
		Connection con = null;

		try {
			//1.加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.获得连接
			con = DriverManager.getConnection(url, user, password);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		} 
		finally{
			return con;
		}

	}

	public static void close(ResultSet rs, Statement st, Connection con) {
		
		if (rs != null) {
			try{
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if (st != null) {
			try{
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try{
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}

	}

}
