package com.tmtc.po;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Card {
    private String id;

    @NotNull
    @NotEmpty
    private String card_name;

    @NotNull
    private Integer exp_score;

    @NotNull
    private Integer card_type;

    @NotNull
    private Integer city_id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date end_effect_time;

    private Date create_time;

    private Integer is_check;

    public Card() {
		super();
	}

	public Card(String id, String card_name, Integer exp_score, Integer card_type, Integer city_id,
			Date end_effect_time, Date create_time, Integer is_check) {
		super();
		this.id = id;
		this.card_name = card_name;
		this.exp_score = exp_score;
		this.card_type = card_type;
		this.city_id = city_id;
		this.end_effect_time = end_effect_time;
		this.create_time = create_time;
		this.is_check = is_check;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public Integer getExp_score() {
        return exp_score;
    }

    public void setExp_score(Integer exp_score) {
        this.exp_score = exp_score;
    }

    public Integer getCard_type() {
        return card_type;
    }

    public void setCard_type(Integer card_type) {
        this.card_type = card_type;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public Date getEnd_effect_time() {
        return end_effect_time;
    }

    public void setEnd_effect_time(Date end_effect_time) {
        this.end_effect_time = end_effect_time;
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
		return "Card [id=" + id + ", card_name=" + card_name + ", exp_score=" + exp_score + ", card_type=" + card_type
				+ ", city_id=" + city_id + ", end_effect_time=" + end_effect_time + ", create_time=" + create_time
				+ ", is_check=" + is_check + "]";
	}
    
}