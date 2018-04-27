package com.tmtc.vo;

import com.tmtc.po.Line;

public class LineVo extends Line {

	private String lineStationBeginName;

	private String lineStationEndName;

	private String lineStation;

	private String city_name;

	private String company_name;

	private String line_category_name;

	private String line_type_name;

	private String user_type_name;

	public LineVo() {
	}

	public LineVo(Line line,String lineStationBeginName, String lineStationEndName, String lineStation, String city_name,
			String company_name, String line_category_name, String line_type_name, String user_type_name) {
		super(line.getId(), line.getLine_name(), line.getStart_id(), line.getEnd_id(),line.getPrice(), line.getKm(),
				line.getOn_time_rate(), line.getCity_id(), line.getCompany_id(), line.getLine_category(),
				line.getLine_type(), line.getUser_type(), line.getStart_time(), line.getEnd_time(), line.getSort(),
				line.getRemark(), line.getCreate_time(), line.getIs_check(), line.getLine_path());
		this.lineStationBeginName = lineStationBeginName;
		this.lineStationEndName = lineStationEndName;
		this.lineStation = lineStation;
		this.city_name = city_name;
		this.company_name = company_name;
		this.line_category_name = line_category_name;
		this.line_type_name = line_type_name;
		this.user_type_name = user_type_name;
	}

	public String getLineStationBeginName() {
		return lineStationBeginName;
	}

	public void setLineStationBeginName(String lineStationBeginName) {
		this.lineStationBeginName = lineStationBeginName;
	}

	public String getLineStationEndName() {
		return lineStationEndName;
	}

	public void setLineStationEndName(String lineStationEndName) {
		this.lineStationEndName = lineStationEndName;
	}

	public String getLineStation() {
		return lineStation;
	}

	public void setLineStation(String lineStation) {
		this.lineStation = lineStation;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getLine_category_name() {
		return line_category_name;
	}

	public void setLine_category_name(String line_category_name) {
		this.line_category_name = line_category_name;
	}

	public String getLine_type_name() {
		return line_type_name;
	}

	public void setLine_type_name(String line_type_name) {
		this.line_type_name = line_type_name;
	}

	public String getUser_type_name() {
		return user_type_name;
	}

	public void setUser_type_name(String user_type_name) {
		this.user_type_name = user_type_name;
	}

	@Override
	public String toString() {
		return "LineVo [lineStationBeginName=" + lineStationBeginName + ", lineStationEndName=" + lineStationEndName
				+ ", city_name=" + city_name + ", company_name=" + company_name + ", line_category_name="
				+ line_category_name + ", line_type_name=" + line_type_name + ", user_type_name=" + user_type_name
				+ ", lineStation=" + lineStation + "]";
	}

}
