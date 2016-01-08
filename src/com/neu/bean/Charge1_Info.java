package com.neu.bean;

public class Charge1_Info {
	public String com_name = null;
	public String build_num = null;
	public String unit_num = null;
	public String room_num = null;
	public String charge_lasdate=null;	
	public String charge_date = null;
	public int charge_price = 0;
	public String charge_type = null;
	public String charge_num = null;
	
	public String getCom_name() {
		return com_name;
	}
	public String getBuild_num() {
		return build_num;
	}
	public String getUnit_num() {
		return unit_num;
	}
	public String getRoom_num() {
		return room_num;
	}
	public String getCharge_lasdate() {
		return charge_lasdate;
	}
	public String getCharge_date() {
		return charge_date;
	}
	public int getCharge_price() {
		return charge_price;
	}
	public String getCharge_type() {
		return charge_type;
	}
	public String getCharge_num() {
		return charge_num;
	}
	
	
	public void setBuild_num(String buildNum) {
		build_num = buildNum;
	}
	public void setUnit_num(String unitNum) {
		unit_num = unitNum;
	}
	public void setRoom_num(String roomNum) {
		room_num = roomNum;
	}
	public void setCom_name(String comName) {
		com_name = comName;
	}
	public void setCharge_lasdate(String charge_lasdate ) {
		this.charge_lasdate = charge_lasdate;
	}
	public void setCharge_date(String charge_date) {
		this.charge_date = charge_date;
	}
	public void setCharge_price(int charge_price) {
		this.charge_price = charge_price;
	}
	public void setCharge_type(String charge_type) {
		this.charge_type = charge_type;
	}
	public void setCharge_num(String charge_num) {
		this.charge_num = charge_num;
	}
}
