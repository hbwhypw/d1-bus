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
import com.tmtc.controller.appAPI.BaseController;
import com.tmtc.po.Car;
import com.tmtc.po.CarRepository;
import com.tmtc.po.LineTime;
import com.tmtc.service.CarService;
import com.tmtc.service.LineTimeService;
import com.tmtc.service.appAPI.DriveAppService;
import com.tmtc.utils.VerificationUtil;

@Controller
@RequestMapping("/App/drive")
public class DriveController extends BaseController {

	@Autowired
	DriveAppService driveAppService;

	@Autowired
	CarService carService;

	@Autowired
	LineTimeService lineTimeService;

	/**
	 * 开始驾驶1.3 /App/drive/start1.3?
	 * 
	 * @param request
	 * @param response
	 * @param companyName
	 *            公司名
	 * @param car_num
	 *            车牌号
	 * @param lineId
	 *            线路ID
	 * @param driver_id
	 *            司机ID
	 * @return
	 */
	@RequestMapping("/start1.3")
	@ResponseBody
	public Map<String, Object> start(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String driver_id, @RequestParam String companyName, @RequestParam String car_num,
			@RequestParam String lineId) {
		if (!"百度".equals(companyName)) {
			return getMap(request, MessageVar.DRIVER_BAIDU_ERROR, STATUS_ERROR);
		}
		CarRepository carRepository = new CarRepository();
		CarRepository.Criteria criteria = carRepository.createCriteria();
		criteria.andCar_numEqualTo(car_num);
		List<Car> carList = carService.select(carRepository);
		if (0 >= VerificationUtil.size(carList)) {
			return getMap(request, MessageVar.CAR_NULL, STATUS_ERROR);
		}
		LineTime lineTime = lineTimeService.detail(carList.get(0).getId(), lineId, driver_id);
		lineTimeService.insert(lineTime);
		String error = driveAppService.updateStart(lineTime.getId());
		if (error == null) {
			return getMap(request, MessageVar.DRIVESTART, STATUS_SUCCESS, lineTime.getId());
		}
		return getMap(request, error, STATUS_ERROR);
	}

	/**
	 * 开始驾驶 /App/drive/start?（在1.3版本废弃掉，不建议使用请参考  “v1.3开始驾驶，新增可以结束  uri:/App/Steer1.3/start?”）
	 * 
	 * @param line_time_id
	 *            班次id
	 * @return
	 */
	@RequestMapping("/start")
	@ResponseBody
	public Map<String, Object> start(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String line_time_id) {
		String error = driveAppService.updateStart(line_time_id);
		if (error == null) {
			return getMap(request, MessageVar.DRIVESTART);
		}
		Map<String, Object> map = getMap(request, error, STATUS_ERROR);
		return map;
	}

	/**
	 * 结束驾驶 /App/drive/end?
	 * 
	 * @param line_time_id
	 *            班次id
	 * @return
	 */
	@RequestMapping("/end")
	@ResponseBody
	public Map<String, Object> end(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String line_time_id) {
		String error = driveAppService.updateEnd(line_time_id);
		if (error == null) {
			return getMap(request, MessageVar.DRIVEEND);
		}
		return getMap(request, error, STATUS_ERROR);
	}
}
