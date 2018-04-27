package com.tmtc.po;

import java.util.Date;

public class KmUseRecord {
    private String id;

    private String user_id;

    private Integer use_km;

    private Integer use_type;

    private Date opt_time;

    private Integer is_check;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Integer getUse_km() {
        return use_km;
    }

    public void setUse_km(Integer use_km) {
        this.use_km = use_km;
    }

    public Integer getUse_type() {
        return use_type;
    }

    public void setUse_type(Integer use_type) {
        this.use_type = use_type;
    }

    public Date getOpt_time() {
        return opt_time;
    }

    public void setOpt_time(Date opt_time) {
        this.opt_time = opt_time;
    }

    public Integer getIs_check() {
        return is_check;
    }

    public void setIs_check(Integer is_check) {
        this.is_check = is_check;
    }
}