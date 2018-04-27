package com.tmtc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.constant.MessageVar;
import com.tmtc.frame.JsonResult;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Talk;
import com.tmtc.service.TalkService;

@Controller
@RequestMapping("/talk")
public class TalkController {
	
	@Autowired
	TalkService talkService;
	
	/**
	 * 聊天编辑
	 * @param request
	 * @param response
	 * @param edit
	 * @param talk
	 * @return
	 */
	@RequestMapping("/{edit}")
	@ResponseBody
	public JsonResult edit(HttpServletRequest request,HttpServletResponse response,
			@PathVariable String edit,
			@Valid @ModelAttribute Talk talk){
		if (edit.equals("add")){
			int a = talkService.insert(talk);
			return new JsonResult(1,MessageVar.ADD_SUCCESS,a);
		}else if(edit.equals("update")){
			int a = talkService.update(talk);
			return new JsonResult(1,MessageVar.UPDATE_SUCCESS,a);
		}
		return new JsonResult();
	}
	
	/**
	 * 聊天查询
	 * @param request
	 * @param response
	 * @param page
	 * @param rows
	 * @param type
	 * @param room_name
	 * @param company_id
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public PageResult query(HttpServletRequest request,HttpServletResponse response,
			@RequestParam Integer page,
			@RequestParam Integer rows,
			@RequestParam(required = false) String type,
			@RequestParam(required = false) String room_name,
			@RequestParam(required = false) String company_id){
		PageResult pageResult = talkService.select(page, rows, type, room_name,company_id);
		return pageResult;
	}
}
