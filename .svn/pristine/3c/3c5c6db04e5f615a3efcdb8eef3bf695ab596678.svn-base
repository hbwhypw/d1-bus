package com.tmtc.utils.HeepayShortPay.HeepayMain;

import com.tmtc.utils.HeepayShortPay.Common.AES;
import com.tmtc.utils.HeepayShortPay.Common.DataHelper;
import com.tmtc.utils.HeepayShortPay.Common.HeepPayConfig;
import com.tmtc.utils.HeepayShortPay.Common.Md5Tools;
import com.tmtc.utils.HeepayShortPay.HeepayReturn.HeepayQueryBanksReturn;
import com.tmtc.utils.HeepayShortPay.HeepayReturn.HeepayXMLReturn;

import java.net.URLEncoder;
import java.util.*;

public class HeepayQueryBanks {

    public static boolean QueryBanks() throws Exception {
        String agent_id = HeepPayConfig.Const_agent_id;
        //组装get请求URL
        String postData = GetQueryBanksRequestData(agent_id);
        //根据提交订单的请求URL返回的XML数据
        //<?xml version="1.0" encoding="utf-8"?><root><ret_code>0000</ret_code><ret_msg>成功，请重定向进行下一步操作</ret_msg><encrypt_data><![CDATA[base64加密串]]></encrypt_data><sign>7a89830ba1101216aa7367b3dd259efd</sign></root>
        String payheepReturnxml = DataHelper.RequestPostUrl(HeepPayConfig.HeepayQueryBanksUrl, postData);
        HeepayXMLReturn payheepReturn = DataHelper.GetRetuenXmlContent(payheepReturnxml);
        //是否成功.
        boolean isSucess = "0000".equals(payheepReturn.get_retcode());
        if (!isSucess) {
            //记录失败原因 :payheepReturn.get_retmsg()
            return false;
        }

        //为返回XML的加密的DATA
        String encrypt_data = payheepReturn.get_encryptdata();
        //解析XML返回的加密信息解密后的信息
        String payheepReturnData = AES.Decrypt(encrypt_data, HeepPayConfig.Const_data_key);
        //记录返回值的LOG payheepReturn
        Map<String, String> mapValues = DataHelper.URLRequestParams(payheepReturnData);
        if (mapValues.containsKey("banks")) {
            //返回格式 卡类型(0,1)_银行ID2_银行名字;卡类型(0,1)_银行ID1_银行名字2
            String banks = mapValues.get("banks");
            List<HeepayQueryBanksReturn> list = new ArrayList<HeepayQueryBanksReturn>();
            String[] bankArray = banks.split(";");
            for (int i = 0; i < bankArray.length; i++) {
                HeepayQueryBanksReturn queryBanksReturn = new HeepayQueryBanksReturn();
                String[] bank = bankArray[i].split("_");
                queryBanksReturn.set_card_type(bank[0]);////卡类型 信用卡0 储蓄卡1
                queryBanksReturn.set_bank_id(bank[1]);
                queryBanksReturn.set_bank_name(bank[2]);
                list.add(queryBanksReturn);
            }

        }
        return true;
    }

    private static String GetQueryBanksRequestData(String agent_id) throws Exception {

        //对应的值请参考文档 DEMO中的数据为参考
        Map<String, String> mapData = new HashMap<String, String>();
        mapData.put("agent_id", agent_id); //参考文档 汇付宝分配给商户的ID
        mapData.put("version", "2");//参考文档默认为2
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
