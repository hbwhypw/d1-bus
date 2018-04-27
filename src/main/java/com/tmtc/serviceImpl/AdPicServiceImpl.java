package com.tmtc.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.constant.SystemVar;
import com.tmtc.dao.AdPicDao;
import com.tmtc.dao.CompanyDao;
import com.tmtc.dao.DictionaryDao;
import com.tmtc.frame.PageResult;
import com.tmtc.frame.ServiceException;
import com.tmtc.po.AdPic;
import com.tmtc.po.AdPicRepository;
import com.tmtc.po.Company;
import com.tmtc.po.CompanyRepository;
import com.tmtc.po.Dictionary;
import com.tmtc.po.DictionaryRepository;
import com.tmtc.service.AdPicService;
import com.tmtc.utils.UploadImg;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.vo.AdPicVo;

@Service
public class AdPicServiceImpl implements AdPicService {

	@Autowired
	AdPicDao adPicDao;
	
	@Autowired
	CompanyDao companyDao;
	
	@Autowired
	DictionaryDao dictionaryDao;

	@Override
	public int count(AdPicRepository example) {
		return adPicDao.countByExample(example);
	}

	@Override
	public int delete(String id) {
		return adPicDao.deleteByPrimaryKey(id);
	}

	@Override
	public int delete(AdPicRepository example) {
		return 0;
	}

	@Override
	public int insert(AdPic record) {
		return adPicDao.insert(record);
	}

	@Override
	public List<AdPic> select(AdPicRepository example) {
		List<AdPic> listAdPic = adPicDao.selectByExample(example);
		List<AdPic> list = new ArrayList<AdPic>();
		for (AdPic adPic : listAdPic) {
			if (null != adPic.getPic() && !adPic.getPic().isEmpty()) {
				adPic.setPic(SystemVar.SERVER_IMG_URL + SystemVar.PIC + adPic.getPic());
				list.add(adPic);
			}
		}
		return list;
	}
	
	@Override
	public List<AdPic> selectActivity(AdPicRepository example) {
		List<AdPic> listAdPic = adPicDao.selectByExample(example);
		return listAdPic;
	}

	@Override
	public AdPic selectByPrimaryKey(String id) {
		return adPicDao.selectByPrimaryKey(id);
	}

	@Override
	public int update(AdPic record) {
		return adPicDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(AdPic record, AdPicRepository example) {
		return 0;
	}

	@Override
	public PageResult selectByPage(AdPicRepository example) {
		List<AdPic> list = adPicDao.selectByExample(example);
		List<AdPicVo> listVo = new ArrayList<>();
		for (AdPic adPic : list) {
			String company_name = null;
			if (0 != VerificationUtil.length(adPic.getCompany_id())) {
				company_name = getCompanyName(adPic.getCompany_id());
			}
			String city_name = getName(adPic.getCity_id());
			String type_name = getName(adPic.getType());
			AdPicVo adPicVo = new AdPicVo(adPic, city_name, company_name, type_name);
			listVo.add(adPicVo);
		}
		PageResult pageResult = new PageResult(adPicDao.countByExample(example), listVo, 1);
		return pageResult;
	}

	@Override
	public int insert(AdPic record, CommonsMultipartFile[] pic, HttpServletRequest request) throws ServiceException {
		Integer type = record.getType();
		if(ParameterConstant.ADPIC_TYPE_ACTIVITY == type){
			String url = SystemVar.ACTIVE_SERVER_URL + record.getId();
			record.setUrl(url);
		}
		String picUrl = UploadImg.upload(pic, SystemVar.LOCAL_IMG_URL + SystemVar.PIC);
		record.setPic(picUrl);
		return adPicDao.insert(record);
	}

	@Override
	public int update(AdPic record, CommonsMultipartFile[] pic, HttpServletRequest request) throws ServiceException {
		Integer type = record.getType();
		if(ParameterConstant.ADPIC_TYPE_ACTIVITY == type){
			String url = SystemVar.ACTIVE_SERVER_URL + record.getId();
			record.setUrl(url);
		}
		String picUrl = UploadImg.upload(pic, SystemVar.LOCAL_IMG_URL + SystemVar.PIC);
		if (StringUtils.isNotEmpty(picUrl)) {
			record.setPic(picUrl);
		}
		return adPicDao.updateByPrimaryKeySelective(record);
	}

	private String getCompanyName(String company_id) {
		String company_name = null;
		List<Company> listCompany = companyDao.selectByExample(new CompanyRepository());
		for (Company company : listCompany) {
			if (company.getId().equals(company_id)) {
				company_name = company.getName();
			}
		}
		return company_name;
	}

	private String getName(int code) {
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
	public List<String> selectPic(String id) {
		AdPic adPic = adPicDao.selectByPrimaryKey(id);
		List<String> list = new ArrayList<String>();
		if (null != adPic && ParameterConstant.IS_NOT_CHECK != adPic.getIs_check()) {
			if (null != adPic.getPic() && !adPic.getPic().isEmpty()) {
				String a[] = adPic.getPic().split(",");
				for (int i = 0; i < a.length; i++) {
					list.add(SystemVar.SERVER_IMG_URL + SystemVar.PIC + a[i]);
				}
			}
		}
		return list;
	}

	@Override
	public int updateRecover(String id) {
		AdPic adPic = adPicDao.selectByPrimaryKey(id);
		adPic.setIs_check(ParameterConstant.IS_CHECK);
		return adPicDao.updateByPrimaryKeySelective(adPic);
	}

}
