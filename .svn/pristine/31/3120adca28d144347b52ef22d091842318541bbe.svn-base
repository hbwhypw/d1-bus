package com.tmtc.serviceImpl.appAPI;

import com.tmtc.constant.MessageVar;
import com.tmtc.po.LineTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.dao.CarDao;
import com.tmtc.dao.LineTimeDao;
import com.tmtc.po.Car;
import com.tmtc.po.LineTime;
import com.tmtc.service.appAPI.DriveAppService;

import java.util.List;

@Service
public class DriveAppServiceImpl implements DriveAppService{

	@Autowired
	LineTimeDao lineTimeDao;
	@Autowired
	CarDao carDao;
	
	@Override
	public String updateStart(String line_time_id) {
		LineTime lineTime = lineTimeDao.selectByPrimaryKey(line_time_id);
		if(null != lineTime){
            // 不可以是已经发车班次
			if (lineTime.getDriving_state() == ParameterConstant.DRIVING){
				return MessageVar.LINETIMEDEPARTED;
			}
			Car car = carDao.selectByPrimaryKey(Long.valueOf(lineTime.getCar_id()));
            // 不可以是已经开始驾驶车辆
			if (ParameterConstant.CAR_STATUS_IS == car.getCar_status()) {
				return car.getCar_num() + MessageVar.CARDRIVING;
			}

			String car_id = lineTime.getCar_id();
			LineTimeRepository lineTimeRepository = new LineTimeRepository();
			lineTimeRepository.or()
                    .andCar_idEqualTo(car_id)
                    .andDriving_stateEqualTo(ParameterConstant.DRIVING);
			List<LineTime> lineTimes = lineTimeDao.selectByExample(lineTimeRepository);
            // 判断 当前车辆 是否存在 还在驾驶中的班次
			if (lineTimes.size() != 0) {
				return MessageVar.LINETIMENOTEND;
			}

			car.setSeat(car.getTotal_seat() - ParameterConstant.SEATGAP);
			car.setCar_status(ParameterConstant.CAR_STATUS_IS);
			carDao.updateByPrimaryKeySelective(car);
			lineTime.setDriving_state(ParameterConstant.DRIVING);
			lineTime.setLine_station_sort(0);
			if (lineTimeDao.updateByPrimaryKeySelective(lineTime) == 1){
				return null;
			} else {
				return MessageVar.DRIVESTARTERROR;
			}
		}
		
		return MessageVar.LINETIMENOTEXIST;
	}

	@Override
	public String updateEnd(String line_time_id) {
		LineTime lineTime = lineTimeDao.selectByPrimaryKey(line_time_id);
		if(null != lineTime){
            // 不可以是未发车班次
            if (lineTime.getDriving_state() != ParameterConstant.DRIVING){
                return MessageVar.LINETIMENOTDEPART;
            }
			lineTime.setDriving_state(ParameterConstant.CAR_STATUS_END);
			Car car = carDao.selectByPrimaryKey(Long.valueOf(lineTime.getCar_id()));

            // 不可以是未驾驶的车辆
            if (ParameterConstant.CAR_STATUS_IS != car.getCar_status()) {
                return car.getCar_num() + MessageVar.CARNOTDRIVE;
            }
			car.setSeat(car.getTotal_seat() - ParameterConstant.SEATGAP);
			car.setCar_status(ParameterConstant.CAR_STATUS_END);
			carDao.updateByPrimaryKeySelective(car);
            if (lineTimeDao.updateByPrimaryKeySelective(lineTime) == 1){
                return null;
            } else {
                return MessageVar.DRIVEENDERROR;
            }
		}
		return MessageVar.LINETIMENOTEXIST;
	}

}
