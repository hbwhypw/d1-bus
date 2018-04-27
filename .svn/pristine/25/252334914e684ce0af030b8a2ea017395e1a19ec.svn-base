package com.tmtc.vo;

import com.tmtc.po.Feedback;

public class FeedbackVo extends Feedback{
	private String real_name;
	public FeedbackVo() {	}
	public FeedbackVo(Feedback feedback,String real_name) {
		super(feedback.getId(),feedback.getUser_id(),feedback.getContent(),feedback.getIs_handle(),feedback.getContact(),
				feedback.getCreate_time(),feedback.getIs_check());
		this.real_name = real_name;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	@Override
	public String toString() {
		return "FeedbackVo [real_name=" + real_name + "]";
	}
}
