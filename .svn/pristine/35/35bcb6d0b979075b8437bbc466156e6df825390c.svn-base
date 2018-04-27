package com.tmtc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.frame.PageResult;
import com.tmtc.service.ExpService;

@Controller
@RequestMapping("/exp")
public class ExpController {

	@Autowired
	ExpService expService;
	
	/**
	 * 积分查询
	 * @param request
	 * @param page
	 * @param rows
	 * @param phone
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/query")
	public PageResult query(HttpServletRequest request, Integer page, Integer rows, String phone) {
		return expService.query(page, rows, phone);
	}
}
