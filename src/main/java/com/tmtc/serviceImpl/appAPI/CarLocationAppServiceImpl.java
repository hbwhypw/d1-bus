package com.tmtc.serviceImpl.appAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.dao.CarDao;
import com.tmtc.dao.CarLocationDao;
import com.tmtc.dao.LineTimeDao;
import com.tmtc.po.Car;
import com.tmtc.po.CarLocation;
import com.tmtc.po.CarLocationRepository;
import com.tmtc.po.LineTime;
import com.tmtc.service.appAPI.CarLocationAppService;
import com.tmtc.utils.VerificationUtil;
@Service
public class CarLocationAppServiceImpl implements CarLocationAppService{

	@Autowired
	LineTimeDao lineTimeDao;
	
	@Autowired
	CarDao carDao;
	
	@Autowired
	CarLocationDao carLocationDao;
	
	@Override
	public CarLocation selectCarLocation(String line_time_id) {
		
		//查询次班次的车辆
		LineTime lineTime = lineTimeDao.selectByPrimaryKey(line_time_id);
		if(null == lineTime || ParameterConstant.DRIVING != lineTime.getDriving_state()){
			return null;
		}
		String car_id = lineTime.getCar_id();
		if(0 == VerificationUtil.length(car_id)){
			return null;
		}
		Car car = carDao.selectByPrimaryKey(Long.valueOf(car_id));
		
		//根据车辆找出车辆位置
		if(null == car || ParameterConstant.CAR_STATUS_IS != car.getCar_status()){
			return null;
		}
		String device_id = car.getImei();
		if(0 == VerificationUtil.length(device_id)){
			return null;
		}
		CarLocationRepository carLocationRepository = new CarLocationRepository();
		CarLocationRepository.Criteria criteria = carLocationRepository.createCriteria();
		criteria.andDevice_idEqualTo(device_id);
		List<CarLocation> list = carLocationDao.selectByExample(carLocationRepository);
		if(0 == VerificationUtil.size(list)){
			return null;
		}
		CarLocation carLocation = list.get(0);
		carLocation.setCar(car);
		return carLocation;
	}

}
