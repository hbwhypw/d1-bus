package com.tmtc.controller;

import java.util.Date;

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

import com.tmtc.annotation.SystemControllerLog;
import com.tmtc.constant.MessageVar;
import com.tmtc.constant.ParameterConstant;
import com.tmtc.frame.JsonResult;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Feedback;
import com.tmtc.po.FeedbackRepository;
import com.tmtc.service.FeedbackService;
import com.tmtc.utils.IdWorker;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired
	FeedbackService feedbackService;
	
	/**
	 * 添加消息反馈信息
	 */
	@RequestMapping("/{edit}")
	@ResponseBody
    @SystemControllerLog("消息反馈-编辑")
	public JsonResult insert(HttpServletRequest request,HttpServletResponse response,
			@PathVariable String edit,
			@Valid @ModelAttribute Feedback feedback,
			@RequestParam(required = false) String username
			){
		if (edit.equals("add")){
			feedback.setId(IdWorker.nextId());
			feedback.setIs_check(ParameterConstant.IS_CHECK);
			feedback.setCreate_time(new Date());
			feedbackService.insert(feedback);
			return new JsonResult();
		}else if (edit.equals("update")){
			feedbackService.update(feedback);
			return new JsonResult();
		}
		return new JsonResult();
	}
	
	/**
	 * 删除消息反馈信息
	 */
	@RequestMapping("/delete")
	@ResponseBody
    @SystemControllerLog("消息反馈-删除")
	public JsonResult delete(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = true) String ids){
		String[] idArr = ids.split(",");
		for(String id: idArr){
			Feedback feedback = new Feedback();
			feedback.setId(id);
			feedback.setIs_check(ParameterConstant.IS_NOT_CHECK);
			if(0 == feedbackService.update(feedback)){
				return new JsonResult(0, MessageVar.DELETE_ERROR, 0);
			}
		}
		return new JsonResult(0, MessageVar.DELETE_SUCCESS, 1);
	}
	
	/**
	 * 永久删除消息反馈信息
	 */
	@RequestMapping("/forEver")
	@ResponseBody
    @SystemControllerLog("消息反馈-永久删除")
	public JsonResult forEver(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = true) String ids){
		String[] idArr = ids.split(",");
		for(String id: idArr){
			if(0 == feedbackService.deleteForEver(id)){
				return new JsonResult(0, MessageVar.DELETE_ERROR, 0);
			}
		}
		return new JsonResult(1,MessageVar.DELETE_SUCCESS,1);
	}
	
	/**
	 * 查询消息反馈信息
	 */
	@RequestMapping("/query")
	@ResponseBody
    @SystemControllerLog("消息反馈-查询")
	public PageResult query(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = true) Integer page,
			@RequestParam(required = true) Integer rows,
			@RequestParam(required = false) Integer is_handle){
		if (page != null && rows != null) {
			FeedbackRepository feedbackRepository = new FeedbackRepository();
			FeedbackRepository.Criteria criteria = 	feedbackRepository.createCriteria();
			feedbackRepository.setOrderByClause("create_time desc");
			feedbackRepository.setPageSize(rows);
			feedbackRepository.setRowIndex((page-1)*rows);
			if(null != is_handle){
				criteria.andIs_handleEqualTo(is_handle);
			}
			criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
			PageResult pageResult = feedbackService.selectByPage(feedbackRepository);
			return pageResult;
		}
		return new PageResult(0,null,0);
	}
	
	/**
	 * 恢复使用
	 * @param request
	 * @param response
	 * @param id	消息反馈ID
	 * @return
	 */
	@RequestMapping("/updateRecover")
	@ResponseBody
    @SystemControllerLog("消息反馈-恢复使用")
	public JsonResult updateRecover(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String ids){
		String[] idArr = ids.split(",");
		for(String id: idArr){
			if(0 == feedbackService.updateRecover(id)){
				return new JsonResult(0,MessageVar.ISCHECK_ERROR,0);
			}
		}
		return new JsonResult(1,MessageVar.ISCHECK_SUCCESS,1);
	}
}
