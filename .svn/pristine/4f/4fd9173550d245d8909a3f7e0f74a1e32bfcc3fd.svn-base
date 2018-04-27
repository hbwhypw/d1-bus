package com.tmtc.controller.appAPI;

import com.tmtc.frame.APIResult;
import com.tmtc.utils.VerificationUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

	private static final String RESULT = "result";

	private static final String USER_ID = "userId";

	/**
	 * 失败
	 */
	protected static final int STATUS_ERROR = 1;

	/**
	 * 成功
	 */
	protected static final int STATUS_SUCCESS = 0;

	/**
	 * 获取用户id
	 * 
	 * @return String类型用户id
	 */
	protected String getUserId(HttpServletRequest request) {

		String userId = (String) request.getAttribute(USER_ID);
		if (0 == VerificationUtil.length(userId)) {
			return null;
		}
		return userId;
	}

	/**
	 * 放入成功消息和返回对象，返回hashMap
	 * 
	 * @return
	 */
	protected Map<String, Object> getMap(String msg, int status, Object data, String session) {
		if (null == data) {
			data = "";
		}
		APIResult apiResult = new APIResult(session, msg, status, data);
		return getMap(apiResult);
	}

	/**
	 * 放入成功消息和返回对象，返回hashMap
	 * 
	 * @return
	 */
	protected Map<String, Object> getMap(HttpServletRequest request, String msg, int status, Object data) {

		String session = (String) request.getAttribute("session");
		if (0 != VerificationUtil.length(session)) {
			return getMap(msg, status, data, session);
		}
		return getMap(msg, status, data, "");
	}

	/**
	 * 成功消息和返回数据,并返回hashMap
	 * 
	 * @return
	 */
	protected Map<String, Object> getMap(HttpServletRequest request, String msg, Object data) {
		return getMap(request, msg, STATUS_SUCCESS, data);
	}

	/**
	 * 放入错误信息,并返回hashMap
	 * 
	 * @return
	 */
	protected Map<String, Object> getMap(HttpServletRequest request, String msg, int status) {
		return getMap(request, msg, status, "");
	}

	/**
	 * 放入成功消息，返回hashMap
	 * 
	 * @return
	 */
	protected Map<String, Object> getMap(HttpServletRequest request, String msg) {
		return getMap(request, msg, STATUS_SUCCESS);
	}

	/**
	 * 返回hashMap
	 * 
	 * @return
	 */
	private Map<String, Object> getMap(APIResult apiResult) {
        Map<String, Object> map = new HashMap<>();
		map.put(RESULT, apiResult);
		return map;
	}
}
