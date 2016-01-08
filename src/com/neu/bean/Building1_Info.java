package com.neu.bean;

public class Building1_Info {

	public String com_name = null;
	public String build_num = null;
	public String unit_num = null;
	public String room_num = null;
	public int floor = 0;
	public int room_size = 0;
	public int price = 0;
	public String layout = null;
	public String sale_state = null;
	
	
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
	public int getFloor() {
		return floor;
	}
	public int getRoom_size() {
		return room_size;
	}
	public int getPrice() {
		return price;
	}
	public String getLayout() {
		return layout;
	}
	public String getSale_state() {
		return sale_state;
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
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public void setRoom_size(int roomSize) {
		room_size = roomSize;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setLayout(String layout) {
		this.layout = layout;
	}
	public void setSale_state(String saleState) {
		sale_state = saleState;
	}
	
	
}
