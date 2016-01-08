package com.neu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neu.bean.Office2_Info;
import com.neu.connect.DB_Con;


public class Office2_DAO {

	public List Office2Select(int staff_num,String staff_name,String office_num,String department,int salary1,int salary2) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		List<Office2_Info> office2 = new ArrayList<Office2_Info>();
		try {
			st = con.createStatement();
			String sql = "select s.staff_num,s.staff_name,s.depart_name,s.age,s.hometown,s.salary,s.tele from STAFF s ,DEPARTMENT d where s.depart_name=d.depart_name";

			if(staff_num !=-1 )
			{
				sql += " and s.STAFF_NUM ='"
					+ staff_num + "' ";
			}
			if(!staff_name.equals(""))
			{
				sql +=  " and s.STAFF_NAME ='"+ staff_name + "' ";
			}
			if(!office_num.equals(""))
			{
				sql += " and d.office_num='" + office_num + "'";
			}
			if(!department.equals("0"))
			{
				sql += " and s.depart_name = '"+ department +"'";
			}
			
			if(salary1!= -1 && salary2!=-1)				
			sql += " and s.salary between '"+ salary1+"'"+" and '"+ salary2 +"'" ;
			else if (salary1 == -1 && salary2!=-1)
			{
				sql += " and s.salary between '0'"+" and '"+ salary2 +"'" ;
			}
			else if(salary1!=-1 && salary2==-1)
			{
				sql += " and s.salary >= '"+ salary1 +"'" ;
			}
				
			
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Office2_Info off2 = new Office2_Info();
				off2.setStaff_num(rs.getInt("STAFF_NUM"));
				off2.setStaff_name(rs.getString("STAFF_NAME"));
				off2.setDepart_name(rs.getString("DEPART_NAME"));
				off2.setStaff_age(rs.getInt("AGE"));
				off2.setStaff_hometown(rs.getString("HOMETOWN"));
				off2.setSalary(rs.getInt("SALARY"));
				off2.setTel(rs.getString("TELE"));
				
				office2.add(off2);
				

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		return office2;

	}
	public void Office2Delete(int staff_num){
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;

		try {
			st = con.createStatement();
			String sql = "delete from staff where staff_num ='"
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
	
	public void Office2Insert(int staff_num,String staff_name,String department,int age,String hometown,int salary,String tel){
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		try {
			st = con.createStatement();
			String sql = "insert into staff values(" 
				+ "'" + staff_num + "','" + staff_name + "','" + age + "','" + hometown + "','" + department + "','" + salary 
				+ "','"+tel+"')" ;
			System.out.println(sql);
			st.executeUpdate(sql);
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
	}
	public void Office2Update(int staff_num,String staff_name,String depart,int age,String hometown,int presalary, int salary,String tel){
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式 
		String now = dateFormat.format( date ); 		
		try {
			st = con.createStatement();
			String sql = "update staff set staff_name='" + staff_name + "',depart_name='" + depart + "',age='" + age 
			+ "',hometown='"+hometown+"',salary='"+salary+"',tele='"+tel+"' where staff_num = '" + staff_num + "'" ;
			String sqlinsert ="insert into salary_change values(" 
				+ "'" + staff_num + "','" + staff_name + "','" + presalary + "','" + salary + "',to_date('" + now + "','yyyy-MM-dd'))";
			System.out.println(sqlinsert);
			st.executeUpdate(sql);
			
			if(presalary!=salary)
			st.executeUpdate(sqlinsert);
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
		
	}

}
