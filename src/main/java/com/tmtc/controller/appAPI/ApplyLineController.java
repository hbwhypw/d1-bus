package com.tmtc.controller.appAPI;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.constant.MessageVar;
import com.tmtc.constant.ParameterConstant;
import com.tmtc.po.LineApply;
import com.tmtc.po.LineApplyRepository;
import com.tmtc.service.appAPI.LineApplyAppService;
import com.tmtc.utils.ConvertCity;
import com.tmtc.utils.ConvertUtil;

/**
 * 线路申请
 * 
 * @author zxs
 *
 */
@Controller
@RequestMapping("/App/applyLine")
public class ApplyLineController extends BaseController {

	@Autowired
	LineApplyAppService lineApplyService;

	/**
	 * 用户线路申请 /App/applyLine/applyLine？
	 * 				
	 * @param city_id
	 *            城市ID
	 * @param start_station
	 *            起始站点
	 * @param end_station
	 *            结束站点
	 * @param depart_time
	 *            出行时间(只有时,分)
	 * @param depart_rate
	 *            出行频率
	 * @return 是否申请成功
	 */
	@RequestMapping("/applyLine")
	@ResponseBody
	public Map<String, Object> applyLine(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String cityName, @RequestParam String start_station, @RequestParam String end_station,
			@RequestParam String depart_time, @RequestParam Integer depart_rate) {
		Integer city_id = ConvertCity.gerCity_code(cityName);
		lineApplyService.insert(getUserId(request), city_id, start_station, end_station, depart_time, depart_rate);
		return getMap(request, MessageVar.LINEAPPLY_INSERT_SUCCESS);
	}
	
	/**
	 * 定制详情	/App/applyLine/applyDetail?
	 * @param request
	 * @param response
	 * @param page	第几页
	 * @param rows	一页几行
	 * @return
	 */
	@RequestMapping("/applyDetail")
	@ResponseBody
	public Map<String, Object> applyDetail(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = true) Integer page,
			@RequestParam(required = true) Integer rows) {
		String userid = getUserId(request);
		if(userid == null){
			return getMap(request, "fail");
		}
		Long userId = ConvertUtil.stringToLong(userid);
		LineApplyRepository lineApplyRepository = new LineApplyRepository();
		LineApplyRepository.Criteria criteria = lineApplyRepository.createCriteria();
		criteria.andUser_idEqualTo(userId);
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		lineApplyRepository.setOrderByClause("commite_time desc");
		lineApplyRepository.setPageSize(rows);
		lineApplyRepository.setRowIndex((page-1)*rows);
		List<LineApply> list = lineApplyService.select(lineApplyRepository);
		return getMap(request, MessageVar.LINEAPPLY_QUERY_SUCCESS,list);
	}
}
