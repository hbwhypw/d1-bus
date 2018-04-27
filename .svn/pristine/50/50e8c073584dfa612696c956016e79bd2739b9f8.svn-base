package com.tmtc.service;

import java.text.ParseException;

import com.tmtc.frame.PageResult;
import com.tmtc.po.ExpOrder;
import com.tmtc.po.ExpOrderRepository;
import com.tmtc.vo.CompanyProVo;

public interface ExpOrderService extends IService<ExpOrder, ExpOrderRepository>,PageService<ExpOrderRepository>{
	int update(String id,Integer order_status,String consignee,String area,String address,String mobile);
	PageResult select(Integer page, Integer rows,String user_name,String order_no,String consignee,String mobile,Integer order_status,String start,String end)throws ParseException;
//	PageResult selectSubById(Integer page,Integer rows,String id);
	CompanyProVo selectDetail(String id);
}
