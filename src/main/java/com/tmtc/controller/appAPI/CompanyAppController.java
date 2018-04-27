package com.tmtc.controller.appAPI;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.po.CompanyRepository;
import com.tmtc.service.CompanyService;
import com.tmtc.vo.CompanyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created: hbwhypw Date: 2015/10/12 10:05 Function: 公司接口层
 */
@Controller
@RequestMapping("/App/company")
public class CompanyAppController extends BaseController {
	@Autowired
	CompanyService companyService;

	/**
	 * 查询所有有效公司  /App/company/query
	 */
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(HttpServletRequest request, HttpServletResponse response) {
		CompanyRepository companyRepository = new CompanyRepository();
		companyRepository.or().andIs_checkEqualTo(ParameterConstant.IS_CHECK).andCompany_typeEqualTo(ParameterConstant.FROM_COMPANY_JOIN);
		List<CompanyVo> list = companyService.selectVo(companyRepository);
		return getMap(request, "", list);
	}
}
