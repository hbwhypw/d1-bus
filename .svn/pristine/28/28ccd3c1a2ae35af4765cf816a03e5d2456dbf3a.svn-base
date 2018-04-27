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
import com.tmtc.po.Version;
import com.tmtc.service.VersionService;

@Controller
@RequestMapping("/version")
public class VersionController {
	
	@Autowired
	VersionService versionService;
	
	/**
	 * 版本编辑
	 * @param request
	 * @param response
	 * @param edit
	 * @param version
	 * @return
	 */
	@RequestMapping("/{edit}")
	@ResponseBody
	public JsonResult edit(HttpServletRequest request,HttpServletResponse response,
			@PathVariable String edit,
			@Valid @ModelAttribute Version version){
		if (edit.equals("add")){
			int a = versionService.insert(version);
			return new JsonResult(1,MessageVar.ADD_SUCCESS,a);
		}else if(edit.equals("update")){
			int a = versionService.update(version);
			return new JsonResult(1,MessageVar.UPDATE_SUCCESS,a);
		}
		return new JsonResult();
	}
	
	/**
	 * 版本查询
	 * @param request
	 * @param response
	 * @param page
	 * @param rows
	 * @param version
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public PageResult query(HttpServletRequest request,HttpServletResponse response,
			@RequestParam Integer page,
			@RequestParam Integer rows,
			@RequestParam(required = false) String version){
		PageResult pageResult = versionService.selectByPage(page, rows, version);
		return pageResult;
	}
}
