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
import com.tmtc.service.appAPI.UpEmployeeService;
import com.tmtc.service.appAPI.ValidTimeService;
import com.tmtc.utils.VerificationUtil;

@Controller
@RequestMapping("/App/UpEmloyee")
public class UpEmployeeController extends BaseController {

	@Autowired
	ValidTimeService validTimeService;

	@Autowired
	UpEmployeeService upEmployeeService;

	/**
	 * v1.2（不验证卡）上传卡号url：/App/UpEmloyee/upNo1.2?
	 * @param request
	 * @param company_id
	 * @param cn_ls_st  卡号，站点，刷卡时间
	 * @param line_id
	 * @param line_time_id
	 * @param validDate 默认有效时间
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/upNo1.2")
	public Map<String, Object> addCardNumNOCheck(HttpServletRequest request, @RequestParam String company_id,
			@RequestParam String cn_ls_st, @RequestParam String line_id, @RequestParam String line_time_id,
			@RequestParam Integer validDate) {
		int employeeNocheck = validTimeService.insertUpEmployeeNocheck(company_id, cn_ls_st, line_id, line_time_id,validDate);
		if (4 == employeeNocheck) {
			return getMap(request, "数据错误", STATUS_ERROR);
		}
		return getMap(request, "上传成功");
	}

	/**
	 * v1.2（验证卡的接口）上传刷卡过后的数据url:/App/UpEmloyee/up1.2?
	 * 
	 * @param request
	 * @param company_id
	 * @param cn_ls_st
	 * @param line_id
	 * @param line_time_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/up1.2")
	public Map<String, Object> add(HttpServletRequest request, @RequestParam String company_id,
			@RequestParam String cn_ls_st, @RequestParam String line_id, @RequestParam String line_time_id) {

		int upEmployee = validTimeService.insertUpEmployee(company_id, cn_ls_st, line_id, line_time_id);
		switch (upEmployee) {
		case 1:
			return getMap(request, "无效卡", STATUS_ERROR);
		case 2:
			return getMap(request, "您不是免费员工", 2);
		case 3:
			return getMap(request, "请激活卡", 3);
		case 4:
			return getMap(request, "数据错误", 4);
		default:
			break;
		}
		return getMap(request, "");
	}

	/**
	 * /App/UpEmloyee/up
	 * 
	 * @param request
	 * @param company_id
	 *            公司id
	 * @param card_nums
	 *            串
	 * @param line_time_id
	 *            班次id
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/up")
	public Map<String, Object> add(HttpServletRequest request, String company_id, String card_nums,
			String line_time_id) {

		
		if (0 == VerificationUtil.length(card_nums)) {
			return getMap(request, MessageVar.UP_ERROR, STATUS_ERROR);
		}

		String[] split = card_nums.split(",");
		if (0 != (split.length % 3)) {
			return getMap(request, MessageVar.UP_ERROR, STATUS_ERROR);
		}
		if (0 == VerificationUtil.length(company_id)) {
			return getMap(request, MessageVar.UP_ERROR, STATUS_ERROR);
		}
		if (0 == VerificationUtil.length(line_time_id)) {
			return getMap(request, MessageVar.UP_ERROR, STATUS_ERROR);
		}
		int i = upEmployeeService.upEmployee(split, company_id, line_time_id);
		switch (i) {
		case 0:
			return getMap(request, MessageVar.UP_SUCCESS);
		case 1:
			return getMap(request, MessageVar.UP_ERROR, STATUS_ERROR);
		case 2:
			return getMap(request, MessageVar.UP_ERROR, STATUS_ERROR);
		default:
			return getMap(request, MessageVar.UP_ERROR, STATUS_ERROR);
		}
	}

}
