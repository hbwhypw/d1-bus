package com.tmtc.utils.HeepayShortPay.HeepayMain;

import com.tmtc.utils.HeepayShortPay.Common.AES;
import com.tmtc.utils.HeepayShortPay.Common.DataHelper;
import com.tmtc.utils.HeepayShortPay.Common.HeepPayConfig;
import com.tmtc.utils.HeepayShortPay.Common.Md5Tools;
import com.tmtc.utils.HeepayShortPay.HeepayReturn.HeepayXMLReturn;
import com.tmtc.utils.HeepayShortPay.HeepayReturn.SendOpenAuthPaySMSReturn;
import com.tmtc.utils.HeepayShortPay.HeepayReturn.SubmitOrderReturn;

import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


/**
 * 提交订单HeepaySubmitOrder.SubmitOrderReturn()后 如果返回 is_Success()==true 成功才能 根据返回值调用该类的方法
 */
public class HeepaySendOpenAuthPaySMS {
    /**
     * 先调用HeepaySubmitOrder.SubmitOrderInterFaceReques() 返回的SubmitOrderReturn 结果判断是否成功
     * 成功后根据返回的参数请求
     */
    public SendOpenAuthPaySMSReturn SendOpenAuthPaySMS(SubmitOrderReturn submitOrderResult) throws Exception {
        //只有HeepaySubmitOrder.SubmitOrder() 返回对象 显示提交订单成功才能继续
        //获取授权支付的短信验证码

        String postData = GetSendOpenAuthPaySMSRequestData(submitOrderResult);
        //<?xml version="1.0" encoding="utf-8"?><root><ret_code>0000</ret_code><ret_msg>成功，请重定向进行下一步操作</ret_msg><encrypt_data><![CDATA[base64加密串]]></encrypt_data><sign>7a89830ba1101216aa7367b3dd259efd</sign></root>
        String payheepReturnxml = DataHelper.RequestPostUrl(HeepPayConfig.HeepaySendOpenAuthPaySMSRequestUrl, postData);
        HeepayXMLReturn payheepReturn = DataHelper.GetRetuenXmlContent(payheepReturnxml);
        //是否成功.
        boolean isSucess = "0000".equals(payheepReturn.get_retcode());
        SendOpenAuthPaySMSReturn sendOpenAuth = new SendOpenAuthPaySMSReturn();
        sendOpenAuth.set_success(isSucess);
        if (isSucess) {
            //为返回XML的加密的DATA
            String encrypt_data = payheepReturn.get_encryptdata();
            //解析XML返回的加密信息解密后的信息
            String payheepReturnData = AES.Decrypt(encrypt_data, HeepPayConfig.Const_data_key);
            //记录返回值的LOG payheepReturn
            Map<String, String> mapValues = DataHelper.URLRequestParams(payheepReturnData);

            /************************************************************/
            //has_bank_auth 是否之前已经授权
            boolean has_bank_auth = Boolean.valueOf(mapValues.get("has_bank_auth"));
            String hy_auth_uid = mapValues.get("hy_auth_uid");
            String hy_token_id = mapValues.get("hy_token_id");
            String pre_auth_uid = mapValues.get("pre_auth_uid");
            sendOpenAuth.set_success(true);
            sendOpenAuth.set_has_bank_auth(has_bank_auth);
            sendOpenAuth.set_hy_auth_uid(hy_auth_uid);
            sendOpenAuth.set_hy_token_id(hy_token_id);
            sendOpenAuth.set_pre_auth_uid(pre_auth_uid);
            /**********************************************************/
            return sendOpenAuth;

        } else //失败记录 返回值与日志。。。
        {
            //记录请求返回值
            //mapValues.get("ret_code") 错误代码
            //mapValues.get("ret_msg") 错误描述
            //为返回XML的加密的DATA
            //为返回XML的加密的DATA
            sendOpenAuth.set_error_message(payheepReturn.get_retmsg());
            String encrypt_data = payheepReturn.get_encryptdata();
            //解析XML返回的加密信息解密后的信息
            String payheepReturnData = AES.Decrypt(encrypt_data, HeepPayConfig.Const_data_key);

            return sendOpenAuth;

        }
    }

    /**
     * 注意 中文 请求请转化为UTF-8 String bank_user = new String ("方大山".getBytes(DataHelper.UTF8Encode),DataHelper.GBKEncode);
     * DataHelper.GBKEncode 为当前开发环境的默认编码  DataHelper.UTF8Encode：为汇付宝默认编码
     * 如果确认参数没有问题 提示SIGN签名不正确或者加密数据不正确 ，请将中文换成英文测试 如果测试成功代表编码问题
     */
    private static String GetSendOpenAuthPaySMSRequestData(SubmitOrderReturn submitOrderResult) throws Exception {
        String agent_id = HeepPayConfig.Const_agent_id;// 汇付宝分配给商户的ID
        //对应的值请参考文档 DEMO中的数据为参考
        Map<String, String> mapData = new HashMap<String, String>();
        mapData.put("agent_id", agent_id); //参考文档 汇付宝分配给商户的ID
        mapData.put("mobile", "13606711930");//参考文档 手机号
        mapData.put("auth_card_type", "0");//0储蓄卡 1信用卡
        mapData.put("cert_no", "441322194508081119");//参考文档 身份证号
        mapData.put("bank_user", "方大山");//账户名
        mapData.put("bank_card_no", "6225885100000017");//银行卡号
        mapData.put("bank_cvv", "");//银行卡CVV 信用卡必填
        mapData.put("bank_expire_time", "");//信用卡有效期 四位   信用卡必填
        mapData.put("user_identity", "");//商户自身用户的唯一标识
        mapData.put("device_type", "0");//参考文档 设备类型
        mapData.put("device_id", "");//参考文档 设备唯一标识
        mapData.put("bank_id", "7");//参考文档 1.ICBC 工商银行 2.CCB 建设银行 3.ABC 农业银行 4.PSBC 邮政储蓄银行 5.BOC 中国银行
        //6.COMM 交通银行 7.CMB 招商银行 8.CEB 光大银行 9.SPDB 浦发银行 10.HXBANK 华夏银行
        //11.GDB 广东发展银行 12.CITIC 中信银行 13.CIB 兴业银行 14.CMBC 民生银行 15.HZCB 杭州银行
        //16.SHBANK 上海银行 17.NBBANK 宁波银行 18.SPABANK 平安银行
        mapData.put("hy_token_id", submitOrderResult.get_hy_token_id());//参考文档
        mapData.put("pre_auth_uid", submitOrderResult.get_pre_auth_uid());//参考文档 为提交订单后的授权码
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
