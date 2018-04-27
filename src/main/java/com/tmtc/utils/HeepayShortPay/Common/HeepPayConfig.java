package com.tmtc.utils.HeepayShortPay.Common;

/*汇付宝 分配的资源信息*/
public class HeepPayConfig {
    //HEEPAY分配给商户ID
    public static final String Const_agent_id = "2007781";
    //HEEPAY分配给商户的签名串
    public static final String Const_sign_key = "8BCC771E3E0D42A3A4178EEE";
    //HEEPAY分配给商户数据加密的秘钥
    public static final String Const_data_key = "ZVgW0pqcbtwQaotJMfradSw1jp33QGBAwYzzMrjjLBc=";
    //汇付宝提交订单地址
    public static final String HeepaySubmitOrderRequestUrl = "https://Pay.Heepay.com/ShortPay/SubmitOrder.aspx";
    //汇付宝发送授权支付短信地址
    public static final String HeepaySendOpenAuthPaySMSRequestUrl = "https://Pay.Heepay.com/PayHeepay/ShortPay/SendOpenAuthPaySMS.aspx";
    //汇付宝确认授权并支付
    public static final String HeepayConfirmOpenAuthPayRequestUrl = "https://Pay.Heepay.com/PayHeepay/ShortPay/ConfirmOpenAuthPay.aspx";
    //汇付宝确认支付
    public static final String HeepayConfirmPayRequestUrl = "https://Pay.Heepay.com/PayHeepay/ShortPay/ConfirmPay.aspx";
    //汇付宝发支付短信
    public static final String HeepaySendPaySMSUrl = "https://Pay.Heepay.com/PayHeepay/ShortPay/SendPaySMS.aspx";
    //汇付宝银行类表
    public static final String HeepayQueryBanksUrl = "https://Pay.Heepay.com/PayHeepay/API/ShortPay/ShortPayQueryBanks.aspx";
    //根据商家下的用户唯一标识 获取对应的授权信息
    public static final String HeepayQueryAuthBanksUrl = "https://Pay.Heepay.com/API/ShortPay/ShortPayQueryAuthBanks.aspx";
    //商户对账查询分页接口
    public static final String HeepayPayCheckUrl="https://Pay.Heepay.com/PayHeepay/API/ShortPay/ShortPayCheck.aspx";
    //商户订单查询
    public static final String HeepayQueryPayUrl="https://Pay.Heepay.com/PayHeepay/ShortPay/QueryPay.aspx";
    //关闭授权
    public static final String HeepayCloseAuthUrl="https://Pay.Heepay.com/PayHeepay/ShortPay/CloseAuth.aspx";
    //退款
    public static final String HeepaySubmitRefundUrl="https://Pay.Heepay.com/PayHeepay/ShortPay/SubmitRefund.aspx";

    public static final String WithholdCreateApplyUrl="https://Pay.Heepay.com/PayHeepay/API/WithholdPay/CreateApply.aspx";
}

