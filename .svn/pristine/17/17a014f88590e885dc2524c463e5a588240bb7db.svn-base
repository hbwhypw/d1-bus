package com.tmtc.serviceImpl;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.dao.AdminsDao;
import com.tmtc.dao.MessageDao;
import com.tmtc.dao.MessageRecordDao;
import com.tmtc.dao.UserDetailDao;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Admins;
import com.tmtc.po.Message;
import com.tmtc.po.MessageRecord;
import com.tmtc.po.MessageRecordRepository;
import com.tmtc.po.UserDetail;
import com.tmtc.service.MessageRecordService;
import com.tmtc.utils.DateUtil;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.vo.MessageRecordVo;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Function:
 * 
 * @auther: hbwhypw Date: 2015/10/27 15:44
 */
@Service
public class MessageRecordServiceImpl implements MessageRecordService {
	@Autowired
	MessageRecordDao messageRecordDao;
	@Autowired
	UserDetailDao userDetailDao;
	@Autowired
	AdminsDao adminsDao;
	@Autowired
	MessageDao messageDao;

	@Override
	public int count(MessageRecordRepository example) {
		return messageRecordDao.countByExample(example);
	}

	@Override
	public int delete(String id) {
		return messageRecordDao.deleteByPrimaryKey(id);
	}

	@Override
	public int delete(MessageRecordRepository example) {
		return messageRecordDao.deleteByExample(example);
	}

	@Override
	public int insert(MessageRecord record) {
		return messageRecordDao.insert(record);
	}

	@Override
	public List<MessageRecord> select(MessageRecordRepository example) {
		return messageRecordDao.selectByExample(example);
	}

	@Override
	public MessageRecord selectByPrimaryKey(String id) {
		return messageRecordDao.selectByPrimaryKey(id);
	}

	@Override
	public int update(MessageRecord record) {
		return messageRecordDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(MessageRecord record, MessageRecordRepository example) {
		return messageRecordDao.updateByExampleSelective(record, example);
	}

	@Override
	public List<MessageRecordVo> selectVo(MessageRecordRepository example) {
		List<MessageRecord> list = select(example);
		List<MessageRecordVo> listVo = new ArrayList<MessageRecordVo>();
		for (MessageRecord messageRecord : list) {
			String userId = messageRecord.getUser_id();
			String adminsId = messageRecord.getAdmin_id();
			String messageId = messageRecord.getMessage_id();
			Integer is_check = messageRecord.getIs_check();

			String userName = null;
			String adminsName = null;
			String messageName = null;
			String isCheckName = null;

			if (0 != VerificationUtil.length(userId)) {
				userName = getUserName(userId);
			}
			if (0 != VerificationUtil.length(adminsId)) {
				adminsName = getAdminsName(adminsId);
			}
			if (0 != VerificationUtil.length(messageId)) {
				messageName = getMessageName(messageId);
			}
			if (0 != VerificationUtil.integerIsNull(is_check)) {
				if (0 == is_check) {
					isCheckName = "X";
				} else {
					isCheckName = "√";
				}
			}

			MessageRecordVo messageRecordVo = new MessageRecordVo(messageRecord, messageName, adminsName, userName,
					isCheckName);
			listVo.add(messageRecordVo);
		}
		return listVo;
	}

	@Override
	public PageResult selectByPage(MessageRecordRepository example) {
		return new PageResult(count(example), selectVo(example), 1);
	}

	public String getUserName(String userId) {
		UserDetail userDetail = userDetailDao.selectByPrimaryKey(userId);
		if (null != userDetail) {
			return userDetail.getReal_name();
		}
		return null;
	}

	public String getAdminsName(String adminsId) {
		Admins admins = adminsDao.selectByPrimaryKey(adminsId);
		if (null != admins) {
			return admins.getUsername();
		}
		return null;
	}

	public String getMessageName(String messageId) {
		Message message = messageDao.selectByPrimaryKey(messageId);
		if (null != message) {
			return message.getTitle();
		}
		return null;
	}

	@Override
	public List<MessageRecord> selectVo(String userId) {
		MessageRecordRepository messageRecordRepository = new MessageRecordRepository();
		Date date = new Date();
		Date date2 = DateUtil.AddDate(date, -30);
		messageRecordRepository.or().andUser_idEqualTo(userId).andIs_checkEqualTo(ParameterConstant.IS_CHECK)
				.andSend_timeBetween(date2, date);
		messageRecordRepository.or().andUser_idEqualTo("0");
		messageRecordRepository.setOrderByClause("send_time desc");

		List<MessageRecord> list = select(messageRecordRepository);
		for (MessageRecord messageRecord : list) {
			String messageId = messageRecord.getMessage_id();
			Message message = null;
			if (StringUtils.isNotEmpty(messageId)) {
				message = messageDao.selectByPrimaryKey(messageId);
			}
			messageRecord.setMessage(message);
		}
		return list;

	}

}
