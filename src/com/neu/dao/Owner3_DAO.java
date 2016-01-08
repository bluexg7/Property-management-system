package com.neu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neu.bean.Owner3_Info;
import com.neu.connect.DB_Con;


public class Owner3_DAO {

	public List Owner3Select(int comm_num,String comm_name) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		List<Owner3_Info> owner3 = new ArrayList<Owner3_Info>();
		try {
			st = con.createStatement();
			String sql = "select o.name,o.id_num,o.birthday,o.sex,o.hometown,o.tele from owner o,committee c where c.owner_num=o.owner_num";

			if(comm_num!=-1 )
			{
				sql += " and c.comm_num ='"
					+ comm_num + "' ";
			}
			if(!comm_name.equals(""))
			{
				sql +=  " and c.owner_name ='"+ comm_name + "' ";
			}
			
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Owner3_Info own3 = new Owner3_Info();
				own3.setComm_name(rs.getString("name"));
				own3.setId_num(rs.getString("id_num"));
				own3.setBirthday(rs.getDate("birthday").toString());
				own3.setComm_sex(rs.getString("sex"));
				own3.setHometown(rs.getString("hometown"));
				own3.setTele(rs.getString("tele"));
		
				owner3.add(own3);
				

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		return owner3;

	}
	public void Owner3Delete(String commname) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;

		try {
			st = con.createStatement();
			String sql = "delete from committee where  owner_name='" + commname
					+ "' ";
			st.executeUpdate(sql);
			System.out.println(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}

	}

	public void Owner3Insert( int comm_num,String owner_name,int owner_num) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;

		try {
			st = con.createStatement();
			String sql = "insert into committee values( '" + owner_num + "','"
					+ owner_name + "','" + comm_num
					+ "')";
			System.out.println(sql);
			st.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}

	}

}
