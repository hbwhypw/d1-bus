package com.tmtc.service;

import java.util.List;

import com.tmtc.po.CarLocation;
import com.tmtc.po.CarLocationRepository;
import com.tmtc.po.LineStation;

public interface CarLocationService extends IService<CarLocation, CarLocationRepository>,PageService<CarLocationRepository>{
	
	/**
	 * 附近班车
	 * @param x
	 * @param y
	 * @return
	 */
	List<CarLocation> nearBus(Double x,Double y);
	
//	/**
//	 * 修改班车位置
//	 * @param device_id
//	 * @param x_point
//	 * @param y_point
//	 * @param lineTimeId 
//	 * @return
//	 */
//	int updateCarLocation(String device_id,Double x_point,Double y_point);

	/**
	 * 修改班车位置和加站
	 * @param device_id
	 * @param x_point
	 * @param y_point
	 * @param lineTimeId
	 * @return
	 */
	int updateCarLocation(String device_id, Double x_point, Double y_point, String lineTimeId);
	
	LineStation getNewLineStation(String lineTimeId);
}
