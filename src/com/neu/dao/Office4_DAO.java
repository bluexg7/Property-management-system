package com.neu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neu.bean.Office4_Info;
import com.neu.connect.DB_Con;


public class Office4_DAO {

	public List Office4Select(int train_num,String train_date) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		List<Office4_Info> office4 = new ArrayList<Office4_Info>();
		try {
			st = con.createStatement();
			String sql = "select * from train  where 1=1";

			if(train_num !=-1 )
			{
				sql += " and train_num ='"
					+ train_num + "' ";
			}
			if(!train_date.equals(""))
			{
				sql +=  " and to_char(train_date,'yyyy-mm-dd') ='"+ train_date + "' ";
			}
			
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Office4_Info off4 = new Office4_Info();
				off4.setTrain_num(rs.getInt("TRAIN_NUM"));
				if(rs.getDate("train_date")!=null)
				off4.setTrain_date(rs.getDate("train_date").toString());
				off4.setContent(rs.getString("content"));
				
				
				office4.add(off4);
				

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		return office4;

	}
	public void Office4Delete(int train_num){
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;

		try {
			st = con.createStatement();
			String sql = "delete from train where train_num ='"
				+ train_num+ "' ";
			st.executeUpdate(sql);
			System.out.println(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
	}
	
	public void Office4Insert(int train_num,String content,String date){
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		try {
			st = con.createStatement();
			String sql = "insert into train values( " 
				+ "'" + train_num + "',to_date('" + date + "','yyyy-MM-dd'),'" + content + "')" ;
			System.out.println(sql);
			st.executeUpdate(sql);
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
	}
	public void Office4Update(int train_num,String content,String date){
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null; 		
		try {
			st = con.createStatement();
			String sql = "update train set content='"+content+"',train_date = to_date('"+date+"','yyyy-MM-dd') where train_num = '" + train_num + "'" ;
			System.out.println(sql);
			st.executeUpdate(sql);
						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
		
	}

}
