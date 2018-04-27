package com.tmtc.filter;

import java.util.Enumeration;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * API验证签名
 * 
 * @author Administrator
 *
 */
public class AppFilter extends HandlerInterceptorAdapter {
	// 继承HandlerInterceptorAdapter类

	private String reqSign = null;

	/**
	 * 对用户进行验证 return true通过，false不通过
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		TreeMap<String, Object> _params = new TreeMap<String, Object>();
		@SuppressWarnings("unchecked")
		Enumeration<String> paraNames = request.getParameterNames();
		while (paraNames.hasMoreElements()) {
			String paraKey = (String) paraNames.nextElement();
			String paraValue = request.getParameter(paraKey);
			if (paraKey.equals("enc")) {
				reqSign = paraValue;
			} else {
				_params.put(paraKey.toLowerCase(), paraValue);
			}
		}
		return FilterUtil.verifiy(_params, reqSign, request, response);
	}
}