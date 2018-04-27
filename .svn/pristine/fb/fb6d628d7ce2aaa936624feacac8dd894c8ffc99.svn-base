package com.tmtc.controller.driver;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.constant.MessageVar;
import com.tmtc.controller.appAPI.BaseController;
import com.tmtc.service.appAPI.DriveAppService;
import com.tmtc.utils.VerificationUtil;

/**
 * 开始驾驶1.3
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/App/Steer1.3")
public class SteerController extends BaseController {

	@Autowired
	DriveAppService driveAppService;

	/**
	 * v1.3开始驾驶，新增可以结束 uri:/App/Steer1.3/start?
	 * 
	 * @param request
	 * @param line_time_id
	 *            开始驾驶的班次id
	 * @param end_line_time_id
	 *            结束驾驶的班次id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/start")
	public Map<String, Object> start(HttpServletRequest request, @RequestParam String line_time_id,
			String end_line_time_id) {
		if (0 == VerificationUtil.length(line_time_id))
			return getMap(request, "数据错误", STATUS_ERROR);

		if (0 != VerificationUtil.length(end_line_time_id)) {
			driveAppService.updateEnd(end_line_time_id);
		}

		if (driveAppService.updateStart(line_time_id) == null) {
			return getMap(request, MessageVar.DRIVESTART);
		}

		return getMap(request, "", STATUS_ERROR);
	}

}
