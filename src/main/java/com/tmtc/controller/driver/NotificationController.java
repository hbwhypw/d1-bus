package com.tmtc.controller.driver;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.controller.appAPI.BaseController;
import com.tmtc.po.LineTime;
import com.tmtc.service.LineService;
import com.tmtc.service.LineTimeService;
import com.tmtc.utils.VerificationUtil;

@Controller
@RequestMapping("/App/notification")
public class NotificationController extends BaseController{
	
	@Autowired
	LineService lineService;
	
	@Autowired
	LineTimeService lineTimeService;
	
	@RequestMapping("/emergency")
	@ResponseBody
	public Map<String, Object> emergency(HttpServletRequest request,HttpServletResponse response,String linetime_id){
		LineTime lineTime = lineTimeService.selectByPrimaryKey(linetime_id);
		if (null == lineTime) {
			return getMap(request, "没有该班次");
		}
		String line_id = lineTime.getLine_id();
		if (0 == VerificationUtil.length(line_id)) {
			return getMap(request, "");
		}
		return null;
	}
}
