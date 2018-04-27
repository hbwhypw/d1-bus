package com.tmtc.service;

import com.tmtc.frame.PageResult;
import com.tmtc.po.Company;
import com.tmtc.po.ShopOrder;
import com.tmtc.po.ShopOrderRepository;

import java.text.ParseException;
import java.util.List;

public interface ShopOrderService extends IService<ShopOrder, ShopOrderRepository>, PageService<ShopOrderRepository> {
	int update(String id, Integer order_status, String consignee, String area, String address, String mobile);

	PageResult select(Integer page, Integer rows, String user_name, String order_no, String consignee, String mobile,
			Integer order_status, Integer pay_type, String start, String end, Integer is_bill) throws ParseException;

	List<Company> selectDetail(String id);

	/**
	 * 支付成功，更新总订单及其子订单
	 * @param shopOrder
	 * @return 更新成功 true
	 */
	boolean updateOrderPay(ShopOrder shopOrder);
	
}
