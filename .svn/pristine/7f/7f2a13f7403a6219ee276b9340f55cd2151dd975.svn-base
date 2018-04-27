package com.tmtc.controller.appAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tmtc.po.Version;
import com.tmtc.service.VersionService;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 司机端新版本
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/App/version")
public class VersionAppController extends BaseController {

	@Autowired
	VersionService versionService;

	@RequestMapping("/query")
	public Map<String, Object> query(HttpServletRequest request) {
		Version version = versionService.selectByNew();
		if (null == version) {
			return getMap(request, "没有新版本", STATUS_ERROR);
		}
		return getMap(request, "嘀一巴士，有新的版本", version);
	}
}
