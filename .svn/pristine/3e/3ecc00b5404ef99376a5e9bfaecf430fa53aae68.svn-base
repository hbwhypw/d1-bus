package com.tmtc.task;

import com.tmtc.service.LineOrderStatusService;
import com.tmtc.service.appAPI.OrderAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Function:
 * 
 * @auther: hbwhypw Date: 2015-11-11 14:39
 */
@Component
public class CheckOrderTask {

	@Autowired
	LineOrderStatusService lineOrderStatusService;

	@Autowired
	OrderAppService orderAppService;

	/**
	 * 线路订单检查
	 */
	@Scheduled(fixedRate = 15 * 60 * 1000)
	public void checkLineOrder() {
		lineOrderStatusService.update();
	}

	/**
	 * 商城订单检查
	 */
	@Scheduled(fixedRate = 15 * 60 * 1000)
	public void checkShopOrder() {
		orderAppService.updateShopOrderTimeOut();
	}
}
