package com.tmtc.utils.HeepayShortPay.HeepayMain;

import com.tmtc.utils.HeepayShortPay.Common.AES;
import com.tmtc.utils.HeepayShortPay.Common.DataHelper;
import com.tmtc.utils.HeepayShortPay.Common.HeepPayConfig;
import com.tmtc.utils.HeepayShortPay.Common.Md5Tools;
import com.tmtc.utils.HeepayShortPay.HeepayReturn.HeepayXMLReturn;
import com.tmtc.utils.HeepayShortPay.HeepayReturn.QueryPayReturn;

import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class HeepayQueryPay {

    public static QueryPayReturn QueryPay(String agent_bill_id) throws Exception {
        String agent_id = HeepPayConfig.Const_agent_id;
        QueryPayReturn queryPayReturn = new QueryPayReturn();
        //组装get请求URL
        String postData = GetShortQueryPayRequestData(agent_id, agent_bill_id);
        //根据提交订单的请求URL返回的XML数据
        //<?xml version="1.0" encoding="utf-8"?><root><ret_code>0000</ret_code><ret_msg>成功，请重定向进行下一步操作</ret_msg><encrypt_data><![CDATA[base64加密串]]></encrypt_data><sign>7a89830ba1101216aa7367b3dd259efd</sign></root>
        String payheepReturnxml = DataHelper.RequestPostUrl(HeepPayConfig.HeepayQueryPayUrl, postData);
        HeepayXMLReturn payheepReturn = DataHelper.GetRetuenXmlContent(payheepReturnxml);
        //是否成功.
        boolean isSucess = payheepReturn.get_is_success();
        if (!isSucess) {
            //记录失败原因 :payheepReturn.get_retmsg()
            return null;
        }

        //为返回XML的加密的DATA
        String encrypt_data = payheepReturn.get_encryptdata();
        //解析XML返回的加密信息解密后的信息
        String payheepReturnData = AES.Decrypt(encrypt_data, HeepPayConfig.Const_data_key);
        //记录返回值的LOG payheepReturn
        Map<String, String> mapValues = DataHelper.URLRequestParams(payheepReturnData);
        if (!mapValues.get("ret_code").equals("0000")) {
            //失败 记录日志返回 mapValues.get("ret_msg")
            return null;
        }
        queryPayReturn.set_agent_bill_id(mapValues.get("agent_bill_id"));
        queryPayReturn.set_agent_bill_time(mapValues.get("agent_bill_time"));
        queryPayReturn.set_goods_name(mapValues.get("goods_name"));
        queryPayReturn.set_goods_note(mapValues.get("goods_note"));
        queryPayReturn.set_goods_num(mapValues.get("goods_num"));
        queryPayReturn.set_hy_bill_no(mapValues.get("hy_bill_no"));
        queryPayReturn.set_hy_deal_time(mapValues.get("hy_deal_time"));
        queryPayReturn.set_pay_amt(mapValues.get("pay_amt"));
        queryPayReturn.set_real_amt(mapValues.get("real_amt"));
        queryPayReturn.set_refund_fee(mapValues.get("refund_fee"));
        queryPayReturn.set_refund_status(mapValues.get("refund_status"));
        queryPayReturn.set_status(mapValues.get("status"));

        return queryPayReturn;
    }


    private static String GetShortQueryPayRequestData(String agent_id, String agent_bill_id) throws Exception {
        //对应的值请参考文档 DEMO中的数据为参考
        Map<String, String> mapData = new HashMap<String, String>();
        mapData.put("agent_id", agent_id); //参考文档 汇付宝分配给商户的ID
        mapData.put("version", "1");//参考文档默认为1
        mapData.put("agent_bill_id", agent_bill_id);//商户订单号
        Calendar calTime = Calendar.getInstance();
        long time = calTime.getTimeInMillis();//以1970年1月1日0:0:0为基线的毫秒
        mapData.put("timestamp", String.valueOf(time));
        // 生成SIGN 需要将商户签名KEY加入后MD5
        mapData.put("key", HeepPayConfig.Const_sign_key);//签名需要加入KEY
        String getSignData = DataHelper.GetSortQueryToLowerString(mapData);
        String sign = Md5Tools.MD5(getSignData).toLowerCase();
        //平台之间的转码
        DataHelper.TranferCharsetEncode(mapData);
        //生成 encrypt_data
        String[] filterKeys = {"agent_id", "key"};
        String getEncryptData = DataHelper.GetSortFilterQueryString(mapData, filterKeys);
        //AES加密后 的URLENCODE字符串
        String encrypt_data = URLEncoder.encode(AES.Encrypt(getEncryptData, HeepPayConfig.Const_data_key), DataHelper.UTF8Encode);

        Map<String, String> mapResultData = new HashMap<String, String>();
        mapResultData.put("agent_id", agent_id); //参考文档 汇付宝分配给商户的ID
        mapResultData.put("encrypt_data", encrypt_data);
        mapResultData.put("sign", sign);
        String params = DataHelper.GetSortQueryString(mapResultData);

        return params;

    }
}
