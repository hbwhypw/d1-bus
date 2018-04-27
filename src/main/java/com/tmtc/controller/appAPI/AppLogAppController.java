package com.tmtc.controller.appAPI;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.constant.MessageVar;
import com.tmtc.service.appAPI.AppLogAppService;

@Controller
@RequestMapping("/App/appLog")
public class AppLogAppController extends BaseController{
	
	@Autowired
	AppLogAppService appLogService;
	
	/**
	 * app日志	/App/appLog/add?
	 * @param request
	 * @param response
	 * @param name	请求名称
	 * @param param	参数
	 * @param ip	IP
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String name, 
			@RequestParam(required = false) String param,
			@RequestParam(required = false) String ip) {
		return getMap(request, MessageVar.APPLOG_ADD_SUCCESS,appLogService.insert(name,param, getUserId(request), ip));
	}
}
