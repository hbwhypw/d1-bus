package com.tmtc.po;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.internal.NotNull;

public class Driver {
    private String id;
    @NotNull
    @NotEmpty
    private String real_name;

    private String password;

    private String mobile;
    @NotNull
    private Integer gender;
    @NotNull
    private Integer driver_age;
    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;
    private String idcard;
    @NotNull
    @NotEmpty
    private String license_no;

    private String license_pic;
    @NotNull
    private Integer license_type;
    @NotNull
    @NotEmpty
    private String native_place;
    @NotNull
    @NotEmpty
    private String address;
    @NotNull
    private Integer driver_source;
    @NotNull
    private Integer city_id;

    private String photo;

    private String bg_pic;

    private String remark;

    private Date create_time;

    private Integer is_check;

    public Driver() {	}

	public Driver(String id, String real_name, String password, String mobile, Integer gender, Integer driver_age,
			Date birthday, String idcard, String license_no, String license_pic, Integer license_type,
			String native_place, String address, Integer driver_source, Integer city_id, String photo, String bg_pic,
			String remark, Date create_time, Integer is_check) {
		super();
		this.id = id;
		this.real_name = real_name;
		this.password = password;
		this.mobile = mobile;
		this.gender = gender;
		this.driver_age = driver_age;
		this.birthday = birthday;
		this.idcard = idcard;
		this.license_no = license_no;
		this.license_pic = license_pic;
		this.license_type = license_type;
		this.native_place = native_place;
		this.address = address;
		this.driver_source = driver_source;
		this.city_id = city_id;
		this.photo = photo;
		this.bg_pic = bg_pic;
		this.remark = remark;
		this.create_time = create_time;
		this.is_check = is_check;
	}



	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getDriver_age() {
        return driver_age;
    }

    public void setDriver_age(Integer driver_age) {
        this.driver_age = driver_age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getLicense_no() {
        return license_no;
    }

    public void setLicense_no(String license_no) {
        this.license_no = license_no;
    }

    public String getLicense_pic() {
        return license_pic;
    }

    public void setLicense_pic(String license_pic) {
        this.license_pic = license_pic;
    }

    public Integer getLicense_type() {
        return license_type;
    }

    public void setLicense_type(Integer license_type) {
        this.license_type = license_type;
    }

    public String getNative_place() {
        return native_place;
    }

    public void setNative_place(String native_place) {
        this.native_place = native_place;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDriver_source() {
        return driver_source;
    }

    public void setDriver_source(Integer driver_source) {
        this.driver_source = driver_source;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBg_pic() {
        return bg_pic;
    }

    public void setBg_pic(String bg_pic) {
        this.bg_pic = bg_pic;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreate_time() {
        return create_time;
    }

    @Override
	public String toString() {
		return "Driver [id=" + id + ", real_name=" + real_name + ", password=" + password + ", mobile=" + mobile
				+ ", gender=" + gender + ", driver_age=" + driver_age + ", birthday=" + birthday + ", idcard=" + idcard
				+ ", license_no=" + license_no + ", license_pic=" + license_pic + ", license_type=" + license_type
				+ ", native_place=" + native_place + ", address=" + address + ", driver_source=" + driver_source
				+ ", city_id=" + city_id + ", photo=" + photo + ", bg_pic=" + bg_pic + ", remark=" + remark
				+ ", create_time=" + create_time + ", is_check=" + is_check + "]";
	}

	public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getIs_check() {
        return is_check;
    }

    public void setIs_check(Integer is_check) {
        this.is_check = is_check;
    }
}