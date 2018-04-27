package com.tmtc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.dao.CarDao;
import com.tmtc.dao.LineOrderDao;
import com.tmtc.dao.LineTimeDao;
import com.tmtc.po.Car;
import com.tmtc.po.LineOrder;
import com.tmtc.po.LineTime;
import com.tmtc.service.LineOrderStatusService;
import com.tmtc.utils.VerificationUtil;

@Service
public class LineOrderStatusServiceImpl implements LineOrderStatusService {

	@Autowired
	LineOrderDao lineOrderDao;

	@Autowired
	LineTimeDao lineTimeDao;

	@Autowired
	CarDao carDao;

	@Override
	public void update() {
		// 过期订单数
		int timeOutCount = lineOrderDao.updateByOrderTime(ParameterConstant.ORDER_STATUS_DATED,
				ParameterConstant.ORDER_STATUS_NOT_PAY);
		if (timeOutCount > 0) {
			List<LineOrder> list = lineOrderDao.selectByOrderTime(ParameterConstant.ORDER_STATUS_NOT_PAY);
			if (0 != VerificationUtil.size(list)) {
				for (LineOrder lineOrder : list) {
					String line_time_id = lineOrder.getTime_line_id();

					LineTime lineTime = lineTimeDao.selectByPrimaryKey(line_time_id);
					// update 座位数
					if (lineTime != null) {
						String carId = lineTime.getCar_id();
						if (0 != VerificationUtil.length(carId)) {
							Car car = carDao.selectByPrimaryKey(Long.valueOf(carId));
							if (null != car) {
								int seat = car.getSeat();
								if (0 != VerificationUtil.integerIsNull(seat)) {
									car.setSeat(seat + 1);
									carDao.updateByPrimaryKeySelective(car);
								}
							}
						}
					}
				}
			}
		}
	}
}
