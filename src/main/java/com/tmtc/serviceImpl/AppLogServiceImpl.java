package com.tmtc.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.dao.AppLogDao;
import com.tmtc.dao.UserDetailDao;
import com.tmtc.frame.PageResult;
import com.tmtc.po.AppLog;
import com.tmtc.po.AppLogRepository;
import com.tmtc.po.UserDetail;
import com.tmtc.service.AppLogService;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.vo.AppLogVo;
@Service
public class AppLogServiceImpl implements AppLogService{

	@Autowired
	AppLogDao appLogDao;
	@Autowired
	UserDetailDao userDetailDao;
	
	@Override
	public int count(AppLogRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		return appLogDao.deleteByPrimaryKey(id);
	}

	@Override
	public int delete(AppLogRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(AppLog record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AppLog> select(AppLogRepository example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppLog selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(AppLog record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(AppLog record, AppLogRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageResult selectByPage(AppLogRepository example) {
		List<AppLog> list = appLogDao.selectByExample(example);
		ArrayList<AppLogVo> listVo = new ArrayList<AppLogVo>();
		for(AppLog appLog:list){
			String userId = appLog.getUser_id();
			String userName = null;
			if(0 != VerificationUtil.length(userId)){
				 userName = getUserName(userId);
			}
			AppLogVo appLogVo = new AppLogVo(appLog, userName);
			listVo.add(appLogVo);
		}
		return new PageResult(appLogDao.countByExample(example),listVo,1);
	}
	
	private String getUserName(String userId){
		UserDetail userDetail = userDetailDao.selectByPrimaryKey(userId);
		return userDetail.getReal_name();
	}
}
