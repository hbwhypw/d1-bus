package com.tmtc.vo.recharge;

public class RechargeFind {

	private String charge;
	
	private long timeKey;

	private String enc;

	public RechargeFind() {
		super();
	}

	public RechargeFind(String charge, long timeKey, String enc) {
		super();
		this.charge = charge;
		this.timeKey = timeKey;
		this.enc = enc;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public long getTimeKey() {
		return timeKey;
	}

	public void setTimeKey(long timeKey) {
		this.timeKey = timeKey;
	}

	public String getEnc() {
		return enc;
	}

	public void setEnc(String enc) {
		this.enc = enc;
	}

	@Override
	public String toString() {
		return "RechargeFind [charge=" + charge + ", timeKey=" + timeKey + ", enc=" + enc + "]";
	}
}
