package com.tmtc.controller.driver;

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
import com.tmtc.controller.appAPI.BaseController;
import com.tmtc.po.Line;
import com.tmtc.po.LineRepository;
import com.tmtc.po.LineTime;
import com.tmtc.service.LineService;
import com.tmtc.service.appAPI.LineAPIService;
@Controller
@RequestMapping("/App/driveLine")
public class LineDriverController extends BaseController{
	
	@Autowired
	LineService lineService;
	
	@Autowired
	LineAPIService lineAPIService;
	
	/**
	 * 百度线路	/App/driveLine/line?
	 * @param request
	 * @param response
	 * @param companyName	公司名
	 * @return
	 */
	@RequestMapping("/line")
	@ResponseBody
	public Map<String, Object> line(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String companyName){
		if(!"百度".equals(companyName)){
			return getMap(request, MessageVar.DRIVER_BAIDU_ERROR,STATUS_ERROR);
		}
		LineRepository lineRepository = new LineRepository();
		LineRepository.Criteria criteria = lineRepository.createCriteria();
		criteria.andCompany_idEqualTo(ParameterConstant.BAIDU);
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		List<Line> list = lineService.select(lineRepository);
		List<Line> detailList = lineAPIService.detailList(list);
		return getMap(request, MessageVar.BAIDU_LINE,STATUS_SUCCESS,detailList);
	}
	
	/**
	 * 班次详情	/App/driveLine/lineTime?
	 * @param request
	 * @param response
	 * @param lineTimeId	班次ID
	 * @return
	 */
	@RequestMapping("/lineTime")
	@ResponseBody
	public Map<String, Object> lineTime(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String lineTimeId){
		LineTime lineTime = lineAPIService.findLineTime(lineTimeId);
		if(null == lineTime){
			return getMap(request, MessageVar.LINETIMENOTEXIST,STATUS_ERROR);
		}
		return getMap(request, "",STATUS_SUCCESS,lineTime);
	}
}
