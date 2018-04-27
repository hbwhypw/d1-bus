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
import com.tmtc.po.ProductType;
import com.tmtc.po.ProductTypeRepository;
import com.tmtc.service.appAPI.ProductTypeAppService;

@Controller
@RequestMapping("/App/productType")
public class ProductTypeAppController extends BaseController{
	
	@Autowired
	ProductTypeAppService productTypeAppService;
	
	/**
	 * 产品类型	/App/productType/query?
	 * @param request
	 * @param response
	 * @param page 第几页
	 * @param rows 一页几条数据
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = true) Integer page,
			@RequestParam(required = true) Integer rows) {
		ProductTypeRepository productTypeRepository = new ProductTypeRepository();
		ProductTypeRepository.Criteria criteria = productTypeRepository.createCriteria();
		productTypeRepository.setOrderByClause("sort asc ");
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		productTypeRepository.setPageSize(rows);
		productTypeRepository.setRowIndex((page-1)*rows);
		List<ProductType> list = productTypeAppService.select(productTypeRepository);
		return getMap(request, "",list);
	}
}
