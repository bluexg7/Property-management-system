package com.neu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.neu.bean.Office5_Info;
import com.neu.connect.DB_Con;


public class Office5_DAO {

	public List Office5Select(int staff_num,String exam_name) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		List<Office5_Info> office5 = new ArrayList<Office5_Info>();
		try {
			st = con.createStatement();
			String sql = "select e.exam_num, f.staff_name,e.exam_name,e.grade,e.exam_date from exam e,staff f where e.staff_num=f.staff_num";

			if(staff_num !=-1 )
			{
				sql += " and e.staff_num ='"
					+ staff_num + "' ";
			}
			if(!exam_name.equals(""))
			{
				sql +=  " and e.exam_name ='"+ exam_name + "' ";
			}
			
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Office5_Info off5 = new Office5_Info();
				off5.setExam_num(rs.getInt("exam_num"));
				off5.setExam_name(rs.getString("exam_name"));
				off5.setStaff_name(rs.getString("staff_name"));
				off5.setGrade(rs.getInt("grade"));
				if(rs.getDate("exam_date")!=null)
				off5.setExam_date(rs.getDate("exam_date").toString());
							
				office5.add(off5);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		return office5;

	}
	public void Office5Delete(int staff_num){
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;

		try {
			st = con.createStatement();
			String sql = "delete from exam where exam_num ='"
				+ staff_num+ "' ";
			st.executeUpdate(sql);
			System.out.println(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
	}
	
	public void Office5Insert(int exam_num,String staff_name,String exam_name,int grade,String date){
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		try {
			st = con.createStatement();
			String sql = "insert into exam select " 
				+ "'" + exam_num + "','" + exam_name + "', staff_num ,to_date('" + date + "','yyyy-MM-dd'),'" + grade + "'from staff where staff_name='"+staff_name+"'" ;
			System.out.println(sql);
			st.executeUpdate(sql);
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
	}
	public void Office5Update(int exam_num,String staff_name,String exam_name,int grade,String date){
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null; 		
		try {
			st = con.createStatement();
			String sql = "update exam set grade='"+grade+"'where exam_num = '" + exam_num + "'" ;
			System.out.println(sql);
			st.executeUpdate(sql);
						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
		
	}

}
