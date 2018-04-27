package com.tmtc.service;

import java.text.ParseException;
import java.util.List;

import com.tmtc.frame.PageResult;
import com.tmtc.po.MoneyOrder;
import com.tmtc.po.MoneyOrderRepository;
import com.tmtc.vo.MoneyOrderVo;

public interface MoneyOrderService extends IService<MoneyOrder, MoneyOrderRepository>,PageService<MoneyOrderRepository>{
	PageResult query(int page,int rows,String userName,String realName,Integer payType,String start,String end,String company_id) throws ParseException;
	List<MoneyOrderVo> selectById(MoneyOrderRepository example);
}
