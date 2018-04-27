package com.tmtc.controller.driver;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tmtc.controller.appAPI.BaseController;
import com.tmtc.frame.ServiceException;
import com.tmtc.service.appAPI.CollectMoneyService;

/**
 * 
 * @author Administrator
 * @version 1.2
 */
@Controller
@RequestMapping("/App/collect")
public class CollectMoneyController extends BaseController {

	@Autowired
	CollectMoneyService collectMoneyService;

	/**
	 * 验证收费用户 url: /App/collect/check
	 * 
	 * @param request
	 * @param company_id
	 * @param card_num
	 * @param line_id
	 * @param line_time_id
	 * @param line_station_id
	 * @return
	 * @throws ServiceException
	 */
	@ResponseBody
	@RequestMapping("/check")
	public Map<String, Object> check(HttpServletRequest request, @RequestParam String company_id,
			@RequestParam String card_num, @RequestParam String line_id, @RequestParam String line_time_id,
			@RequestParam String line_station_id) throws ServiceException {
		if ("0".equals(card_num)) {
			return getMap(request, "无效卡", 2);
		}
		int check = collectMoneyService.insertCheck(company_id, card_num, line_id, line_time_id, line_station_id);
		switch (check) {
		case 0:
			return getMap(request, "无效卡", 2);
		case 1:
			return getMap(request, "余额不足", STATUS_ERROR);
		case 3:
			return getMap(request, "您不是付费员工", 3);
		case 4:
			return getMap(request, "扣费失败！请重试", 4);
		case 5:
			return getMap(request, "已刷卡，请上车", 5);
		default:
			break;
		}
		return getMap(request, "请上车");
	}
}
