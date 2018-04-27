package com.tmtc.po;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

public class AppResource {
    private String id;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String url;
    
    private String param;
    
    private String remark;

    private Date create_time;

    private Integer is_check;
    
    public AppResource() {	}
    
    public AppResource(String id, String name, String url, String param, String remark, Date create_time,
			Integer is_check) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.param = param;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
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

    public Integer getIs_check() {
        return is_check;
    }

    public void setIs_check(Integer is_check) {
        this.is_check = is_check;
    }

	@Override
	public String toString() {
		return "AppResource [id=" + id + ", name=" + name + ", url=" + url + ", param=" + param + ", remark=" + remark
				+ ", create_time=" + create_time + ", is_check=" + is_check + "]";
	}
}