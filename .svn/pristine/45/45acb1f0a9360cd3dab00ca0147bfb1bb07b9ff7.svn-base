package com.tmtc.vo;

import java.util.Date;

import com.tmtc.po.ExpScoreRecord;

public class ExpScoreRecordVo extends ExpScoreRecord {

	private String userName;
	
	private String exp_type_name;

	public ExpScoreRecordVo() {
		super();
	}

	public ExpScoreRecordVo(String id, String user_id, Integer exp_type, Integer score, Date opt_time,
			Integer is_check) {
		super(id, user_id, exp_type, score, opt_time, is_check);
	}

	public ExpScoreRecordVo(ExpScoreRecord e,String userName, String exp_type_name) {
		super(e.getId(), e.getUser_id(), e.getExp_type(), e.getScore(), e.getOpt_time(), e.getIs_check());
		this.userName = userName;
		this.exp_type_name = exp_type_name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getExp_type_name() {
		return exp_type_name;
	}

	public void setExp_type_name(String exp_type_name) {
		this.exp_type_name = exp_type_name;
	}

	@Override
	public String toString() {
		return "ExpScoreRecordVo [userName=" + userName + ", exp_type_name=" + exp_type_name + "]";
	}
}
