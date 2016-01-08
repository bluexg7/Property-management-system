package com.neu.dao;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.neu.bean.Document1_Info;
import com.neu.bean.Parking3_Info;
import com.neu.connect.DB_Con;

public class Document1_DAO {
     
	public List<Document1_Info> select(int doc_num,String doc_title,String start_time,String end_time, String upload_person)
	{
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		List<Document1_Info> list = new ArrayList<Document1_Info>();
		try {
			st = con.createStatement();
			String sql = "select * from document where 1=1";//to_char(start_time,'yyyy-MM-dd')
		    if(doc_num!=0){
			    sql += " and doc_num=" +doc_num;
			    }
	
		    if(doc_title!=null&&!doc_title.equals("")){
		    	sql += " and doc_title='"+doc_title+"'";
		    }
		    
		    if(start_time!=null&&!start_time.equals("")){
		    	sql += " and to_char(upload_date,'yyyy-MM-dd HH24:mi:ss')>='"+start_time+"'";
		    }
		    if(end_time!=null&&!end_time.equals("")){
		    	sql += " and to_char(upload_date,'yyyy-MM-dd HH24:mi:ss')<='"+end_time+"'";
		    }
		    if(upload_person!=null&&!upload_person.equals("")){
		    	sql += " and upload_person='"+upload_person+"'";
		    }
		    sql+=" order by doc_num";
            System.out.println(sql);
		    rs = st.executeQuery(sql);
		      
		    while(rs.next()){
		    	Document1_Info d1_info = new Document1_Info();		    	
		    	d1_info.setDoc_num(rs.getInt("doc_num"));	    	
		    	d1_info.setDoc_title(rs.getString("doc_title"));	    	
		    	d1_info.setUpload_date(rs.getString("upload_date"));
		    	d1_info.setUpload_person(rs.getString("upload_person"));	    			    
		    	list.add(d1_info);
		    	
		    }
		    
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
		return  list;				
	}//select 2015.7.18
	
	 public void insert(String doc_path,String doc_title,String upload_person,String realpath){
		
		 Connection con = DB_Con.getCon();
	     ResultSet rs = null;
	     Statement st = null;
	     File uploadFile;//得到上传的文件
	     String uploadFileName;//得到文件的名称
         String upload_date;
         try {
				st = con.createStatement();
				//添加
				String querySql="select max(doc_num) num from document";
				rs=st.executeQuery(querySql);
				int max=1000;
				while(rs.next())
				{   
					if(rs.getInt("num")==0)
			        break;
					max=rs.getInt("num")+1;
					System.out.println("max:"+max);
					
				}
				Date date=new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式 
			    upload_date=dateFormat.format(date);
			   
				String sql = "insert into document (doc_num,upload_date,upload_person,doc_title) values(" 
					+ "'" +max+ "'," +"to_date('"+upload_date+"','yyyy/mm/dd HH24:mi:ss')"+",'"+upload_person+ "','" +doc_title+"')"; 							    
				System.out.println(sql);
				st.executeUpdate(sql);
				uploadFileName=String.valueOf(max)+"@"+doc_title;
				
			    File file = new File(realpath);
			    if(!file.exists()) file.mkdirs();
			    uploadFile=new File(doc_path);
			    FileUtils.copyFile(uploadFile, new File(file, uploadFileName));
			    
			    
			    
			    System.out.println("存放的文件为:"+uploadFileName);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DB_Con.close(rs, st, con);
			
			}
		 
	 }
	 //2015.7.18
	 public void delete(String doc_num){
			
			Connection con = DB_Con.getCon();
			ResultSet rs = null;
			Statement st = null;
			
			try {
				st = con.createStatement();
				
				String sqlQuery="select doc_title from document where doc_num='"+doc_num+"'";
				rs=st.executeQuery(sqlQuery);
				while(rs.next()){
					String filename=rs.getString("doc_title");
					String path="C:\\tomcat-6.0.14\\webapps\\MyProject\\upload\\"+String.valueOf(doc_num)+"@"+filename;
					System.out.println("path"+path);
					File  deledFile=new File(path);
					deledFile.delete();
				}
				String sql = "delete from document where doc_num='"+doc_num+"'";				
				st.executeUpdate(sql);
			    
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DB_Con.close(rs, st, con);
			}
			
		}

	 public void update(int doc_num,String doc_title,String person){
			
			Connection con = DB_Con.getCon();
			ResultSet rs = null;
			Statement st = null;	
			try {
		
				st = con.createStatement();
				String sql = "update document set doc_title='"+doc_title+"',upload_person='"+person+"' where doc_num='"+doc_num+"'"; 
				 
				System.out.println("update:"+sql);
				System.out.println("*************************************");
				st.executeUpdate(sql);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DB_Con.close(rs, st, con);
			}
			
		}//

}
