package com.tmtc.vo;

import com.tmtc.po.Message;

public class MessageVo extends Message{
	private String type_name;
	public MessageVo() {	}
	public MessageVo(Message message,String type_name) {
		super(message.getId(),message.getTitle(),message.getContent(),message.getType(),message.getCreate_time());
		this.type_name = type_name;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	@Override
	public String toString() {
		return "MessageVo [type_name=" + type_name + "]";
	}
}
