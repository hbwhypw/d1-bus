package com.tmtc.vo;

import com.tmtc.po.Driver;

public class DriverVo extends Driver{
	private String license_type_name;
	private String driver_source_name;
	private String city_name;
	public DriverVo() {	}
	public DriverVo(Driver driver,String license_type_name, String driver_source_name, String city_name) {
		super(driver.getId(),driver.getReal_name(),driver.getPassword(),driver.getMobile(),driver.getGender(),driver.getDriver_age()
				,driver.getBirthday(),driver.getIdcard(),driver.getLicense_no(),driver.getLicense_pic(),
				driver.getLicense_type(),driver.getNative_place(),driver.getAddress(),driver.getDriver_source(),
				driver.getCity_id(),driver.getPhoto(),driver.getBg_pic(),driver.getRemark(),driver.getCreate_time(),
				driver.getIs_check());
		this.license_type_name = license_type_name;
		this.driver_source_name = driver_source_name;
		this.city_name = city_name;
	}
	public String getLicense_type_name() {
		return license_type_name;
	}
	public void setLicense_type_name(String license_type_name) {
		this.license_type_name = license_type_name;
	}
	public String getDriver_source_name() {
		return driver_source_name;
	}
	public void setDriver_source_name(String driver_source_name) {
		this.driver_source_name = driver_source_name;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
}
