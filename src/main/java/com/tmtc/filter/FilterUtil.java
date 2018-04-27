package com.tmtc.filter;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmtc.utils.secret.MD5;

public class FilterUtil {

	/**
	 * 获取密文
	 */
	public final static String KEY = "key";
	
	/**
	 * 接口密钥
	 * ！！！！！！！！！！！！！千万不要修改！！！！！！！！！！！
	 */
	private final static String VALUE = "c6a757b4cce7556325419260ec248dd7";

	/**
	 * 验证签名
	 * 
	 * @param _params
	 * @param reqSign
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public static boolean verifiy(Map<String, Object> _params, String reqSign, HttpServletRequest request,
			HttpServletResponse response) {

		String timeKey = _params.get("timekey").toString();
		
		// 验证是否发送了签名
		if (null == reqSign || null == timeKey) {
			return getFalse(request, response);
		}

		// 生成签名
		_params.put(KEY.toLowerCase(), VALUE);
		StringBuffer strToVerfy = new StringBuffer();
		for (Object param : _params.values()) {
			strToVerfy.append(param);
		}
		String myenc = MD5.getMD5(strToVerfy.toString());
		// 验证签名
		if (myenc == null || !myenc.equals(reqSign)) {
			return FilterUtil.getFalse(request, response);
		}
		return true;
	}

	/**
	 * 转发到验证失败页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public static boolean getFalse(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/App/error/enc").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
