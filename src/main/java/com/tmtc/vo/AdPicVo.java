package com.tmtc.vo;

import com.tmtc.po.AdPic;

public class AdPicVo extends AdPic{
	private String city_name;
	private String company_name;
	private String type_name;
	public AdPicVo() {	}
	public AdPicVo(AdPic adPic,String city_name, String company_name, String type_name) {
		super(adPic.getId(),adPic.getCity_id(),adPic.getCompany_id(),adPic.getTitle(),adPic.getType(),adPic.getContent(),
				adPic.getPic(),adPic.getUrl(),adPic.getEnd_time(),adPic.getSort(),adPic.getCreate_time(),adPic.getIs_check());
		this.city_name = city_name;
		this.company_name = company_name;
		this.type_name = type_name;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	@Override
	public String toString() {
		return "AdPicVo [city_name=" + city_name + ", company_name=" + company_name + ", type_name=" + type_name + "]";
	}
}
