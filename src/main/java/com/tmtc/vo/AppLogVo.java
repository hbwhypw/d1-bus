package com.tmtc.vo;

import com.tmtc.po.AppLog;

public class AppLogVo extends AppLog{
	private String userName;
	public AppLogVo() {	}
	public AppLogVo(AppLog appLog,String userName) {
		super(appLog.getId(),appLog.getParam(),appLog.getName(),appLog.getUser_id(),appLog.getIp(),appLog.getCreate_time());
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "AppLogVo [userName=" + userName + "]";
	}
}
