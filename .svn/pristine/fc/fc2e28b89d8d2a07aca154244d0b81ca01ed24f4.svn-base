package com.tmtc.po;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class LineStation {
    private String id;

    @NotNull
    @NotEmpty
    private String line_id;

    @NotNull
    @NotEmpty
    private String station_name;

    @NotNull
    private Integer next_time;

    @NotNull
    private Double next_km;

    private String prev_id;

    private String next_id;

    @NotNull
    private Double x_point;

    @NotNull
    private Double y_point;

    private String qrcode;

    private Integer sort;

    private Integer willnum;

    private Date create_time;

    private Integer is_check;

    public LineStation() {
		super();
	}

	public LineStation(String id, String line_id, String station_name, Integer next_time, Double next_km,
			String prev_id, String next_id, Double x_point, Double y_point, String qrcode, Integer sort,
			Integer willnum, Date create_time, Integer is_check) {
		super();
		this.id = id;
		this.line_id = line_id;
		this.station_name = station_name;
		this.next_time = next_time;
		this.next_km = next_km;
		this.prev_id = prev_id;
		this.next_id = next_id;
		this.x_point = x_point;
		this.y_point = y_point;
		this.qrcode = qrcode;
		this.sort = sort;
		this.willnum = willnum;
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

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public Integer getNext_time() {
        return next_time;
    }

    public void setNext_time(Integer next_time) {
        this.next_time = next_time;
    }

    public Double getNext_km() {
        return next_km;
    }

    public void setNext_km(Double next_km) {
        this.next_km = next_km;
    }

    public String getPrev_id() {
        return prev_id;
    }

    public void setPrev_id(String prev_id) {
        this.prev_id = prev_id;
    }

    public String getNext_id() {
        return next_id;
    }

    public void setNext_id(String next_id) {
        this.next_id = next_id;
    }

    public Double getX_point() {
        return x_point;
    }

    public void setX_point(Double x_point) {
        this.x_point = x_point;
    }

    public Double getY_point() {
        return y_point;
    }

    public void setY_point(Double y_point) {
        this.y_point = y_point;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getWillnum() {
        return willnum;
    }

    public void setWillnum(Integer willnum) {
        this.willnum = willnum;
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

	@Override
	public String toString() {
		return "LineStation [id=" + id + ", line_id=" + line_id + ", station_name=" + station_name + ", next_time="
				+ next_time + ", next_km=" + next_km + ", prev_id=" + prev_id + ", next_id=" + next_id + ", x_point="
				+ x_point + ", y_point=" + y_point + ", qrcode=" + qrcode + ", sort=" + sort + ", willnum=" + willnum
				+ ", create_time=" + create_time + ", is_check=" + is_check + "]";
	}
    
}