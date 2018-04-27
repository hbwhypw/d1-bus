package com.tmtc.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tmtc.constant.ParameterConstant;
import com.tmtc.dao.CarDao;
import com.tmtc.dao.DictionaryDao;
import com.tmtc.dao.DriverDao;
import com.tmtc.dao.LineDao;
import com.tmtc.dao.LineStationDao;
import com.tmtc.dao.LineTimeDao;
import com.tmtc.frame.BasePage;
import com.tmtc.frame.JsonResult;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Car;
import com.tmtc.po.CarRepository;
import com.tmtc.po.Driver;
import com.tmtc.po.DriverRepository;
import com.tmtc.po.Line;
import com.tmtc.po.LineRepository;
import com.tmtc.po.LineStation;
import com.tmtc.po.LineStationRepository;
import com.tmtc.po.LineTime;
import com.tmtc.po.LineTimeRepository;
import com.tmtc.po.LineTimeRepository.Criteria;
import com.tmtc.service.LineTimeService;
import com.tmtc.utils.ConvertUtil;
import com.tmtc.utils.DateUtil;
import com.tmtc.utils.IdWorker;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.vo.LineTimeVo;

@Service
public class LineTimeServiceImpl extends BasePage implements LineTimeService {

	@Autowired
	LineTimeDao lineTimeDao;

	@Autowired
	DriverDao driverDao;

	@Autowired
	CarDao carDao;

	@Autowired
	LineDao lineDao;

	@Autowired
	DictionaryDao dictionaryDao;

	@Autowired
	LineStationDao lineStationDao;

	@Override
	public int count(LineTimeRepository example) {
		return lineTimeDao.countByExample(example);
	}

	@Override
	public int delete(String id) {

		String[] split = id.split(",");
		for (String s : split)
			lineTimeDao.deleteByPrimaryKey(s);
		return 1;
	}

	@Override
	public int delete(LineTimeRepository example) {
		return 0;
	}

	@Override
	public int insert(LineTime record) {
		return lineTimeDao.insert(record);
	}

	@Override
	public List<LineTime> select(LineTimeRepository example) {
		return lineTimeDao.selectByExample(example);
	}

	@Override
	public LineTime selectByPrimaryKey(String id) {
		return lineTimeDao.selectByPrimaryKey(id);
	}

	@Override
	public int update(LineTime record) {
		return lineTimeDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(LineTime record, LineTimeRepository example) {
		return 0;
	}

	@Override
	public PageResult selectByPage(LineTimeRepository example) {
		return null;
	}

	@Override
	public void insertLineTime(LineTime lineTime, String yearMonth, String[] sendDate, String sendTime,
			String doneTime) {

		String str1 = "-";
		String str2 = " ";
		lineTime.setIs_check(ParameterConstant.IS_CHECK);
		lineTime.setCreate_time(new Date());
		lineTime.setDriving_state(ParameterConstant.NOT_DRIVING);

		if (null != sendDate && 0 != sendDate.length) {

			for (String s : sendDate) {
				StringBuffer sb = new StringBuffer();
				sb.append(yearMonth);
				sb.append(str1);
				sb.append(s);
				sb.append(str2);
				sb.append(sendTime);
				Date depart_time = DateUtil.stringToDateTime(sb.toString());

				StringBuffer sb1 = new StringBuffer();
				sb1.append(yearMonth);
				sb1.append(str1);
				sb1.append(s);
				sb1.append(str2);
				sb1.append(doneTime);
				Date arrival_time = DateUtil.stringToDateTime(sb1.toString());

				lineTime.setId(IdWorker.nextId());
				lineTime.setDepart_time(depart_time);
				lineTime.setArrival_time(arrival_time);

				this.insert(lineTime);
			}
		}
	}

	@Override
	public JsonResult selectDriverAndCar(String line_id) {

		LineTimeRepository lineTimeRepository = new LineTimeRepository();
		Criteria criteria = lineTimeRepository.createCriteria();
		criteria.andLine_idEqualTo(line_id);
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		Date date = new Date();
		// 把日期往后增加一天.整数往后推,负数往前移动
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -30);
		Date date1 = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		criteria.andDepart_timeBetween(date1, date);

		List<LineTime> lineTimeList = lineTimeDao.selectByExample(lineTimeRepository);
		if (0 != VerificationUtil.size(lineTimeList)) {

			String driverId = "";
			int i = 0;
			for (LineTime lt : lineTimeList) {
				if (!driverId.equals(lt.getDriver_id())) {
					driverId = lt.getDriver_id();
					i++;
				}
			}

			if (1 == i) {
				LineTime lineTime = lineTimeList.get(0);
				Driver driver = driverDao.selectByPrimaryKey(lineTime.getDriver_id());
				Car car = carDao.selectByPrimaryKey(ConvertUtil.stringToLong(lineTime.getCar_id()));
				
				Date time = lineTime.getDepart_time();
				Date time2 = lineTime.getArrival_time();
				
				String dateString = DateUtil.getDateString(time).substring(11,16);
				String dateString2 = DateUtil.getDateString(time2).substring(11,16);
				
				Map<String, Object> map = new HashMap<>();
				map.put("driver_id", driver.getId());
				map.put("driver_name", driver.getReal_name());
				map.put("car_id", car.getId());
				map.put("car_num", car.getCar_num());
				map.put("sendTime", dateString);
				map.put("doneTime", dateString2);
				return new JsonResult(0, "", map);
			}
		}
		return new JsonResult(0, "", "");
	}

	@Override
	public PageResult query(String line_name, Integer page, Integer rows,String driver_name,String car_num,String start,String end,Integer driving_state,String company_id) throws ParseException {

		List<String> stringList = new ArrayList<String>();

		if (0 != VerificationUtil.length(line_name)) {
			LineRepository lineRepository = new LineRepository();
			com.tmtc.po.LineRepository.Criteria criteria3 = lineRepository.createCriteria();
			criteria3.andLine_nameLike("%" + line_name + "%");
			criteria3.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
			List<Line> list = lineDao.selectByExample(lineRepository);
			for (Line l : list) {
				stringList.add(l.getId());
			}
		}
		
		List<String> driverList = new ArrayList<String>();
		if(0 != VerificationUtil.length(driver_name)){
			DriverRepository driverRepository = new DriverRepository();
			DriverRepository.Criteria criteria1 = driverRepository.createCriteria();
			criteria1.andReal_nameLike("%"+driver_name+"%");
			criteria1.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
			List<Driver> list = driverDao.selectByExample(driverRepository);
			for (Driver d : list) {
				driverList.add(d.getId());
			}
		}
		
		List<String> carList = new ArrayList<String>();
		if(0 != VerificationUtil.length(car_num)){
			CarRepository carRepository = new CarRepository();
			CarRepository.Criteria criteria2 = carRepository.createCriteria();
			criteria2.andCar_numLike("%"+car_num+"%");
			criteria2.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
			List<Car> list = carDao.selectByExample(carRepository);
			for (Car c : list){
				carList.add(c.getId());
			}
		}
		
		List<String> lineList = new ArrayList<String>();
		if(0 != VerificationUtil.length(company_id)){
			LineRepository lineRepository = new LineRepository();
			LineRepository.Criteria criteria4 = lineRepository.createCriteria();
			criteria4.andCompany_idEqualTo(company_id);
			criteria4.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
			List<Line> list = lineDao.selectByExample(lineRepository);
			for (Line l : list){
				lineList.add(l.getId());
			}
		}
		
		LineTimeRepository lineTimeRepository = new LineTimeRepository();
		Criteria criteria = lineTimeRepository.createCriteria();
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		if (0 != stringList.size()) {
			criteria.andLine_idIn(stringList);
		}
		if (0 != VerificationUtil.size(driverList)){
			criteria.andDriver_idIn(driverList);
		}
		if (0 != VerificationUtil.size(carList)){
			criteria.andCar_idIn(carList);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (0 != VerificationUtil.length(start)){
			Date start_time = sdf.parse(start);
			criteria.andDepart_timeGreaterThan(start_time);
		}
		if (0 != VerificationUtil.length(end)) {
			Date end_time = sdf.parse(end);
			criteria.andDepart_timeLessThan(end_time);
		} 
		if (0 != VerificationUtil.integerIsNull(driving_state)){
			criteria.andDriving_stateEqualTo(driving_state);
		}
		if (0 != VerificationUtil.size(lineList)){
			criteria.andLine_idIn(lineList);
		}
		lineTimeRepository.setOrderByClause("create_time desc");

		this.setPageParams(lineTimeRepository, page, rows);
		List<LineTime> list = lineTimeDao.selectByExample(lineTimeRepository);
		List<LineTimeVo> lineTimeVo = new ArrayList<LineTimeVo>();
		for (LineTime lt : list) {

			String ln = lineDao.selectByPrimaryKey(lt.getLine_id()).getLine_name();
			String rn = driverDao.selectByPrimaryKey(lt.getDriver_id()).getReal_name();
			String cn = carDao.selectByPrimaryKey(ConvertUtil.stringToLong(lt.getCar_id())).getCar_num();
			String driving_state_name = dictionaryDao.selectNameByCode(lt.getDriving_state());

			String station_name = null;

			if (null != lt.getLine_station_sort()) {
				LineStationRepository lineStationRepository = new LineStationRepository();
				com.tmtc.po.LineStationRepository.Criteria criteria2 = lineStationRepository.createCriteria();
				criteria2.andLine_idEqualTo(lt.getLine_id());
				criteria2.andSortEqualTo(lt.getLine_station_sort());
				criteria2.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
				List<LineStation> lineStationList = lineStationDao.selectByExample(lineStationRepository);
				if(0 != VerificationUtil.size(lineStationList)){
					station_name = lineStationList.get(0).getStation_name();
				}
			}
			lineTimeVo.add(new LineTimeVo(lt, ln, rn, cn, driving_state_name, station_name));
		}

		return new PageResult(count(lineTimeRepository), lineTimeVo, 1);
	}

	@Override
	public LineTime detail(String car_id, String lineId,String driver_id) {
		LineTime lineTime = new LineTime(IdWorker.nextId(), lineId, driver_id, car_id, new Date(), null, null, ParameterConstant.CAR_STATUS_NO, 0, null, new Date(), ParameterConstant.IS_CHECK);
		return lineTime;
	}
}
