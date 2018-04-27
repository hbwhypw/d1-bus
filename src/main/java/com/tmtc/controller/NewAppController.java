package com.tmtc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tmtc.po.AdPic;
import com.tmtc.service.AdPicService;

@Controller
@RequestMapping("/App/new")
public class NewAppController {

	@Autowired
	AdPicService adPicService;

	/**
	 * 新闻活动查询
	 * @param id
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/query")
	public ModelAndView query(@RequestParam String id, ModelAndView modelAndView) {

		AdPic adPic = adPicService.selectByPrimaryKey(id);
		if (null == adPic) {
			return null;
		}
		modelAndView.setViewName("activity2");
		modelAndView.addObject("title", adPic.getTitle());
		modelAndView.addObject("content", adPic.getContent());
		return modelAndView;
	}
}
