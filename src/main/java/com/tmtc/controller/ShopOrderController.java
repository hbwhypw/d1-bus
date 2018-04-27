package com.tmtc.controller;

import com.tmtc.constant.MessageVar;
import com.tmtc.constant.ParameterConstant;
import com.tmtc.frame.JsonResult;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Company;
import com.tmtc.po.ShopOrder;
import com.tmtc.service.ShopOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/shopOrder")
public class ShopOrderController {
	
	@Autowired
	ShopOrderService shopOrderService;
	/**
	 * 修改商城订单
	 * @param request
	 * @param response
	 * @param id
	 * @param order_status
	 * @param consignee
	 * @param area
	 * @param address
	 * @param mobile
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public JsonResult update(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String id,
			@RequestParam(required = false) Integer order_status,
			@RequestParam(required = false) String consignee,
			@RequestParam(required = false) String area,
			@RequestParam(required = false) String address,
			@RequestParam(required = false) String mobile){
		int a = shopOrderService.update(id, order_status, consignee, area, address, mobile);
		if(0 == a){
			return new JsonResult(0,MessageVar.UPDATE_ERROR,0);
		}
		return new JsonResult(1,MessageVar.UPDATE_SUCCESS,1);
	}
	
	/**
	 * 删除订单
	 * @param request
	 * @param response
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public JsonResult delete(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String ids){
		String[] idArr = ids.split(",");
		for(String id : idArr){
			ShopOrder shopOrder = new ShopOrder();
			shopOrder.setId(id);
			shopOrder.setIs_check(ParameterConstant.IS_NOT_CHECK);
			int a = shopOrderService.update(shopOrder);
			if(0 == a){
				return new JsonResult(0, MessageVar.DELETE_ERROR, 0);
			}
		}
		return new JsonResult(1, MessageVar.DELETE_SUCCESS, 1);
	}
	
	/**
	 * 永久删除
	 * @param request
	 * @param response
	 * @param ids
	 * @return
	 */
	@RequestMapping("/forEver")
	@ResponseBody
	public JsonResult forEver(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String ids){
		String[] idArr = ids.split(",");
		for(String id : idArr){
			if(0 == shopOrderService.delete(id)){
				return new JsonResult(0, MessageVar.DELETE_ERROR, 0);
			}
		}
		return new JsonResult(1, MessageVar.DELETE_SUCCESS, 1);
	}
	
	/**
	 * 恢复状态
	 * @param request
	 * @param response
	 * @param ids
	 * @return
	 */
	@RequestMapping("/recover")
	@ResponseBody
	public JsonResult recover(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String ids){
		String[] idArr = ids.split(",");
		for(String id : idArr){
			ShopOrder shopOrder = new ShopOrder();
			shopOrder.setId(id);
			shopOrder.setIs_check(ParameterConstant.IS_CHECK);
			int a = shopOrderService.update(shopOrder);
			if(0 == a){
				return new JsonResult(0, MessageVar.ISCHECK_ERROR, 0);
			}
		}
		return new JsonResult(1, MessageVar.ISCHECK_SUCCESS, 1);
	}
	
	/**
	 * 查询所有商城订单
	 * @param page
	 * @param rows
	 * @param user_name
	 * @param order_no
	 * @param consignee
	 * @param mobile
	 * @param order_status
	 * @param pay_type
	 * @param start
	 * @param end
	 * @param is_bill 是否开票
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/query")
	@ResponseBody
	public PageResult query(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = true) Integer page,
			@RequestParam(required = true) Integer rows,
			@RequestParam(required = false) String user_name,
			@RequestParam(required = false) String order_no,
			@RequestParam(required = false) String consignee,
			@RequestParam(required = false) String mobile,
			@RequestParam(required = false) Integer order_status,
			@RequestParam(required = false) Integer pay_type,
			@RequestParam(required = false) String start,
			@RequestParam(required = false) String end,
			@RequestParam(required = false) Integer is_bill) throws ParseException{
		PageResult pageResult = shopOrderService.select(page, rows, user_name, order_no, consignee, mobile,order_status,pay_type,start,end, is_bill);
		return pageResult;
	}
	
	/**
	 * 根据ID查询详细信息
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/selectDetail")
	@ResponseBody
	public JsonResult selectDetail(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = true) String id){
		List<Company> companyList = shopOrderService.selectDetail(id);
		return new JsonResult(1, "", companyList);
	}
	/*@RequestMapping("/selectSubById")
	@ResponseBody
	public PageResult query(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = true) Integer page,
			@RequestParam(required = true) Integer rows,
			@RequestParam(required = true) String id){
		PageResult pageResult = shopOrderService.selectSubById(page, rows, id);
		return pageResult;
	}*/
}
