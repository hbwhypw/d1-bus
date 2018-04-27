package com.tmtc.controller.appAPI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.constant.MessageVar;
import com.tmtc.po.Line;
import com.tmtc.po.LineOrder;
import com.tmtc.po.LineTime;
import com.tmtc.service.LineTimeService;
import com.tmtc.service.appAPI.LineAPIService;
import com.tmtc.utils.DateUtil;
import com.tmtc.utils.VerificationUtil;

/**
 * app线路接口
 * 
 * @author qiukai
 *
 */
@Controller
@RequestMapping("/App/line")
public class LineAppController extends BaseController {

	@Autowired
	LineAPIService lineAPIService;
	
	@Autowired
	LineTimeService lineTimeService;

	/**
	 * 查询行车记录 /App/line/queryLineHistory?
	 * 
	 * @param beginDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @param page
	 *            第多少页
	 * @param rows
	 *            查多少行
	 * @return
	 */
	@RequestMapping("/queryLineHistory")
	@ResponseBody
	public Map<String, Object> query(HttpServletRequest request, @RequestParam String beginDate,
			@RequestParam String endDate, @RequestParam Integer page, @RequestParam Integer rows) {
		Date beginDate1 = DateUtil.stringToDate(beginDate);
		if (0 == VerificationUtil.length(endDate))
			return getMap(request, null, STATUS_ERROR);
		Date endDate2 = DateUtil.getTomorrow(DateUtil.stringToDate(endDate));
		List<LineOrder> lineOrderList = lineAPIService.findLineTime(beginDate1, endDate2,getUserId(request),page,rows);
		if (0 == VerificationUtil.size(lineOrderList)) {
			lineOrderList = new ArrayList<>();
			return getMap(request, null, lineOrderList);
		}
		return getMap(request, "", lineOrderList);
	}

	/**
	 * 查询班次详情信息 /App/line/queryLineTime?
	 * 
	 * @param lineTimeId
	 *            班次id
	 * @return
	 */
	@RequestMapping("/queryLineTime")
	@ResponseBody
	public Map<String, Object> query(HttpServletRequest request, @RequestParam String lineTimeId) {
		LineTime lineTime = lineAPIService.findLineTime(lineTimeId);
		return getMap(request, "", lineTime);
	}

	/**
	 * 通过车辆查询正在行驶的班次 /App/line/lineTimeDetail?
	 * 
	 * @param car_id
	 *            车辆id
	 * @return
	 */
	@RequestMapping("/lineTimeDetail")
	@ResponseBody
	public Map<String, Object> lineTimeDetail(HttpServletRequest request, @RequestParam String car_id) {
		String lineTimeId = lineAPIService.findLine(car_id,getUserId(request));
		if (StringUtils.isEmpty(lineTimeId)) {
			return getMap(request, "", STATUS_ERROR);
		}
		return getMap(request, "", lineTimeId);
	}
	/*
	 * @RequestMapping("/lineTimeDetail")
	 * 
	 * @ResponseBody public Map<String, Object>
	 * lineTimeDetail(HttpServletRequest request, @RequestParam String car_id) {
	 * SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH-mm-ss"); String
	 * date = sdf.format(new Date()).toString(); LineTimeRepository
	 * lineTimeRepository = new LineTimeRepository();
	 * LineTimeRepository.Criteria criteria =
	 * lineTimeRepository.createCriteria(); criteria.andCar_idEqualTo(car_id);
	 * lineTimeRepository.or().andDriving_stateEqualTo(ParameterConstant.
	 * CAR_STATUS_IS); lineTimeRepository.or().andDepart_timeBetween(new Date(),
	 * DateUtil.getTomorrow(ConvertUtil.stringToDate(date))); List<LineTime>
	 * lineTimeList = lineTimeService.select(lineTimeRepository); String
	 * lineTimeId = null; if (0 != VerificationUtil.size(lineTimeList)) {
	 * lineTimeId = lineTimeList.get(0).getId(); } return query(request,
	 * lineTimeId); }
	 */

	/**
	 * 首页查询线路列表带班次 /App/line/query?
	 * 
	 * @param request
	 * @param date
	 *            日期（String类型，格式yyyy-MM-dd）
	 * @param page
	 *            当前页（int类型）
	 * @param rows
	 *            查询多少条（int 类型）
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(HttpServletRequest request, @RequestParam String date, @RequestParam Integer page,
			@RequestParam Integer rows) {
		Date date1 = DateUtil.stringToDate(date);
		if (null == date1) {
			return getMap(request, MessageVar.DATE_ERROR, STATUS_ERROR);
		}
		List<Line> findLine = lineAPIService.findLine(getUserId(request), page, rows, date1);
		return getMap(request, MessageVar.LINE_SUCCESS, findLine);
	}

	/**
	 * 首页查询线路列表带班次 /App/line/queryDriverLine?
	 * 
	 * @param request
	 * @param date
	 *            日期（String类型，格式yyyy-MM-dd）
	 * @param page
	 *            当前页（int类型）
	 * @param rows
	 *            查询多少条（int 类型）
	 * @return
	 */
	@RequestMapping("/queryDriverLine")
	@ResponseBody
	public Map<String, Object> queryDriverLine(HttpServletRequest request, @RequestParam String date,
			@RequestParam Integer page, @RequestParam Integer rows) {
		Date date1 = DateUtil.stringToDate(date);

		if (null == date1) {
			return getMap(request, MessageVar.DATE_ERROR, STATUS_ERROR);
		}
		List<LineTime> findLine = lineAPIService.findDriverLine(getUserId(request), page, rows, date1);
		return getMap(request, MessageVar.LINE_SUCCESS, findLine);
	}
}
