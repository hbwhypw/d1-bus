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
import com.tmtc.service.FeedbackService;

/**
 * 消息反馈
 * 
 * @author zxs
 *
 */
@Controller
@RequestMapping("/App/feedback")
public class FeedBackAppController extends BaseController {

	@Autowired
	FeedbackService feedbackService;

	/**
	 * 添加消息反馈信息 /App/feedback/add?
	 * 
	 * @param content
	 *            反馈被容
	 * @param contact
	 *            联系方式
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> insert(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = true) String content, @RequestParam(required = false) String contact) {
		feedbackService.insert(getUserId(request), content, contact);
		return getMap(request,MessageVar.FEEDBACK_SUCCESS,STATUS_SUCCESS);
	}
}
