package com.tmtc.po;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import java.util.Date;

public class Admins {
    private String id;

    private Integer city_id;

    private Integer type;

    private String role_id;

    private String company_id;
    @NotEmpty(message = "{username.not.empty}")
    @Pattern(regexp = "[0-9a-zA-Z]{6,18}",message = "{username.length}")
    private String username;
    @NotEmpty(message = "{password.not.empty}")
    @Pattern(regexp = "[0-9a-zA-Z]{6,18}",message = "{password.length}")
    private String password;

    private String nick_name;

    private String email;

    private Date login_date;

    private Integer login_cunt;

    private Integer lock_time;

    private Date create_time;

    private Integer is_check;

    public Admins() {	}

    public Admins(String id, Integer city_id, String role_id, String company_id, String username, String password,
			String nick_name, String email, Date login_date, Integer login_cunt, Integer lock_time, Date create_time,
			Integer is_check) {
		super();
		this.id = id;
		this.city_id = city_id;
		this.role_id = role_id;
		this.company_id = company_id;
		this.username = username;
		this.password = password;
		this.nick_name = nick_name;
		this.email = email;
		this.login_date = login_date;
		this.login_cunt = login_cunt;
		this.lock_time = lock_time;
		this.create_time = create_time;
		this.is_check = is_check;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
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

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLogin_date() {
        return login_date;
    }

    public void setLogin_date(Date login_date) {
        this.login_date = login_date;
    }

    public Integer getLogin_cunt() {
        return login_cunt;
    }

    public void setLogin_cunt(Integer login_cunt) {
        this.login_cunt = login_cunt;
    }

    public Integer getLock_time() {
        return lock_time;
    }

    public void setLock_time(Integer lock_time) {
        this.lock_time = lock_time;
    }

    public Date getCreate_time() {
        return create_time;
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

	@Override
	public String toString() {
		return "Admins [id=" + id + ", city_id=" + city_id + ", role_id=" + role_id + ", company_id=" + company_id
				+ ", username=" + username + ", password=" + password + ", nick_name=" + nick_name + ", email=" + email
				+ ", login_date=" + login_date + ", login_cunt=" + login_cunt + ", lock_time=" + lock_time
				+ ", create_time=" + create_time + ", is_check=" + is_check + "]";
	}
}