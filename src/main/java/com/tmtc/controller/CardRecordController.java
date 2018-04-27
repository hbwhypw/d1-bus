package com.tmtc.controller;

import java.text.ParseException;

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
import com.tmtc.service.CardRecordService;

@Controller
@RequestMapping("/cardRecord")
public class CardRecordController {
	
	@Autowired
	CardRecordService cardRecordService;
	
	/**
	 * 劵码记录-查询
	 * @param request
	 * @param response
	 * @param page
	 * @param rows
	 * @param userName
	 * @param cardName
	 * @param start
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	@ResponseBody
    @RequestMapping("/query")
    @SystemControllerLog("劵码记录-查询")
	public PageResult query(HttpServletRequest request, HttpServletResponse response,
            @RequestParam Integer page,
            @RequestParam Integer rows,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String cardName,
            @RequestParam(required = false) String start,
            @RequestParam(required = false) String end) throws ParseException{
		PageResult pageResult = cardRecordService.selectByPage(page, rows, userName, cardName, start, end);
		return pageResult;
	}
	
	/**
	 * 劵码记录-删除
	 * @param request
	 * @param response
	 * @param ids
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/delete")
    @SystemControllerLog("劵码记录-删除")
	public JsonResult delete(HttpServletRequest request, HttpServletResponse response,
            @RequestParam String ids){
		String[] idArr = ids.split(",");
		for(String id: idArr){
			if(0 == cardRecordService.delete(id)){
				return new JsonResult(0, MessageVar.DELETE_ERROR, 0);
			}
		}
		return new JsonResult(1,MessageVar.DELETE_SUCCESS,1);
	}
}
