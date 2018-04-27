package com.tmtc.vo;

import com.tmtc.po.CardRecord;

public class CardRecordVo extends CardRecord{
	private String userName;
	private String cardName;
	private String isUseName;
	private String isCheckName;
	public CardRecordVo() {	}
	public CardRecordVo(CardRecord cardRecord,String userName, String cardName, String isUseName, String isCheckName) {
		super(cardRecord.getId(),cardRecord.getUser_id(),cardRecord.getCard_id(),cardRecord.getIs_use(),cardRecord.getOpt_time(),cardRecord.getIs_check());
		this.userName = userName;
		this.cardName = cardName;
		this.isUseName = isUseName;
		this.isCheckName = isCheckName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getIsUseName() {
		return isUseName;
	}
	public void setIsUseName(String isUseName) {
		this.isUseName = isUseName;
	}
	public String getIsCheckName() {
		return isCheckName;
	}
	public void setIsCheckName(String isCheckName) {
		this.isCheckName = isCheckName;
	}
	@Override
	public String toString() {
		return "CardRecordVo [userName=" + userName + ", cardName=" + cardName + ", isUseName=" + isUseName
				+ ", isCheckName=" + isCheckName + "]";
	}
}
