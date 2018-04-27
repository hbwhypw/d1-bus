package com.tmtc.utils.HeepayShortPay.HeepayReturn;

public class HeepayQueryBanksReturn {
	
	private String _card_type;
	private String _bank_id;
	public String get_card_type() {
		return _card_type;
	}
	public void set_card_type(String _card_type) {
		this._card_type = _card_type;
	}
	public String get_bank_id() {
		return _bank_id;
	}
	public void set_bank_id(String _bank_id) {
		this._bank_id = _bank_id;
	}
	public String get_bank_name() {
		return _bank_name;
	}
	public void set_bank_name(String _bank_name) {
		this._bank_name = _bank_name;
	}
	private String _bank_name;

}
