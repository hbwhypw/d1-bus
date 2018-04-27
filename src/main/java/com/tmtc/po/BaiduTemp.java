package com.tmtc.po;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BaiduTemp {
    private String id;

    private String line_time_id;

    private String line_id;

    private String line_station_id;

    private String driver_id;

    private String car_id;

    private String card_num;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date arrival_time;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date scan_time;

    private String driver_name;

    private String car_num;

    private String line_name;

    private String line_station_name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date depart_time;

    private String yuliu1;

    private String yuliu2;

    private String yuliu3;

    private Integer is_check;

    public BaiduTemp() {	}
    
    public BaiduTemp(String id, String line_time_id, String line_id, String line_station_id, String driver_id,
			String car_id, String card_num, Date arrival_time, Date scan_time, String driver_name, String car_num,
			String line_name, String line_station_name, Date depart_time, String yuliu1, String yuliu2, String yuliu3,
			Integer is_check) {
		super();
		this.id = id;
		this.line_time_id = line_time_id;
		this.line_id = line_id;
		this.line_station_id = line_station_id;
		this.driver_id = driver_id;
		this.car_id = car_id;
		this.card_num = card_num;
		this.arrival_time = arrival_time;
		this.scan_time = scan_time;
		this.driver_name = driver_name;
		this.car_num = car_num;
		this.line_name = line_name;
		this.line_station_name = line_station_name;
		this.depart_time = depart_time;
		this.yuliu1 = yuliu1;
		this.yuliu2 = yuliu2;
		this.yuliu3 = yuliu3;
		this.is_check = is_check;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLine_time_id() {
        return line_time_id;
    }

    public void setLine_time_id(String line_time_id) {
        this.line_time_id = line_time_id;
    }

    public String getLine_id() {
        return line_id;
    }

    public void setLine_id(String line_id) {
        this.line_id = line_id;
    }

    public String getLine_station_id() {
        return line_station_id;
    }

    public void setLine_station_id(String line_station_id) {
        this.line_station_id = line_station_id;
    }

    public String getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public String getCard_num() {
        return card_num;
    }

    public void setCard_num(String card_num) {
        this.card_num = card_num;
    }

    public Date getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Date arrival_time) {
        this.arrival_time = arrival_time;
    }

    public Date getScan_time() {
        return scan_time;
    }

    public void setScan_time(Date scan_time) {
        this.scan_time = scan_time;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getCar_num() {
        return car_num;
    }

    public void setCar_num(String car_num) {
        this.car_num = car_num;
    }

    public String getLine_name() {
        return line_name;
    }

    public void setLine_name(String line_name) {
        this.line_name = line_name;
    }

    public String getLine_station_name() {
        return line_station_name;
    }

    public void setLine_station_name(String line_station_name) {
        this.line_station_name = line_station_name;
    }

    public Date getDepart_time() {
        return depart_time;
    }

    public void setDepart_time(Date depart_time) {
        this.depart_time = depart_time;
    }

    public String getYuliu1() {
        return yuliu1;
    }

    public void setYuliu1(String yuliu1) {
        this.yuliu1 = yuliu1;
    }

    public String getYuliu2() {
        return yuliu2;
    }

    public void setYuliu2(String yuliu2) {
        this.yuliu2 = yuliu2;
    }

    public String getYuliu3() {
        return yuliu3;
    }

    public void setYuliu3(String yuliu3) {
        this.yuliu3 = yuliu3;
    }

    public Integer getIs_check() {
        return is_check;
    }

    public void setIs_check(Integer is_check) {
        this.is_check = is_check;
    }

	@Override
	public String toString() {
		return "BaiduTemp [id=" + id + ", line_time_id=" + line_time_id + ", line_id=" + line_id + ", line_station_id="
				+ line_station_id + ", driver_id=" + driver_id + ", car_id=" + car_id + ", card_num=" + card_num
				+ ", arrival_time=" + arrival_time + ", scan_time=" + scan_time + ", driver_name=" + driver_name
				+ ", car_num=" + car_num + ", line_name=" + line_name + ", line_station_name=" + line_station_name
				+ ", depart_time=" + depart_time + ", yuliu1=" + yuliu1 + ", yuliu2=" + yuliu2 + ", yuliu3=" + yuliu3
				+ ", is_check=" + is_check + "]";
	}
}