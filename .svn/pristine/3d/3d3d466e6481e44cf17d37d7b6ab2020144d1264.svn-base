package com.tmtc.vo;

import com.tmtc.po.Car;

public class CarVo extends Car{
	private String car_type_name;
	private String from_company_name;
	private String car_status_name;
	public CarVo() {	}
	public CarVo(Car car,String car_type_name, String from_company_name, String car_status_name) {
		super(car.getId(),car.getCar_num(),car.getSeat(),car.getTotal_seat(),car.getCar_type(),car.getCar_brand(),
				car.getDevice(),car.getPhone(),car.getBuy_date(),car.getFrom_company(),car.getImei(),car.getCar_pic(),
				car.getCar_registration_pic(),car.getAppearance_pic(),car.getTrim_pic(),car.getInsure_end_date(),
				car.getCar_status(),car.getInspection_date(),car.getIs_check(),car.getCreate_time(),car.getRemark());
		this.car_type_name = car_type_name;
		this.from_company_name = from_company_name;
		this.car_status_name = car_status_name;
	}
	public String getCar_type_name() {
		return car_type_name;
	}
	public void setCar_type_name(String car_type_name) {
		this.car_type_name = car_type_name;
	}
	public String getFrom_company_name() {
		return from_company_name;
	}
	public void setFrom_company_name(String from_company_name) {
		this.from_company_name = from_company_name;
	}
	public String getCar_status_name() {
		return car_status_name;
	}
	public void setCar_status_name(String car_status_name) {
		this.car_status_name = car_status_name;
	}
	@Override
	public String toString() {
		return "CarVo [car_type_name=" + car_type_name + ", from_company_name=" + from_company_name
				+ ", car_status_name=" + car_status_name + "]";
	}
}
