package com.tmtc.vo;

public class OrderVo {

	private String id;
	
	private String num;

	public OrderVo() {
		super();
	}

	public OrderVo(String id, String num) {
		super();
		this.id = id;
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "OrderVo [id=" + id + ", num=" + num + "]";
	}
	
}
