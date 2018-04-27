package com.tmtc.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.dao.CardDao;
import com.tmtc.dao.CardRecordDao;
import com.tmtc.dao.DictionaryDao;
import com.tmtc.dao.ExpScoreRecordDao;
import com.tmtc.dao.UserDao;
import com.tmtc.dao.UserDetailDao;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Card;
import com.tmtc.po.CardRecord;
import com.tmtc.po.CardRecordRepository;
import com.tmtc.po.CardRepository;
import com.tmtc.po.CardRepository.Criteria;
import com.tmtc.po.ExpScoreRecord;
import com.tmtc.po.User;
import com.tmtc.po.UserDetail;
import com.tmtc.po.UserRepository;
import com.tmtc.service.CardService;
import com.tmtc.utils.IdWorker;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.vo.CardVo;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	CardDao cardDao;

	@Autowired
	DictionaryDao dictionaryDao;

	@Autowired
	UserDao userDao;

	@Autowired
	CardRecordDao cardRecordDao;

	@Autowired
	ExpScoreRecordDao expScoreRecordDao;

	@Autowired
	UserDetailDao userDetailDao;

	@Override
	public int count(CardRepository example) {
		return cardDao.countByExample(example);
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public int delete(CardRepository example) {
		return 0;
	}

	@Override
	public int insert(Card card) {
		return cardDao.insert(card);
	}

	@Override
	public List<Card> select(CardRepository example) {
		return null;
	}

	@Override
	public Card selectByPrimaryKey(String id) {
		return null;
	}

	@Override
	public int update(Card record) {
		return cardDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Card record, CardRepository example) {
		return 0;
	}

	@Override
	public PageResult query(String card_name, Integer page, Integer rows) {

		List<CardVo> cardVoList = new ArrayList<CardVo>();
		CardRepository cardRepository = new CardRepository();
		Criteria criteria = cardRepository.createCriteria();
		cardRepository.setOrderByClause("create_time desc");
		if (0 != VerificationUtil.length(card_name)) {
			criteria.andCard_nameLike("%" + card_name + "%");
		}
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		List<Card> cardList = cardDao.selectByExample(cardRepository);
		if (0 != cardList.size()) {
			for (Card c : cardList) {
				String city = dictionaryDao.selectNameByCode(c.getCity_id());
				String card_type_name = dictionaryDao.selectNameByCode(c.getCard_type());
				cardVoList.add(new CardVo(c, card_type_name, city));
			}
		}

		return new PageResult(count(cardRepository), cardVoList, 1);
	}

	@Override
	public int addExpGet(String id, String phone) {
		Date date = new Date();
		Card card = cardDao.selectByPrimaryKey(id);
		if (null == card) {
			return 1;
		}

		boolean b = date.before(card.getEnd_effect_time());
		if (!b) {
			return 2;
		}

		UserRepository userRepository = new UserRepository();
		com.tmtc.po.UserRepository.Criteria criteria = userRepository.createCriteria();
		criteria.andUsernameEqualTo(phone);
		List<User> userList = userDao.selectByExample(userRepository);
		if (0 == VerificationUtil.size(userList)) {
			return 3;
		}
		User user = userList.get(0);

		CardRecordRepository cardRecordRepository = new CardRecordRepository();
		com.tmtc.po.CardRecordRepository.Criteria criteria2 = cardRecordRepository.createCriteria();
		criteria2.andUser_idEqualTo(user.getId());
		criteria2.andCard_idEqualTo(card.getId());
		criteria2.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		List<CardRecord> cardRecordList = cardRecordDao.selectByExample(cardRecordRepository);

		if (0 != VerificationUtil.size(cardRecordList)) {
			return 4;
		}

		CardRecord cardRecord = new CardRecord(IdWorker.nextId(), user.getId(), card.getId(), ParameterConstant.USE,
				date, ParameterConstant.IS_CHECK);
		cardRecordDao.insert(cardRecord);

		ExpScoreRecord expScoreRecord = new ExpScoreRecord(IdWorker.nextId(), user.getId(), ParameterConstant.EXP_GET,
				card.getExp_score(), date, ParameterConstant.IS_CHECK);
		expScoreRecordDao.insert(expScoreRecord);

		UserDetail userDetail = userDetailDao.selectByPrimaryKey(user.getId());
		int i = VerificationUtil.integerIsNull(userDetail.getExp_score()) + card.getExp_score();
		userDetail.setExp_score(i);
		userDetailDao.updateByPrimaryKeySelective(userDetail);

		return 0;
	}
}
