package com.tmtc.vo;

import com.tmtc.po.UserDetail;

public class UserDetailVo extends UserDetail{
	
	private int city_id;
	private String company_id;
	private String number;
	private String city_name;
	private String company_name;
	public UserDetailVo() {	}
	public UserDetailVo(UserDetail userDetail,int city_id, String company_id, String number) {
		super(userDetail.getUser_type(), userDetail.getId(), userDetail.getLink_num(), userDetail.getRegister_time(),
				userDetail.getRegister_source(), userDetail.getUsername(), userDetail.getNick_name(),
				userDetail.getReal_name(), userDetail.getQr_code(), userDetail.getQr_code_secret(), userDetail.getSex(),
				userDetail.getId_code(), userDetail.getBirthday(), userDetail.getPortrait(), userDetail.getBackground(),
				userDetail.getEmail(), userDetail.getAddress(), userDetail.getCard_num(), userDetail.getExp_score(),
				userDetail.getRemark(), userDetail.getInvitation_code(), userDetail.getLast_order_time(),
				userDetail.getIs_check());
		this.city_id = city_id;
		this.company_id = company_id;
		this.number = number;
	}

	public UserDetailVo(UserDetailVo userDetail) {
		super(userDetail.getUser_type(), userDetail.getId(), userDetail.getLink_num(), userDetail.getRegister_time(),
				userDetail.getRegister_source(), userDetail.getUsername(), userDetail.getNick_name(),
				userDetail.getReal_name(), userDetail.getQr_code(), userDetail.getQr_code_secret(), userDetail.getSex(),
				userDetail.getId_code(), userDetail.getBirthday(), userDetail.getPortrait(), userDetail.getBackground(),
				userDetail.getEmail(), userDetail.getAddress(), userDetail.getCard_num(), userDetail.getExp_score(),
				userDetail.getRemark(), userDetail.getInvitation_code(), userDetail.getLast_order_time(),
				userDetail.getIs_check());
	}
	
	
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
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

	@Override
	public String toString() {
		return "UserDetailVo [city_id=" + city_id + ", company_id=" + company_id + ", number=" + number + "]";
	}
}
