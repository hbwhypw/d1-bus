package com.tmtc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.frame.PageResult;
import com.tmtc.service.UpCarService;
import com.tmtc.utils.VerificationUtil;

@Controller
@RequestMapping("/upCar")
public class UpCarController {

	@Autowired
	UpCarService upCarService;

	/**
	 * 上车记录
	 * @param request
	 * @param response
	 * @param page
	 * @param rows
	 * @param username
	 * @param real_name
	 * @param name
	 * @param station_name
	 * @param begin_time
	 * @param end_time
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/query")
	public PageResult query(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = true) Integer page, @RequestParam(required = true) Integer rows, String username,
			String real_name, String name, String station_name, String begin_time, String end_time) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (0 != VerificationUtil.length(username)) {
			map.put("username", username);
		}
		if (0 != VerificationUtil.length(real_name)) {
			map.put("real_name", real_name);
		}
		if (0 != VerificationUtil.length(name)) {
			map.put("name", name);
		}
		if (0 != VerificationUtil.length(station_name)) {
			map.put("station_name", station_name);
		}
		if (0 == VerificationUtil.length(begin_time)) {
			map.put("begin_time", "2010-01-01 00:00:00");
		} else {
			map.put("begin_time", begin_time);
		}
		if (0 == VerificationUtil.length(end_time)) {
			map.put("end_time", "2910-01-01 00:00:00");
		} else {
			map.put("end_time", end_time);
		}
		map.put("page", (page - 1) * rows);
		map.put("rows", rows);
		return upCarService.query(map);
	}
	
	/*@RequestMapping("/export")
    @ResponseBody
    public void export(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(required = false) String ids) {
        List<UpCar> list = upCarService.select(ids);
        String[] hearders = new String[]{"登录名", "工号(若有)", "卡号", "真实姓名", "昵称", "生日", "性别", "邮箱", "地址", "注册时间", "公司","用户类型"};
        String[] fields = new String[]{"username", "number", "card_num", "real_name", "nick_name", "birthday", "sex_name", "email", "address", "register_time","company_name","user_type_name"};
        TableData td = ExcelUtils.createTableData(list, ExcelUtils.createTableHeader(hearders), fields);
        JsGridReportBase report = null;
        String title = "用户信息";
        try {
            report = new JsGridReportBase(request, response);
            report.exportToExcel(title, "", td);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
