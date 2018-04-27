package com.tmtc.vo;

import com.tmtc.po.Card;

public class CardVo extends Card {

	private String card_type_name;

	private String city;

	public CardVo() {
		super();
	}

	public CardVo(Card c, String card_type_name, String city) {
		super(c.getId(), c.getCard_name(), c.getExp_score(), c.getCard_type(), c.getCity_id(), c.getEnd_effect_time(),
				c.getCreate_time(), c.getIs_check());
		this.card_type_name = card_type_name;
		this.city = city;
	}

	public String getCard_type_name() {
		return card_type_name;
	}

	public void setCard_type_name(String card_type_name) {
		this.card_type_name = card_type_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "CardVo [card_type_name=" + card_type_name + ", city=" + city + "]";
	}
}
