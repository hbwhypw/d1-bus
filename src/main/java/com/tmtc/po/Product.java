package com.tmtc.po;

import java.util.Date;

public class Product {
    private String id;

    private Integer city_id;

    private String company_id;

    private String pro_name;

    private String pro_type;

    private String remote_url;

    private Double market_price;

    private Double shop_price;

    private Integer exp_score;

    private String detail;

    private Integer stock;

    private Integer sell_type;

    private Integer limit_buy;

    private Integer sort;

    private String remark;

    private Date create_time;

    private Integer is_check;

    private String pro_picture;

    public Product() {	}
    
    public Product(String id, Integer city_id, String company_id, String pro_name, String pro_type, String remote_url,
			Double market_price, Double shop_price, Integer exp_score, String detail, Integer stock, Integer sell_type,
			Integer limit_buy, Integer sort, String remark, Date create_time, Integer is_check, String pro_picture) {
		super();
		this.id = id;
		this.city_id = city_id;
		this.company_id = company_id;
		this.pro_name = pro_name;
		this.pro_type = pro_type;
		this.remote_url = remote_url;
		this.market_price = market_price;
		this.shop_price = shop_price;
		this.exp_score = exp_score;
		this.detail = detail;
		this.stock = stock;
		this.sell_type = sell_type;
		this.limit_buy = limit_buy;
		this.sort = sort;
		this.remark = remark;
		this.create_time = create_time;
		this.is_check = is_check;
		this.pro_picture = pro_picture;
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

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getPro_type() {
        return pro_type;
    }

    public void setPro_type(String pro_type) {
        this.pro_type = pro_type;
    }

    public String getRemote_url() {
        return remote_url;
    }

    public void setRemote_url(String remote_url) {
        this.remote_url = remote_url;
    }

    public Double getMarket_price() {
        return market_price;
    }

    public void setMarket_price(Double market_price) {
        this.market_price = market_price;
    }

    public Double getShop_price() {
        return shop_price;
    }

    public void setShop_price(Double shop_price) {
        this.shop_price = shop_price;
    }

    public Integer getExp_score() {
        return exp_score;
    }

    public void setExp_score(Integer exp_score) {
        this.exp_score = exp_score;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSell_type() {
        return sell_type;
    }

    public void setSell_type(Integer sell_type) {
        this.sell_type = sell_type;
    }

    public Integer getLimit_buy() {
        return limit_buy;
    }

    public void setLimit_buy(Integer limit_buy) {
        this.limit_buy = limit_buy;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    public String getPro_picture() {
        return pro_picture;
    }

    public void setPro_picture(String pro_picture) {
        this.pro_picture = pro_picture;
    }
}