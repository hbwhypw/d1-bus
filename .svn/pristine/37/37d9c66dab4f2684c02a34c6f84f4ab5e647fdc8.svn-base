package com.tmtc.controller;

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

import com.tmtc.constant.MessageVar;
import com.tmtc.constant.ParameterConstant;
import com.tmtc.frame.JsonResult;
import com.tmtc.frame.PageResult;
import com.tmtc.frame.ServiceException;
import com.tmtc.po.ProductType;
import com.tmtc.po.ProductTypeRepository;
import com.tmtc.service.ProductTypeService;
import com.tmtc.utils.VerificationUtil;
/**
 * 
 * @author zxs
 *	产品类型管理
 */
@Controller
@RequestMapping("/productType")
public class ProductTypeController {
	
	@Autowired
	ProductTypeService productTypeService;
	
	/**
	 * 产品类型的添加修改
	 * @param request
	 * @param response
	 * @param edit
	 * @param productType	
	 * @param typ_picFile
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping("/{edit}")
	@ResponseBody
	public JsonResult edit(HttpServletRequest request,HttpServletResponse response,
			@PathVariable String edit,
			@Valid @ModelAttribute ProductType productType,
			@RequestParam CommonsMultipartFile typ_picFile) throws ServiceException{
		if(edit.equals("add")){
			return new JsonResult(1,MessageVar.ADD_SUCCESS,productTypeService.insert(productType, typ_picFile));
		}else if(edit.equals("update")){
			return new JsonResult(1,MessageVar.UPDATE_SUCCESS,productTypeService.update(productType, typ_picFile));
		}
		return new JsonResult(0,MessageVar.DO_ERROR,null);
	}
	
	/**
	 * 产品类型的删除
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public JsonResult delete(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = true) String id){
		 return new JsonResult(1, MessageVar.DELETE_SUCCESS, productTypeService.delete(id));
	}
	
	/**
	 * 产品类型的永久删除
	 */
	@RequestMapping("/forEver")
	@ResponseBody
	public JsonResult forEver(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = true) String id){
		return new JsonResult(1,MessageVar.DELETE_SUCCESS,productTypeService.deleteForEver(id));
	}
	
	/**
	 * 查询产品类型
	 * @param request
	 * @param response
	 * @param page
	 * @param rows
	 * @param name
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public PageResult query(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = true) Integer page,
			@RequestParam(required = true) Integer rows,
			@RequestParam(required = false) String name){
		if(null!=page && null!=rows){
			ProductTypeRepository productTypeRepository = new ProductTypeRepository();
			ProductTypeRepository.Criteria criteria = productTypeRepository.createCriteria();
			productTypeRepository.setPageSize(rows);
			productTypeRepository.setRowIndex((page-1)*rows);
			if(0 != VerificationUtil.length(name)){
				criteria.andNameLike("%"+name+"%");
			}
			criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
			PageResult pageResult = productTypeService.selectByPage(productTypeRepository);
			return pageResult;
	
		}
		return new PageResult(0,MessageVar.DO_ERROR,null);
	}
	
	/**
	 * 查看图片
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/selectById")
	@ResponseBody
	public JsonResult selectById(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String id){
		String type_pic = productTypeService.selectPic(id);
		return new JsonResult(1,"",type_pic);
	}
	
	/**
	 * 恢复
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/updateRecover")
	@ResponseBody
	public JsonResult updateRecover(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String id){
		ProductType productType = new ProductType();
		productType.setId(id);
		productType.setIs_check(ParameterConstant.IS_CHECK);
		return new JsonResult(1,MessageVar.ISCHECK_SUCCESS,productTypeService.update(productType));
	}
	
	/**
	 * 通过ID找name
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/select")
	@ResponseBody
	public JsonResult select(HttpServletRequest request,HttpServletResponse response){
		List<ProductType> list = productTypeService.select(new ProductTypeRepository());
		return new JsonResult(1,"",list);
	}
}
