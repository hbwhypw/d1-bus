package com.tmtc.po;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Company {
    private String id;

    private String name;

    private Integer city_id;

    private String address;

    private String chairman_name;

    private String chairman_phone;

    private String company_chairman;

    private String company_telphone;

    private String qq;

    private String email;

    private String business_fax;

    private Integer company_type;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date start_time;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date end_time;

    private String logo_pic;

    private String business_license;

    private String website;

    private Date creat_time;

    private Integer is_check;

    private String intro;
    
    private List<Product> productList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getChairman_name() {
        return chairman_name;
    }

    public void setChairman_name(String chairman_name) {
        this.chairman_name = chairman_name;
    }

    public String getChairman_phone() {
        return chairman_phone;
    }

    public void setChairman_phone(String chairman_phone) {
        this.chairman_phone = chairman_phone;
    }

    public String getCompany_chairman() {
        return company_chairman;
    }

    public void setCompany_chairman(String company_chairman) {
        this.company_chairman = company_chairman;
    }

    public String getCompany_telphone() {
        return company_telphone;
    }

    public void setCompany_telphone(String company_telphone) {
        this.company_telphone = company_telphone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBusiness_fax() {
        return business_fax;
    }

    public void setBusiness_fax(String business_fax) {
        this.business_fax = business_fax;
    }

    public Integer getCompany_type() {
        return company_type;
    }

    public void setCompany_type(Integer company_type) {
        this.company_type = company_type;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getLogo_pic() {
        return logo_pic;
    }

    public void setLogo_pic(String logo_pic) {
        this.logo_pic = logo_pic;
    }

    public String getBusiness_license() {
        return business_license;
    }

    public void setBusiness_license(String business_license) {
        this.business_license = business_license;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Date getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(Date creat_time) {
        this.creat_time = creat_time;
    }

    public Integer getIs_check() {
        return is_check;
    }

    public void setIs_check(Integer is_check) {
        this.is_check = is_check;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public Company() {
    }

    public Company(String id, String business_license, String name, Integer city_id, String address, String chairman_name, String chairman_phone, String company_chairman, String company_telphone, String qq, String email, String business_fax, Integer company_type, Date start_time, Date end_time, String logo_pic, String website, Date creat_time, Integer is_check, String intro) {
        this.id = id;
        this.business_license = business_license;
        this.name = name;
        this.city_id = city_id;
        this.address = address;
        this.chairman_name = chairman_name;
        this.chairman_phone = chairman_phone;
        this.company_chairman = company_chairman;
        this.company_telphone = company_telphone;
        this.qq = qq;
        this.email = email;
        this.business_fax = business_fax;
        this.company_type = company_type;
        this.start_time = start_time;
        this.end_time = end_time;
        this.logo_pic = logo_pic;
        this.website = website;
        this.creat_time = creat_time;
        this.is_check = is_check;
        this.intro = intro;
    }
}