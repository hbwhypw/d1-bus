package com.tmtc.po;

public class UserLogin {
    private String id;

    private String login_token;

    private String login_time;
    
    public UserLogin() {
		super();
	}

	public UserLogin(String id, String login_token, String login_time) {
		super();
		this.id = id;
		this.login_token = login_token;
		this.login_time = login_time;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin_token() {
        return login_token;
    }

    public void setLogin_token(String login_token) {
        this.login_token = login_token;
    }

    public String getLogin_time() {
        return login_time;
    }

    public void setLogin_time(String login_time) {
        this.login_time = login_time;
    }

	@Override
	public String toString() {
		return "UserLogin [id=" + id + ", login_token=" + login_token + ", login_time=" + login_time + "]";
	}
}