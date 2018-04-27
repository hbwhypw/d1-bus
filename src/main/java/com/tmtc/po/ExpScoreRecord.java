package com.tmtc.po;

import java.util.Date;

public class ExpScoreRecord {
    private String id;

    private String user_id;

    private Integer exp_type;

    private Integer score;

    private Date opt_time;

    private Integer is_check;

    public ExpScoreRecord() {
		super();
	}

	public ExpScoreRecord(String id, String user_id, Integer exp_type, Integer score, Date opt_time, Integer is_check) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.exp_type = exp_type;
		this.score = score;
		this.opt_time = opt_time;
		this.is_check = is_check;
	}

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

    public Integer getExp_type() {
        return exp_type;
    }

    public void setExp_type(Integer exp_type) {
        this.exp_type = exp_type;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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

	@Override
	public String toString() {
		return "ExpScoreRecord [id=" + id + ", user_id=" + user_id + ", exp_type=" + exp_type + ", score=" + score
				+ ", opt_time=" + opt_time + ", is_check=" + is_check + "]";
	}
    
}