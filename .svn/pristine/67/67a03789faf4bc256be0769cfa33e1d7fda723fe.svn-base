package com.tmtc.controller.appAPI;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.tmtc.frame.ServiceException;
import com.tmtc.utils.UploadImg;

@Controller
@RequestMapping("/test")
public class Test extends BaseController{

	/**
	 *  /test/go?
	 * @param request
	 * @param response
	 * @param file 图片
	 * @return
	 */
	@RequestMapping("/go")
	@ResponseBody
	public Map<String, Object> go(HttpServletRequest request, HttpServletResponse response, @RequestParam CommonsMultipartFile file) {
		String shortFileUrl = null;
		try {
			shortFileUrl = UploadImg.upload(file, "F://img");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return getMap(request, "成功");
	}
}
