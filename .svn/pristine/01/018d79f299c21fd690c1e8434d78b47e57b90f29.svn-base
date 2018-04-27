package com.tmtc.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.dao.DictionaryDao;
import com.tmtc.dao.ExpScoreRecordDao;
import com.tmtc.dao.UserDao;
import com.tmtc.frame.BasePage;
import com.tmtc.frame.PageResult;
import com.tmtc.po.ExpScoreRecord;
import com.tmtc.po.ExpScoreRecordRepository;
import com.tmtc.po.User;
import com.tmtc.po.UserRepository;
import com.tmtc.po.UserRepository.Criteria;
import com.tmtc.service.ExpService;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.vo.ExpScoreRecordVo;

@Service
public class ExpServiceImpl extends BasePage implements ExpService {

	@Autowired
	UserDao userDao;

	@Autowired
	ExpScoreRecordDao expScoreRecordDao;

	@Autowired
	DictionaryDao dictionaryDao;

	@Override
	public PageResult query(Integer page, Integer rows, String phone) {

		ExpScoreRecordRepository expScoreRecordRepository = new ExpScoreRecordRepository();
		com.tmtc.po.ExpScoreRecordRepository.Criteria criteria2 = expScoreRecordRepository.createCriteria();
		criteria2.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		if (0 != VerificationUtil.length(phone)) {
			UserRepository userRepository = new UserRepository();
			Criteria criteria = userRepository.createCriteria();
			criteria.andUsernameLike("%" + phone + "%");
			List<User> list = userDao.selectByExample(userRepository);
			List<String> stringlist = new ArrayList<>();
			for (User u : list) {
				stringlist.add(u.getId());
			}
			criteria2.andUser_idIn(stringlist);
		}

		super.setPageParams(expScoreRecordRepository, page, rows);
		List<ExpScoreRecord> list2 = expScoreRecordDao.selectByExample(expScoreRecordRepository);
		List<ExpScoreRecordVo> expScoreRecordVoList = new ArrayList<>();
		for (ExpScoreRecord e : list2) {
			UserRepository userRepository = new UserRepository();
			Criteria criteria = userRepository.createCriteria();
			criteria.andIdEqualTo(e.getUser_id());
			List<User> list = userDao.selectByExample(userRepository);
			if(0 == VerificationUtil.size(list)){
				return null;
			}
			String exp_type_name = dictionaryDao.selectNameByCode(e.getExp_type());
			expScoreRecordVoList.add(new ExpScoreRecordVo(e, list.get(0).getUsername(), exp_type_name));
		}

		return new PageResult(count(expScoreRecordRepository), expScoreRecordVoList, 1);
	}

	private int count(ExpScoreRecordRepository example) {
		return expScoreRecordDao.countByExample(example);
	}
}
