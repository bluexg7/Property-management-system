package com.neu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neu.bean.Owner1_Info;
import com.neu.connect.DB_Con;


public class Owner1_DAO {

	public List Owner1Select(String owner_name,String owner_sex) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		List<Owner1_Info> owner1 = new ArrayList<Owner1_Info>();
		try {
			st = con.createStatement();
			String sql = "select * from owner where 1=1";

			if(!owner_name.equals("") )
			{
				sql += " and name ='"
					+ owner_name + "' ";
			}
			if(!owner_sex.equals(""))
			{
				sql +=  " and sex ='"+ owner_sex + "' ";
			}
			
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Owner1_Info own1 = new Owner1_Info();
				own1.setOwner_num(rs.getInt("owner_num"));
				own1.setOwner_name(rs.getString("name"));
				own1.setId_num(rs.getString("id_num"));
				own1.setBirthday(rs.getDate("birthday").toString());
				own1.setOwner_sex(rs.getString("sex"));
				own1.setHometown(rs.getString("hometown"));
				own1.setTele(rs.getString("tele"));
				own1.setPopulation(rs.getInt("population"));
		
				owner1.add(own1);
				

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		return owner1;

	}
	public void Owner1Delete(String owner_num) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;

		try {
			st = con.createStatement();
			String sql = "delete from owner where owner_num ='" + owner_num
					+ "' ";
			st.executeUpdate(sql);
			System.out.println(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}

	}

	public void Owner1Insert( int ownernum,String ownername, String idnum,String  birthday,String sex,String hometown,String tel,int population ) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;

		try {
			st = con.createStatement();
			String sql = "insert into owner values( '" + ownernum + "','"
					+ ownername + "','" + idnum
					+ "','" + sex
					+ "',to_date('" + birthday + "','yyyy-MM-dd'),'" + hometown
					+ "','" + tel + "','" + population + "')";
			System.out.println(sql);
			st.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}

	}

	public void Owner1Update(int ownernum,String ownername, String idnum,String  birthday,String sex,String hometown,String tel,int population ) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		try {
			st = con.createStatement();
			String sql = "update owner set name='" + ownername
					+ "',id_num='" + idnum
					+ "',sex='" + sex
					+ "',birthday= to_date('" + birthday
					+ "','yyyy-MM-dd') ,hometown='" + hometown
					+ "',tele='" + tel
					+ "',population='" + population
					+ "'where owner_num = '" + ownernum + "'";
			System.out.println(sql);
			st.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}

	}


}
