package com.tmtc.utils.HeepayShortPay.HeepayReturn;

/**
 * Function: 同步通知返回结果
 * @auther: hbwhypw
 * Date: 2015-11-18 16:39
 */
public class SyncNotifyReturn {
    private Integer agent_id;
    private String agent_bill_id;
    private String agent_bill_time;
    private String hy_bill_no;
    private String hy_deal_time;
    private String hy_deal_note;
    private Double pay_amt;
    private Double real_amt;
    private String status;
    private String ext_param1;
    private String ext_param2;

    public Integer getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(Integer agent_id) {
        this.agent_id = agent_id;
    }

    public String getAgent_bill_id() {
        return agent_bill_id;
    }

    public void setAgent_bill_id(String agent_bill_id) {
        this.agent_bill_id = agent_bill_id;
    }

    public String getAgent_bill_time() {
        return agent_bill_time;
    }

    public void setAgent_bill_time(String agent_bill_time) {
        this.agent_bill_time = agent_bill_time;
    }

    public String getHy_bill_no() {
        return hy_bill_no;
    }

    public void setHy_bill_no(String hy_bill_no) {
        this.hy_bill_no = hy_bill_no;
    }

    public String getHy_deal_time() {
        return hy_deal_time;
    }

    public void setHy_deal_time(String hy_deal_time) {
        this.hy_deal_time = hy_deal_time;
    }

    public String getHy_deal_note() {
        return hy_deal_note;
    }

    public void setHy_deal_note(String hy_deal_note) {
        this.hy_deal_note = hy_deal_note;
    }

    public Double getPay_amt() {
        return pay_amt;
    }

    public void setPay_amt(Double pay_amt) {
        this.pay_amt = pay_amt;
    }

    public Double getReal_amt() {
        return real_amt;
    }

    public void setReal_amt(Double real_amt) {
        this.real_amt = real_amt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExt_param1() {
        return ext_param1;
    }

    public void setExt_param1(String ext_param1) {
        this.ext_param1 = ext_param1;
    }

    public String getExt_param2() {
        return ext_param2;
    }

    public void setExt_param2(String ext_param2) {
        this.ext_param2 = ext_param2;
    }
}
