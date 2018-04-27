package com.tmtc.po;

import java.util.Date;

public class ArrivalTime {
    private String id;

    private String line_time_id;

    private String station_id;

    private Date real_arrival_time;

    public ArrivalTime() {	}
    
    public ArrivalTime(String id, String line_time_id, String station_id, Date real_arrival_time) {
		super();
		this.id = id;
		this.line_time_id = line_time_id;
		this.station_id = station_id;
		this.real_arrival_time = real_arrival_time;
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

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public Date getReal_arrival_time() {
        return real_arrival_time;
    }

    public void setReal_arrival_time(Date real_arrival_time) {
        this.real_arrival_time = real_arrival_time;
    }

	@Override
	public String toString() {
		return "ArrivalTime [id=" + id + ", line_time_id=" + line_time_id + ", station_id=" + station_id
				+ ", real_arrival_time=" + real_arrival_time + "]";
	}
}