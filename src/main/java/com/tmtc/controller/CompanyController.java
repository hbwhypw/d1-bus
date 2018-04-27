package com.tmtc.controller;

import com.tmtc.annotation.SystemControllerLog;
import com.tmtc.constant.MessageVar;
import com.tmtc.constant.ParameterConstant;
import com.tmtc.excelTools.ExcelUtils;
import com.tmtc.excelTools.JsGridReportBase;
import com.tmtc.excelTools.TableData;
import com.tmtc.frame.JsonResult;
import com.tmtc.frame.PageResult;
import com.tmtc.frame.ServiceException;
import com.tmtc.po.CompanyRepository;
import com.tmtc.po.Company;
import com.tmtc.service.CompanyService;
import com.tmtc.utils.IdWorker;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.vo.CompanyVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created:  hbwhypw
 * Date: 2015/10/12 10:01
 * Function:
 */
@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController {
    @Autowired
    CompanyService companyService;

    /**
     * 公司-查询全部
     * @param request
     * @param response
     * @param page
     * @param rows
     * @param name
     * @param city_id
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryAll")
    @SystemControllerLog("公司-查询全部")
    public PageResult query(HttpServletRequest request, HttpServletResponse response,
                            @RequestParam(required = false) Integer page,
                            @RequestParam(required = false) Integer rows,
                            @RequestParam(required = false) String name,
                            @RequestParam(required = false) Integer city_id) {
        CompanyRepository companyRepository = new CompanyRepository();
        CompanyRepository.Criteria criteria = companyRepository.createCriteria();
        criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
        if(0 != VerificationUtil.length(name)){
        	criteria.andNameLike("%"+name+"%");
        }
        if(0 != VerificationUtil.integerIsNull(city_id)){
        	criteria.andCity_idEqualTo(city_id);
        }
        setPageParams(companyRepository, page, rows);
        PageResult pageResult = companyService.selectByPage(companyRepository); 
        return pageResult;
    }

    /**
     * 查询所有公司
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/query")
    public PageResult queryCombo(HttpServletRequest request, HttpServletResponse response) {
        CompanyRepository companyRepository = new CompanyRepository();
        companyRepository.or().andIs_checkEqualTo(ParameterConstant.IS_CHECK);
        return companyService.selectByPage(companyRepository);
    }

    /**
     * 公司-编辑
     * @param request
     * @param response
     * @param edit
     * @param logo_pic_file
     * @param business_license_file
     * @param company
     * @param bindingResult
     * @return
     * @throws ServiceException
     */
    @ResponseBody
    @RequestMapping(value = "/{edit}")
    @SystemControllerLog("公司-编辑")
    public JsonResult add(HttpServletRequest request, HttpServletResponse response,@PathVariable String edit,
                          @RequestParam CommonsMultipartFile logo_pic_file,
                          @RequestParam CommonsMultipartFile business_license_file,
                          @Valid @ModelAttribute Company company, BindingResult bindingResult) throws ServiceException {
        if (bindingResult.hasErrors()) {
            handlerErrors(bindingResult);
        }
        if (edit.equals(ADD)){
            company.setId(IdWorker.nextId());
            companyService.insert(company, logo_pic_file, business_license_file);
        } else if (edit.equals(UPDATE)) {
            companyService.update(company, logo_pic_file, business_license_file);
        }
        return new JsonResult();
    }

    /**
     * 删除，改为无效
     */
    @ResponseBody
    @RequestMapping(value = "/delete")
    @SystemControllerLog("公司-删除")
    public JsonResult delete(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam(required = false) String id) {
        Company company = new Company();
        company.setId(id);
        company.setIs_check(ParameterConstant.IS_NOT_CHECK);
        companyService.update(company);
        return new JsonResult();
    }
    
    /**
     * 公司导出
     */
    @RequestMapping("/export")
    @ResponseBody
    @SystemControllerLog("公司导出")
    public void export(HttpServletRequest request, HttpServletResponse response,
    		@RequestParam(required = false) String ids) {
    	String[] idArr = ids.split(",");
    	List<Long> listId = new ArrayList<Long>();
    	for (int i = 0; i < idArr.length; i++) {
			listId.add(Long.valueOf(idArr[i]));
		}
    	CompanyRepository companyRepository = new CompanyRepository();
    	CompanyRepository.Criteria criteria = companyRepository.createCriteria();
    	criteria.andIdIn(listId);
    	criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		List<CompanyVo> list = companyService.selectDetail(companyRepository);
        String[] hearders = new String[]{"公司名称","城市", "公司地址","联系人","联系电话","法人代表", "公司座机", "QQ","邮箱","公司传真","公司类型","合同开始时间","合同结束时间","简介","网址"};
        String[] fields = new String[]{"name", "cityName", "address", "chairman_name", "chairman_phone", "company_chairman", "company_telphone", "qq","email","business_fax","company_type","start_time","end_time","intro","website"};
        TableData td = ExcelUtils.createTableData(list, ExcelUtils.createTableHeader(hearders), fields);
        JsGridReportBase report = null;
        String title = "公司信息";
        try {
            report = new JsGridReportBase(request, response);
            report.exportToExcel(title, "", td);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @ResponseBody
    @RequestMapping("/selectByProduct")
    public PageResult selectByProduct(HttpServletRequest request, HttpServletResponse response) {
    	return companyService.select();
    }
    
    /**
     * 根据公司名查询
     * @param request
     * @param response
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectByName")
    public JsonResult selectByName(HttpServletRequest request, HttpServletResponse response,
    		@RequestParam(required = false) String name) {
    	if(0 != VerificationUtil.length(name)){
    		CompanyRepository companyRepository = new CompanyRepository();
    		CompanyRepository.Criteria criteria = companyRepository.createCriteria();
    		criteria.andNameEqualTo(name);
    		List<Company> list = companyService.select(companyRepository);
    		if(0 != VerificationUtil.size(list)){
    			return new JsonResult(0, MessageVar.COMPANY_NAME_REPEAT, list);
    		}
    		return new JsonResult();
    	}
    	return new JsonResult(0,MessageVar.COMPANY_NAME_NULL,null);
    }
}
