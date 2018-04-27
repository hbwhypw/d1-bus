package com.tmtc.serviceImpl.appAPI;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tmtc.constant.ParameterConstant;
import com.tmtc.dao.LineDao;
import com.tmtc.dao.LineOrderDao;
import com.tmtc.dao.LineTimeDao;
import com.tmtc.dao.ScanDao;
import com.tmtc.dao.UserDao;
import com.tmtc.dao.UserDetailDao;
import com.tmtc.po.Line;
import com.tmtc.po.LineOrder;
import com.tmtc.po.LineTime;
import com.tmtc.po.Scan;
import com.tmtc.po.User;
import com.tmtc.po.UserDetail;
import com.tmtc.po.UserDetailRepository;
import com.tmtc.po.UserDetailRepository.Criteria;
import com.tmtc.service.appAPI.UpEmployeeService;
import com.tmtc.utils.DateUtil;
import com.tmtc.utils.IdWorker;
import com.tmtc.utils.OrderNumUtil;
import com.tmtc.utils.VerificationUtil;

@Service
public class UpEmployeeServiceImpl implements UpEmployeeService {

	@Autowired
	UserDetailDao userDetailDao;

	@Autowired
	UserDao userDao;

	@Autowired
	LineTimeDao lineTimeDao;

	@Autowired
	LineDao lineDao;

	@Autowired
	LineOrderDao lineOrderDao;

	@Autowired
	ScanDao scanDao;

	@Override
	public int upEmployee(String[] str, String company_id, String line_time_id) {

		LineTime lineTime = lineTimeDao.selectByPrimaryKey(line_time_id);
		if (null == lineTime) {
			return 1;
		}

		String line_id = lineTime.getLine_id();
		Line line = lineDao.selectByPrimaryKey(line_id);
		if (null == line) {
			return 1;
		}

		int lt = str.length / 3;
		String[] user_ids = new String[lt];
		String[] line_station_ids = new String[lt];
		Date[] times = new Date[lt];

		for (int i = 0, j = 0; i < str.length; i = i + 3, j++) {

			String user_id = checkCardNum(str[i], company_id);
			if (0 == VerificationUtil.length(user_id)) {
				return 2;
			}

			user_ids[j] = user_id;
			line_station_ids[j] = str[i + 1];
			times[j] = DateUtil.getLongDate(str[i + 2]);
		}

		for (int i = 0; i < user_ids.length; i++) {
			
			UserDetail userDetail = userDetailDao.selectByPrimaryKey(user_ids[i]);
			if (null == userDetail) {
				continue;
			}
			userDetail.setExp_score(userDetail.getExp_score()+ParameterConstant.ORDER_EXP);
			userDetailDao.updateByPrimaryKeySelective(userDetail);
			LineOrder lineOrder = new LineOrder(IdWorker.nextId(), OrderNumUtil.getOrderByXL(), user_ids[i],
					line.getCity_id(), line_id, line_time_id, line_station_ids[i], times[i],
					ParameterConstant.ORDER_STATUS, ParameterConstant.ORDER_EXP,
					ParameterConstant.LINE_ORDER_TYPE_DIRECT, times[i], ParameterConstant.IS_CHECK);
			lineOrderDao.insert(lineOrder);
			Scan scan = new Scan(IdWorker.nextId(), user_ids[i], line_time_id, line_station_ids[i], times[i],
					ParameterConstant.USER_STATUS_GETON, ParameterConstant.IS_CHECK);
			scanDao.insert(scan);
		}

		return 0;
	}

	/**
	 * 检测卡号是否存在
	 * 
	 * @param card_num
	 * @param company_id
	 * @return
	 */
	private String checkCardNum(String card_num, String company_id) {
		UserDetailRepository userDetailRepository = new UserDetailRepository();
		Criteria criteria = userDetailRepository.createCriteria();
		try {
			criteria.andCard_numEqualTo(card_num);
			criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		} catch (Exception e) {
			return null;
		}
		List<UserDetail> list = userDetailDao.selectByExample(userDetailRepository);
		if (0 == VerificationUtil.size(list)) {
			return null;
		}

		User user = userDao.selectByPrimaryKey(list.get(0).getId());
		if (null == user) {
			return null;
		}
		return user.getId();
	}
}
