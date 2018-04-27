package com.tmtc.po;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.internal.NotNull;

public class Car {

	private String id;

	@NotNull
	@NotEmpty
	private String car_num;

	@NotNull
	private Integer seat;

	@NotNull
	private Integer total_seat;

	@NotNull
	private Integer car_type;

	private String car_brand;

	@NotNull
	@NotEmpty
	private String device;

	private String phone;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date buy_date;
	
	@NotNull
	private Integer from_company;
	
	@NotNull
	@NotEmpty
	private String imei;

	private String car_pic;

	private String car_registration_pic;

	private String appearance_pic;

	private String trim_pic;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date insure_end_date;
	
	private Integer car_status;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date inspection_date;

	private Integer is_check;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date create_time;

	private String remark;

	public Car() {
	}

	public Car(String id, String car_num, Integer seat, Integer total_seat, Integer car_type, String car_brand,
			String device, String phone, Date buy_date, Integer from_company, String imei, String car_pic,
			String car_registration_pic, String appearance_pic, String trim_pic, Date insure_end_date,
			Integer car_status, Date inspection_date, Integer is_check, Date create_time, String remark) {
		super();
		this.id = id;
		this.car_num = car_num;
		this.seat = seat;
		this.total_seat = total_seat;
		this.car_type = car_type;
		this.car_brand = car_brand;
		this.device = device;
		this.phone = phone;
		this.buy_date = buy_date;
		this.from_company = from_company;
		this.imei = imei;
		this.car_pic = car_pic;
		this.car_registration_pic = car_registration_pic;
		this.appearance_pic = appearance_pic;
		this.trim_pic = trim_pic;
		this.insure_end_date = insure_end_date;
		this.car_status = car_status;
		this.inspection_date = inspection_date;
		this.is_check = is_check;
		this.create_time = create_time;
		this.remark = remark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCar_num() {
		return car_num;
	}

	public void setCar_num(String car_num) {
		this.car_num = car_num;
	}

	public Integer getSeat() {
		return seat;
	}

	public void setSeat(Integer seat) {
		this.seat = seat;
	}

	public Integer getTotal_seat() {
		return total_seat;
	}

	public void setTotal_seat(Integer total_seat) {
		this.total_seat = total_seat;
	}

	public Integer getCar_type() {
		return car_type;
	}

	public void setCar_type(Integer car_type) {
		this.car_type = car_type;
	}

	public String getCar_brand() {
		return car_brand;
	}

	public void setCar_brand(String car_brand) {
		this.car_brand = car_brand;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBuy_date() {
		return buy_date;
	}

	public void setBuy_date(Date buy_date) {
		this.buy_date = buy_date;
	}

	public Integer getFrom_company() {
		return from_company;
	}

	public void setFrom_company(Integer from_company) {
		this.from_company = from_company;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getCar_pic() {
		return car_pic;
	}

	public void setCar_pic(String car_pic) {
		this.car_pic = car_pic;
	}

	public String getCar_registration_pic() {
		return car_registration_pic;
	}

	public void setCar_registration_pic(String car_registration_pic) {
		this.car_registration_pic = car_registration_pic;
	}

	public String getAppearance_pic() {
		return appearance_pic;
	}

	public void setAppearance_pic(String appearance_pic) {
		this.appearance_pic = appearance_pic;
	}

	public String getTrim_pic() {
		return trim_pic;
	}

	public void setTrim_pic(String trim_pic) {
		this.trim_pic = trim_pic;
	}

	public Date getInsure_end_date() {
		return insure_end_date;
	}

	public void setInsure_end_date(Date insure_end_date) {
		this.insure_end_date = insure_end_date;
	}

	public Integer getCar_status() {
		return car_status;
	}

	public void setCar_status(Integer car_status) {
		this.car_status = car_status;
	}

	public Date getInspection_date() {
		return inspection_date;
	}

	public void setInspection_date(Date inspection_date) {
		this.inspection_date = inspection_date;
	}

	public Integer getIs_check() {
		return is_check;
	}

	public void setIs_check(Integer is_check) {
		this.is_check = is_check;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", car_num=" + car_num + ", seat=" + seat + ", total_seat=" + total_seat
				+ ", car_type=" + car_type + ", car_brand=" + car_brand + ", device=" + device + ", phone=" + phone
				+ ", buy_date=" + buy_date + ", from_company=" + from_company + ", imei=" + imei + ", car_pic="
				+ car_pic + ", car_registration_pic=" + car_registration_pic + ", appearance_pic=" + appearance_pic
				+ ", trim_pic=" + trim_pic + ", insure_end_date=" + insure_end_date + ", car_status=" + car_status
				+ ", inspection_date=" + inspection_date + ", is_check=" + is_check + ", create_time=" + create_time
				+ ", remark=" + remark + "]";
	}

}