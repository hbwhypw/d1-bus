package com.tmtc.controller.appAPI;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.constant.MessageVar;

/**
 * app接口错误处理
 * 
 * @author qiukai
 *
 */
@Controller
@RequestMapping("/App/error")
public class ErrorAppController extends BaseController {

	/**
	 * 没有登录 /App/error/login?
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Map<String, Object> login(HttpServletRequest request) {
		return getMap(request, MessageVar.ERROR_LOGIN,100);
	}

	/**
	 * 签名错误 /App/error/enc?
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/enc")
	@ResponseBody
	public Map<String, Object> enc(HttpServletRequest request) {
		return getMap(request, MessageVar.ERROR_ENC,STATUS_ERROR);
	}
}
