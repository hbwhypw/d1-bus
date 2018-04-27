package com.tmtc.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.constant.MessageVar;
import com.tmtc.constant.ParameterConstant;
import com.tmtc.frame.JsonResult;
import com.tmtc.frame.PageResult;
import com.tmtc.po.LineOrder;
import com.tmtc.service.LineOrderService;

@Controller
@RequestMapping("/lineOrder")
public class LineOrderController {
	
	@Autowired
	LineOrderService lineOrderService;
	
	/**
	 * 修改订单状态
	 * @param request
	 * @param response
	 * @param id
	 * @param order_status
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public JsonResult update(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String id,
			@RequestParam Integer order_status){
		LineOrder lineOrder = new LineOrder();
		lineOrder.setId(id);
		lineOrder.setOrder_status(order_status);
		return new JsonResult(1,MessageVar.UPDATE_SUCCESS,lineOrderService.update(lineOrder));
	}
	
	/**
	 * 删除订单
	 * @param request
	 * @param response
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public JsonResult delete(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String ids){
		String[] idArr = ids.split(",");
		for(String id : idArr){
			LineOrder lineOrder = new LineOrder();
			lineOrder.setId(id);
			lineOrder.setIs_check(ParameterConstant.IS_NOT_CHECK);
			if(0 == lineOrderService.update(lineOrder)){
				return new JsonResult(0, MessageVar.DELETE_ERROR, 0);
			}
		}
		return new JsonResult(1, MessageVar.DELETE_SUCCESS, 1);
	}
	
	/**
	 * 永久删除
	 * @param request
	 * @param response
	 * @param ids
	 * @return
	 */
	@RequestMapping("/forEver")
	@ResponseBody
	public JsonResult forEver(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String ids){
		String[] idArr = ids.split(",");
		for(String id : idArr){
			if(0 == lineOrderService.delete(id)){
				return new JsonResult(0, MessageVar.DELETE_ERROR, 0);
			}
		}
		return new JsonResult(1, MessageVar.DELETE_SUCCESS, 1);
	}
	
	/**
	 * 恢复状态
	 * @param request
	 * @param response
	 * @param ids
	 * @return
	 */
	@RequestMapping("/recover")
	@ResponseBody
	public JsonResult recover(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String ids){
		String[] idArr = ids.split(",");
		for(String id : idArr){
			LineOrder lineOrder = new LineOrder();
			lineOrder.setId(id);
			lineOrder.setIs_check(ParameterConstant.IS_CHECK);
			if(0 == lineOrderService.update(lineOrder)){
				return new JsonResult(0, MessageVar.ISCHECK_ERROR, 0);
			}
		}
		return new JsonResult(1, MessageVar.ISCHECK_SUCCESS, 1);
	}
	
	/**
	 * 线路订单查询
	 * @param request
	 * @param response
	 * @param page
	 * @param rows
	 * @param city_id
	 * @param line_name
	 * @param station_name
	 * @param order_status
	 * @param start
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/query")
	@ResponseBody
	public PageResult query(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = true) Integer page,
			@RequestParam(required = true) Integer rows,
			@RequestParam(required = false) Integer city_id,
			@RequestParam(required = false) String line_name,
			@RequestParam(required = false) String station_name,
			@RequestParam(required = false) Integer order_status,
			@RequestParam(required = false) String start,
			@RequestParam(required = false) String end) throws ParseException{
		PageResult pageResult = lineOrderService.select(page, rows, city_id, line_name, station_name, order_status, start, end);
		return pageResult;
	}
}
