package com.tmtc.serviceImpl.appAPI;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.annotation.verity.VerifyUserDetailImpl;
import com.tmtc.annotation.verity.VerifyUserImpl;
import com.tmtc.constant.ParameterConstant;
import com.tmtc.dao.ExpScoreRecordDao;
import com.tmtc.dao.LineDao;
import com.tmtc.dao.LineOrderDao;
import com.tmtc.dao.LineTimeDao;
import com.tmtc.dao.MoneyOrderDao;
import com.tmtc.dao.UserDao;
import com.tmtc.dao.UserDetailDao;
import com.tmtc.frame.ServiceRuntimeException;
import com.tmtc.po.ExpScoreRecord;
import com.tmtc.po.Line;
import com.tmtc.po.LineOrder;
import com.tmtc.po.LineOrderRepository;
import com.tmtc.po.MoneyOrder;
import com.tmtc.po.User;
import com.tmtc.po.UserDetail;
import com.tmtc.po.LineOrderRepository.Criteria;
import com.tmtc.po.LineTime;
import com.tmtc.service.UserDetailService;
import com.tmtc.service.appAPI.UpCarValidService;
import com.tmtc.utils.DateUtil;
import com.tmtc.utils.IdWorker;
import com.tmtc.utils.OrderNumUtil;
import com.tmtc.utils.VerificationUtil;

@Service
public class UpCarValidServiceImpl implements UpCarValidService {

	@Autowired
	UserDao userDao;

	@Autowired
	UserDetailDao userDetailDao;

	@Autowired
	LineTimeDao lineTimeDao;

	@Autowired
	VerifyUserImpl verifyUserImpl;

	@Autowired
	VerifyUserDetailImpl verifyUserDetailImpl;

	@Autowired
	UserDetailService userDetailService;

	@Autowired
	LineOrderDao lineOrderDao;

	@Autowired
	LineDao lineDao;

	@Autowired
	MoneyOrderDao moneyOrderDao;

	@Autowired
	ExpScoreRecordDao expScoreRecordDao;

	/**
	 * 1.该公司下卡号不存在 2.数据出现异常
	 */
	@Override
	public int upCar(String company_id, String card_num, String line_time_id, String line_station_id, Integer validDate,
			Date date) {

		if (0 == VerificationUtil.length(card_num)) {
			return 5;
		}

		synchronized (UpCarValidServiceImpl.class) {
			String user_id = userDao.selectCompanyCardNum(company_id, card_num);
			if (0 == VerificationUtil.length(user_id)) {
				user_id = this.addNoValidUser(company_id, validDate, card_num);
			}
			UserDetail userDetail = userDetailDao.selectByPrimaryKey(user_id);
			if (null == userDetail || 0 == VerificationUtil.length(userDetail.getId())) {
				return 2;
			}
			switch (userDetail.getUser_type()) {
			case 1401:
				return free(userDetail, line_time_id, line_station_id, card_num, date);
			default:
				break;
			}
			return 1;
		}
	}

	/**
	 * 
	 * @param user_id
	 * @param line_time_id
	 * @param line_station
	 * @return 5已经刷过卡
	 */
	private int free(UserDetail userDetail, String line_time_id, String line_station_id, String card_num, Date date) {
		String user_id = userDetail.getId();
		LineOrderRepository lineOrderRepository = new LineOrderRepository();
		Criteria criteria = lineOrderRepository.createCriteria();
		criteria.andUser_idEqualTo(user_id);
		criteria.andTime_line_idEqualTo(line_time_id);
		List<LineOrder> list = lineOrderDao.selectByExample(lineOrderRepository);
		if (0 != VerificationUtil.size(list)) {
			return 5;
		}
		LineTime lineTime = lineTimeDao.selectByPrimaryKey(line_time_id);
		Line line = lineDao.selectByPrimaryKey(lineTime.getLine_id());

		// 添加扫描记录
		// Scan scan = new Scan(IdWorker.nextId(), userDetail.getId(),
		// line_time_id, line_station_id, date,
		// ParameterConstant.SCAN_TYPE_FINISH, ParameterConstant.IS_CHECK);
		// if (scanDao.insert(scan) < 0) {
		// throw new ServiceRuntimeException("扫描表添加异常");
		// }

		String orderByXL = OrderNumUtil.getOrderByXL();
		LineOrder lineOrder = new LineOrder(IdWorker.nextId(), orderByXL, user_id, line.getCity_id(), line.getId(),
				line_time_id, line_station_id, date, ParameterConstant.ORDER_STATUS, ParameterConstant.ORDER_EXP,
				ParameterConstant.LINE_ORDER_TYPE_PAY_CARD_NUM, date, ParameterConstant.IS_CHECK);
		if (lineOrderDao.insert(lineOrder) != 1) {
			throw new ServiceRuntimeException("线路订单添加异常");
		}

		MoneyOrder moneyOrder = new MoneyOrder(IdWorker.nextId(), user_id, card_num, orderByXL, 0,
				ParameterConstant.PAY_TYPE_BALANCE, ParameterConstant.ORDER_STATUS, date);
		if (moneyOrderDao.insert(moneyOrder) != 1) {
			throw new ServiceRuntimeException("消费记录添加异常");
		}
		ExpScoreRecord expScoreRecord = new ExpScoreRecord(IdWorker.nextId(), user_id, ParameterConstant.EXP_CRAD,
				ParameterConstant.ORDER_EXP, date, ParameterConstant.IS_CHECK);
		if (expScoreRecordDao.insert(expScoreRecord) != 1) {
			throw new ServiceRuntimeException("积分添加异常(记录)");
		}
		userDetail.setExp_score(userDetail.getExp_score() + ParameterConstant.ORDER_EXP);
		if (userDetailDao.updateByPrimaryKeySelective(userDetail) != 1) {
			throw new ServiceRuntimeException("积分添加异常(用户)");
		}
		return 0;
	}

	// private int pay(String company_id, String card_num, String
	// line_time_id,int user_type) {
	//
	// }

	public String addNoValidUser(String company_id, Integer validDate, String card_num) {
		String nextId = IdWorker.nextId();
		Map<String, String> map = userDetailService.createQR_code(nextId);
		User user = new User(nextId, ParameterConstant.BEIJING, company_id, null, null, null,
				ParameterConstant.USER_TYPE_COMPANY, null, null, null, null, null, null);
		verifyUserImpl.vUser(user);
		if (userDao.insert(user) != 1) {
			throw new ServiceRuntimeException("不验证用户刷卡添加用户异常！");
		}
		UserDetail userDetail = new UserDetail(ParameterConstant.USER_TYPE_COMPANY, nextId,
				userDetailService.getLinkNum(), new Date(), null, null, null, null, map.get("qr_code"),
				map.get("qr_code_secret"), null, null, null, null, null, null, null, card_num, 0, null, null,
				DateUtil.AddDate(new Date(), validDate), ParameterConstant.IS_CHECK);
		verifyUserDetailImpl.vUserDetail(userDetail);
		if (userDetailDao.insert(userDetail) != 1) {
			throw new ServiceRuntimeException("不验证用户刷卡添加用户详细信息异常！");
		}
		return nextId;
	}
}
