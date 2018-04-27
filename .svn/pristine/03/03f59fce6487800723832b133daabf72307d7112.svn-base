package com.tmtc.serviceImpl.appAPI;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.dao.CarDao;
import com.tmtc.dao.LineOrderDao;
import com.tmtc.dao.LineTimeDao;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Car;
import com.tmtc.po.LineOrder;
import com.tmtc.po.LineOrderRepository;
import com.tmtc.po.LineTime;
import com.tmtc.service.appAPI.LineOrderAppService;
import com.tmtc.utils.IdWorker;
import com.tmtc.utils.OrderNumUtil;
import com.tmtc.utils.VerificationUtil;
@Service
public class LineOrderAppServiceImpl implements LineOrderAppService{

	@Autowired
	LineTimeDao lineTimeDao;
	@Autowired
	LineOrderDao lineOrderDao;
	@Autowired
	CarDao carDao;
	
	@Override
	public int count(LineOrderRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(LineOrderRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(LineOrder record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<LineOrder> select(LineOrderRepository example) {
		List<LineOrder> list = lineOrderDao.selectByExample(example);
		return list;
	}

	@Override
	public LineOrder selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(LineOrder record) {
		return lineOrderDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(LineOrder record, LineOrderRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageResult selectByPage(LineOrderRepository example) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public int add(String userId,Integer city_id, String time_line_id,String station_id) {
//		String id = IdWorker.nextId();
//		Long Id = Long.valueOf(time_line_id);
//		LineTime lineTime = lineTimeDao.selectByPrimaryKey(Id);
//		String line_id = null;
//		if(null != lineTime){
//			line_id = lineTime.getLine_id();
//		}
//		LineOrder lineOrder = new LineOrder(id,OrderNumUtil.getOrderByXL(),userId,city_id, line_id, time_line_id, station_id, new Date(), ParameterConstant.ORDER_STATUS_NOT_PAY, ParameterConstant.ORDER_EXP, ParameterConstant.LINE_ORDER_TYPE_PAY, null, ParameterConstant.IS_CHECK);
//		int a = lineOrderDao.insert(lineOrder); 
//		if(0 != a && null != lineTime){
//			String car_id = lineTime.getCar_id();
//			Long carId = Long.valueOf(car_id);
//			Car car = carDao.selectByPrimaryKey(carId);
//			if(null != car){
//				car.setSeat(car.getSeat()-1);
//				carDao.updateByPrimaryKeySelective(car);
//			}
//		}
//		return a;
//	}

	@Override
	public int select(String userId, String line_time_id) {
		LineOrderRepository lineOrderRepository = new LineOrderRepository();
		LineOrderRepository.Criteria criteria = lineOrderRepository.createCriteria();
		criteria.andUser_idEqualTo(userId);
		criteria.andTime_line_idEqualTo(line_time_id);
		List<LineOrder> list = lineOrderDao.selectByExample(lineOrderRepository);
		Integer status = 0;
		if(0 != VerificationUtil.size(list)){
			status = list.get(0).getOrder_status();
		}
		return status;
	}

	@Override
	public LineOrder add(String userId, Integer city_id, String time_line_id) {
		String id = IdWorker.nextId();
		LineTime lineTime = lineTimeDao.selectByPrimaryKey(time_line_id);
		String line_id = null;
		if(null != lineTime){
			line_id = lineTime.getLine_id();
		}
		LineOrder lineOrder = new LineOrder(id,OrderNumUtil.getOrderByXL(),userId,city_id, line_id, time_line_id, null, new Date(), ParameterConstant.ORDER_STATUS_NOT_PAY, ParameterConstant.ORDER_EXP, ParameterConstant.LINE_ORDER_TYPE_PAY, null, ParameterConstant.IS_CHECK);
		lineOrder.setLineTime(lineTime);
		
		int a = lineOrderDao.insert(lineOrder); 
		if(0 != a && null != lineTime){
			String car_id = lineTime.getCar_id();
			Long carId = Long.valueOf(car_id);
			Car car = carDao.selectByPrimaryKey(carId);
			if(null != car){
				car.setSeat(car.getSeat()-1);
				carDao.updateByPrimaryKeySelective(car);
			}
		}
		return lineOrder;
	}

	@Override
	public LineOrder update(String userId, String time_line_id) {
		LineOrderRepository lineOrderRepository = new LineOrderRepository();
		LineOrderRepository.Criteria criteria = lineOrderRepository.createCriteria();
		criteria.andUser_idEqualTo(userId);
		criteria.andTime_line_idEqualTo(time_line_id);
		List<LineOrder> list = lineOrderDao.selectByExample(lineOrderRepository);
		if(0 != VerificationUtil.size(list)){
			LineOrder lineOrder = list.get(0);
			lineOrder.setOrder_status(ParameterConstant.ORDER_STATUS_NOT_PAY);
			lineOrderDao.updateByPrimaryKeySelective(lineOrder);
			return lineOrder;
		}
		return null;
	}
}
