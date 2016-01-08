package com.neu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.neu.bean.Parking3_Info;
import com.neu.connect.DB_Con;

public class Parking3_DAO {
	public List<Parking3_Info> select( int record_num,int parking_num,String car_owner,String  start_time)
	{
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		List<Parking3_Info> list = new ArrayList<Parking3_Info>();
		try {
			st = con.createStatement();
			String sql = "select * from park_record where 1=1";//to_char(start_time,'yyyy-MM-dd')
		    if(record_num!=0){
			    sql += " and record_num=" +record_num;
			    }
		    if(parking_num!=0){
			    sql += " and parking_num=" +parking_num;
			    }
		    if(car_owner!=null&&!car_owner.equals("")){
		    	sql += " and car_owner='"+car_owner+"'";
		    }
		   
		    if(start_time!=null&&!start_time.equals("")){
		    	sql += " and to_char(start_time,'yyyy-MM-dd')>='" + start_time+"'";
		    }	
            System.out.println(sql);
		    rs = st.executeQuery(sql);
		      
		    while(rs.next()){
		    	Parking3_Info p3_info = new Parking3_Info();		    	
		    	p3_info.setRecord_num(rs.getInt("record_num"));	    	
		    	p3_info.setParking_num(rs.getString("parking_num"));		    	
		    	p3_info.setCar_owner(rs.getString("car_owner"));
		    	p3_info.setTele(rs.getString("tele"));	    	
 		    	p3_info.setStart_time(rs.getDate("start_time").toString());
		    	p3_info.setPlan_time(rs.getInt("plan_time"));
		    	p3_info.setCharge(rs.getInt("charge"));
		    	p3_info.setCharger(rs.getString("charger"));
		    	list.add(p3_info);
		    	
		    }
		    
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
		return  list;				
	}//select 2015.7.15
	
   public void delete(String record_num){
		
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		try {
			st = con.createStatement();
			String sql = "delete from park_record where record_num='"+record_num+"'";
			st.executeUpdate(sql);
		    
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
	}
   
   public void update(int  record_num,int parking_num,String  car_owner,String tele,String start_time,
			int  plan_time ,int charge,String charger){
		
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		
		try {
			Date date =new Date(sdf.parse(start_time).getTime());
			st = con.createStatement();
			String sql = "update park_record set plan_time='"+plan_time+"',charge='"+charge+"',charger='"+charger+"',"+"parking_num='"+parking_num + "',car_owner='" + car_owner + "',tele='" + tele
			+ "',start_time =to_date('"+date+"','yyyy-mm-dd')"+ " where record_num='"+record_num+"'"; 
			 
			System.out.println("update:"+sql);
			System.out.println("*************************************");
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
	}//

   public void insert(int record_num,int parking_num,String car_owner,String tele,String start_time,
			String plan_time,int charge,String charger){
		
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		try {
			st = con.createStatement();
			//Ìí¼Ó
			String sql = "insert into park_record(record_num,parking_num,car_owner,tele,start_time, plan_time, charge,charger) values(" 
				+ "'" + record_num + "','" + parking_num + "','" + car_owner + "','" + tele + "'," + "to_date('"+start_time+"','yyyy-mm-dd')"+ ",'"+plan_time+"','"+charge 
				+ "','" + charger + "'" + ")"; 
			System.out.println(sql);
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
	}
	
}
