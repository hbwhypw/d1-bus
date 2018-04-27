package com.tmtc.po;

public class VerificationCode {
    private String id;

    private String mobile_phone;

    private String code;

    private Long create_time;

    private Integer is_check;

    public VerificationCode() {
		super();
	}

	public VerificationCode(String id, String mobile_phone, String code, Long create_time, Integer is_check) {
		super();
		this.id = id;
		this.mobile_phone = mobile_phone;
		this.code = code;
		this.create_time = create_time;
		this.is_check = is_check;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
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
		return "VerificationCode [id=" + id + ", mobile_phone=" + mobile_phone + ", code=" + code + ", create_time="
				+ create_time + ", is_check=" + is_check + "]";
	}
}