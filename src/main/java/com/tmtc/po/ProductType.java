package com.tmtc.po;

import java.util.Date;

public class ProductType {
    private String id;

    private String name;

    private String typ_pic;

    private Integer sort;

    private Date create_time;

    private Integer is_check;

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

    public String getTyp_pic() {
        return typ_pic;
    }

    public void setTyp_pic(String typ_pic) {
        this.typ_pic = typ_pic;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
}