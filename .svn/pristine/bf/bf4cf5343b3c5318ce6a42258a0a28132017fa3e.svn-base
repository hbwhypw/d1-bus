package com.tmtc.controller.appAPI;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pingplusplus.Pingpp;
import com.pingplusplus.model.Charge;
import com.tmtc.constant.ParameterConstant;
import com.tmtc.po.Line;
import com.tmtc.po.LineOrder;
import com.tmtc.po.LineOrderRepository;
import com.tmtc.service.LineOrderService;
import com.tmtc.utils.IP;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.utils.pingpp.ChargeExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/App/linePing")
public class LinePayAppController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(LinePayAppController.class);
	
	@Autowired
	LineOrderService lineOrderService;
	
	/**
	 * 线路ping++支付 /App/linePing/pp
	 * 
	 * @param request
	 * @param order_no
	 *            订单号
	 * @param channel
	 *            支付类型
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/pp")
	public Map<String, Object> pingPP(HttpServletRequest request, String order_no, String channel) {

		if (19 != VerificationUtil.length(order_no)) {
			return getMap(request, "订单号错误", STATUS_ERROR);
		}

		if (!(channel.equals("alipay") || channel.equals("wx"))) {
			return getMap(request, "购买方式错误", STATUS_ERROR);
		}

		LineOrderRepository lineOrderRepository = new LineOrderRepository();
		lineOrderRepository.or().andOrder_noEqualTo(order_no).andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		List<LineOrder> lineOrderList = lineOrderService.select(lineOrderRepository);
		
		if (0 == VerificationUtil.size(lineOrderList)) {
			return getMap(request, "订单不存在", STATUS_ERROR);
		}
		LineOrder lineOrder = lineOrderList.get(0);
		Integer status = lineOrder.getOrder_status();
		switch (status) {
		case ParameterConstant.ORDER_STATUS_NOT_PAY:
			break;
		case ParameterConstant.ORDER_STATUS_NOT:
			return getMap(request, "该订单已经付过款", STATUS_ERROR);
			
		case ParameterConstant.ORDER_STATUS_USER_CANCEL:
		case ParameterConstant.ORDER_STATUS_ADMIN_CANCEL:
			return getMap(request, "该订单已经取消", STATUS_ERROR);
			
		case ParameterConstant.ORDER_STATUS_DATED:
			return getMap(request, "该订单已经过期", STATUS_ERROR);
		default:
			break;
		}
		Charge charge = null;
		try {
			
			Line line = lineOrder.getLine();
			if (null == line) {
				return getMap(request, "订单不存在", STATUS_ERROR);
			}
			int price = VerificationUtil.integerIsNull(line.getPrice());
			Pingpp.apiKey = ParameterConstant.apiKey;
			charge = ChargeExample.charge(price, order_no, IP.getIP(request), channel);
			logger.info(charge.toString());

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("#######################支付失败##################");
			return getMap(request, "支付失败,请重新下单再次支付", STATUS_ERROR);
		}
		return getMap(request, "请求支付成功", charge.toString());
	}
	
	/**
	 * /App/linePing/findCharge 确认支付
	 * 
	 * @param request
	 * @param charge
	 *            Charge类型
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findCharge")
	public Map<String, Object> findCCharge(HttpServletRequest request, String charge) {
		Charge charge1 = new Gson().fromJson(charge, new TypeToken<Charge>() {
		}.getType());

		if (null == charge1) {
			return getMap(request, "网络异常", STATUS_ERROR);
		}
		
		if (0 == VerificationUtil.length(charge1.getId())) {
			return getMap(request, "网络异常", STATUS_ERROR);
		}

		try {
			Pingpp.apiKey = ParameterConstant.apiKey;
			Charge charge2 = ChargeExample.retrieve(charge1.getId());
			if (null == charge2) {
				return getMap(request, "支付失败,请重新下单再次支付", STATUS_ERROR);
			}
			if (!charge2.getPaid()) {
				return getMap(request, "您还未支付！！", STATUS_ERROR);
			}
			logger.info(charge2.toString());
			
			LineOrderRepository lineOrderRepository = new LineOrderRepository();
			lineOrderRepository.or().andOrder_noEqualTo(charge2.getOrderNo());
			List<LineOrder> lineOrderList = lineOrderService.select(lineOrderRepository);
			
			if (0 == lineOrderList.size()) {
				return getMap(request, "支付错误", STATUS_ERROR);
			}
			LineOrder lineOrder = lineOrderList.get(0);
			if(ParameterConstant.ORDER_STATUS == lineOrder.getOrder_status()){
				return getMap(request, "支付成功");
			}
			lineOrder.setOrder_status(ParameterConstant.ORDER_STATUS_NOT);
			int i = lineOrderService.update(lineOrder);
			if (0 >= i) {
				return getMap(request, "支付失败,请重新下单再次支付", STATUS_ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("#######################支付失败##################");
			return getMap(request, "支付失败,请重新下单再次支付", STATUS_ERROR);
		}
		return getMap(request, "支付成功");
	}
}
