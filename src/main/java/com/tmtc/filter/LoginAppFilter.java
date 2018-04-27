package com.tmtc.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tmtc.po.UserLogin;
import com.tmtc.service.appAPI.LoginAPIService;
import com.tmtc.utils.VerificationUtil;

/**
 * API验证登录
 * 
 * @author Administrator
 *
 */
public class LoginAppFilter extends HandlerInterceptorAdapter {
	// 继承HandlerInterceptorAdapter类

	@Autowired
	LoginAPIService loginAPIService;

	/**
	 * 对用户进行验证 return true通过，false不通过
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 验证签名
		boolean b = new AppFilter().preHandle(request, response, handler);
		if (!b) {
			return false;
		}

		// 获得登录令牌
		String session = request.getHeader("session_id");
		if (null == session) {
			request.getRequestDispatcher("/App/error/login").forward(request, response);
			return false;
		}

		// 得到验证session
		UserLogin userLogin = loginAPIService.findLogin(session);
		if (null == userLogin || 0 == VerificationUtil.length(userLogin.getId())) { 
			request.getRequestDispatcher("/App/error/login").forward(request, response);
			return false;
		}
		
		request.setAttribute("userId", userLogin.getId());
		request.setAttribute("session", userLogin.getLogin_token());
		return true;
	}
}