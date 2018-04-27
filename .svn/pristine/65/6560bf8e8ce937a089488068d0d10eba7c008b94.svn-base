package com.tmtc.vo;

import com.tmtc.po.Scan;

public class ScanVo extends Scan{
	private String userName;
	private String stationName;
	private String statusName;
	private String ischeckName;
	public ScanVo() {	}
	public ScanVo(Scan scan,String userName, String stationName, String statusName, String ischeckName) {
		super(scan.getId(),scan.getUser_id(),scan.getLinetime_id(),scan.getStation_id(),scan.getCreate_time(),scan.getStatus(),
				scan.getIs_check());
		this.userName = userName;
		this.stationName = stationName;
		this.statusName = statusName;
		this.ischeckName = ischeckName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getIscheckName() {
		return ischeckName;
	}
	public void setIscheckName(String ischeckName) {
		this.ischeckName = ischeckName;
	}
	@Override
	public String toString() {
		return "ScanVo [userName=" + userName + ", stationName=" + stationName + ", statusName=" + statusName
				+ ", ischeckName=" + ischeckName + "]";
	}
}
