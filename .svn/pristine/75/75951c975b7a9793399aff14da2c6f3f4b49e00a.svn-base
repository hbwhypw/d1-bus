package com.tmtc.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.dao.FeedbackDao;
import com.tmtc.dao.UserDetailDao;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Feedback;
import com.tmtc.po.FeedbackRepository;
import com.tmtc.po.UserDetail;
import com.tmtc.service.FeedbackService;
import com.tmtc.utils.IdWorker;
import com.tmtc.vo.FeedbackVo;
@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	FeedbackDao feedbackDao;
	@Autowired
	UserDetailDao userDetailDao;
	
	@Override
	public int count(FeedbackRepository example) {
		return feedbackDao.countByExample(example);
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public int delete(FeedbackRepository example) {
		return 0;
	}

	@Override
	public int insert(Feedback record) {
		return feedbackDao.insert(record);
	}

	@Override
	public List<Feedback> select(FeedbackRepository example) {
		return null;
	}

	@Override
	public Feedback selectByPrimaryKey(String id) {
		return null;
	}

	@Override
	public int update(Feedback record) {
		return feedbackDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Feedback record, FeedbackRepository example) {
		return 0;
	}

	@Override
	public PageResult selectByPage(FeedbackRepository example) {
		List<Feedback> listFeedback = feedbackDao.selectByExample(example);
		List<FeedbackVo> listVo = new ArrayList<FeedbackVo>();
		for(Feedback feedback:listFeedback){
			String realname = getRealName(feedback.getUser_id());
			FeedbackVo feedbackVo = new FeedbackVo(feedback,realname);
			listVo.add(feedbackVo);
		}
		return new PageResult(feedbackDao.countByExample(example),listVo,1);
	}

	private String getRealName(String user_id){
		String real_name = null;
		UserDetail userDetail = userDetailDao.selectByPrimaryKey(user_id);
		if(null != userDetail){
			real_name = userDetail.getReal_name();
		}
		return real_name;
	}
	
	@Override
	public int insert(String user_id, String content, String contact) {
		Feedback feedback = new Feedback(IdWorker.nextId(),user_id,content,ParameterConstant.NOT_HANDLE,contact,new Date(),ParameterConstant.IS_CHECK);
		return feedbackDao.insert(feedback);
	}

	@Override
	public int updateRecover(String id) {
		Long adPicId = Long.valueOf(id);
		Feedback feedback = feedbackDao.selectByPrimaryKey(adPicId);
		feedback.setIs_check(ParameterConstant.IS_CHECK);
		return feedbackDao.updateByPrimaryKeySelective(feedback);
	}

	@Override
	public int deleteForEver(String id) {
		Long feedbackId = Long.valueOf(id);
		return feedbackDao.deleteByPrimaryKey(feedbackId);
	}
}
