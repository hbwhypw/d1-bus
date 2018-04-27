package com.tmtc.controller.appAPI;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.constant.MessageVar;
import com.tmtc.po.Line;
import com.tmtc.service.LineStationService;
import com.tmtc.utils.VerificationUtil;

/**
 * 线路搜索
 * 
 * @author zxs
 *
 */
@Controller
@RequestMapping("/App/search")
public class SearchAppController extends BaseController {

	@Autowired
	LineStationService lineStationService;

	/**
	 * 搜索结果 /App/search/searchResult？
	 * 
	 * @param xStart
	 *            起始位置X坐标
	 * @param yStart
	 *            起始位置Y坐标
	 * @param xEnd
	 *            结束位置X坐标
	 * @param yEnd
	 *            结束位置Y坐标
	 * @param page
	 *            第几页
	 * @param rows
	 *            一页几条数据
	 * @param date
	 *            时间
	 * @return
	 */
	@RequestMapping("/searchResult")
	@ResponseBody
	public Map<String, Object> searchResult(HttpServletRequest request, HttpServletResponse response,
			@RequestParam Double xStart, @RequestParam Double yStart, @RequestParam Double xEnd,
			@RequestParam Double yEnd, @RequestParam(required = true) Integer page,
			@RequestParam(required = true) Integer rows,
			@RequestParam String date) {
		if (null != xStart && null != yStart && null != xEnd && null != yEnd) {
			List<Line> listLine = lineStationService.search(xStart, yStart, xEnd, yEnd, page, rows,date);
			if(0 != VerificationUtil.size(listLine)){
				return getMap(request, MessageVar.SEARCHSUCCESS, listLine);
			}
			return getMap(request, MessageVar.SEARCHERROR,null);
		}
		return getMap(request, MessageVar.SEARCHERROR, null);
	}
}
