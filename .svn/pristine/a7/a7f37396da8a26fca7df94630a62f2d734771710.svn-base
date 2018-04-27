package com.tmtc.po;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.internal.NotNull;

public class AdPic {
	private String id;
	@NotNull
	private Integer city_id;

	private String company_id;
	@NotNull
	@NotEmpty
	private String title;
	@NotNull
	private Integer type;

	private String content;

	private String pic;

	private String url;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date end_time;

	private Integer sort;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date create_time;

	private Integer is_check;

	public AdPic() {
	}

	public AdPic(String id, Integer city_id, String company_id, String title, Integer type, String content, String pic,
			String url, Date end_time, Integer sort, Date create_time, Integer is_check) {
		super();
		this.id = id;
		this.city_id = city_id;
		this.company_id = company_id;
		this.title = title;
		this.type = type;
		this.content = content;
		this.pic = pic;
		this.url = url;
		this.end_time = end_time;
		this.sort = sort;
		this.create_time = create_time;
		this.is_check = is_check;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getCity_id() {
		return city_id;
	}

	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}

	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
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
		return "AdPic [id=" + id + ", city_id=" + city_id + ", company_id=" + company_id + ", title=" + title
				+ ", type=" + type + ", content=" + content + ", pic=" + pic + ", url=" + url + ", end_time=" + end_time
				+ ", sort=" + sort + ", create_time=" + create_time + ", is_check=" + is_check + "]";
	}
	
}