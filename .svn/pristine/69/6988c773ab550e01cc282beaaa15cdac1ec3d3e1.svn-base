package com.tmtc.controller.appAPI;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.po.Talk;
import com.tmtc.service.TalkService;

@Controller
@RequestMapping("/App/talk")
public class TalkAppController extends BaseController{

	@Autowired
	TalkService talkService;
	
	/**
	 * /App/talk/query  查询所有聊天室
	 * @param request
	 * @param company_id 公司id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/query")
	public Map<String, Object> query(HttpServletRequest request,String company_id) {
		Talk talk = talkService.select(company_id);
		if (null == talk) {
			return getMap(request, "该公司没有聊天室", STATUS_ERROR);
		}
		return getMap(request, "", talk);
	}
}
