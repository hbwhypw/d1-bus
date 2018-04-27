package com.tmtc.po;

import java.util.Date;

public class ShopOrder {
	private String id;

	private String user_id;

	private String pro_id;

	private Integer city_id;

	private String order_no;

	private Integer order_status;

	private String sub_order_no;

	private Integer pay_type;

	private Double money;

	private Double transport_pay;

	private String consignee;

	private String area;

	private String address;

	private String mobile;

	private String telephone;

	private String email;

	private Integer is_bill;

	private String invoice_title;

	private String invoice_details;

	private Integer delivery;

	private String remark;

	private Date order_time;

	private Integer is_check;

	private Product product;
	public ShopOrder() {
	}

	public ShopOrder(String id, String user_id, String pro_id, Integer city_id, String order_no, Integer order_status,
			String sub_order_no, Integer pay_type, Double money, Double transport_pay, String consignee, String area,
			String address, String mobile, String telephone, String email, Integer is_bill, String invoice_title,
			String invoice_details, Integer delivery, String remark, Date order_time, Integer is_check) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.pro_id = pro_id;
		this.city_id = city_id;
		this.order_no = order_no;
		this.order_status = order_status;
		this.sub_order_no = sub_order_no;
		this.pay_type = pay_type;
		this.money = money;
		this.transport_pay = transport_pay;
		this.consignee = consignee;
		this.area = area;
		this.address = address;
		this.mobile = mobile;
		this.telephone = telephone;
		this.email = email;
		this.is_bill = is_bill;
		this.invoice_title = invoice_title;
		this.invoice_details = invoice_details;
		this.delivery = delivery;
		this.remark = remark;
		this.order_time = order_time;
		this.is_check = is_check;
	}
	
	public ShopOrder(String id, String user_id, String pro_id, Integer city_id, String order_no, Integer order_status,
			String sub_order_no, Integer pay_type, Double money, Double transport_pay, String consignee, String area,
			String address, String mobile, String telephone, String email, Integer is_bill, String invoice_title,
			String invoice_details, Integer delivery, String remark, Date order_time, Integer is_check,Product product) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.pro_id = pro_id;
		this.city_id = city_id;
		this.order_no = order_no;
		this.order_status = order_status;
		this.sub_order_no = sub_order_no;
		this.pay_type = pay_type;
		this.money = money;
		this.transport_pay = transport_pay;
		this.consignee = consignee;
		this.area = area;
		this.address = address;
		this.mobile = mobile;
		this.telephone = telephone;
		this.email = email;
		this.is_bill = is_bill;
		this.invoice_title = invoice_title;
		this.invoice_details = invoice_details;
		this.delivery = delivery;
		this.remark = remark;
		this.order_time = order_time;
		this.is_check = is_check;
		this.product = product;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPro_id() {
		return pro_id;
	}

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	public Integer getCity_id() {
		return city_id;
	}

	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public Integer getOrder_status() {
		return order_status;
	}

	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}

	public String getSub_order_no() {
		return sub_order_no;
	}

	public void setSub_order_no(String sub_order_no) {
		this.sub_order_no = sub_order_no;
	}

	public Integer getPay_type() {
		return pay_type;
	}

	public void setPay_type(Integer pay_type) {
		this.pay_type = pay_type;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Double getTransport_pay() {
		return transport_pay;
	}

	public void setTransport_pay(Double transport_pay) {
		this.transport_pay = transport_pay;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIs_bill() {
		return is_bill;
	}

	public void setIs_bill(Integer is_bill) {
		this.is_bill = is_bill;
	}

	public String getInvoice_title() {
		return invoice_title;
	}

	public void setInvoice_title(String invoice_title) {
		this.invoice_title = invoice_title;
	}

	public String getInvoice_details() {
		return invoice_details;
	}

	public void setInvoice_details(String invoice_details) {
		this.invoice_details = invoice_details;
	}

	public Integer getDelivery() {
		return delivery;
	}

	public void setDelivery(Integer delivery) {
		this.delivery = delivery;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getOrder_time() {
		return order_time;
	}

	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}

	public Integer getIs_check() {
		return is_check;
	}

	public void setIs_check(Integer is_check) {
		this.is_check = is_check;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ShopOrder [id=" + id + ", user_id=" + user_id + ", pro_id=" + pro_id + ", city_id=" + city_id
				+ ", order_no=" + order_no + ", order_status=" + order_status + ", sub_order_no=" + sub_order_no
				+ ", pay_type=" + pay_type + ", money=" + money + ", transport_pay=" + transport_pay + ", consignee="
				+ consignee + ", area=" + area + ", address=" + address + ", mobile=" + mobile + ", telephone="
				+ telephone + ", email=" + email + ", is_bill=" + is_bill + ", invoice_title=" + invoice_title
				+ ", invoice_details=" + invoice_details + ", delivery=" + delivery + ", remark=" + remark
				+ ", order_time=" + order_time + ", is_check=" + is_check + "]";
	}
}