package com.tmtc.utils.HeepayShortPay.HeepayMain;

import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.tmtc.utils.HeepayShortPay.Common.AES;
import com.tmtc.utils.HeepayShortPay.Common.DataHelper;
import com.tmtc.utils.HeepayShortPay.Common.HeepPayConfig;
import com.tmtc.utils.HeepayShortPay.Common.Md5Tools;
import com.tmtc.utils.HeepayShortPay.HeepayReturn.HeepayXMLReturn;
import com.tmtc.utils.HeepayShortPay.HeepayReturn.SubmitOrderReturn;

/**
 * 商户提交订单 获取跳转汇付宝地址以及返回值， 以及直接调用接口获取 返回值 不需要自定义支付页面的商户直接SubmitOrderReques
 * 根据返回的URL导航 需要自定义支付页面的商户 调用SubmitOrder 返回结果 再去请求HeepaySendOpenAuthPaySMS
 * 发送签约支付短信
 */
public class HeepaySubmitOrder {

	// @org.junit.Test
	// public void SubmitOrder() throws Exception {
	//
	// SubmitOrderReques();
	//// String aes1=AES.Encrypt("111",
	// "bsxAqXDTbawirsa0dQR0EaXaFqKG/xd7h3phJMcu/L0=");
	//// String aes2=AES.Decrypt(aes1,
	// "bsxAqXDTbawirsa0dQR0EaXaFqKG/xd7h3phJMcu/L0=");
	//// String xmls="<?xml version=\"1.0\"
	// encoding=\"utf-8\"?><root><ret_code>E100</ret_code><ret_msg><![CDATA[sadddddd地方咚咚咚咚咚咚]]></ret_msg></root>";
	//// HeepayXMLReturn Result=DataHelper.GetXmlContent(xmls);
	//// String
	// md5=Md5Tools.MD5("agent_bill_id=32132132433&agent_bill_time=20131226110704&agent_id=27652&auth_card_type=0&custom_page=0&device_id=&device_type=0&display=1&ext_param1=&ext_param2=&goods_name=&goods_note=&goods_num=&hy_auth_uid=&key=e916b29a0bd241c6bcf61ea5&mobile=13888888999&notify_url=http://192.168.2.100/shortpaytestweb/returnpage.aspx&pay_amt=0.01&return_url=http://192.168.2.100/shortpaytestweb/returnpage.aspx&timestamp=1388027225166&user_identity=&user_ip=&version=1");
	// }

	/**
	 * 自定义支付页面开通直接访问汇付宝接口用户调用
	 */
	public static SubmitOrderReturn SubmitOrder(String agent_id, String user_identity, String hy_auth_uid,
			String mobile, String device_type, String device_id, String custom_page, String display, String return_url,
			String notify_url, String agent_bill_id, String agent_bill_time, String pay_amt, String goods_name,
			String goods_note, String goods_num, String user_ip, String ext_param1, String ext_param2,
			String auth_card_type) throws Exception {
		// 组装get请求URL
		String postData = GetSubmitOrderRequestData(agent_id, user_identity, hy_auth_uid, mobile, device_type,
				device_id, custom_page, display, return_url, notify_url, agent_bill_id, agent_bill_time, pay_amt,
				goods_name, goods_note, goods_num, user_ip, ext_param1, ext_param2, auth_card_type);
		// System.out.println(postData);
		// 根据提交订单的请求URL返回的XML数据
		// <?xml version="1.0"
		// encoding="utf-8"?><root><ret_code>0000</ret_code><ret_msg>成功，请重定向进行下一步操作</ret_msg><encrypt_data><![CDATA[base64加密串]]></encrypt_data><sign>7a89830ba1101216aa7367b3dd259efd</sign></root>
		String payheepReturnxml = DataHelper.RequestPostUrl(HeepPayConfig.HeepaySubmitOrderRequestUrl, postData);
		HeepayXMLReturn payheepReturn = DataHelper.GetRetuenXmlContent(payheepReturnxml);
		// 是否成功.
		boolean isSucess = "0000".equals(payheepReturn.get_retcode());
		SubmitOrderReturn submitReturn = new SubmitOrderReturn();
		submitReturn.set_isSuccess(isSucess);
		if (isSucess) {
			// 为返回XML的加密的DATA
			String encrypt_data = payheepReturn.get_encryptdata();
			// 解析XML返回的加密信息解密后的信息
			String payheepReturnData = AES.Decrypt(encrypt_data, HeepPayConfig.Const_data_key);
			// 记录返回值的LOG payheepReturn
			Map<String, String> mapValues = DataHelper.URLRequestParams(payheepReturnData);

			/************************************************************/
			// 商户需要保存并核对的信息 如果预约授权码与授权码相等 代表该用户在商户与汇付宝都没有签约记录
			// 商户需要保存授权码 从第二次开始 每次都需要将授权码赋值请求订单 详细见GetSubmitOrderRequestUrl 中的
			// hy_auth_uid 赋值
			// 返回的授权码 和保存的授权码比对 以本次返回的为主保存 以授权码认证是否用户已经签约
			// 预约授权码
			// String pre_auth_uid=mapValues.get("pre_auth_uid");
			// 授权码
			String return_hy_auth_uid = mapValues.get("hy_auth_uid");
			// 商户订单号
			String return_agent_bill_id = mapValues.get("agent_bill_id");
			// 商户ID
			String return_agent_id = mapValues.get("agent_id");
			// 汇付宝订单号 商户可以保留对账等使用
			String return_hy_token_id = mapValues.get("hy_token_id");
			// 需要请求的下一步URL地址
			String nextStepUrl = mapValues.get("redirect_url");
			// submitReturn.set_pre_auth_uid(pre_auth_uid);
			submitReturn.set_hy_auth_uid(return_hy_auth_uid);
			submitReturn.set_agent_bill_id(return_agent_bill_id);
			submitReturn.set_agent_id(return_agent_id);
			submitReturn.set_hy_token_id(return_hy_token_id);

			// 返回的结果验证的签名串 请求下一步URL时追加
			String sign = mapValues.get("sign");
			String requestEncryptData = mapValues.get("encrypt_data");
			Map<String, String> mapResultData = new HashMap<String, String>();
			mapResultData.put("agent_id", agent_id); // 参考文档 汇付宝分配给商户的ID
			mapResultData.put("encrypt_data", requestEncryptData);
			mapResultData.put("sign", sign);
			String params = DataHelper.GetSortQueryString(mapResultData);
			// 汇付宝支付页面地址
			String nextStepResultUrl = nextStepUrl.concat("?").concat(params);
			submitReturn.set_redirect_url(nextStepResultUrl);
			// 跳转到nextStepResultUrl 我方页面进行支付即可
			// 如需自定义页面进行支付的 需要联系我方业务方 开通 后台直接调用我方接口 然后给出开发文档
			// String directUrl=nextStepResultUrl;
			/**********************************************************/

		} else // 失败记录 返回值与日志。。。
		{
			submitReturn.set_error_message(payheepReturn.get_retmsg());
			// System.out.println("失败记录日志:" + payheepReturn.get_retmsg());
			// 记录请求返回值
			// mapValues.get("ret_code") 错误代码
			// mapValues.get("ret_msg") 错误描述
			// 为返回XML的加密的DATA
			// 为返回XML的加密的DATA
			String encrypt_data = payheepReturn.get_encryptdata();
			// 解析XML返回的加密信息解密后的信息
			String payheepReturnData = AES.Decrypt(encrypt_data, HeepPayConfig.Const_data_key);
		}

		return submitReturn;
	}

	/**
	 * 注意 中文 请求请转化为GBK String goods_name=new
	 * String("商品名称".getBytes(DataHelper.UTF8Encode),DataHelper.GBKEncode);
	 * 如果确认参数没有问题 提示SIGN签名不正确或者加密数据不正确 ，请将中文换成英文测试 如果测试成功代表编码问题
	 */
	private static String GetSubmitOrderRequestData(String agent_id, String user_identity, String hy_auth_uid,
			String mobile, String device_type, String device_id, String custom_page, String display, String return_url,
			String notify_url, String agent_bill_id, String agent_bill_time, String pay_amt, String goods_name,
			String goods_note, String goods_num, String user_ip, String ext_param1, String ext_param2,
			String auth_card_type) throws Exception {
		// 对应的值请参考文档 DEMO中的数据为参考
		Map<String, String> mapData = new HashMap<String, String>();
		mapData.put("agent_id", agent_id); // 参考文档 汇付宝分配给商户的ID
		mapData.put("version", "1");// 参考文档默认为1
		mapData.put("user_identity", user_identity);// 商户自身用户的唯一标识
		mapData.put("hy_auth_uid", hy_auth_uid);// 授权码
												// 第一次提交订单时为空，授权后返回的授权码需要商户保存，以后该用户用该授权的银行卡支付时
												// 将保存后的授权码赋值，每次请求后需要对比授权码是否和本地的相同
												// 不相同以最后一次返回的授权码为主
		mapData.put("mobile", mobile);// 银行卡注册手机
		mapData.put("device_type", device_type);// 参考文档
		mapData.put("device_id", device_id);// 参考文档
		mapData.put("custom_page", custom_page);// 参考文档 0 为在汇付宝进行支付
		mapData.put("display", display);// 参考文档
		mapData.put("return_url", return_url);// 参考文档支付异步通知地址
		mapData.put("notify_url", notify_url);// 参考文档返回商户页面地址
		mapData.put("agent_bill_id", agent_bill_id);// 参考文档 商户不重复订单号
		mapData.put("agent_bill_time", agent_bill_time);// 参考文档 订单日期
		mapData.put("pay_amt", pay_amt);// 参考文档 支付金额
		mapData.put("goods_name", goods_name);// 参考文档 商品名称
		mapData.put("goods_note", goods_note);// 参考文档 商品说明
		mapData.put("goods_num", goods_num);// 参考文档 商品数量
		mapData.put("user_ip", user_ip);// 参考文档 当前支付用户IP
		mapData.put("ext_param1", ext_param1);// 参考文档 用户扩展参数1 通知时原值返回
		mapData.put("ext_param2", ext_param2);// 参考文档 用户扩展参数2 通知时原值返回
		mapData.put("auth_card_type", auth_card_type);// 0储蓄卡 1信用卡 -1未知
		Calendar calTime = Calendar.getInstance();
		long time = calTime.getTimeInMillis();// 以1970年1月1日0:0:0为基线的毫秒
		mapData.put("timestamp", String.valueOf(time));
		// 生成SIGN 需要将商户签名KEY加入后MD5
		mapData.put("key", HeepPayConfig.Const_sign_key);// 签名需要加入KEY
		String getSignData = DataHelper.GetSortQueryToLowerString(mapData);
		String sign = Md5Tools.MD5(getSignData).toLowerCase();
		// 平台之间的转码
		DataHelper.TranferCharsetEncode(mapData);
		// 生成 encrypt_data
		String[] filterKeys = { "agent_id", "key" };
		String getEncryptData = DataHelper.GetSortFilterQueryString(mapData, filterKeys);
		// AES加密后 的URLENCODE字符串
		String encrypt_data = URLEncoder.encode(AES.Encrypt(getEncryptData, HeepPayConfig.Const_data_key),
				DataHelper.UTF8Encode);

		Map<String, String> mapResultData = new HashMap<String, String>();
		mapResultData.put("agent_id", agent_id); // 参考文档 汇付宝分配给商户的ID
		mapResultData.put("encrypt_data", encrypt_data);
		mapResultData.put("sign", sign);
		String params = DataHelper.GetSortQueryString(mapResultData);
		return params;
	}
}
