package com.tmtc.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.dao.AppResourceDao;
import com.tmtc.frame.PageResult;
import com.tmtc.po.AppResource;
import com.tmtc.po.AppResourceRepository;
import com.tmtc.service.AppResourceService;
import com.tmtc.utils.IdWorker;
@Service
public class AppResourceServiceImpl implements AppResourceService{

	@Autowired
	AppResourceDao appResourceDao;
	
	@Override
	public int count(AppResourceRepository example) {
		return 0;
	}

	@Override
	public int delete(String id) {
		AppResource appResource = new AppResource();
		appResource.setId(id);
		appResource.setIs_check(ParameterConstant.IS_NOT_CHECK);
		return appResourceDao.updateByPrimaryKeySelective(appResource);
	}

	@Override
	public int delete(AppResourceRepository example) {
		return 0;
	}

	@Override
	public int insert(AppResource record) {
		String id = IdWorker.nextId();
		record.setId(id);
		record.setCreate_time(new Date());
		record.setIs_check(ParameterConstant.IS_CHECK);
		return appResourceDao.insert(record);
	}

	@Override
	public List<AppResource> select(AppResourceRepository example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateRecover(String id) {
		AppResource appResource = appResourceDao.selectByPrimaryKey(id);
		appResource.setIs_check(ParameterConstant.IS_CHECK);
		return appResourceDao.updateByPrimaryKeySelective(appResource);
	}
	@Override
	public AppResource selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(AppResource record) {
		return appResourceDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(AppResource record, AppResourceRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageResult selectByPage(AppResourceRepository example) {
		return new PageResult(appResourceDao.countByExample(example),appResourceDao.selectByExample(example),1);
	}

	@Override
	public int deleteForEver(String id) {
		return appResourceDao.deleteByPrimaryKey(id);
	}

}
