package com.tmtc.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.dao.DictionaryDao;
import com.tmtc.dao.LineApplyDao;
import com.tmtc.dao.UserDetailDao;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Dictionary;
import com.tmtc.po.DictionaryRepository;
import com.tmtc.po.LineApply;
import com.tmtc.po.LineApplyRepository;
import com.tmtc.po.UserDetail;
import com.tmtc.service.LineApplyService;
import com.tmtc.utils.DateUtil;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.vo.LineApplyVo;

@Service
public class LineApplyServiceImpl implements LineApplyService {

	@Autowired
	LineApplyDao lineApplyDao;
	@Autowired
	UserDetailDao userDetailDao;
	@Autowired
	DictionaryDao dictionaryDao;

	@Override
	public int count(LineApplyRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		return lineApplyDao.deleteByPrimaryKey(id);
	}

	@Override
	public int delete(LineApplyRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(LineApply record) {

		return 0;
	}

	@Override
	public List<LineApply> select(LineApplyRepository example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LineApply selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(LineApply record) {
		return lineApplyDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(LineApply record, LineApplyRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageResult selectByPage(LineApplyRepository example) {
		List<LineApply> listLineApply = lineApplyDao.selectByExample(example);
		List<LineApplyVo> list = new ArrayList<LineApplyVo>();
		for (LineApply lineApply : listLineApply) {
			String userId = lineApply.getUser_id();
			Integer departrate = lineApply.getDepart_rate();
			Integer cityId = lineApply.getCity_id();
			Date depart_time = lineApply.getDepart_time();
			String realName = null;
			String departRate = null;
			String cityName = null;
			String time = null;
			if (0 != VerificationUtil.length(userId)) {
				realName = getRealName(userId);
			}
			if (0 != VerificationUtil.integerIsNull(departrate)) {
				departRate = getName(departrate);
			}
			if (0 != VerificationUtil.integerIsNull(cityId)) {
				cityName = getName(cityId);
			}
			if (null != depart_time) {
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
				time = sdf.format(depart_time);
			}
			LineApplyVo lineApplyVo = new LineApplyVo(lineApply, realName, departRate, cityName, time);
			list.add(lineApplyVo);
		}
		return new PageResult(lineApplyDao.countByExample(example), list, 1);
	}

	public String getRealName(String userId) {
		UserDetail userDetail = userDetailDao.selectByPrimaryKey(userId);
		String realName = null;
		if (null != userDetail) {
			realName = userDetail.getReal_name();
		}
		return realName;
	}

	public String getName(int code) {
		String name = null;
		List<Dictionary> listDictionary = dictionaryDao.selectByExample(new DictionaryRepository());
		for (Dictionary dictionary : listDictionary) {
			if (dictionary.getCode().equals(code)) {
				name = dictionary.getName();
			}
		}
		return name;
	}

	@Override
	public int update(LineApplyVo record) {
		LineApply lineApply = new LineApply();
		lineApply.setId(record.getId());
		lineApply.setCity_id(record.getCity_id());
		lineApply.setStart_station(record.getStart_station());
		lineApply.setEnd_station(record.getEnd_station());
		lineApply.setDepart_rate(record.getDepart_rate());
		String depart_timeStr = record.getTime();
		Date departtime = DateUtil.stringToTime(depart_timeStr);
		if (null == departtime) {
			return 0;
		} else {
			lineApply.setDepart_time(departtime);
		}
		return lineApplyDao.updateByPrimaryKeySelective(lineApply);
	}
}
