package com.tmtc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.tmtc.annotation.SystemControllerLog;
import com.tmtc.constant.MessageVar;
import com.tmtc.constant.ParameterConstant;
import com.tmtc.excelTools.ExcelUtils;
import com.tmtc.excelTools.JsGridReportBase;
import com.tmtc.excelTools.TableData;
import com.tmtc.frame.JsonResult;
import com.tmtc.frame.PageResult;
import com.tmtc.frame.ServiceException;
import com.tmtc.po.ProductRepository;
import com.tmtc.po.Product;
import com.tmtc.service.ProductService;
import com.tmtc.utils.IdWorker;
import com.tmtc.vo.ProductVo;
@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	/**
	 * 添加/修改产品
	 * @param request
	 * @param response
	 * @param product（产品）
	 * @return
	 * @throws ServiceException 
	 */
	@RequestMapping("/{edit}")
	@ResponseBody
	public JsonResult add(HttpServletRequest request,HttpServletResponse response,
			@PathVariable String edit,
			@Valid @ModelAttribute Product product,
			@RequestParam CommonsMultipartFile[] pro_pictureFile) throws ServiceException{
		if (edit.equals("add")){
            product.setCreate_time(new Date());
            product.setId(IdWorker.nextId());
            product.setIs_check(ParameterConstant.IS_CHECK);
            productService.insert(product,pro_pictureFile,request);
            return new JsonResult();
        } else if (edit.equals("update")){
        	String id = product.getId();
        	if(null!=id&&""!=id){
        		productService.update(product,pro_pictureFile,request);
        		return new JsonResult();
        	}else{
        		return new JsonResult(0,MessageVar.DO_ERROR,null);
        	}
        }
		return new JsonResult(0,MessageVar.DO_ERROR,null);
	}
	
	/**
	 * 删除产品
	 * @param request
	 * @param response
	 * @param product（产品）
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public JsonResult delete(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = true) String id){
		Product product = new Product();
		product.setId(id);
		product.setIs_check(ParameterConstant.IS_NOT_CHECK);
		productService.update(product);
		return new JsonResult();
	}
	
	/**
	 * 永久删除产品
	 * @param request
	 * @param response
	 * @param product（产品）
	 * @return
	 */
	@RequestMapping("/forEver")
	@ResponseBody
	public JsonResult forEver(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = true) String id){
		return new JsonResult(1,MessageVar.DELETE_SUCCESS,productService.deleteForEver(id));
	}
	
	/**
	 * 查询所有产品
	 * @param request
	 * @param response
	 * @param product（产品）
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public PageResult query(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = true) Integer page,
			@RequestParam(required = true) Integer rows,
			@RequestParam(required = false) String pro_name,
			@RequestParam(required = false) String pro_type,
			@RequestParam(required = false) Integer sell_type,
			@RequestParam(required = false) String company_id){
		if(null!=page && null!=rows){
			ProductRepository productRepository = new ProductRepository();
			ProductRepository.Criteria criteria = productRepository.createCriteria();
			productRepository.setPageSize(rows);
			productRepository.setRowIndex((page-1)*rows);
			productRepository.setOrderByClause("is_check desc,create_time desc");
			if(null != pro_name && "" != pro_name){
				criteria.andPro_nameLike("%"+pro_name+"%");
			}
			if(null != pro_type){
				criteria.andPro_typeEqualTo(pro_type);
			}
			if(null != sell_type){
				criteria.andSell_typeEqualTo(sell_type);
			}
			if(null != company_id){
				criteria.andCompany_idEqualTo(company_id);
			}
			PageResult pageResult = productService.selectByPage(productRepository);
			return pageResult;
		}
		return new PageResult(0,null,0);
	}
	
	/**
	 * 查看图片
	 * @param request
	 * @param response
	 * @param id	商品ID
	 * @return
	 */
	@RequestMapping("/selectById")
	@ResponseBody
	public JsonResult selectById(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String id){
		List<String> list = productService.img(id);
		return new JsonResult(1,"",list);
	}
	
	/**
	 * 恢复使用
	 * @param request
	 * @param response
	 * @param id	商品ID
	 * @return
	 */
	@RequestMapping("/updateRecover")
	@ResponseBody
	public JsonResult updateRecover(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String id){
		int a = productService.updateRecover(id);
		return new JsonResult(1,MessageVar.ISCHECK_SUCCESS,a);
	}
	/**
	 * 审核
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/updateAudit")
	@ResponseBody
	public JsonResult updateAudit(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String id){
		int a = productService.updateAudit(id);
		return new JsonResult(1,MessageVar.AUDIT_SUCCESS,a);
	}
	/**
     * 产品导出
     */
    @RequestMapping("/export")
    @ResponseBody
    @SystemControllerLog("产品导出")
    public void export(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = false) String ids){
    	String[] idArr = ids.split(",");
    	List<String> listId = new ArrayList<String>();
    	for (int i = 0; i < idArr.length; i++) {
			listId.add(idArr[i]);
		}
    	ProductRepository productRepository = new ProductRepository();
		ProductRepository.Criteria criteria = productRepository.createCriteria();
		criteria.andIdIn(listId);
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		List<ProductVo> list = productService.selectDetail(productRepository);
        String[] hearders = new String[]{"所属地区","所属公司", "产品名称","产品类型","外链","市场价格", "商城价格", "积分数","详细信息","销售类型"};
        String[] fields = new String[]{"city_name", "company_name", "pro_name", "pro_type_name", "remote_url", "market_price", "shop_price", "exp_score","detail","sell_type_name"};
        TableData td = ExcelUtils.createTableData(list, ExcelUtils.createTableHeader(hearders), fields);
        JsGridReportBase report = null;
        String title = "产品信息";
        try {
            report = new JsGridReportBase(request, response);
            report.exportToExcel(title, "", td);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
