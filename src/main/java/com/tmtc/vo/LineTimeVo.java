package com.tmtc.vo;

import java.util.Date;

import com.tmtc.po.LineTime;

public class LineTimeVo extends LineTime {

	private String line_name;

	private String real_name;

	private String car_num;
	
	private String driving_state_name ;
	
	private String line_station_sort_name;

	public LineTimeVo() {
		super();
	}

	public LineTimeVo(LineTime l, String line_name, String real_name, String car_num,String driving_state_name,String line_station_sort_name) {
		super(l.getId(), l.getLine_id(), l.getDriver_id(), l.getCar_id(), l.getDepart_time(), l.getDepart_hour(),
				l.getArrival_time(), l.getDriving_state(), l.getLine_station_sort(), l.getRemark(), l.getCreate_time(),
				l.getIs_check());
		this.line_name = line_name;
		this.real_name = real_name;
		this.car_num = car_num;
		this.driving_state_name = driving_state_name;
		this.line_station_sort_name = line_station_sort_name;
	}

	public LineTimeVo(String id, String line_id, String driver_id, String car_id, Date depart_time, Date depart_hour,
			Date arrival_time, Integer driving_state, Integer line_station_sort, String remark, Date create_time,
			Integer is_check) {
		super(id, line_id, driver_id, car_id, depart_time, depart_hour, arrival_time, driving_state, line_station_sort,
				remark, create_time, is_check);
	}

	public String getLine_name() {
		return line_name;
	}

	public void setLine_name(String line_name) {
		this.line_name = line_name;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public String getCar_num() {
		return car_num;
	}

	public void setCar_num(String car_num) {
		this.car_num = car_num;
	}

	public String getDriving_state_name() {
		return driving_state_name;
	}

	public void setDriving_state_name(String driving_state_name) {
		this.driving_state_name = driving_state_name;
	}

	public String getLine_station_sort_name() {
		return line_station_sort_name;
	}

	public void setLine_station_sort_name(String line_station_sort_name) {
		this.line_station_sort_name = line_station_sort_name;
	}

	@Override
	public String toString() {
		return "LineTimeVo [line_name=" + line_name + ", real_name=" + real_name + ", car_num=" + car_num + "]";
	}
}
