package com.tmtc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.annotation.SystemControllerLog;
import com.tmtc.constant.MessageVar;
import com.tmtc.constant.ParameterConstant;
import com.tmtc.frame.JsonResult;
import com.tmtc.frame.PageResult;
import com.tmtc.po.LineApply;
import com.tmtc.po.LineApplyRepository;
import com.tmtc.service.LineApplyService;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.vo.LineApplyVo;

@Controller
@RequestMapping("lineApply")
public class LineApplyController {

	@Autowired
	LineApplyService lineApplyService;
	
	/**
	 * 修改线路申请信息
	 * @param request
	 * @param response
	 * @param lineApply
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	@SystemControllerLog("线路申请-修改")
	public JsonResult update(HttpServletRequest request,HttpServletResponse response,
			@Valid @ModelAttribute LineApplyVo lineApplyVo){
		return new JsonResult(1,MessageVar.UPDATE_SUCCESS,lineApplyService.update(lineApplyVo));
	}
	
	/**
	 * 删除线路申请信息
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	@SystemControllerLog("线路申请-删除")
	public JsonResult delete(HttpServletRequest request,HttpServletResponse response,
			@RequestParam (required = true) String id){
		LineApply lineApply = new LineApply();
		lineApply.setId(id);
		lineApply.setIs_check(ParameterConstant.IS_NOT_CHECK);
		return new JsonResult(1,MessageVar.DELETE_SUCCESS,lineApplyService.update(lineApply));
	}
	
	/**
	 * 永久删除线路申请信息
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/forEver")
	@ResponseBody
	public JsonResult forEver(HttpServletRequest request,HttpServletResponse response,
			@RequestParam (required = true) String id){
		return new JsonResult(1,MessageVar.DELETE_SUCCESS,lineApplyService.delete(id));
	}
	
	/**
	 * 恢复使用
	 * @param request
	 * @param response
	 * @param id	线路申请ID
	 * @return
	 */
	@RequestMapping("/updateRecover")
	@ResponseBody
	public JsonResult updateRecover(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String id){
		LineApply lineApply = new LineApply();
		lineApply.setId(id);
		lineApply.setIs_check(ParameterConstant.IS_CHECK);
		return new JsonResult(1,MessageVar.ISCHECK_SUCCESS,lineApplyService.update(lineApply));
	}
	
	/**
	 * 查找所有的线路申请信息
	 * @param request
	 * @param response
	 * @param page
	 * @param rows
	 * @param city_id
	 * @param is_check
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public PageResult query(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = true) Integer page,
			@RequestParam(required = true) Integer rows,
			@RequestParam(required = false) Integer city_id){
		LineApplyRepository lineApplyRepository = new LineApplyRepository();
		LineApplyRepository.Criteria criteria = lineApplyRepository.createCriteria();
		lineApplyRepository.setPageSize(rows);
		lineApplyRepository.setRowIndex((page-1)*rows);
		if(0 != VerificationUtil.integerIsNull(city_id)){
			criteria.andCity_idEqualTo(city_id);
		}
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		PageResult pageResult = lineApplyService.selectByPage(lineApplyRepository);
		return pageResult;
	}
}
