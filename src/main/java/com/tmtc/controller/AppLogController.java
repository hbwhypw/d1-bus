package com.tmtc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.annotation.SystemControllerLog;
import com.tmtc.constant.MessageVar;
import com.tmtc.frame.JsonResult;
import com.tmtc.frame.PageResult;
import com.tmtc.po.AppLogRepository;
import com.tmtc.service.AppLogService;
import com.tmtc.service.UserDetailService;
import com.tmtc.utils.VerificationUtil;

@Controller
@RequestMapping("/appLog")
public class AppLogController {
	
	@Autowired
	AppLogService appLogService;
	@Autowired
	UserDetailService userDetailService;
	
	/**
	 * APP日志-查询
	 * @param request
	 * @param response
	 * @param page
	 * @param rows
	 * @param name
	 * @param start
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/query")
	@ResponseBody
    @SystemControllerLog("APP日志-查询")
	public PageResult query(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = true) Integer page,
			@RequestParam(required = true) Integer rows,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String start,
			@RequestParam(required = false) String end) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		AppLogRepository appLogRepository = new AppLogRepository();
		AppLogRepository.Criteria criteria = appLogRepository.createCriteria();
		appLogRepository.setPageSize(rows);
		appLogRepository.setRowIndex((page-1)*rows);
		if(0 != VerificationUtil.length(name)){
			criteria.andNameLike("%"+name+"%");
		}
		if(null != start){
			Date start_time = sdf.parse(start);
			criteria.andCreate_timeGreaterThan(start_time);
		}
		if(null != end){
			Date end_time = sdf.parse(end);
			criteria.andCreate_timeLessThan(end_time);
		}
		PageResult pageResult = appLogService.selectByPage(appLogRepository);
		return pageResult;
	}
	
	/**
	 * 永久删除日志
	 */
	@RequestMapping("/delete")
	@ResponseBody
    @SystemControllerLog("APP日志-删除")
	public JsonResult delete(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = true) String ids){
		String[] idArr = ids.split(",");
		for(String id: idArr){
			if(0 == appLogService.delete(id)){
				return new JsonResult(0,MessageVar.DELETE_ERROR,0);
			}
		}
		return new JsonResult(1,MessageVar.DELETE_SUCCESS,null);
	}
}
