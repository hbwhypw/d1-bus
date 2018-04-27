package com.tmtc.utils.HeepayShortPay.HeepayReturn;

public class QueryPayReturn {
	//商户订单号，必须唯一
	private String _agent_bill_id;
	//商户订单时间格式：2014/4/11 17:37:06
	private String _agent_bill_time;
	//汇元银通订单处理时间，格式为：2014/4/11 17:36:14
	private String _hy_deal_time;
	//汇元银通订单号
	private String _hy_bill_no;
	//支付金额，单位：元，保留二位小数
	private String _pay_amt;
	//实际支付金额，单位：元，保留二位小数
	private String _real_amt;
	//订单状态	交易成功：SUCCESS 等待付款：WFPAYMENT 交易关闭：CLOSED 退款成功：REFUND
	private String _status;
	//退款状态	未退款：NOREFUND	处理中：INREFUND	处理完成：REFUND	退款失败：FAILURE
	private String _refund_status;
	//退款金额单位：元，	未退款默认为0.00	保留二位小数
	private String _refund_fee;
	private String _goods_name;//商品名称
	private String _goods_note;//商品描述
	private String _goods_num;//商品数量
	public String get_agent_bill_id() {
		return _agent_bill_id;
	}
	public void set_agent_bill_id(String _agent_bill_id) {
		this._agent_bill_id = _agent_bill_id;
	}
	public String get_agent_bill_time() {
		return _agent_bill_time;
	}
	public void set_agent_bill_time(String _agent_bill_time) {
		this._agent_bill_time = _agent_bill_time;
	}
	public String get_hy_deal_time() {
		return _hy_deal_time;
	}
	public void set_hy_deal_time(String _hy_deal_time) {
		this._hy_deal_time = _hy_deal_time;
	}
	public String get_hy_bill_no() {
		return _hy_bill_no;
	}
	public void set_hy_bill_no(String _hy_bill_no) {
		this._hy_bill_no = _hy_bill_no;
	}
	public String get_pay_amt() {
		return _pay_amt;
	}
	public void set_pay_amt(String _pay_amt) {
		this._pay_amt = _pay_amt;
	}
	public String get_real_amt() {
		return _real_amt;
	}
	public void set_real_amt(String _real_amt) {
		this._real_amt = _real_amt;
	}
	public String get_status() {
		return _status;
	}
	public void set_status(String _status) {
		this._status = _status;
	}
	public String get_refund_status() {
		return _refund_status;
	}
	public void set_refund_status(String _refund_status) {
		this._refund_status = _refund_status;
	}
	public String get_refund_fee() {
		return _refund_fee;
	}
	public void set_refund_fee(String _refund_fee) {
		this._refund_fee = _refund_fee;
	}
	public String get_goods_name() {
		return _goods_name;
	}
	public void set_goods_name(String _goods_name) {
		this._goods_name = _goods_name;
	}
	public String get_goods_note() {
		return _goods_note;
	}
	public void set_goods_note(String _goods_note) {
		this._goods_note = _goods_note;
	}
	public String get_goods_num() {
		return _goods_num;
	}
	public void set_goods_num(String _goods_num) {
		this._goods_num = _goods_num;
	}
}
