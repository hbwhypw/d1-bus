package com.tmtc.controller.appAPI;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.pingplusplus.Pingpp;
import com.pingplusplus.model.Charge;
import com.pingplusplus.model.Event;
import com.pingplusplus.model.Webhooks;
import com.tmtc.constant.ParameterConstant;
import com.tmtc.frame.ServiceException;
import com.tmtc.po.*;
import com.tmtc.service.LineOrderService;
import com.tmtc.service.LogService;
import com.tmtc.service.ReChargeService;
import com.tmtc.service.ShopOrderService;
import com.tmtc.utils.DateUtil;
import com.tmtc.utils.IdWorker;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.utils.pingpp.ChargeExample;
import com.tmtc.utils.pingpp.WebHooksVerify;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

/**
 * Function: ping++回调
 *
 * @auther: hbwhypw
 * Date: 2016-01-13 11:16
 */
@Controller
@RequestMapping("/App/hooks")
public class PingPPHooksController {

    private static Logger logger = LoggerFactory.getLogger(PingPPHooksController.class);

    @Autowired
    private LogService logService;

    @Autowired
    LineOrderService lineOrderService;

    @Autowired
    ReChargeService reChargeService;

    @Autowired
    ShopOrderService shopOrderService;

    /**
     * ping++ 钩子 回调
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("/pp")
    public void pingPP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF8");
        //获取头部所有信息
        @SuppressWarnings("rawtypes")
		Enumeration headerNames = request.getHeaderNames();
        HashMap<String, String> param = new HashMap<>();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            param.put(key, value);
        }

        // 获得 http body 内容
        BufferedReader reader = request.getReader();
        StringBuffer body = new StringBuffer();
        String string;
        while ((string = reader.readLine()) != null) {
            body.append(string);
        }
        reader.close();
        String sign = param.get("x-pingplusplus-signature");
        String data = body.toString();
        try {
            if (!WebHooksVerify.verifyData(data.getBytes(), WebHooksVerify.getByteFromString(sign, true), WebHooksVerify.getPubKey())) {
                // 验证失败
                response.setStatus(502);
                log("验证失败", "错误sign", "");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log("验证失败", "getPubKey失败", StringUtils.substring(e.getMessage(), 0, 300));
            response.setStatus(500);
        }

        // 解析异步通知数据
        Event event = Webhooks.eventParse(body.toString());
        if (event == null) {
            response.setStatus(500);
            log("验证失败", "解析异步通知数据错误", "event为null");
            return;
        }
        if ("charge.succeeded".equals(event.getType())) {
            try {
            	JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = jsonParser.parse(data).getAsJsonObject();
                String eventData = jsonObject.get("data").getAsJsonObject().get("object").getAsJsonObject().toString();
                Charge charge = verifyCharge(eventData);
                String orderNo = charge.getOrderNo();
                String orderTop = orderNo.substring(0,2);
                switch (orderTop){
                    case "XL":
                        lineOrderHooks(charge);
                        break;
                    case "CZ":
                        rechangeOrderHooks(charge);
                        break;
                    case "ZX":
                        shopingOrderHooks(charge);
                        break;
                    default:
                        response.setStatus(500);
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.setStatus(500);
                return;
            }
            response.setStatus(200);
            log("充值成功", "charge.succeeded", StringUtils.substring(data, 0, 300));
        } else if ("refund.succeeded".equals(event.getType())) {
            response.setStatus(200);
            log("退款成功", "refund.succeeded", StringUtils.substring(data, 0, 300));
        } else {
            response.setStatus(500);
            log("失败", "event fail", StringUtils.substring(data, 0, 300));
        }
    }

    /**
     * ping++回调用于测试日志
     * @param name
     * @param description
     * @param exceptionDetail
     */
    private void log(String name, String description, String exceptionDetail) {
        Log log = new Log();
        log.setId(IdWorker.nextId());
        log.setName(name);
        log.setDescription(description);
        log.setType(0);
        log.setExceptionCode(null);
        log.setExceptionDetail(exceptionDetail);
        log.setParams(null);
        log.setCreateDate(DateUtil.getCurrentDate());
        //保存数据库
        logService.insert(log);
    }

    /**
     * 修改线路订单状态
     * @param charge2
     * @throws Exception
     */
    private void lineOrderHooks(Charge charge2) throws Exception {

        LineOrderRepository lineOrderRepository = new LineOrderRepository();
        lineOrderRepository.or().andOrder_noEqualTo(charge2.getOrderNo());
        List<LineOrder> lineOrderList = lineOrderService.select(lineOrderRepository);
        if (0 == lineOrderList.size()) {
            throw new ServiceException("该订单号不存在！！");
        }
        LineOrder lineOrder = lineOrderList.get(0);
        if (ParameterConstant.ORDER_STATUS == lineOrder.getOrder_status()) {
            return;
        }
        lineOrder.setOrder_status(ParameterConstant.ORDER_STATUS_NOT);
        int i = lineOrderService.update(lineOrder);
        if (0 >= i) {
            throw new ServiceException("支付失败，但钱已到账！！，数据层异常或者cpu异常");
        }
    }

    /**
     * 修改充值订单状态
     * @param charge2
     * @throws Exception
     */
    private void rechangeOrderHooks(Charge charge2) throws Exception {

        MoneyOrderRepository moneyOrderRepository = new MoneyOrderRepository();
        MoneyOrderRepository.Criteria criteria = moneyOrderRepository.createCriteria();
        criteria.andOrder_noEqualTo(charge2.getOrderNo());
        List<MoneyOrder> list = reChargeService.select(moneyOrderRepository);
        if (0 == list.size()) {
            throw new ServiceException("该订单号不存在！！");
        }
        MoneyOrder moneyOrder = list.get(0);

        if (ParameterConstant.CZ_ORDER_STATUS_FINISH == moneyOrder.getOrder_status()) {
            return;
        }

        String channel = charge2.getChannel();
        if (channel.equals("wx")) {
            moneyOrder.setPay_type(ParameterConstant.PAY_TYPE_ALIPAY);
        } else if (channel.equals("alipay")) {
            moneyOrder.setPay_type(ParameterConstant.PAY_TYPE_WECHAR);
        }
        moneyOrder.setOrder_status(ParameterConstant.CZ_ORDER_STATUS_FINISH);
        if (!reChargeService.updatereCharger(moneyOrder)) {
            throw new ServiceException("支付失败，但钱已到账！！，数据层异常或者cpu异常");
        }
    }

    /**
     * 修改商场订单状态
     * @param charge2
     * @throws Exception
     */
    private void shopingOrderHooks(Charge charge2) throws Exception {
        ShopOrderRepository shopOrderRepository1 = new ShopOrderRepository();
        ShopOrderRepository.Criteria createCriteria = shopOrderRepository1.createCriteria();
        createCriteria.andOrder_noEqualTo(charge2.getOrderNo());
        List<ShopOrder> list1 = shopOrderService.select(shopOrderRepository1);

        if (0 == list1.size()) {
            throw new ServiceException("该订单号不存在！！");
        }
        ShopOrder shopOrder2 = list1.get(0);

        if (ParameterConstant.SHOP_ORDER_PAY == shopOrder2.getOrder_status()) {
            return;
        }

        String channel = charge2.getChannel();
        if (channel.equals("wx")) {
            shopOrder2.setPay_type(ParameterConstant.PAY_TYPE_ALIPAY);
        } else if (channel.equals("alipay")) {
            shopOrder2.setPay_type(ParameterConstant.PAY_TYPE_WECHAR);
        }
        if (!shopOrderService.updateOrderPay(shopOrder2)) {
            throw new ServiceException("支付失败，但钱已到账！！，数据层异常或者cpu异常");
        }
    }

    /**
     * 对charge的检查
     *
     * @param data
     * @return
     * @throws ServiceException
     */
    private Charge verifyCharge(String data) throws ServiceException {
        Charge charge1 = new Gson().fromJson(data, new TypeToken<Charge>() {
        }.getType());

        if (null == charge1) {
            throw new ServiceException("数据解析出错");
        }
        if (0 == VerificationUtil.length(charge1.getId())) {
            throw new ServiceException("数据解析出错");
        }
        if (!charge1.getPaid()) {
        	
        }
        Charge charge2 = null;
        try {
            Pingpp.apiKey = ParameterConstant.apiKey;
            charge2 = ChargeExample.retrieve(charge1.getId());
            if (null == charge2) {
                throw new ServiceException("支付失败,请重新下单再次支付");
            }
            if (!charge2.getPaid()) {
                throw new ServiceException("您还未支付！！");
            }
            logger.info(charge2.toString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("支付失败");
        }
        return charge2;
    }
}
