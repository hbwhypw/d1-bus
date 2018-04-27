package com.tmtc.controller.appAPI;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.constant.SystemVar;
import com.tmtc.po.ExpOrder;
import com.tmtc.po.UserDetail;
import com.tmtc.service.ExpOrderService;
import com.tmtc.service.UserDetailService;
import com.tmtc.utils.IdWorker;
import com.tmtc.utils.OrderNumUtil;
import com.tmtc.utils.duiba.CreditConsumeParams;
import com.tmtc.utils.duiba.CreditConsumeResult;
import com.tmtc.utils.duiba.CreditNotifyParams;
import com.tmtc.utils.duiba.CreditTool;

@Controller
@RequestMapping("/App/duiba")
public class DuiBaController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(DuiBaController.class);

	@Autowired
	UserDetailService userDetailService;
	
	@Autowired
	ExpOrderService expOrderService;

	private CreditTool tool = new CreditTool(SystemVar.DUI_BA_KEY, SystemVar.DUI_BA_SECRET);

	/**
	 * 兑吧登录！ /App/duiba/login?
	 * 
	 * @param request
	 *            请求
	 * @param mav
	 *            返回对象
	 * @return mav
	 */
	@ResponseBody
	@RequestMapping("/login")
	public Map<String, Object> login(HttpServletRequest request) {
		UserDetail userDetail = userDetailService.selectByPrimaryKey(getUserId(request));
		Map<String, String> params = new HashMap<String, String>();
		params.put("uid", userDetail.getId());
		params.put("credits", userDetail.getExp_score().toString());
		String url = tool.buildUrlWithSign("http://www.duiba.com.cn/autoLogin/autologin?", params);
		return getMap(request, "", url);
	}

	/**
	 * 兑吧扣积分！ /App/duiba/conversion?
	 * 
	 * @param request
	 *            请求
	 * @param response
	 *            响应
	 */
	@RequestMapping("/conversion")
	public void conversion(HttpServletRequest request, HttpServletResponse response) {
		try {
			CreditConsumeParams params = tool.parseCreditConsume(request);// 利用tool来解析这个请求
			String bizId = OrderNumUtil.getOrderByJF();// 返回开发者系统中的业务订单id
			String uid = params.getUid();// 用户id
			Long credits = params.getCredits(); // 本次兑换扣除的积分
			String type = transformCoding(params.getType());// 获取兑换类型
			String description = transformCoding(params.getDescription()); // 本次积分消耗的描述(带中文，请用utf-8进行url解码)
			String orderNum = transformCoding(params.getOrderNum()); // 兑吧订单号(请记录到数据库中)
			Integer facePrice = params.getFacePrice(); // 兑换商品的市场价值，单位是分，请自行转换单位
			String param = transformCoding(params.getParams()); // 此次兑换实际扣除开发者账户费用，单位为分

			ExpOrder expOrder = new ExpOrder();
			expOrder.setId(IdWorker.nextId());
			expOrder.setAddress(type);
			expOrder.setOrder_no(bizId);
			expOrder.setUser_id(uid);
			expOrder.setCost_exp_score(Integer.parseInt(credits.toString()));
			expOrder.setEmail(description);
			expOrder.setArea(orderNum);
			expOrder.setPro_id(facePrice.toString());
			expOrder.setRemark(param);
			expOrder.setOrder_time(new Date());
			expOrder.setIs_check(ParameterConstant.IS_CHECK);
			int i = userDetailService.updateExpOrder(expOrder);
			CreditConsumeResult result = null;
			if (i > 0) {
				result = new CreditConsumeResult(true);
				logger.info("--------------------------兑吧扣积分----------成功--------------------------");
			} else {
				result = new CreditConsumeResult(false);
				logger.info("--------------------------兑吧扣积分----------失败--------------------------");
			}
			result.setBizId(bizId);
			logger.info(result.toString());
			response.getWriter().write(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 兑换结果的回调
	 * @param request
	 * @param response
	 */
	@RequestMapping("/result")
	public void result(HttpServletRequest request, HttpServletResponse response) {

		/*
		 * 兑换订单的结果通知请求的解析方法
		 * 当兑换订单成功时，兑吧会发送请求通知开发者，兑换订单的结果为成功或者失败，如果为失败，开发者需要将积分返还给用户
		 */
		try {
			CreditNotifyParams params = tool.parseCreditNotify(request);// 利用tool来解析这个请求
			String orderNum = params.getOrderNum();
			logger.info(orderNum.toString());
			if (params.isSuccess()) {
				logger.info("--------------------------兑吧积分----------完成--------------------------");
				// 兑换成功
				logger.info(params.toString());
			} else {
				logger.info("--------------------------兑吧积分回滚----------完成--------------------------");
				// 兑换失败，根据orderNum，对用户的金币进行返还，回滚操作
				userDetailService.updateExpOrder(orderNum);
				logger.info(params.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 转码
	 * @param str	输入iso-8859-1格式编码的字符串
	 * @return		返回utf-8格式编码的字符串
	 */
	private String transformCoding(String str){
		try {
			String s = new String(str.getBytes("iso-8859-1"), "utf-8");
			return s;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
