package com.tmtc.po;

import java.util.Date;

public class LineApply {
    private String id;

    private String user_id;

    private Integer city_id;

    private String start_station;

    private String end_station;

    private Date depart_time;

    private Integer depart_rate;

    private Date commite_time;

    private Date update_time;

    private Integer is_check;
    
    public LineApply() {	}
    
    public LineApply(String id, String user_id, Integer city_id, String start_station, String end_station,
			Date depart_time, Integer depart_rate, Date commite_time, Date update_time, Integer is_check) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.city_id = city_id;
		this.start_station = start_station;
		this.end_station = end_station;
		this.depart_time = depart_time;
		this.depart_rate = depart_rate;
		this.commite_time = commite_time;
		this.update_time = update_time;
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

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public String getStart_station() {
        return start_station;
    }

    public void setStart_station(String start_station) {
        this.start_station = start_station;
    }

    public String getEnd_station() {
        return end_station;
    }

    public void setEnd_station(String end_station) {
        this.end_station = end_station;
    }

    public Date getDepart_time() {
        return depart_time;
    }

    public void setDepart_time(Date depart_time) {
        this.depart_time = depart_time;
    }

    public Integer getDepart_rate() {
        return depart_rate;
    }

    public void setDepart_rate(Integer depart_rate) {
        this.depart_rate = depart_rate;
    }

    public Date getCommite_time() {
        return commite_time;
    }

    public void setCommite_time(Date commite_time) {
        this.commite_time = commite_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getIs_check() {
        return is_check;
    }

    public void setIs_check(Integer is_check) {
        this.is_check = is_check;
    }

	@Override
	public String toString() {
		return "LineApply [id=" + id + ", user_id=" + user_id + ", city_id=" + city_id + ", start_station="
				+ start_station + ", end_station=" + end_station + ", depart_time=" + depart_time + ", depart_rate="
				+ depart_rate + ", commite_time=" + commite_time + ", update_time=" + update_time + ", is_check="
				+ is_check + "]";
	}
}