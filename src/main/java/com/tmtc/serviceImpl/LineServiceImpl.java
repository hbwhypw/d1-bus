package com.tmtc.serviceImpl;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.dao.CompanyDao;
import com.tmtc.dao.DictionaryDao;
import com.tmtc.dao.LineDao;
import com.tmtc.dao.LineStationDao;
import com.tmtc.frame.BasePage;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Company;
import com.tmtc.po.CompanyRepository;
import com.tmtc.po.Line;
import com.tmtc.po.LineRepository;
import com.tmtc.po.LineStation;
import com.tmtc.po.LineStationRepository;
import com.tmtc.service.LineService;
import com.tmtc.utils.ConvertUtil;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.vo.LineVo;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class LineServiceImpl extends BasePage implements LineService{
	
	@Autowired
	LineDao lineDao;
	
	@Autowired
	LineStationDao lineStationDao;
	
	@Autowired
	DictionaryDao dictionaryDao;
	
	@Autowired
	CompanyDao companyDao;

	@Override
	public int count(LineRepository example) {
		return lineDao.countByExample(example);
	}

	@Override
	public int delete(String id) {
		Line line = lineDao.selectByPrimaryKey(id);
		line.setIs_check(ParameterConstant.IS_NOT_CHECK);
		return lineDao.updateByPrimaryKeyWithBLOBs(line);
	}

	@Override
	public int delete(LineRepository example) {
		return lineDao.deleteByExample(example);
	}

	@Override
	public int insert(Line record) {
		return lineDao.insertSelective(record);
	}

	@Override
	public List<Line> select(LineRepository example) {
		return lineDao.selectByExample(example);
	}

	@Override
	public Line selectByPrimaryKey(String id) {
		return lineDao.selectByPrimaryKey(id);
	}

	@Override
	public int update(Line record) {
		return lineDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Line record, LineRepository example) {
		return lineDao.updateByExampleSelective(record, example);
	}

	@Override
	public PageResult selectByPage(LineRepository example) {
		
		List<Line> lineList = lineDao.selectByExampleWithBLOBs(example);
		
		List<LineVo> lineVoList = new LinkedList<LineVo>();
		
		for(Line l : lineList) {
			
			LineStationRepository lineStationRepository = new LineStationRepository();
			LineStationRepository.Criteria criteria = lineStationRepository.createCriteria();
			lineStationRepository.setOrderByClause("sort asc");
			String start_name = null;
			String start_end = null;
			
			Long startId = ConvertUtil.stringToLong(l.getStart_id());
			Long endId = ConvertUtil.stringToLong(l.getEnd_id());
			
			if(0 < startId){
				start_name = lineStationDao.selectByPrimaryKey(l.getStart_id()).getStation_name();
			}
			
			if( 0 < endId){
				start_end = lineStationDao.selectByPrimaryKey(l.getEnd_id()).getStation_name();
			}
			criteria.andLine_idEqualTo(l.getId());
			List<LineStation> lineStationList = lineStationDao.selectByExample(lineStationRepository);
			StringBuffer sb = new StringBuffer();
			if(0 < VerificationUtil.size(lineStationList)){
				for(int i = 0; i < lineStationList.size();i++){
					sb.append(lineStationList.get(i).getStation_name());
					sb.append(":");
					sb.append(lineStationList.get(i).getX_point());
					sb.append(",");
					sb.append(lineStationList.get(i).getY_point());
					if(i < lineStationList.size()-1) {
						sb.append("|");
					}
				}
			}
			String city_name = dictionaryDao.selectNameByCode(l.getCity_id());
			Company company = companyDao.selectByPrimaryKey(l.getCompany_id());
			String company_name = company.getName();

			String line_category_name = dictionaryDao.selectNameByCode(l.getLine_category());

			String line_type_name = dictionaryDao.selectNameByCode(l.getLine_type());
			
			String user_type_name = dictionaryDao.selectNameByCode(l.getUser_type());

			lineVoList.add(new LineVo(l, start_name, start_end, sb.toString(),city_name,company_name,line_category_name,line_type_name,user_type_name));
		}
		return new PageResult(count(example), lineVoList, 1);
	}

	@Override
	public int deleteForEver(String id) {
		return lineDao.deleteByPrimaryKey(id);
	}

	@Override
	public PageResult selectByPage(LineRepository lineRepository, Integer page, Integer rows, String line_name,
			String company_name) {

		LineRepository.Criteria criteria = lineRepository.createCriteria();
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
        if (StringUtils.isNotEmpty(line_name)){
            criteria.andLine_nameLike("%"+line_name+"%");
        }
        
        if (StringUtils.isNotEmpty(company_name)) {
			CompanyRepository companyRepository = new CompanyRepository();
			companyRepository.or().andNameLike("%"+company_name+"%");
			List<Company> list = companyDao.selectByExample(companyRepository);
			if (0 != VerificationUtil.size(list)) {
				List<String> stringList = new ArrayList<String>();
				for (Iterator<Company> iterator = list.iterator(); iterator.hasNext();) {
					Company company = (Company) iterator.next();
					stringList.add(company.getId());
				}
				criteria.andCompany_idIn(stringList);
			}
		}
        super.setPageParams(lineRepository, page, rows);
		List<Line> lineList = lineDao.selectByExampleWithBLOBs(lineRepository);
		
		List<LineVo> lineVoList = new LinkedList<LineVo>();
		
		for(Line l : lineList) {
			
			LineStationRepository lineStationRepository = new LineStationRepository();
			LineStationRepository.Criteria criteria1 = lineStationRepository.createCriteria();
			criteria1.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
			lineStationRepository.setOrderByClause("sort asc");
			String start_name = null;
			String start_end = null;
			
			String startId = l.getStart_id();
			String endId = l.getEnd_id();
			
			if(StringUtils.isNotEmpty(startId)){
				start_name = lineStationDao.selectByPrimaryKey(startId).getStation_name();
			}
			
			if(StringUtils.isNotEmpty(endId)){
				start_end = lineStationDao.selectByPrimaryKey(endId).getStation_name();
			}
			criteria1.andLine_idEqualTo(l.getId());
			List<LineStation> lineStationList = lineStationDao.selectByExample(lineStationRepository);
			StringBuffer sb = new StringBuffer();
			if(0 < VerificationUtil.size(lineStationList)){
				for(int i = 0; i < lineStationList.size();i++){
					sb.append(lineStationList.get(i).getStation_name());
					sb.append(":");
					sb.append(lineStationList.get(i).getX_point());
					sb.append(",");
					sb.append(lineStationList.get(i).getY_point());
					if(i < lineStationList.size()-1) {
						sb.append("|");
					}
				}
			}
			String city_name = dictionaryDao.selectNameByCode(l.getCity_id());
			Company company = companyDao.selectByPrimaryKey(l.getCompany_id());
			String company_name1 = company.getName();
			String line_category_name = dictionaryDao.selectNameByCode(l.getLine_category());
			String line_type_name = dictionaryDao.selectNameByCode(l.getLine_type());
			String user_type_name = dictionaryDao.selectNameByCode(l.getUser_type());

			lineVoList.add(new LineVo(l, start_name, start_end, sb.toString(),city_name,company_name1,line_category_name,line_type_name,user_type_name));
		}
		return new PageResult(count(lineRepository), lineVoList, 1);
	}
}
