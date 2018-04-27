package com.tmtc.service;

import java.util.List;

import com.tmtc.frame.ServiceException;
import com.tmtc.po.MoneyOrder;
import com.tmtc.po.MoneyOrderRepository;

public interface ReChargeService extends IService<MoneyOrder, MoneyOrderRepository>,PageService<MoneyOrderRepository>{

	boolean updatereCharger(MoneyOrder moneyOrder) throws ServiceException;
	
	List<MoneyOrder> findMoneyOrder(String userId, Integer page,Integer rows);
}