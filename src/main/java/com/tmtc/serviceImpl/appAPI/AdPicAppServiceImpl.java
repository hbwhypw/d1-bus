package com.tmtc.serviceImpl.appAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.constant.SystemVar;
import com.tmtc.dao.AdPicDao;
import com.tmtc.frame.PageResult;
import com.tmtc.po.AdPic;
import com.tmtc.po.AdPicRepository;
import com.tmtc.service.appAPI.AdPicAppService;
@Service
public class AdPicAppServiceImpl implements AdPicAppService{

	@Autowired
	AdPicDao adPicDao;
	
	@Override
	public int count(AdPicRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(AdPicRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(AdPic record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AdPic> select(AdPicRepository example) {
		List<AdPic> list = adPicDao.selectByExample(example);
		return list;
	}

	@Override
	public AdPic selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(AdPic record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(AdPic record, AdPicRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageResult selectByPage(AdPicRepository example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdPic> selectProductBanner() {
		AdPicRepository adPicRepository = new AdPicRepository();
		AdPicRepository.Criteria criteria = adPicRepository.createCriteria();
		criteria.andTypeEqualTo(ParameterConstant.ADPIC_TYPE_MAIN_BANNER);
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		List<AdPic> list= adPicDao.selectByExample(adPicRepository);
		for(AdPic adPic:list){
			adPic.setPic(SystemVar.SERVER_IMG_URL+SystemVar.PIC+adPic.getPic());
		}
		return list;
	}

	@Override
	public List<AdPic> selectProductAdPica(Integer page, Integer rows) {
		AdPicRepository adPicRepository = new AdPicRepository();
		AdPicRepository.Criteria criteria = adPicRepository.createCriteria();
		adPicRepository.setPageSize(rows);
		adPicRepository.setRowIndex((page-1)*rows);
		adPicRepository.setOrderByClause("sort");
		criteria.andTypeEqualTo(ParameterConstant.ADPIC_TYPE_LONG);
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		List<AdPic> list = adPicDao.selectByExample(adPicRepository);
		for(AdPic adPic:list){
			adPic.setPic(SystemVar.SERVER_IMG_URL+SystemVar.PIC+adPic.getPic());
		}
		return list;
	}

	@Override
	public List<AdPic> selectProductAdPicb(Integer page, Integer rows) {
		AdPicRepository adPicRepository = new AdPicRepository();
		AdPicRepository.Criteria criteria = adPicRepository.createCriteria();
		adPicRepository.setPageSize(rows);
		adPicRepository.setRowIndex((page-1)*rows);
		adPicRepository.setOrderByClause("sort");
		criteria.andTypeEqualTo(ParameterConstant.ADPIC_TYPE_SQUARE);
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		List<AdPic> list = adPicDao.selectByExample(adPicRepository);
		for(AdPic adPic:list){
			adPic.setPic(SystemVar.SERVER_IMG_URL+SystemVar.PIC+adPic.getPic());
		}
		return list;
	}

}
