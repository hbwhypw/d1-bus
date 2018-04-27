package com.tmtc.utils.HeepayShortPay.HeepayMain;

import com.tmtc.utils.HeepayShortPay.Common.AES;
import com.tmtc.utils.HeepayShortPay.Common.DataHelper;
import com.tmtc.utils.HeepayShortPay.Common.HeepPayConfig;
import com.tmtc.utils.HeepayShortPay.Common.Md5Tools;
import com.tmtc.utils.HeepayShortPay.HeepayReturn.HeepayXMLReturn;

import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class HeepaySendPaySMS {

    public static boolean SendPaySMS(String agent_id, String hy_auth_uid, String hy_token_id) throws Exception {
        //组装get请求URL
        String postData = GetSendPaySMSRequestData(agent_id, hy_auth_uid, hy_token_id);
        //根据提交订单的请求URL返回的XML数据
        //<?xml version="1.0" encoding="utf-8"?><root><ret_code>0000</ret_code><ret_msg>成功，请重定向进行下一步操作</ret_msg><encrypt_data><![CDATA[base64加密串]]></encrypt_data><sign>7a89830ba1101216aa7367b3dd259efd</sign></root>
        String payheepReturnxml = DataHelper.RequestPostUrl(HeepPayConfig.HeepaySendPaySMSUrl, postData);
        HeepayXMLReturn payheepReturn = DataHelper.GetRetuenXmlContent(payheepReturnxml);
        //是否成功.
        boolean isSucess = "0000".equals(payheepReturn.get_retcode());
        if (!isSucess) {

            //记录失败原因 :payheepReturn.get_retmsg()
        }
        return isSucess;
    }

    private static String GetSendPaySMSRequestData(String agent_id, String hy_auth_uid, String hy_token_id) throws Exception {

        //对应的值请参考文档 DEMO中的数据为参考
        Map<String, String> mapData = new HashMap<String, String>();
        mapData.put("agent_id", agent_id); //参考文档 汇付宝分配给商户的ID
        mapData.put("version", "1");//参考文档默认为1
        mapData.put("hy_auth_uid", hy_auth_uid);
        mapData.put("hy_token_id", hy_token_id);//参考文档
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
