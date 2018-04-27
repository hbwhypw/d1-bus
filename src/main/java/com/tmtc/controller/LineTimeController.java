package com.tmtc.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.annotation.SystemControllerLog;
import com.tmtc.frame.JsonResult;
import com.tmtc.frame.PageResult;
import com.tmtc.po.LineTime;
import com.tmtc.service.LineTimeService;

@Controller
@RequestMapping("/lineTime")
public class LineTimeController extends BaseController {

	@Autowired
	LineTimeService lineTimeService;

	/**
	 * 班车的添加
	 * @param lineTime
	 * @param bindingResult
	 * @param yearMonth
	 * @param sendDate
	 * @param sendTime
	 * @param doneTime
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add")
	@SystemControllerLog("班车的添加")
	public JsonResult add(@Valid @ModelAttribute LineTime lineTime, BindingResult bindingResult,
			@RequestParam String yearMonth, @RequestParam String[] sendDate, @RequestParam String sendTime,
			@RequestParam String doneTime) {

		lineTimeService.insertLineTime(lineTime, yearMonth, sendDate, sendTime, doneTime);
		return new JsonResult();
	}

	/**
	 * 班次的修改
	 * @param lineTime
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update")
	@SystemControllerLog("班次的修改")
	public JsonResult update(@Valid @ModelAttribute LineTime lineTime) {
		lineTimeService.update(lineTime);
		return new JsonResult();
	}

	/**
	 * 班次查询
	 * @param request
	 * @param page
	 * @param rows
	 * @param line_name
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/query")
	public PageResult query(HttpServletRequest request, @RequestParam Integer page,
			@RequestParam Integer rows, String line_name,String driver_name,String car_num,String start,String end,Integer driving_state,String company_id) throws ParseException {
		return lineTimeService.query(line_name, page, rows,driver_name,car_num,start,end,driving_state,company_id);
	}

	/**
	 * 班次的永久删除
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	@SystemControllerLog("班次的永久删除")
	public JsonResult delete(@RequestParam String ids) {
		lineTimeService.delete(ids);
		return new JsonResult();
	}

	/**
	 * 根据线路ID查询司机跟车辆
	 * @param line_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/selectDriverAndCar")
	public JsonResult selectDriverAndCar(@RequestParam String line_id) {
		return lineTimeService.selectDriverAndCar(line_id);
	}
}
