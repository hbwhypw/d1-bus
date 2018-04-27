package com.tmtc.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.tmtc.po.UserLogin;
import com.tmtc.service.appAPI.LoginAPIService;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.utils.secret.SRSACoder;
import static com.tmtc.filter.FilterUtil.getFalse;

public class RSAAppFilter extends HandlerInterceptorAdapter {

	@Autowired
	LoginAPIService loginAPIService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String data = null;
		try {
			String RSAsecret = new String(request.getParameter(FilterUtil.KEY).getBytes(), "utf-8");
			if (0 == VerificationUtil.length(RSAsecret)) {
				return getFalse(request, response);
			}
			// 解密
			data = SRSACoder.decryptByPrivateKey(RSAsecret);
			if (0 == VerificationUtil.length(data)) {
				return getFalse(request, response);
			}
		} catch (Exception e) {
			return getFalse(request, response);
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
		request.setAttribute("data", data);
		return true;
	}

}
