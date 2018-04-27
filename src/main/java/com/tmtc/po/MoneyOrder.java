package com.tmtc.po;

import java.util.Date;

public class MoneyOrder {
    private String id;

    private String userId;

    private String card_no;

    private String order_no;

    private Integer money;

    private Integer pay_type;

    private Integer order_status;

    private Date create_time;

    public MoneyOrder() {
		super();
	}

	public MoneyOrder(String id, String userId, String card_no, String order_no, Integer money, Integer pay_type,
			Integer order_status, Date create_time) {
		super();
		this.id = id;
		this.userId = userId;
		this.card_no = card_no;
		this.order_no = order_no;
		this.money = money;
		this.pay_type = pay_type;
		this.order_status = order_status;
		this.create_time = create_time;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getPay_type() {
        return pay_type;
    }

    public void setPay_type(Integer pay_type) {
        this.pay_type = pay_type;
    }

    public Integer getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Integer order_status) {
        this.order_status = order_status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

	@Override
	public String toString() {
		return "MoneyOrder [id=" + id + ", userId=" + userId + ", card_no=" + card_no + ", order_no=" + order_no
				+ ", money=" + money + ", pay_type=" + pay_type + ", order_status=" + order_status + ", create_time="
				+ create_time + "]";
	}
}