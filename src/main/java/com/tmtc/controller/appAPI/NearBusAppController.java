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

import com.tmtc.po.CarLocation;
import com.tmtc.service.CarLocationService;
import com.tmtc.service.appAPI.CarLocationAppService;

/**
 * 附近班车
 * 
 * @author zxs
 *
 */
@Controller
@RequestMapping("/App/car")
public class NearBusAppController extends BaseController {

	@Autowired
	CarLocationService carLocationService;

	@Autowired
	CarLocationAppService carLocationAppService;
	
	/**
	 * 附近班车 /App/car/nearCar?
	 * 
	 * @param x
	 *            用户坐标（x坐标）
	 * @param y
	 *            用户坐标（y坐标）
	 * @return 离用户最近的几辆车
	 */
	@RequestMapping("/nearCar")
	@ResponseBody
	public Map<String, Object> nearBus(HttpServletRequest request, HttpServletResponse response, @RequestParam Double x,
			@RequestParam Double y) {
		List<CarLocation> list = carLocationService.nearBus(x, y);
		return getMap(request, "", list);
	}

	/**
	 * 班车位置	/App/car/carLocation?
	 * @param request
	 * @param response
	 * @param line_time_id	班次id
	 * @return
	 */
	@RequestMapping("/carLocation")
	@ResponseBody
	public Map<String, Object> carLocation(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String line_time_id) {
		CarLocation carLocation = carLocationAppService.selectCarLocation(line_time_id);
		return getMap(request, "", carLocation);
	}
}
