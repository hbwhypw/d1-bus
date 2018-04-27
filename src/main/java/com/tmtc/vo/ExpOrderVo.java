package com.tmtc.vo;

import com.tmtc.po.ExpOrder;

public class ExpOrderVo extends ExpOrder{
	private String real_name;
	private String user_name;
	private String pro_name;
	private String city_name;
	private String order_status_name;
	public ExpOrderVo() {	}
	public ExpOrderVo(ExpOrder expOrder,String real_name,String user_name, String pro_name, String city_name, String order_status_name) {
		super(expOrder.getId(),expOrder.getOrder_no(),expOrder.getUser_id(),expOrder.getCity_id(),expOrder.getPro_id(),
				expOrder.getSub_order_id(),expOrder.getCost_exp_score(),expOrder.getTransport_pay(),expOrder.getConsignee(),
				expOrder.getArea(),expOrder.getAddress(),expOrder.getTelephone(),expOrder.getMobile(),expOrder.getEmail(),
				expOrder.getDelivery(),expOrder.getRemark(),expOrder.getOrder_time(),expOrder.getIs_check(),expOrder.getProduct());
		this.real_name = real_name;
		this.user_name = user_name;
		this.pro_name = pro_name;
		this.city_name = city_name;
		this.order_status_name = order_status_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getOrder_status_name() {
		return order_status_name;
	}
	public void setOrder_status_name(String order_status_name) {
		this.order_status_name = order_status_name;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
}
