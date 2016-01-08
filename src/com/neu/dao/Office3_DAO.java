package com.neu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neu.bean.Office3_Info;
import com.neu.connect.DB_Con;


public class Office3_DAO {

	public List Office3Select(int staff_num,String staff_name) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		List<Office3_Info> office3 = new ArrayList<Office3_Info>();
		try {
			st = con.createStatement();
			String sql = "select * from SALARY_CHANGE  where 1=1";

			if(staff_num !=-1 )
			{
				sql += " and STAFF_NUM ='"
					+ staff_num + "' ";
			}
			if(!staff_name.equals(""))
			{
				sql +=  " and STAFF_NAME ='"+ staff_name + "' ";
			}
			
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Office3_Info off3 = new Office3_Info();
				off3.setStaff_num(rs.getInt("STAFF_NUM"));
				off3.setStaff_name(rs.getString("STAFF_NAME"));
				off3.setFormer(rs.getInt("FORMER"));
				off3.setPresent(rs.getInt("PRESENT"));
				if(rs.getDate("change_date")!=null)
				off3.setChangedate(rs.getDate("CHANGE_DATE").toString());
				
				office3.add(off3);
				

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		return office3;

	}
	public void Office3Delete(int staff_num){
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;

		try {
			st = con.createStatement();
			String sql = "delete from salary_change where staff_num ='"
				+ staff_num+ "' ";
			System.out.println(sql);
			st.executeUpdate(sql);
			System.out.println(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
	}

}
