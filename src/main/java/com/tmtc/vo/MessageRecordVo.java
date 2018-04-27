package com.tmtc.vo;

import com.tmtc.po.MessageRecord;

public class MessageRecordVo extends MessageRecord{
	private String messageName;
	private String adminName;
	private String userName;
	private String isCheckName;
	public MessageRecordVo() {	}
	public MessageRecordVo(MessageRecord messageRecord,String messageName, String adminName, String userName, String isCheckName) {
		super(messageRecord.getId(),messageRecord.getMessage_id(),messageRecord.getAdmin_id(),messageRecord.getUser_id(),
				messageRecord.getSend_time(),messageRecord.getIs_check());
		this.messageName = messageName;
		this.adminName = adminName;
		this.userName = userName;
		this.isCheckName = isCheckName;
	}
	public String getMessageName() {
		return messageName;
	}
	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIsCheckName() {
		return isCheckName;
	}
	public void setIsCheckName(String isCheckName) {
		this.isCheckName = isCheckName;
	}
	@Override
	public String toString() {
		return "MessageRecordVo [messageName=" + messageName + ", adminName=" + adminName + ", userName=" + userName
				+ ", isCheckName=" + isCheckName + "]";
	}
}
