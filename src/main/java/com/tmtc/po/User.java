package com.tmtc.po;

import java.util.Date;

public class User {
    private String id;

    private Integer city_id;

    private String company_id;

    private String username;

    private String password;

    private String number;

    private Integer user_type;

    private Integer login_source;

    private Integer lock_time;

    private Integer lock_cnt;

    private Date login_time;

    private Integer login_cnt;

    private String ip_address;

    public User() {
		super();
	}

	public User(String id, Integer city_id, String company_id, String username, String password, String number,
			Integer user_type, Integer login_source, Integer lock_time, Integer lock_cnt, Date login_time,
			Integer login_cnt, String ip_address) {
		super();
		this.id = id;
		this.city_id = city_id;
		this.company_id = company_id;
		this.username = username;
		this.password = password;
		this.number = number;
		this.user_type = user_type;
		this.login_source = login_source;
		this.lock_time = lock_time;
		this.lock_cnt = lock_cnt;
		this.login_time = login_time;
		this.login_cnt = login_cnt;
		this.ip_address = ip_address;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getUser_type() {
        return user_type;
    }

    public void setUser_type(Integer user_type) {
        this.user_type = user_type;
    }

    public Integer getLogin_source() {
        return login_source;
    }

    public void setLogin_source(Integer login_source) {
        this.login_source = login_source;
    }

    public Integer getLock_time() {
        return lock_time;
    }

    public void setLock_time(Integer lock_time) {
        this.lock_time = lock_time;
    }

    public Integer getLock_cnt() {
        return lock_cnt;
    }

    public void setLock_cnt(Integer lock_cnt) {
        this.lock_cnt = lock_cnt;
    }

    public Date getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }

    public Integer getLogin_cnt() {
        return login_cnt;
    }

    public void setLogin_cnt(Integer login_cnt) {
        this.login_cnt = login_cnt;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", city_id=" + city_id + ", company_id=" + company_id + ", username=" + username
				+ ", password=" + password + ", number=" + number + ", user_type=" + user_type + ", login_source="
				+ login_source + ", lock_time=" + lock_time + ", lock_cnt=" + lock_cnt + ", login_time=" + login_time
				+ ", login_cnt=" + login_cnt + ", ip_address=" + ip_address + "]";
	}
}