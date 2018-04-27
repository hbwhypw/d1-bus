package com.tmtc.controller.appAPI;

import com.tmtc.po.MessageRecord;
import com.tmtc.service.MessageRecordService;
import com.tmtc.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Function:
 * @auther: hbwhypw
 * Date: 2015/10/29 11:58
 */
@Controller
@RequestMapping("/App/message")
public class MessageAppController extends BaseController {
	@Autowired
	MessageService messageService;
	@Autowired
	MessageRecordService messageRecordService;

	/**
	 * 获取用户历史消息 /App/message/query
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/query")
	public Map<String, Object> query(HttpServletRequest request, HttpServletResponse response) {
		List<MessageRecord> list = messageRecordService.selectVo(getUserId(request));
		return getMap(request, "", list);
	}
}
