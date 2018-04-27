package com.tmtc.controller.appAPI;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.constant.ParameterConstant;

@Controller
@RequestMapping("/App/aboutD1")
public class AboutD1 extends BaseController{
	
	/**
	 * 关于嘀一	/App/aboutD1/url?
	 * @param request
	 * @param num	(1,产品介绍;2,奖励活动;3,关于我们;4,客户服务)
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/url")
	public Map<String,Object> selectUrl(HttpServletRequest request, String num) {
		switch (num) {
		case ParameterConstant.PRODUCT_INTRODUCE:
			return getMap(request, "产品介绍",ParameterConstant.PRODUCT_INTRODUCE_URL);
		case ParameterConstant.ACTIVITY:
			return getMap(request, "奖励活动", ParameterConstant.ACTIVITY_URL);
		case ParameterConstant.ABOUT_OUR:
			return getMap(request, "关于我们", ParameterConstant.ABOUT_OUR_URL);
		case ParameterConstant.CLIENT:
			return getMap(request, "客户服务", ParameterConstant.CLIENT_URL);
		default:
			break;
		}
		return null;
	}
}
