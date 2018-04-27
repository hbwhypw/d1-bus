package com.tmtc.controller.driver;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.controller.appAPI.BaseController;
import com.tmtc.service.appAPI.UpCarValidService;
import com.tmtc.utils.DateUtil;

/**
 * 将刷卡信息，上传到服务端
 * 
 * @author Administrator 2016-02-17
 */
@Controller
@RequestMapping("/App/upCar1.3")
public class UpCarValidController extends BaseController {

	@Autowired
	UpCarValidService upCarValidService;

	/**
	 * 上传刷卡信息 uri:/App/upCar1.3/valid?
	 * 
	 * @param request
	 * @param company_id
	 *            公司id
	 * @param card_num
	 *            卡号
	 * @param line_time_id
	 *            班次id
	 * @param line_station_id
	 *            站点id
	 * @param validDate
	 *            天数
	 * @param date
	 *            刷卡时间 （格式yyyy-MM-dd HH:mm:ss）String类型
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/valid")
	public Map<String, Object> valid(HttpServletRequest request, @RequestParam String company_id,
			@RequestParam String card_num, @RequestParam String line_time_id, @RequestParam String line_station_id,
			@RequestParam Integer validDate, @RequestParam String date) {
		Date date2 = DateUtil.getLongDate(date);
		if (null == date2) {
			return getMap(request, "", STATUS_ERROR);
		}
		int upCar = upCarValidService.upCar(company_id, card_num, line_time_id, line_station_id, validDate, date2);
		if (upCar != 0 && upCar !=5) {
			return getMap(request, "", STATUS_ERROR);
		}
		return getMap(request, "");
	}
}
