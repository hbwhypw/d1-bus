package com.tmtc.serviceImpl.appAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.dao.DriverDao;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Driver;
import com.tmtc.po.DriverRepository;
import com.tmtc.service.appAPI.DriverAppService;
@Service
public class DriverAppServiceImpl implements DriverAppService{

	@Autowired
	DriverDao driverDao;
	
	@Override
	public int count(DriverRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(DriverRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Driver record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Driver> select(DriverRepository example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Driver selectByPrimaryKey(String id) {
		return driverDao.selectByPrimaryKey(id);
	}

	@Override
	public int update(Driver record) {
		return driverDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Driver record, DriverRepository example) {
		return 0;
	}

	@Override
	public PageResult selectByPage(DriverRepository example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Driver> selectByPhone(String phone) {
		DriverRepository driverRepository = new DriverRepository();
		DriverRepository.Criteria criteria = driverRepository.createCriteria();
		criteria.andMobileEqualTo(phone);
		return driverDao.selectByExample(driverRepository);
	}

	@Override
	public boolean updatePW(Driver driver) {
		int i = driverDao.updateByPrimaryKeySelective(driver);
		return 0 < i ? true : false;
	}
	
}
