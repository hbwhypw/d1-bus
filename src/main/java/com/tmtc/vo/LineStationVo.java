package com.tmtc.vo;

import com.tmtc.po.LineStation;

public class LineStationVo extends LineStation {

	private String line_name;
	
	private String prev_name;
	
	private String next_name;
	
	private String line_path;

	public LineStationVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LineStationVo(LineStation ls, String line_name, String prev_name, String next_name) {
		super(ls.getId(), ls.getLine_id(), ls.getStation_name(), ls.getNext_time(), ls.getNext_km(), ls.getPrev_id(),
				ls.getNext_id(), ls.getX_point(), ls.getY_point(), ls.getQrcode(), ls.getSort(), ls.getWillnum(),
				ls.getCreate_time(), ls.getIs_check());
		this.line_name = line_name;
		this.prev_name = prev_name;
		this.next_name = next_name;
	}

	public String getLine_name() {
		return line_name;
	}

	public void setLine_name(String line_name) {
		this.line_name = line_name;
	}

	public String getPrev_name() {
		return prev_name;
	}

	public void setPrev_name(String prev_name) {
		this.prev_name = prev_name;
	}

	public String getNext_name() {
		return next_name;
	}

	public void setNext_name(String next_name) {
		this.next_name = next_name;
	}
	
	public String getLine_path() {
		return line_path;
	}

	public void setLine_path(String line_path) {
		this.line_path = line_path;
	}

	@Override
	public String toString() {
		return "LineStationVo [line_name=" + line_name + ", prev_name=" + prev_name + ", next_name=" + next_name
				+ ", toString()=" + super.toString() + "]";
	}

}
