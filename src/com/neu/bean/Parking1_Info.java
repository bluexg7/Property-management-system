package com.neu.bean;

public class Parking1_Info {
	public String getParklot_num() {
		return parklot_num;
	}
	public void setParklot_num(String parklotNum) {
		parklot_num = parklotNum;
	}
	public String getParklot_name() {
		return parklot_name;
	}
	public void setParklot_name(String parklotName) {
		parklot_name = parklotName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getMaxinum() {
		return maxinum;
	}
	public void setMaxinum(int maxinum) {
		this.maxinum = maxinum;
	}
	public int getCharge() {
		return charge;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
	public String parklot_num = null;
	public String parklot_name = null;
	public String location =null;
	public int  maxinum = 0;
	public int charge =0;
}
