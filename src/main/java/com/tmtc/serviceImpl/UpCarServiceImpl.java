package com.tmtc.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.dao.ScanDao;
import com.tmtc.frame.PageResult;
import com.tmtc.service.UpCarService;
import com.tmtc.vo.UpCar;

@Service
public class UpCarServiceImpl implements UpCarService {
	
	@Autowired
	ScanDao scanDao;

	@Override
	public PageResult query(Map<String, Object> map) {
		return new PageResult(scanDao.count(map), scanDao.select(map), 1);
	}

	@Override
	public List<UpCar> select(String ids) {
		return scanDao.selectById(ids);
	}

}
