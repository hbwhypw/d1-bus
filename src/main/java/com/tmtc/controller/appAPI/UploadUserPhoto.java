package com.tmtc.controller.appAPI;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.tmtc.constant.MessageVar;
import com.tmtc.po.UserLogin;
import com.tmtc.service.UserDetailService;
import com.tmtc.service.appAPI.LoginAPIService;
import com.tmtc.utils.VerificationUtil;

@Controller
@RequestMapping("/App/uploadUser")
public class UploadUserPhoto extends BaseController {

	@Autowired
	UserDetailService userDetailService;

	@Autowired
	LoginAPIService loginAPIService;

	/**
	 * 更换头像 url：/App/uploadUser/changephoto
	 * 
	 * @param file
	 *            头像图片文件
	 */
	@RequestMapping("/changephoto")
	@ResponseBody
	public Map<String, Object> changePhoto(HttpServletRequest request, HttpServletResponse response,
			@RequestParam CommonsMultipartFile file) {

		// 获得登录令牌
		String session = request.getHeader("session_id");
		if (null == session) {
			return getMap(request, MessageVar.ERROR_ENC, STATUS_ERROR);
		}

		// 得到验证session
		UserLogin userLogin = loginAPIService.findLogin(session);
		if (null == userLogin || 0 == VerificationUtil.length(userLogin.getId())) {
			return getMap(request, MessageVar.ERROR_ENC, STATUS_ERROR);
		}
		String msg = userDetailService.updatePhoto(userLogin.getId(), file);
		if (StringUtils.isNotEmpty(msg)) {
			return getMap("", STATUS_SUCCESS, msg, session);
		} else {
			return getMap(request, MessageVar.USER_CHANGEPHOTO_FAIL, STATUS_ERROR);
		}
	}
}
