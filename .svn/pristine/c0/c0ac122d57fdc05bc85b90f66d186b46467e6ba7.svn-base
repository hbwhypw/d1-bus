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

import com.tmtc.constant.ParameterConstant;
import com.tmtc.po.LineOrder;
import com.tmtc.po.LineOrderRepository;
import com.tmtc.po.UserDetail;
import com.tmtc.service.UserDetailService;
import com.tmtc.service.appAPI.LineOrderAppService;

@Controller
@RequestMapping("/App/lineOrder")
public class OrdersAppController extends BaseController{
	
	@Autowired
	LineOrderAppService lineOrderAppService;
	
	@Autowired
	UserDetailService userDetailService;
	
	/**
	 * 线路下单	/App/lineOrder/add?
	 * @param request
	 * @param response
	 * @param city_id	城市id(code值)
	 * @param time_line_id	班次id
	 * @param station_id	站点id
	 * @return
	 */
	/*  
    @RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response,
			@RequestParam Integer city_id, 
			@RequestParam String time_line_id,
			@RequestParam String station_id) {
		String userId = getUserId(request);
		if(0 != VerificationUtil.length(userId)){
			lineOrderAppService.add(userId,city_id, time_line_id,station_id);
			return getMap(request, MessageVar.ADD_SUCCESS);
		}
		return getMap(request, MessageVar.ADD_ERROE);
	}*/
	
	/**
	 * 查看线路订单	/App/lineOrder/query?
	 * @param request
	 * @param response
	 * @param page	第几页
	 * @param rows	一页几条数据
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(HttpServletRequest request,HttpServletResponse response,
			@RequestParam Integer page,
			@RequestParam Integer rows){
		String userId = getUserId(request);
		UserDetail userDetail = userDetailService.selectByPrimaryKey(userId);
		if(null != userDetail){
			if(ParameterConstant.USER_TYPE_COMPANY == userDetail.getUser_type()){
				return getMap(request, "");
			}
		}
		LineOrderRepository lineOrderRepository = new LineOrderRepository();
		LineOrderRepository.Criteria criteria = lineOrderRepository.createCriteria();
		lineOrderRepository.setPageSize(rows);
		lineOrderRepository.setRowIndex((page-1)*rows);
		criteria.andUser_idEqualTo(userId);
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		List<LineOrder> list = lineOrderAppService.select(lineOrderRepository);
		return getMap(request, "",list);
	}
}
