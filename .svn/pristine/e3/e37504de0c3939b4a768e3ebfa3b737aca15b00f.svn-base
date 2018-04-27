package com.tmtc.service;

import java.text.ParseException;

import com.tmtc.frame.PageResult;
import com.tmtc.po.LineOrder;
import com.tmtc.po.LineOrderRepository;

public interface LineOrderService extends IService<LineOrder, LineOrderRepository>,PageService<LineOrderRepository>{
	PageResult select(Integer page,Integer rows,Integer city_id,String line_name,String station_name,Integer order_status,String start,String end)throws ParseException;
	int insert(String user_id,String time_line_id,String station_id);
}
