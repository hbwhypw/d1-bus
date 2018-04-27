package com.tmtc.controller.appAPI;

import java.util.Date;
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
import com.tmtc.constant.ParameterConstant;
import com.tmtc.po.ExpOrder;
import com.tmtc.po.ShopOrder;
import com.tmtc.po.ShopOrderRepository;
import com.tmtc.service.appAPI.OrderAppService;
import com.tmtc.utils.ConvertCity;
import com.tmtc.utils.IdWorker;
import com.tmtc.utils.OrderNumUtil;
import com.tmtc.vo.ShopOrderVo;

@Controller
@RequestMapping("/App/order")
public class OrderAPPController extends BaseController {

	@Autowired
	OrderAppService orderAppService;

	/**
	 * /App/order/addExpOrder? 积分下单
	 * @param pro_id
	 * @param city_id
	 * @param consignee
	 * @param address
	 * @param mobile
	 * @param telephone
	 * @param email
	 * @param remark
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addExpOrder")
	public Map<String, Object> addExpOrder(HttpServletRequest request, String pro_id, @RequestParam String cityName,
			@RequestParam String consignee, @RequestParam String address, @RequestParam String mobile, String telephone,
			String email, String remark) {
		Integer city_id = ConvertCity.gerCity_code(cityName);
		ExpOrder expOrder = new ExpOrder(IdWorker.nextId(), OrderNumUtil.getOrderByJF(), getUserId(request), city_id, pro_id, null, null,
				ParameterConstant.TRANSPORT_PAY, consignee, null, address, telephone, mobile, email, null, remark,
				new Date(), ParameterConstant.IS_CHECK);
		ExpOrder expOrder2 = orderAppService.addExpOrder(expOrder);
		return getMap(request, MessageVar.ORDER_SUCCESS,expOrder2);
	}

	/**
	 * /App/order/add? 在线商城下单
	 * 
	 * @param order
	 *            商品id和数量（String类型，标准的json
	 *            例如：[{"id":"123","num":"123"},{"id":"123","num":"123"}]）
	 * @param city_id
	 *            城市id（类型int）
	 * @param consignee
	 *            收货人名 （类型Sting）
	 * @param address
	 *            收货地址 （类型Sting）
	 * @param mobile
	 *            手机号 （类型Sting）
	 * @param telephone
	 *            固定电话 （类型Sting 可选发送）
	 * @param email
	 *            E-mail （类型Sting 可选发送）
	 * @param is_bill
	 *            是否要发票（int 类型 1代表要，0代表不要）
	 * @param invoice_title
	 *            发票抬头 （类型Sting 可选发送）
	 * @param invoice_details
	 *            发票内容 （类型Sting 可选发送）
	 * @param remark
	 *            备注 （类型Sting 可选发送）
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public Map<String, Object> addOrderZX(HttpServletRequest request, @RequestParam String order,
			@RequestParam String cityName, @RequestParam String consignee, @RequestParam String address,
			@RequestParam String mobile, String telephone, String email, @RequestParam Integer is_bill,
			String invoice_title, String invoice_details, String remark) {

		Integer city_id = ConvertCity.gerCity_code(cityName);
		ShopOrder shopOrder = null;

		if (ParameterConstant.FALSE == is_bill) {
			shopOrder = new ShopOrder(null, getUserId(request), null, city_id, null,
					ParameterConstant.SHOP_ORDER_NOT_PAY, null, null, null, ParameterConstant.TRANSPORT_PAY, consignee,
					null, address, mobile, telephone, email, is_bill, null, null, null, remark, new Date(),
					ParameterConstant.IS_CHECK);

		} else if (ParameterConstant.TRUE == is_bill) {
			shopOrder = new ShopOrder(null, getUserId(request), null, city_id, null,
					ParameterConstant.SHOP_ORDER_NOT_PAY, null, null, null, ParameterConstant.TRANSPORT_PAY, consignee,
					null, address, mobile, telephone, email, is_bill, invoice_title, invoice_details, null, remark,
					new Date(), ParameterConstant.IS_CHECK);
		}

		if (null != orderAppService.addShopOrder(order, shopOrder)) {
			return getMap(request, MessageVar.ORDER_SUCCESS, shopOrder);
		}
		return getMap(request, MessageVar.ORDER_ERROR, STATUS_ERROR);
	}
	
	/**
	 * 用户积分订单	/App/order/queryExp?   已废弃不再使用2015年11月19日
	 * @param request
	 * @param response
	 * @param page	第几页
	 * @param rows	一页几条数据
	 * @return
	 */
//	@RequestMapping("/queryExp")
//	@ResponseBody
//	public Map<String,Object> queryExp(HttpServletRequest request,HttpServletResponse response,
//			@RequestParam Integer page,
//			@RequestParam Integer rows){
//		String userId = getUserId(request);
//		ExpOrderRepository expOrderRepository = new ExpOrderRepository();
//		ExpOrderRepository.Criteria criteria = expOrderRepository.createCriteria();
//		criteria.andUser_idEqualTo(userId);
//		expOrderRepository.setPageSize(rows);
//		expOrderRepository.setRowIndex((page-1)*rows);
//		expOrderRepository.setOrderByClause("order_time desc");
//		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
//		List<ExpOrderVo> list = orderAppService.select(expOrderRepository);
//		return getMap(request, "",list);
//	}
	
	/**
	 * 用户在线商城订单	/App/order/queryShop?
	 * @param request
	 * @param response
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/queryShop")
	@ResponseBody
	public Map<String,Object> queryShop(HttpServletRequest request,HttpServletResponse response,
			@RequestParam Integer page,
			@RequestParam Integer rows){
		Long userId = Long.valueOf(getUserId(request));
		ShopOrderRepository shopOrderRepository = new ShopOrderRepository();
		ShopOrderRepository.Criteria criteria = shopOrderRepository.createCriteria();
		criteria.andUser_idEqualTo(userId);
		shopOrderRepository.setPageSize(rows);
		shopOrderRepository.setRowIndex((page-1)*rows);
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		criteria.andSub_order_noEqualTo(String.valueOf(ParameterConstant.TRUE));
		shopOrderRepository.setOrderByClause("order_time desc");
		List<ShopOrderVo> list = orderAppService.select(shopOrderRepository);
		return getMap(request, "",list);
	}
}
