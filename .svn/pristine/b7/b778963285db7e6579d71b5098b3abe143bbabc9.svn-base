package com.tmtc.controller.driver;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.controller.appAPI.BaseController;
import com.tmtc.utils.PropertiesUtil;

/**
 * 验证系统设置参数密码
 * 
 * @author qk
 *
 */
@Controller
@RequestMapping("/App/driverPassword")
public class PasswordController extends BaseController {

	/**
	 * 验证密码 url：/App/driverPassword/query?
	 * @param request
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/query")
	public Map<String, Object> query(HttpServletRequest request, String password) {
		String password1 = PropertiesUtil.getSystem("driver.password");
		if (!password1.equals(password)) {
			return getMap(request, "密码错误", STATUS_ERROR);
		}
		return getMap(request, "");
	}
}
