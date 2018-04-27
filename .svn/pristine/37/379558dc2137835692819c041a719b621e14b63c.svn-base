package com.tmtc.utils;

import javax.servlet.http.HttpServletRequest;

public class IP {

	public static String getIP(HttpServletRequest request) {

		// 获取ip地址
		String ip_address = null;
		if (request.getHeader("X-Real-IP") != null) {
			ip_address = request.getHeader("X-Real-IP");
		} else {
			ip_address = request.getRemoteAddr();
		}
		return ip_address;
	}
}
