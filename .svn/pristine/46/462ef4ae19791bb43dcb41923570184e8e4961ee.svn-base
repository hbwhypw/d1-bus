package com.tmtc.vo;

import com.tmtc.po.ShopOrder;

public class ShopOrderVo extends ShopOrder{
	private String real_name;
	private String user_name;
	private String pro_name;
	private String city_name;
	private String order_status_name;
	private String pay_type_name;
	public ShopOrderVo() {	}
	public ShopOrderVo(ShopOrder shopOrder,String real_name,String user_name, String pro_name, String city_name, String order_status_name,
			String pay_type_name) {
		super(shopOrder.getId(),shopOrder.getUser_id(),shopOrder.getPro_id(),shopOrder.getCity_id(),shopOrder.getOrder_no(),
				shopOrder.getOrder_status(),shopOrder.getSub_order_no(),shopOrder.getPay_type(),shopOrder.getMoney(),
				shopOrder.getTransport_pay(),shopOrder.getConsignee(),shopOrder.getArea(),shopOrder.getAddress(),
				shopOrder.getMobile(),shopOrder.getTelephone(),shopOrder.getEmail(),shopOrder.getIs_bill(),shopOrder.getInvoice_title(),
				shopOrder.getInvoice_details(),shopOrder.getDelivery(),shopOrder.getRemark(),shopOrder.getOrder_time(),shopOrder.getIs_check(),shopOrder.getProduct());
		this.real_name = real_name;
		this.user_name = user_name;
		this.pro_name = pro_name;
		this.city_name = city_name;
		this.order_status_name = order_status_name;
		this.pay_type_name = pay_type_name;
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
	public String getPay_type_name() {
		return pay_type_name;
	}
	public void setPay_type_name(String pay_type_name) {
		this.pay_type_name = pay_type_name;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	@Override
	public String toString() {
		return "ShopOrderVo [real_name=" + real_name + ", user_name=" + user_name + ", pro_name=" + pro_name
				+ ", city_name=" + city_name + ", order_status_name=" + order_status_name + ", pay_type_name="
				+ pay_type_name + "]";
	}
}
