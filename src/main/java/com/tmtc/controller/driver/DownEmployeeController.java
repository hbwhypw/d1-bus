package com.tmtc.controller.driver;

import com.tmtc.constant.MessageVar;
import com.tmtc.controller.appAPI.BaseController;
import com.tmtc.service.appAPI.DownEmployeeAppService;
import com.tmtc.utils.VerificationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/App/DownEmployee")
public class DownEmployeeController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(DownEmployeeController.class);
	@Autowired
	DownEmployeeAppService downEmployeeAppService;

	/**
	 * 获取卡号 /App/DownEmployee/query?
	 * 
	 * @param request
	 * @param company_id
	 *            公司id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/query")
	public Map<String, Object> query(HttpServletRequest request, @RequestParam String company_id) {

		if (0 == VerificationUtil.length(company_id)) {
			return getMap(request, MessageVar.PARAMERROR, STATUS_ERROR);
		}
		String string = downEmployeeAppService.downEmloyeeAppService(company_id);
		if (0 == VerificationUtil.length(string)) {
			logger.error(company_id+"获取卡号为空");
			return getMap(request, MessageVar.CARDEMPTY, STATUS_ERROR);
		}
		return getMap(request, "", string);
	}
}
