package com.tmtc.utils.HeepayShortPay.HeepayMain;

import com.tmtc.utils.HeepayShortPay.Common.AES;
import com.tmtc.utils.HeepayShortPay.Common.DataHelper;
import com.tmtc.utils.HeepayShortPay.Common.HeepPayConfig;
import com.tmtc.utils.HeepayShortPay.Common.Md5Tools;
import com.tmtc.utils.HeepayShortPay.HeepayReturn.ConfirmOpenAuthPayReturn;
import com.tmtc.utils.HeepayShortPay.HeepayReturn.HeepayXMLReturn;
import com.tmtc.utils.HeepayShortPay.HeepayReturn.SendOpenAuthPaySMSReturn;

import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


/**
 * 确认授权并支付 只有当HeepaySendOpenAuthPaySMS.SendOpenAuthPaySMSReturn 返回is_success() ==true
 * 并且isHas_bank_auth() ==false 时 才调用此类的方法
 */
public class HeepayConfirmOpenAuthPay {

    /* 确定授权并支付方法  没有授权的用户才能直接调用 */
    public ConfirmOpenAuthPayReturn ConfirmOpenAuthPay(SendOpenAuthPaySMSReturn sendOpenAuthPaySMSReturn) throws Exception {
        ConfirmOpenAuthPayReturn confirmOpenAuthPayReturn = new ConfirmOpenAuthPayReturn();
        confirmOpenAuthPayReturn.set_isSuccess(false);

        SendOpenAuthPaySMSReturn sendOpenAuth = new SendOpenAuthPaySMSReturn();
        sendOpenAuth.set_success(false);
        //只有HeepaySubmitOrder.SubmitOrder() 返回对象 显示提交订单成功才能继续
        //获取授权支付的短信验证码
//		  if(!sendOpenAuthPaySMSReturn.is_success()) return confirmOpenAuthPayReturn;
//		  if(sendOpenAuthPaySMSReturn.is_has_bank_auth()) return confirmOpenAuthPayReturn;

        String postData = GetConfirmOpenAuthPayRequestData(sendOpenAuthPaySMSReturn);
        //<?xml version="1.0" encoding="utf-8"?><root><ret_code>0000</ret_code><ret_msg>成功，请重定向进行下一步操作</ret_msg><encrypt_data><![CDATA[base64加密串]]></encrypt_data><sign>7a89830ba1101216aa7367b3dd259efd</sign></root>
        String payheepReturnxml = DataHelper.RequestPostUrl(HeepPayConfig.HeepayConfirmOpenAuthPayRequestUrl, postData);
        HeepayXMLReturn payheepReturn = DataHelper.GetRetuenXmlContent(payheepReturnxml);
        //是否成功.
        boolean isSucess = "0000".equals(payheepReturn.get_retcode());
        confirmOpenAuthPayReturn.set_isSuccess(isSucess);
        if (isSucess) {
            return confirmOpenAuthPayReturn;
        } else {//失败记录 返回值与日志。。。

            //记录请求返回值
            //mapValues.get("ret_code") 错误代码
            //mapValues.get("ret_msg") 错误描述
            //为返回XML的加密的DATA
            //为返回XML的加密的DATA
            String encrypt_data = payheepReturn.get_encryptdata();
            //解析XML返回的加密信息解密后的信息
            String payheepReturnData = AES.Decrypt(encrypt_data, HeepPayConfig.Const_data_key);
            confirmOpenAuthPayReturn.set_error_message(payheepReturn.get_retmsg());

            return confirmOpenAuthPayReturn;
        }
    }

    /*
     注意 中文 请求请转化为UTF-8 String goods_name = new String ("测试".getBytes(),DataHelper.UTF8Encode);
     如果确认参数没有问题 提示SIGN签名不正确或者加密数据不正确 ，请将中文换成英文测试 如果测试成功代表编码问题
     */
    private static String GetConfirmOpenAuthPayRequestData(SendOpenAuthPaySMSReturn sendOpenAuthPaySMSReturn) throws Exception {
        String agent_id = HeepPayConfig.Const_agent_id;// 汇付宝分配给商户的ID
        //对应的值请参考文档 DEMO中的数据为参考
        Map<String, String> mapData = new HashMap<String, String>();
        mapData.put("agent_id", agent_id); //参考文档 汇付宝分配给商户的ID
        mapData.put("hy_auth_uid", sendOpenAuthPaySMSReturn.get_hy_auth_uid());//参考文档 正式授权码
        mapData.put("pre_auth_uid", sendOpenAuthPaySMSReturn.get_pre_auth_uid());//参考文档预约授权码
        mapData.put("hy_token_id", sendOpenAuthPaySMSReturn.get_hy_token_id());//参考文档 token_id
        mapData.put("verify_code", "123456");//发送到用户手机的授权支付短信
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
