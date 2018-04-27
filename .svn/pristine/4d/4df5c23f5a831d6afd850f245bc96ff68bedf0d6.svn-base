package com.tmtc.serviceImpl.appAPI;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.dao.AppLogDao;
import com.tmtc.frame.PageResult;
import com.tmtc.po.AppLog;
import com.tmtc.po.AppLogRepository;
import com.tmtc.service.appAPI.AppLogAppService;
import com.tmtc.utils.IdWorker;
@Service
public class AppLogAppServiceImpl implements AppLogAppService{

	@Autowired
	AppLogDao appLogDao;
	
	@Override
	public int insert(String name,String param, String userId, String ip) {
		String id = IdWorker.nextId();
		AppLog appLog = new AppLog(id,param,name,userId,ip,new Date());
		return appLogDao.insert(appLog);
	}

	@Override
	public int count(AppLogRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		return null;
	}

}
