package com.tmtc.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.dao.DictionaryDao;
import com.tmtc.dao.LineStationDao;
import com.tmtc.dao.ScanDao;
import com.tmtc.dao.UserDetailDao;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Dictionary;
import com.tmtc.po.DictionaryRepository;
import com.tmtc.po.LineStation;
import com.tmtc.po.LineStationRepository;
import com.tmtc.po.Scan;
import com.tmtc.po.ScanRepository;
import com.tmtc.po.UserDetail;
import com.tmtc.po.UserDetailRepository;
import com.tmtc.service.ScanService;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.vo.ScanVo;
@Service
public class ScanServiceImpl implements ScanService{

	@Autowired
	ScanDao scanDao;
	@Autowired
	UserDetailDao userDetailDao;
	@Autowired
	LineStationDao lineStationDao;
	@Autowired
	DictionaryDao dictionaryDao;
	
	@Override
	public int count(ScanRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		Scan scan = new Scan();
		scan.setId(id);
		scan.setIs_check(ParameterConstant.IS_NOT_CHECK);
		int a = scanDao.updateByPrimaryKeySelective(scan);
		return a;
	}

	@Override
	public int delete(ScanRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Scan record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Scan> select(ScanRepository example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scan selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Scan record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Scan record, ScanRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageResult selectByPage(ScanRepository example) {
		
		return null;
	}

	@Override
	public PageResult select(Integer page, Integer rows, String userName, String stationName, String start,
			String end) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ScanRepository scanRepository = new ScanRepository();
		ScanRepository.Criteria criteria = scanRepository.createCriteria();
		scanRepository.setPageSize(rows);
		scanRepository.setRowIndex((page-1)*rows);
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		scanRepository.setOrderByClause("create_time desc");
		if(0 != VerificationUtil.length(userName)){
			UserDetailRepository userDetailRepository = new UserDetailRepository();
			UserDetailRepository.Criteria criteria2 = userDetailRepository.createCriteria();
			criteria2.andUsernameLike("%"+userName+"%");
			criteria2.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
			List<UserDetail> userDetailList= userDetailDao.selectByExample(userDetailRepository);
			if(0 != VerificationUtil.size(userDetailList)){
				List<String> listId = new ArrayList<String>();
				for(UserDetail userDetail:userDetailList){
					listId.add(userDetail.getId());
				}
				criteria.andUser_idIn(listId);
			}
		}
		if(0 != VerificationUtil.length(stationName)){
			LineStationRepository lineStationRepository = new LineStationRepository();
			LineStationRepository.Criteria criteria2 = lineStationRepository.createCriteria();
			criteria2.andStation_nameLike("%"+stationName+"%");
			List<LineStation> lineStationList = lineStationDao.selectByExample(lineStationRepository);
			if(0 != VerificationUtil.size(lineStationList)){
				List<String> listId = new ArrayList<String>();
				for(LineStation lineStation:lineStationList){
					listId.add(lineStation.getId());
				}
				criteria.andStation_idIn(listId);
			}
		}
		if(null != start){
			Date start_time = sdf.parse(start);
			criteria.andCreate_timeGreaterThan(start_time);
		}
		if(null != end){
			Date end_time = sdf.parse(end);
			criteria.andCreate_timeLessThan(end_time);
		}
		List<Scan> list = scanDao.selectByExample(scanRepository);
		List<ScanVo> listVo = new ArrayList<ScanVo>();
		if(0 != VerificationUtil.size(list)){
			for(Scan scan:list){
				String userId = scan.getUser_id();
				String stationId = scan.getStation_id();
				Integer status = scan.getStatus();
				
				String userNameVo = null;
				String stationNameVo = null;
				String statusNameVo = null;
				String ischeckNameVo = null;
				
				if(0 != VerificationUtil.length(userId)){
					userNameVo = getUserName(userId);
				}
				if(0 != VerificationUtil.length(stationId)){
					stationNameVo = getStationName(stationId);
				}
				if(0 != VerificationUtil.integerIsNull(status)){
					statusNameVo = getName(status);
				}
				if(ParameterConstant.IS_CHECK == scan.getIs_check()){
					ischeckNameVo = "√";
				}else{
					ischeckNameVo = "X";
				}
				ScanVo scanVo = new ScanVo(scan, userNameVo, stationNameVo, statusNameVo, ischeckNameVo);
				listVo.add(scanVo);
			}
		}
		return new PageResult(scanDao.countByExample(scanRepository), listVo, 1);
	}

	private String getUserName(String userId){
		String userName = null;
		UserDetail userDetail = userDetailDao.selectByPrimaryKey(userId);
		if(null != userDetail){
			userName = userDetail.getUsername();
		}
		return userName;
	}
	
	private String getStationName(String stationId){
		String stationName = null;
		LineStation lineStation = lineStationDao.selectByPrimaryKey(stationId);
		if(null != lineStation){
			stationName = lineStation.getStation_name();
		}
		return stationName;
	}
	
	private String getName(Integer code){
		String name = null;
		DictionaryRepository dictionaryRepository = new DictionaryRepository();
		DictionaryRepository.Criteria criteria = dictionaryRepository.createCriteria();
		criteria.andCodeEqualTo(code);
		List<Dictionary> list = dictionaryDao.selectByExample(dictionaryRepository);
		if(0 != VerificationUtil.size(list)){
			name = list.get(0).getName();
		}
		return name;
	}

	@Override
	public int updateRecover(String id) {
		Scan scan = new Scan();
		scan.setId(id);
		scan.setIs_check(ParameterConstant.IS_CHECK);
		int a = scanDao.updateByPrimaryKeySelective(scan);
		return a;
	}

	@Override
	public List<ScanVo> selectById(ScanRepository scanRepository) {
		List<Scan> list = scanDao.selectByExample(scanRepository);
		List<ScanVo> listVo = new ArrayList<ScanVo>();
		if(0 != VerificationUtil.size(list)){
			for(Scan scan:list){
				String userId = scan.getUser_id();
				String stationId = scan.getStation_id();
				Integer status = scan.getStatus();
				
				String userNameVo = null;
				String stationNameVo = null;
				String statusNameVo = null;
				String ischeckNameVo = null;
				
				if(0 != VerificationUtil.length(userId)){
					userNameVo = getUserName(userId);
				}
				if(0 != VerificationUtil.length(stationId)){
					stationNameVo = getStationName(stationId);
				}
				if(0 != VerificationUtil.integerIsNull(status)){
					statusNameVo = getName(status);
				}
				if(ParameterConstant.IS_CHECK == scan.getIs_check()){
					ischeckNameVo = "√";
				}else{
					ischeckNameVo = "X";
				}
				ScanVo scanVo = new ScanVo(scan, userNameVo, stationNameVo, statusNameVo, ischeckNameVo);
				listVo.add(scanVo);
			}
		}
		return listVo;
	}
}
