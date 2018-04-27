package com.tmtc.utils.HeepayShortPay.HeepayMain;

import com.tmtc.utils.HeepayShortPay.Common.AES;
import com.tmtc.utils.HeepayShortPay.Common.DataHelper;
import com.tmtc.utils.HeepayShortPay.Common.HeepPayConfig;
import com.tmtc.utils.HeepayShortPay.Common.Md5Tools;
import com.tmtc.utils.HeepayShortPay.HeepayReturn.HeepayQueryAuthBanksReturn;
import com.tmtc.utils.HeepayShortPay.HeepayReturn.HeepayXMLReturn;

import java.net.URLEncoder;
import java.util.*;

/**
 * Function:
 * @auther: hbwhypw
 * Date: 2015-11-16 10:07
 */
public class HeepayQueryAuthBanks {

    public static List<HeepayQueryAuthBanksReturn> QueryAuthBanks(String user_identity) throws Exception {
        String agent_id = HeepPayConfig.Const_agent_id;
        //组装get请求URL
        String postData = GetQueryBanksRequestData(agent_id, user_identity);
        //根据提交订单的请求URL返回的XML数据
        //<?xml version="1.0" encoding="utf-8"?><root><ret_code>0000</ret_code><ret_msg>成功，请重定向进行下一步操作</ret_msg><encrypt_data><![CDATA[base64加密串]]></encrypt_data><sign>7a89830ba1101216aa7367b3dd259efd</sign></root>
        String payheepReturnxml = DataHelper.RequestPostUrl(HeepPayConfig.HeepayQueryAuthBanksUrl, postData);
        HeepayXMLReturn payheepReturn = DataHelper.GetRetuenXmlContent(payheepReturnxml);
        //是否成功.
        boolean isSucess = "0000".equals(payheepReturn.get_retcode());
        if (!isSucess) {
            //记录失败原因 :payheepReturn.get_retmsg()
//            System.out.println(payheepReturn.get_retmsg());
            return null;
        }

        //为返回XML的加密的DATA
        String encrypt_data = payheepReturn.get_encryptdata();
        //解析XML返回的加密信息解密后的信息
        String payheepReturnData = AES.Decrypt(encrypt_data, HeepPayConfig.Const_data_key);
        //记录返回值的LOG payheepReturn
        Map<String, String> mapValues = DataHelper.URLRequestParams(payheepReturnData);
        List<HeepayQueryAuthBanksReturn> list = new ArrayList<HeepayQueryAuthBanksReturn>();
        if (mapValues.containsKey("auth_uid_Info")) {
            //返回格式 卡类型(0,1)_银行ID2_银行名字;卡类型(0,1)_银行ID1_银行名字2
            String banks = mapValues.get("auth_uid_Info");
            String[] bankArray = banks.split(";");
            for (int i = 0; i < bankArray.length; i++) {
                HeepayQueryAuthBanksReturn queryAuthBanksReturn = new HeepayQueryAuthBanksReturn();
                String[] bank = bankArray[i].split("_");
                queryAuthBanksReturn.set_bank_id(bank[0]);
                queryAuthBanksReturn.set_bank_name(bank[1]);
                queryAuthBanksReturn.set_card_end_num(bank[2]);
                queryAuthBanksReturn.set_card_type(bank[3]);////卡类型 信用卡0 储蓄卡1
                queryAuthBanksReturn.set_auth_code(bank[4]);//授权码
                list.add(queryAuthBanksReturn);
            }
        }
        return list;
    }

    private static String GetQueryBanksRequestData(String agent_id, String user_identity)
            throws Exception {
        //对应的值请参考文档 DEMO中的数据为参考
        Map<String, String> mapData = new HashMap<String, String>();
        mapData.put("agent_id", agent_id); //参考文档 汇付宝分配给商户的ID
        mapData.put("version", "1");//参考文档默认为1
        Calendar calTime = Calendar.getInstance();
        long time = calTime.getTimeInMillis();//以1970年1月1日0:0:0为基线的毫秒
        mapData.put("timestamp", String.valueOf(time));
        mapData.put("user_identity", user_identity);//商户用户唯一标识，用户id
        // 生成SIGN 需要将商户签名KEY加入后MD5
        mapData.put("key", HeepPayConfig.Const_sign_key);//签名需要加入KEY
        String getSignData = DataHelper.GetSortQueryToLowerString(mapData);
        String sign = Md5Tools.MD5(getSignData).toLowerCase();
//        System.out.println("sign md5: " + getSignData);
        //平台之间的转码
        DataHelper.TranferCharsetEncode(mapData);
        //生成 encrypt_data
        String[] filterKeys = {"agent_id", "key"};
        String getEncryptData = DataHelper.GetSortFilterQueryString(mapData, filterKeys);
//        System.out.println("getEncryptData: " + getEncryptData);
        //AES加密后 的URLENCODE字符串
//        String encrypt_data = URLEncoder.encode(Md5Tools.MD5(getEncryptData), DataHelper.UTF8Encode);
        String encrypt_data=URLEncoder.encode(AES.Encrypt(getEncryptData, HeepPayConfig.Const_data_key),DataHelper.UTF8Encode);
        Map<String, String> mapResultData = new HashMap<String, String>();
        mapResultData.put("agent_id", agent_id); //参考文档 汇付宝分配给商户的ID
        mapResultData.put("encrypt_data", encrypt_data);
        mapResultData.put("sign", sign);
        String params = DataHelper.GetSortQueryString(mapResultData);

//        System.out.println("params: " + params);
        return params;

    }
}
