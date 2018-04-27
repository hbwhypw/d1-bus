package com.tmtc.po;

import java.util.Date;

public class Talk {
    private String id;

    private String type;

    private String company_id;

    private String room_id;

    private String room_name;

    private String romm_des;

    private Integer room_num;

    private String remark;

    private Date create_time;

    public Talk() {	}
    
    public Talk(String id, String type, String company_id, String room_id, String room_name, String romm_des,
			Integer room_num, String remark, Date create_time) {
		super();
		this.id = id;
		this.type = type;
		this.company_id = company_id;
		this.room_id = room_id;
		this.room_name = room_name;
		this.romm_des = romm_des;
		this.room_num = room_num;
		this.remark = remark;
		this.create_time = create_time;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getRomm_des() {
        return romm_des;
    }

    public void setRomm_des(String romm_des) {
        this.romm_des = romm_des;
    }

    public Integer getRoom_num() {
        return room_num;
    }

    public void setRoom_num(Integer room_num) {
        this.room_num = room_num;
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

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}