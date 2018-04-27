package com.tmtc.vo;

import com.tmtc.po.MoneyOrder;

public class MoneyOrderVo extends MoneyOrder{
	private String userName;
	private String realName;
	private String payTypeName;
	private String orderStatusName;
	private String companyName;
	public MoneyOrderVo() {	}
	public MoneyOrderVo(MoneyOrder moneyOrder,String realName, String userName, String payTypeName, String orderStatusName,String companyName) {
		super(moneyOrder.getId(),moneyOrder.getUserId(),moneyOrder.getCard_no(),moneyOrder.getOrder_no(),moneyOrder.getMoney(),
				moneyOrder.getPay_type(),moneyOrder.getOrder_status(),moneyOrder.getCreate_time());
		this.userName = userName;
		this.realName = realName;
		this.payTypeName = payTypeName;
		this.orderStatusName = orderStatusName;
		this.companyName = companyName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPayTypeName() {
		return payTypeName;
	}
	public void setPayTypeName(String payTypeName) {
		this.payTypeName = payTypeName;
	}
	public String getOrderStatusName() {
		return orderStatusName;
	}
	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Override
	public String toString() {
		return "MoneyOrderVo [userName=" + userName + ", realName=" + realName + ", payTypeName=" + payTypeName
				+ ", orderStatusName=" + orderStatusName + ", companyName=" + companyName + "]";
	}
}
