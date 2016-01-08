package com.neu.dao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neu.bean.System1_Info;
import com.neu.connect.DB_Con;


public class System1_DAO {

	public List System1Select(String date1,String date2) {
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		List<System1_Info> sys1 = new ArrayList<System1_Info>();
		try {
			st = con.createStatement();
			String sql = "select * from sysbase where 1=1";

			if(!date1.equals(""))
			{
				sql +=  " and sys_date >= to_date('"+ date1 + "','yyyy-MM-dd') ";
			}
			if(!date2.equals(""))
			{
				sql +=  " and sys_date <= to_date('"+ date2 + "','yyyy-MM-dd') ";
			}
				
			
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System1_Info sys = new System1_Info();
				sys.setSysnum(rs.getInt("sys_num"));
				sys.setSysdmp(rs.getString("sys_dmp"));
				sys.setSyslog(rs.getString("sys_log"));
				if(rs.getDate("sys_date")!=null)
				sys.setSysdate(rs.getString("sys_date"));
				
				sys1.add(sys);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		return sys1;

	}
	public void System1Delete(int sysnum){
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		try {
			st = con.createStatement();
			String sqlselect = "select * from sysbase where sys_num='"+ sysnum +"'";
			rs = st.executeQuery(sqlselect);
			while(rs.next()){
				String deletedmp ="D:/BackupDatabase/"+rs.getString("sys_dmp")+"" ;
				File filedmp = new File(deletedmp);
				filedmp.delete();
				
				String deletelog = "D:/BackupDatabase/"+rs.getString("sys_log")+"" ;
				File filelog = new File(deletelog);
				filelog.delete();
				
			}
			String sql = "delete from sysbase where sys_num ='"
				+ sysnum+ "' ";

			System.out.println(sql);
			st.executeUpdate(sql);
			System.out.println(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
	}
	
	public void System1Insert(){
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式 
		SimpleDateFormat Format = new SimpleDateFormat("yyyyMMddhhmmss");
		String now = dateFormat.format( date );
		String backupname =Format.format(date);
		File saveFile = new File("D:/BackupDatabase");
		Runtime rt=Runtime.getRuntime();
		
		if (!saveFile.exists()) {// 如果目录不存在
			saveFile.mkdirs();// 创建文件夹
		}
		String backup="exp scott/tiger@oracle file=D:/BackupDatabase/"+backupname+".dmp log=D:/BackupDatabase/"+backupname+".log";
		try {
			Process process = null;
			process = rt.exec(backup);
			StreamGobbler  errorGobbler  =  new  StreamGobbler(process.getErrorStream(),  "ERROR");                                     
            //  kick  off  stderr  
            errorGobbler.start();  
            StreamGobbler  outGobbler  =  new  StreamGobbler(process.getInputStream(),  "STDOUT");  
            //  kick  off  stdout  
            outGobbler.start();  
			System.out.println(backup);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			st = con.createStatement();
			String sql = "insert into sysbase select max(sys_num)+1,'"+backupname+".dmp','"+backupname+".log',to_date('"+now+"','yyyy-MM-dd hh24:mi:ss') from sysbase";
			System.out.println(sql);
			st.executeUpdate(sql);
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
	}
	public void System1Reduction(String sysdmp,String syslog){
		Runtime rt=Runtime.getRuntime();
		String reduction = "imp scott/tiger@oracle file=D:/BackupDatabase/"+sysdmp+" log=D:/BackupDatabase/"+syslog+" ignore=y";
		try {
			Process process = null;
			process = rt.exec(reduction);
			StreamGobbler  errorGobbler  =  new  StreamGobbler(process.getErrorStream(),  "ERROR");                                     
            //  kick  off  stderr  
            errorGobbler.start();  
            StreamGobbler  outGobbler  =  new  StreamGobbler(process.getInputStream(),  "STDOUT");  
            //  kick  off  stdout  
            outGobbler.start();  
			System.out.println(reduction);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
