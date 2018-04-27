package com.tmtc.serviceImpl.appAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.dao.CarDao;
import com.tmtc.dao.LineTimeDao;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Car;
import com.tmtc.po.CarRepository;
import com.tmtc.po.LineTime;
import com.tmtc.service.appAPI.CarAppService;
@Service
public class CarAppServiceImpl implements CarAppService{

	@Autowired
	CarDao carDao;
	@Autowired
	LineTimeDao lineTimeDao;
	
	@Override
	public int count(CarRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(CarRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Car record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Car> select(CarRepository example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Car record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Car record, CarRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageResult selectByPage(CarRepository example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateSeat(String lineTimeId) {
		LineTime lineTime = lineTimeDao.selectByPrimaryKey(lineTimeId);
		if(null != lineTime){
			Long carId = Long.valueOf(lineTime.getCar_id());
			Car car = carDao.selectByPrimaryKey(carId);
			if(null != car){
				car.setSeat(car.getSeat()-1);
				return carDao.updateByPrimaryKeySelective(car);
			}
		}
		return 0;
	}

}
