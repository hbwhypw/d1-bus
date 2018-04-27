package com.tmtc.service.appAPI;

import java.util.Date;
import java.util.List;

import com.tmtc.po.Line;
import com.tmtc.po.LineOrder;
import com.tmtc.po.LineTime;

public interface LineAPIService {

	/**
	 * 查询线路（带班次）
	 * @param userId
	 * @param page
	 * @param rows
	 * @param date
	 * @return
	 */
	List<Line> findLine(String userId, Integer page, Integer rows, Date date);

	/**
	 * 查询班次详细信息（带线路，带站点，带司机，带车）
	 * @param lineTimeId
	 * @return
	 */
	LineTime findLineTime(String lineTimeId);

	/**
	 * 查询历史乘车
	 * @param beginDate
	 * @param endDate
	 * @param rows 
	 * @param page 
	 * @return
	 */
	List<LineOrder> findLineTime(Date beginDate, Date endDate,String user_id, Integer page, Integer rows);

	/**
	 * 查询司机线路（带班次）
	 * @param userId
	 * @param page
	 * @param rows
	 * @param date
	 * @return
	 */
	List<LineTime> findDriverLine(String userId, Integer page, Integer rows, Date date);
	
	/**
	 * 根据车辆和用户查询正在行驶的班次
	 * @param car_id
	 * @param userId
	 * @return
	 */
	String findLine(String car_id,String userId);
	
	public List<Line> detailList(List<Line> lineList);
	
	String driverPush(String linetime_id);
}
