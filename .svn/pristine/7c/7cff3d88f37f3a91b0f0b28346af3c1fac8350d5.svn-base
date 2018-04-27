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

import com.tmtc.constant.ParameterConstant;
import com.tmtc.po.Dictionary;
import com.tmtc.po.DictionaryRepository;
import com.tmtc.service.DictionaryService;

@Controller
@RequestMapping("/App/dictionary")
public class DictionaryAppController extends BaseController {

	@Autowired
	DictionaryService dictionaryService;

	/**
	 * 根据父节点的Code查询所有父节点下的所有子节点 /App/dictionary/selectByCode?
	 * 
	 * @param request
	 * @param response
	 * @param code
	 *            代码值（int类型）
	 * @return
	 */
	@RequestMapping("/selectByCode")
	@ResponseBody
	public Map<String, Object> selectByCode(HttpServletRequest request, HttpServletResponse response,
			@RequestParam Integer code) {
		DictionaryRepository dictionaryRepository = new DictionaryRepository();
		DictionaryRepository.Criteria criteria = dictionaryRepository.createCriteria();
		code = code * 100;
		criteria.andCodeBetween(code, code + 99);
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		List<Dictionary> dictionaryList = dictionaryService.selectByCode(dictionaryRepository);
		return getMap(request, "", dictionaryList);
	}
}
