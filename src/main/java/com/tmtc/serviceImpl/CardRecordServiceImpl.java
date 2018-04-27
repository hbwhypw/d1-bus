package com.tmtc.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.constant.MessageVar;
import com.tmtc.constant.ParameterConstant;
import com.tmtc.dao.CardDao;
import com.tmtc.dao.CardRecordDao;
import com.tmtc.dao.UserDetailDao;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Card;
import com.tmtc.po.CardRecord;
import com.tmtc.po.CardRecordRepository;
import com.tmtc.po.CardRepository;
import com.tmtc.po.UserDetail;
import com.tmtc.po.UserDetailRepository;
import com.tmtc.service.CardRecordService;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.vo.CardRecordVo;
@Service
public class CardRecordServiceImpl implements CardRecordService{

	@Autowired
	CardRecordDao cardRecordDao;
	@Autowired
	UserDetailDao userDetailDao;
	@Autowired
	CardDao cardDao;
	
	@Override
	public int count(CardRecordRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		Long Id = Long.valueOf(id);
		return cardRecordDao.deleteByPrimaryKey(Id);
	}

	@Override
	public int delete(CardRecordRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(CardRecord record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CardRecord> select(CardRecordRepository example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CardRecord selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(CardRecord record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(CardRecord record, CardRecordRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageResult selectByPage(CardRecordRepository example) {
		return null;
	}

	@Override
	public PageResult selectByPage(Integer page, Integer rows, String userName, String cardName, String start,
			String end) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CardRecordRepository cardRecordRepository = new CardRecordRepository();
		CardRecordRepository.Criteria criteria = cardRecordRepository.createCriteria();
		cardRecordRepository.setPageSize(rows);
		cardRecordRepository.setRowIndex((page-1)*rows);
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		if(0 != VerificationUtil.length(userName)){
			UserDetailRepository userDetailRepository = new UserDetailRepository();
			UserDetailRepository.Criteria criteria2 = userDetailRepository.createCriteria();
			criteria2.andUsernameLike("%"+userName+"%");
			criteria2.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
			List<UserDetail> listUserDetail = userDetailDao.selectByExample(userDetailRepository);
			List<String> listUserId = new ArrayList<String>();
			for(UserDetail userDetail:listUserDetail){
				listUserId.add(userDetail.getId());
			}
			criteria.andUser_idIn(listUserId);
		}
		if(0 != VerificationUtil.length(cardName)){
			CardRepository cardRepository = new CardRepository();
			CardRepository.Criteria criteria2 = cardRepository.createCriteria();
			criteria2.andCard_nameLike("%"+cardName+"%");
			criteria2.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
			List<Card> listCard = cardDao.selectByExample(cardRepository);
			List<String> listCardId = new ArrayList<String>();
			for(Card card:listCard){
				listCardId.add(card.getId());
			}
			criteria.andCard_idIn(listCardId);
		}
		if(null != start){
			Date start_time = sdf.parse(start);
			criteria.andOpt_timeGreaterThan(start_time);
		}
		if(null != end){
			Date end_time = sdf.parse(end);
			criteria.andOpt_timeLessThan(end_time);
		}
		List<CardRecord> listCardRecord = cardRecordDao.selectByExample(cardRecordRepository);
		List<CardRecordVo> listVo = new ArrayList<CardRecordVo>();
		for(CardRecord cardRecord:listCardRecord){
			String user_id = cardRecord.getUser_id();
			String card_id = cardRecord.getCard_id();
			Integer is_use = cardRecord.getIs_use();
			Integer is_check = cardRecord.getIs_check();
			
			String userName1 = null; 
			String cardName1 = null;
			String isUseName = null;
			String isCheckName = null;
			
			if(0 != VerificationUtil.length(user_id)){
				UserDetail userDetail = userDetailDao.selectByPrimaryKey(user_id);
				if(null != userDetail){
					if(ParameterConstant.IS_NOT_CHECK != userDetail.getIs_check()){
						userName1 = userDetail.getUsername();
					}
				}
			}
			if(0 != VerificationUtil.length(card_id)){
				Card card = cardDao.selectByPrimaryKey(card_id);
				if(null != card){
					if(ParameterConstant.IS_NOT_CHECK != card.getIs_check()){
						cardName1 = card.getCard_name();
					}
				}
			}
			if(0 != VerificationUtil.integerIsNull(is_use)){
				isUseName = MessageVar.CARDRECORD_USE;
			}
			if(0 != VerificationUtil.integerIsNull(is_check)){
				if(1 == is_check){
					isCheckName = "√";
				}else{
					isCheckName = "X";
				}
			}
			CardRecordVo cardRecordVo = new CardRecordVo(cardRecord, userName1, cardName1, isUseName, isCheckName);
			listVo.add(cardRecordVo);
		}
		return new PageResult(cardRecordDao.countByExample(cardRecordRepository), listVo, 1);
	}

}
