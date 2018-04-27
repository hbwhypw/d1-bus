package com.tmtc.utils;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;


/**
 * 发送验证码
 * 
 * @author qiukai
 */
public class SendVerificationCode {

	/***
	 * 100 发送成功 101 验证失败 102 手机号码格式不正确 103 会员级别不够 104 内容未审核 105 内容过多 106 账户余额不足
	 * 107 Ip受限 108 手机号码发送太频繁 120 系统升级
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		String mobile = "18612787251";
		sendSMS(mobile);
	}

	public static int sendSMS(String mobile) {

		String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";

		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(Url);

		client.getParams().setContentCharset("UTF-8");
		method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");
		int mobile_code = (int) ((Math.random() * 9 + 1) * 100000);

		String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");

		NameValuePair[] data = { // 提交短信
				new NameValuePair("account", "cf_tmtc"), new NameValuePair("password", "z5UXw4"), // 密码可以使用明文密码或使用32位MD5加密
				new NameValuePair("mobile", mobile), new NameValuePair("content", content), };
		method.setRequestBody(data);
			try {
				client.executeMethod(method);
				String SubmitResult = method.getResponseBodyAsString();
				StringReader reader=new StringReader(SubmitResult);
				InputSource source=new InputSource(reader);
				SAXBuilder sb = new SAXBuilder();
				Document doc = sb.build(source);
				Element root = doc.getRootElement();
				List<Element> elements = root.getChildren();
				Map<String,String> map = new HashMap<>();
				for (Element element : elements) {
//					System.out.println(element.getName() +": " + element.getText());
					map.put(element.getName(),element.getText());
				}
				String code = map.get("code");
				String msg = map.get("msg");
				String smsid = map.get("smsid");
//				System.out.println(code);
//				System.out.println(msg);
//				System.out.println(smsid);
				if ("2".equals(code)) {
//					System.out.println("短信提交成功");
					return mobile_code;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JDOMException e) {
				e.printStackTrace();
			}
		return 0;
	}
}
