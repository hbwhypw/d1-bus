package com.tmtc.vo;

import java.util.Date;

import com.tmtc.po.LineOrder;

public class LineOrderVo extends LineOrder{
	private String city_name;
	private String line_name;
	private Date depart_time;
	private String station_name;
	private String order_status_name;
	public LineOrderVo() {	}
	public LineOrderVo(LineOrder lineOrder,String city_name, String line_name, Date depart_time, String station_name,
			String order_status_name) {
		super(lineOrder.getId(),lineOrder.getOrder_no(),lineOrder.getUser_id(),lineOrder.getCity_id(),lineOrder.getLine_id(),lineOrder.getTime_line_id(),
				lineOrder.getStation_id(),lineOrder.getOrder_time(),lineOrder.getOrder_status(),lineOrder.getOrder_exp(),
				lineOrder.getOrder_type(),lineOrder.getScan_time(),lineOrder.getIs_check());
		this.city_name = city_name;
		this.line_name = line_name;
		this.depart_time = depart_time;
		this.station_name = station_name;
		this.order_status_name = order_status_name;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getLine_name() {
		return line_name;
	}
	public void setLine_name(String line_name) {
		this.line_name = line_name;
	}
	public Date getDepart_time() {
		return depart_time;
	}
	public void setDepart_time(Date depart_time) {
		this.depart_time = depart_time;
	}
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}
	public String getOrder_status_name() {
		return order_status_name;
	}
	public void setOrder_status_name(String order_status_name) {
		this.order_status_name = order_status_name;
	}
	@Override
	public String toString() {
		return "LineOrderVo [city_name=" + city_name + ", line_name=" + line_name + ", depart_time=" + depart_time
				+ ", station_name=" + station_name + ", order_status_name=" + order_status_name + "]";
	}
}
