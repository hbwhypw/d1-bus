package com.tmtc.po;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.internal.NotNull;

public class LineTime {
    private String id;

    @NotNull
    @NotEmpty
    private String line_id;

    @NotNull
    @NotEmpty
    private String driver_id;

    @NotNull
    @NotEmpty
    private String car_id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull
    private Date depart_time;

    private Date depart_hour;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull
    private Date arrival_time;

    private Integer driving_state;

    private Integer line_station_sort;

    private String remark;

    private Date create_time;

    private Integer is_check;
    
    private Line line;
    
    private Driver driver;
    
    private Car car;

    public LineTime() {
		super();
	}
    
    public LineTime(String id, String line_id, String driver_id, String car_id, Date depart_time, Date depart_hour,
			Date arrival_time, Integer driving_state, Integer line_station_sort, String remark, Date create_time,
			Integer is_check) {
		super();
		this.id = id;
		this.line_id = line_id;
		this.driver_id = driver_id;
		this.car_id = car_id;
		this.depart_time = depart_time;
		this.depart_hour = depart_hour;
		this.arrival_time = arrival_time;
		this.driving_state = driving_state;
		this.line_station_sort = line_station_sort;
		this.remark = remark;
		this.create_time = create_time;
		this.is_check = is_check;
	}

	public String getId() {
        return id;
    }

	public void setId(String id) {
        this.id = id;
    }

    public String getLine_id() {
        return line_id;
    }

    public void setLine_id(String line_id) {
        this.line_id = line_id;
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

    public Date getDepart_time() {
        return depart_time;
    }

    public void setDepart_time(Date depart_time) {
        this.depart_time = depart_time;
    }

    public Date getDepart_hour() {
        return depart_hour;
    }

    public void setDepart_hour(Date depart_hour) {
        this.depart_hour = depart_hour;
    }

    public Date getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Date arrival_time) {
        this.arrival_time = arrival_time;
    }

    public Integer getDriving_state() {
        return driving_state;
    }

    public void setDriving_state(Integer driving_state) {
        this.driving_state = driving_state;
    }

    public Integer getLine_station_sort() {
        return line_station_sort;
    }

    public void setLine_station_sort(Integer line_station_sort) {
        this.line_station_sort = line_station_sort;
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

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "LineTime [id=" + id + ", line_id=" + line_id + ", driver_id=" + driver_id + ", car_id=" + car_id
				+ ", depart_time=" + depart_time + ", depart_hour=" + depart_hour + ", arrival_time=" + arrival_time
				+ ", driving_state=" + driving_state + ", line_station_sort=" + line_station_sort + ", remark=" + remark
				+ ", create_time=" + create_time + ", is_check=" + is_check + ", line=" + line + ", driver=" + driver
				+ ", car=" + car + "]";
	}
}