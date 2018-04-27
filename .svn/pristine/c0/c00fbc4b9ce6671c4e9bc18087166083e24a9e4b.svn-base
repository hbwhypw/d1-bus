package com.tmtc.serviceImpl;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.dao.LineDao;
import com.tmtc.dao.LineStationDao;
import com.tmtc.dao.LineTimeDao;
import com.tmtc.frame.BasePage;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Line;
import com.tmtc.po.LineRepository;
import com.tmtc.po.LineStation;
import com.tmtc.po.LineStationRepository;
import com.tmtc.po.LineStationRepository.Criteria;
import com.tmtc.po.LineTime;
import com.tmtc.po.LineTimeRepository;
import com.tmtc.service.LineStationService;
import com.tmtc.utils.DateUtil;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.utils.XYCalculate;
import com.tmtc.vo.LineStationVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LineStationServiceImpl extends BasePage implements LineStationService {

	private String origin = "起点";

	private String terminal = "终点";

	@Autowired
	LineStationDao lineStationDao;

	@Autowired
	LineDao lineDao;

	@Autowired
	LineTimeDao lineTimeDao;

	@Override
	public int count(LineStationRepository example) {
		return lineStationDao.countByExample(example);
	}

	@Override
	public int delete(String id) {
		LineStation lineStation = lineStationDao.selectByPrimaryKey(id);
		LineStation lineStation2 = this.removeStation(lineStation);
		lineStation.setCreate_time(lineStation2.getCreate_time());
		lineStation.setIs_check(ParameterConstant.IS_NOT_CHECK);
		lineStationDao.insertSelective(lineStation);
		return 1;
	}

	@Override
	public int delete(LineStationRepository example) {
		return lineStationDao.deleteByExample(example);
	}

	@Override
	public int insert(LineStation lineStation) {
		this.addLineStation(lineStation);
		return 1;
	}

	@Override
	public List<LineStation> select(LineStationRepository example) {
		return lineStationDao.selectByExample(example);
	}

	@Override
	public LineStation selectByPrimaryKey(String id) {
		return lineStationDao.selectByPrimaryKey(id);
	}

	@Override
	public int update(LineStation lineStation) {
		LineStation lineStation2 = this.removeStation(lineStation);
		lineStation.setCreate_time(lineStation2.getCreate_time());
		lineStation.setIs_check(lineStation2.getIs_check());
		this.insert(lineStation);
		return 1;
	}

	@Override
	public int update(LineStation record, LineStationRepository example) {
		return lineStationDao.updateByExampleSelective(record, example);
	}

	@Override
	public PageResult query(String line_name, String station_name, Integer page, Integer rows) {

		List<String> stringList = new ArrayList<String>();

		if (0 != VerificationUtil.length(line_name)) {
			LineRepository lineRepository = new LineRepository();
			com.tmtc.po.LineRepository.Criteria criteria = lineRepository.createCriteria();
			criteria.andLine_nameLike("%" + line_name + "%");
			criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
			List<Line> list = lineDao.selectByExample(lineRepository);
			for (Line l : list) {
				stringList.add(l.getId());
			}
		}

		LineStationRepository lineStationRepository = new LineStationRepository();
		Criteria criteria = lineStationRepository.createCriteria();
		lineStationRepository.setOrderByClause("create_time desc");
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		if (0 != VerificationUtil.length(station_name)) {
			criteria.andStation_nameLike("%" + station_name + "%");
		}
		if (0 != VerificationUtil.size(stringList)) {
			criteria.andLine_idIn(stringList);
		}
		super.setPageParams(lineStationRepository, page, rows);
		List<LineStation> lineStationlist = select(lineStationRepository);
		List<LineStationVo> lineStationVo = new ArrayList<LineStationVo>();
		for (LineStation ls : lineStationlist) {
			Line line = lineDao.selectByPrimaryKey(ls.getLine_id());

			if (null == line) {
				return null;
			}
			LineStation prevLineStation = lineStationDao.selectByPrimaryKey(ls.getPrev_id());
			String prevName = null;
			if (null == prevLineStation) {
				prevName = origin;
			} else {
				prevName = prevLineStation.getStation_name();
			}
			LineStation nextLineStation = lineStationDao.selectByPrimaryKey(ls.getNext_id());
			String nextName = null;
			if (null == nextLineStation) {
				nextName = terminal;
			} else {
				nextName = nextLineStation.getStation_name();
			}
			LineStationVo lineStationVo2 = new LineStationVo(ls, line.getLine_name(), prevName, nextName);
			lineStationVo2.setLine_path(line.getLine_path());
			lineStationVo.add(lineStationVo2);
		}
		return new PageResult(count(lineStationRepository), lineStationVo, 1);
	}

	@Override
	public PageResult selectByPage(LineStationRepository example) {
		return null;
	}

	@Override
	public List<Line> search(Double xStart, Double yStart, Double xEnd, Double yEnd, Integer page, Integer rows,
			String date) {
		Date startTime = DateUtil.stringToDate(date);
		Date endTime = DateUtil.getTomorrow(DateUtil.stringToDate(date));

		double[] start = null;
		double[] end = null;
		try {
			start = XYCalculate.xyCalculate(xStart, yStart);
			end = XYCalculate.xyCalculate(xEnd, yEnd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Line> lineList = lineStationDao.search(start[0], start[1], end[0], end[1], start[2], start[3], end[2],
				end[3]);
		for (Line line : lineList) {
			LineStation startLineStation = lineStationDao.selectByPrimaryKey(line.getStart_id());
			LineStation endLineStation = lineStationDao.selectByPrimaryKey(line.getEnd_id());

			LineTimeRepository lineTimeRepository = new LineTimeRepository();
			LineTimeRepository.Criteria criteria = lineTimeRepository.createCriteria();
			criteria.andLine_idEqualTo(line.getId());
			criteria.andDepart_timeBetween(startTime, endTime);
			criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
			List<LineTime> lineTimeList = lineTimeDao.selectByExample(lineTimeRepository);

			LineStationRepository lineStationRepository = new LineStationRepository();
			LineStationRepository.Criteria criteria2 = lineStationRepository.createCriteria();
			criteria2.andLine_idEqualTo(line.getId());
			List<LineStation> lineStationList = lineStationDao.selectByExample(lineStationRepository);

			line.setLineStationList(lineStationList);
			line.setLineTimeList(lineTimeList);
			line.setStartLineStation(startLineStation);
			line.setEndLineStation(endLineStation);
		}
		return lineList;
	}

	/**
	 * 移除站点
	 * 
	 * @param lineStation
	 * @return
	 */
	private LineStation removeStation(LineStation lineStation) {
		if (lineStation.getId().equals(lineStation.getPrev_id())) {
			return null;
		}
		// 原来的站点
		LineStation lineStation2 = lineStationDao.selectByPrimaryKey(lineStation.getId());
		// 上一站的站点
		LineStation lineStation3 = null;
		// 下一站的站点
		LineStation lineStation4 = null;
		String prev_id = lineStation2.getPrev_id();
		String next_id = lineStation2.getNext_id();
		if (0 != VerificationUtil.length(prev_id)) {
			lineStation3 = lineStationDao.selectByPrimaryKey(prev_id);
		}
		if (0 != VerificationUtil.length(next_id)) {
			lineStation4 = lineStationDao.selectByPrimaryKey(next_id);
		}
		if (null != lineStation3) {
			if (null != lineStation4) {
				lineStation3.setNext_id(lineStation4.getId());
			} else {
				lineStation3.setNext_id(null);
				// 添加线路的起点
				Line line = new Line();
				line.setId(lineStation2.getLine_id());
				line.setEnd_id(lineStation3.getId());
				lineDao.updateByPrimaryKeySelective(line);
			}
			lineStationDao.updateByPrimaryKey(lineStation3);
		}
		if (null != lineStation4) {
			if (null != lineStation3) {
				lineStation4.setPrev_id(lineStation3.getId());
			} else {
				lineStation4.setPrev_id(null);
				// 添加线路的起点
				Line line = new Line();
				line.setId(lineStation2.getLine_id());
				line.setStart_id(lineStation4.getId());
				lineDao.updateByPrimaryKeySelective(line);
			}
			lineStationDao.updateByPrimaryKey(lineStation4);
		}
		lineStationDao.updateBySortReduction(lineStation2.getLine_id(), lineStation2.getSort());
		lineStationDao.deleteByPrimaryKey(lineStation2.getId());
		return lineStation2;
	}

	/**
	 * 添加站点
	 * 
	 * @param lineStation
	 * @return
	 */
	private LineStation addLineStation(LineStation lineStation) {
		String prev_id = lineStation.getPrev_id();

		// 如果没有上一站，可以认为是起点
		if (0 == VerificationUtil.length(prev_id)) {

			// 添加线路的起点
			Line line = new Line();
			line.setId(lineStation.getLine_id());
			line.setStart_id(lineStation.getId());
			lineDao.updateByPrimaryKeySelective(line);

			// 设置默认排序0
			lineStation.setSort(ParameterConstant.SORT_DEFALUT);
			lineStation.setPrev_id(null);

			// 查询起点
			LineStationRepository lineStationRepository = new LineStationRepository();
			Criteria criteria = lineStationRepository.createCriteria();
			criteria.andSortEqualTo(lineStation.getSort());
			criteria.andLine_idEqualTo(lineStation.getLine_id());
			List<LineStation> lineStationlist = lineStationDao.selectByExample(lineStationRepository);

			// 如果之前有起点
			if (0 != VerificationUtil.size(lineStationlist)) {

				// 获取原来的起点
				LineStation lineStation2 = lineStationlist.get(0);

				lineStation.setNext_id(lineStation2.getId());
				lineStation2.setPrev_id(lineStation.getId());
				lineStation2.setSort(lineStation.getSort() + 1);
				lineStationDao.updateBySort(lineStation.getLine_id(), ParameterConstant.SORT_DEFALUT);
				lineStationDao.updateByPrimaryKeySelective(lineStation2);

			}
			lineStationDao.insertSelective(lineStation);
			// 修改线路的终点
			lineDao.updateLineEndId(lineStation.getLine_id());
			return lineStation;
		}

		LineStation lineStation2 = lineStationDao.selectByPrimaryKey(prev_id);
		if (0 != VerificationUtil.length(lineStation2.getNext_id())) {
			LineStation lineStation3 = lineStationDao.selectByPrimaryKey(lineStation2.getNext_id());
			lineStation3.setPrev_id(lineStation.getId());
			lineStation.setNext_id(lineStation3.getId());
			lineStationDao.updateByPrimaryKeySelective(lineStation3);
		}

		lineStation2.setNext_id(lineStation.getId());
		lineStationDao.updateByPrimaryKeySelective(lineStation2);
		lineStation.setSort(lineStation2.getSort() + 1);
		lineStationDao.updateBySort(lineStation.getLine_id(), lineStation2.getSort());

		// 插入站点
		lineStationDao.insert(lineStation);
		
		LineStationRepository lineStationRepository = new LineStationRepository();
		Criteria criteria = lineStationRepository.createCriteria();
		criteria.andLine_idEqualTo(lineStation.getLine_id());
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		lineStationRepository.setOrderByClause("sort desc");
		List<LineStation> list = lineStationDao.selectByExample(lineStationRepository);
		String line_id = null;
		if(0 < VerificationUtil.size(list)){
			line_id = list.get(0).getLine_id();
		} else {
			line_id = lineStation.getLine_id();
		}
		// 修改线路的终点
		lineDao.updateLineEndId(line_id);
		return lineStation;
	}

	@Override
	public int deleteForEver(String id) {
		return lineStationDao.deleteByPrimaryKey(id);
	}

	@Override
	public LineStation location(Double x_min, Double x_max, Double y_min, Double y_max,String line_id) {
		
		List<LineStation> list = lineStationDao.location(x_min, x_max, y_min, y_max,line_id);
		LineStation lineStation = null;
		if(0 != VerificationUtil.size(list)){
			lineStation = list.get(0);
		}
		return lineStation;
	}
}
