package com.tmtc.serviceImpl.appAPI;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.dao.LineApplyDao;
import com.tmtc.frame.PageResult;
import com.tmtc.po.LineApply;
import com.tmtc.po.LineApplyRepository;
import com.tmtc.service.appAPI.LineApplyAppService;
import com.tmtc.utils.DateUtil;
import com.tmtc.utils.IdWorker;
@Service
public class LineApplyAppServiceImpl implements LineApplyAppService{
	
	@Autowired
	LineApplyDao lineApplyDao; 
	
	@Override
	public int count(LineApplyRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(LineApplyRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(LineApply record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<LineApply> select(LineApplyRepository example) {
		List<LineApply> lineList = lineApplyDao.selectByExample(example);
		return lineList;
	}

	@Override
	public LineApply selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(LineApply record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(LineApply record, LineApplyRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageResult selectByPage(LineApplyRepository example) {
		return null;
	}

	@Override
	public int insert(String user_id, Integer city_id, String start_station, String end_station, String depart_time,
			Integer depart_rate) {
		Date departtime = DateUtil.stringToTime(depart_time);
		if(null == departtime){
			return 0;
		}
		LineApply lineApply = new LineApply(IdWorker.nextId(), user_id, city_id, start_station, end_station, departtime, depart_rate, new Date(), null, ParameterConstant.IS_CHECK);
		return lineApplyDao.insert(lineApply);
	}
}
