package com.tmtc.vo;

import com.tmtc.po.Talk;

public class TalkVo extends Talk {

	private String company_name;

	public TalkVo() {
		super();
	}

	public TalkVo(Talk talk, String company_name) {
		super(talk.getId(), talk.getType(), talk.getCompany_id(), talk.getRoom_id(), talk.getRoom_name(),
				talk.getRomm_des(), talk.getRoom_num(), talk.getRemark(), talk.getCreate_time());
		this.company_name = company_name;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	@Override
	public String toString() {
		return "TalkVo [company_name=" + company_name + "]";
	}
}
