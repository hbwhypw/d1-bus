package com.tmtc.service;

import java.text.ParseException;

import com.tmtc.frame.JsonResult;
import com.tmtc.frame.PageResult;
import com.tmtc.po.LineTime;
import com.tmtc.po.LineTimeRepository;

public interface LineTimeService extends IService<LineTime, LineTimeRepository>,PageService<LineTimeRepository>{

	void insertLineTime(LineTime lineTime, String yearMonth, String[] sendDate, String sendTime, String doneTime);

	/**
	 * 查询司机和车
	 * @param line_id
	 * @return
	 */
	JsonResult selectDriverAndCar(String line_id);

	PageResult query(String line_name, Integer page, Integer rows,String driver_name,String car_num,String start,String end,Integer driving_state,String company_id)throws ParseException;
	
	LineTime detail(String car_id,String lineId,String driver_id);
}
