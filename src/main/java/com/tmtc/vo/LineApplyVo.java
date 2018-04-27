package com.tmtc.vo;

import com.tmtc.po.LineApply;

public class LineApplyVo extends LineApply{
	private String realName;
	private String departRate;
	private String cityName;
	private String time;
	public LineApplyVo() {	}
	public LineApplyVo(LineApply lineApply, String realName, String departRate, String cityName,String time) {
		super(lineApply.getId(),lineApply.getUser_id(),lineApply.getCity_id(),lineApply.getStart_station(),
				lineApply.getEnd_station(),lineApply.getDepart_time(),lineApply.getDepart_rate(),lineApply.getCommite_time(),
				lineApply.getUpdate_time(),lineApply.getIs_check());
		this.realName = realName;
		this.departRate = departRate;
		this.cityName = cityName; 
		this.time = time;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getDepartRate() {
		return departRate;
	}
	public void setDepartRate(String departRate) {
		this.departRate = departRate;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "LineApplyVo [realName=" + realName + ", departRate=" + departRate + ", cityName=" + cityName + ", time="
				+ time + "]";
	}
}
