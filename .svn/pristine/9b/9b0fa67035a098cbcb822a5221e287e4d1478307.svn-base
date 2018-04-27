package com.tmtc.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
import com.tmtc.po.Card;
import com.tmtc.service.CardService;
import com.tmtc.utils.IdWorker;
import com.tmtc.utils.PropertiesUtil;

@Controller
@RequestMapping("/card")
public class CardController extends BaseController {

	@Autowired
	CardService cardService;

	/**
	 * 劵码-编辑
	 * @param edit
	 * @param card
	 * @param bindingResult
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/{edit}")
    @SystemControllerLog("劵码-编辑")
	public JsonResult add(@PathVariable String edit, @Valid @ModelAttribute Card card, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return handlerErrors(bindingResult);
		}
		if (edit.equals("add")) {
			card.setId(IdWorker.nextId());
			card.setCreate_time(new Date());
			card.setIs_check(ParameterConstant.IS_CHECK);
			cardService.insert(card);
		} else if (edit.equals("update")) {
			int i = cardService.update(card);
			if (0 == i) {
				return new JsonResult(1, MessageVar.UPDATE_ERROR, null);
			}
		} else if (edit.equals("delete")) {
			card.setIs_check(ParameterConstant.IS_NOT_CHECK);
			int i = cardService.update(card);
			if (0 == i) {
				return new JsonResult(1, MessageVar.UPDATE_ERROR, null);
			}
		}
		return new JsonResult();
	}

	/**
	 * 劵码-查询
	 * @param card_name
	 * @param rows
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/query")
    @SystemControllerLog("劵码-查询")
	public PageResult query(String card_name, @RequestParam Integer rows, @RequestParam Integer page) {
		return cardService.query(card_name, page, rows);
	}

	/**
	 * 领取积分
	 * 
	 * @param id
	 * @param phone
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addExp")
    @SystemControllerLog("劵码-领取积分")
	public JsonResult addExpScore(@RequestParam String id, @RequestParam String phone) {

		int i = cardService.addExpGet(id, phone);
		JsonResult jsonResult = null;
		switch (i) {
		case 0:
			jsonResult = new JsonResult(1, PropertiesUtil.getPropertyValue("message", "get.exp_score.success"), null);
			break;
		case 1:
			jsonResult = new JsonResult(1, PropertiesUtil.getPropertyValue("message", "activity.null"), null);
			break;
		case 2:
			jsonResult = new JsonResult(1, PropertiesUtil.getPropertyValue("message", "activity.out.time"), null);
			break;
		case 3:
			jsonResult = new JsonResult(1, PropertiesUtil.getPropertyValue("message", "user.not"), null);
			break;
		case 4:
			jsonResult = new JsonResult(1, PropertiesUtil.getPropertyValue("message", "get.exped"), null);
			break;
		default:
			jsonResult = new JsonResult(1, PropertiesUtil.getPropertyValue("message", "user.not"), null);
			break;
		}
		return jsonResult;
	}

	/**
	 * 广告
	 * 
	 * @param mav
	 * @param id
	 * @return
	 */
	// @RequestMapping("/activity")
	// public JsonResult activity(ModelAndView mav,String id) {
	// return mav;
	// }
}
