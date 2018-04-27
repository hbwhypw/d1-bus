package com.tmtc.controller.appAPI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/App/share")
public class ShareAppController {
	
	/**
	 * 分享
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/query")
	public ModelAndView query(ModelAndView modelAndView) {
		modelAndView.setViewName("share");
		modelAndView.addObject("title", "");
		modelAndView.addObject("content", "");
		return modelAndView;
	}
}
