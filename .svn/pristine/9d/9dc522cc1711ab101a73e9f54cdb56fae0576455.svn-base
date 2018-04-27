package com.tmtc.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.constant.SystemVar;
import com.tmtc.dao.DictionaryDao;
import com.tmtc.dao.DriverDao;
import com.tmtc.frame.PageResult;
import com.tmtc.frame.ServiceException;
import com.tmtc.po.Dictionary;
import com.tmtc.po.DictionaryRepository;
import com.tmtc.po.Driver;
import com.tmtc.po.DriverRepository;
import com.tmtc.service.DriverService;
import com.tmtc.utils.UploadImg;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.utils.secret.MD5;
import com.tmtc.vo.DriverVo;
@Service
public class DriverServiceImpl implements DriverService{

	@Autowired
	DriverDao driverDao;
	@Autowired
	DictionaryDao dictionaryDao;
	
	@Override
	public int count(DriverRepository example) {
		return driverDao.countByExample(example);
	}

	@Override
	public int delete(String id) {
		return 0;
	}
	
	@Override
	public int delete(DriverRepository example) {
		return 0;
	}

	@Override
	public int insert(Driver record) {
		return driverDao.insertSelective(record);
	}

	@Override
	public List<Driver> select(DriverRepository example) {
		return driverDao.selectByExample(example);
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
		List<Driver> list = driverDao.selectByExample(example);
		List<DriverVo> listVo = new ArrayList<>();
		for(Driver driver : list){
			String license_type_name = getName(driver.getLicense_type());
			String driver_source_name = getName(driver.getDriver_source());
			String city_name = getName(driver.getCity_id());
			DriverVo driverVo = new DriverVo(driver,license_type_name,driver_source_name,city_name);
			listVo.add(driverVo);
			}
		return new PageResult(driverDao.countByExample(example), listVo, 1);
	}
	
	private String getName(int code){
		String name = null;
		List<Dictionary> listDictionary = dictionaryDao.selectByExample(new DictionaryRepository());
		for(Dictionary dictionary : listDictionary){
			if(dictionary.getCode().equals(code)){
				name = dictionary.getName();
			}
		}
		return name;
	}
	
	@Override
	public int insert(Driver record, CommonsMultipartFile[] license_pic,CommonsMultipartFile[] photoFile,CommonsMultipartFile[] bg_picFile, HttpServletRequest request) throws ServiceException {
		String license_picUrl = UploadImg.upload(license_pic, SystemVar.LOCAL_IMG_URL+SystemVar.LICENSE_PIC);
		String photoFileUrl = UploadImg.upload(photoFile, SystemVar.LOCAL_IMG_URL+SystemVar.PHOTO);
		String bg_picFileUrl = UploadImg.upload(bg_picFile, SystemVar.LOCAL_IMG_URL+SystemVar.BG_PIC);
		if(StringUtils.isNotEmpty(license_picUrl)){
			record.setLicense_pic(license_picUrl);
		}
		if(StringUtils.isNotEmpty(photoFileUrl)){
			record.setPhoto(photoFileUrl);
		}
		if(StringUtils.isNotEmpty(bg_picFileUrl)){
			record.setBg_pic(bg_picFileUrl);
		}
		return driverDao.insertSelective(record);
	}

	@Override
	public int update(Driver record, CommonsMultipartFile[] license_pic,CommonsMultipartFile[] photoFile,CommonsMultipartFile[] bg_picFile, HttpServletRequest request) throws ServiceException{
		String license_picUrl = UploadImg.upload(license_pic, SystemVar.LOCAL_IMG_URL+SystemVar.LICENSE_PIC);
		String photoFileUrl = UploadImg.upload(photoFile, SystemVar.LOCAL_IMG_URL+SystemVar.PHOTO);
		String bg_picFileUrl = UploadImg.upload(bg_picFile, SystemVar.LOCAL_IMG_URL+SystemVar.BG_PIC);
		if(StringUtils.isNotEmpty(license_picUrl)){
			record.setLicense_pic(license_picUrl);
		}
		if(StringUtils.isNotEmpty(photoFileUrl)){
			record.setPhoto(photoFileUrl);
		}
		if(StringUtils.isNotEmpty(bg_picFileUrl)){
			record.setBg_pic(bg_picFileUrl);
		}
		return driverDao.updateByPrimaryKeySelective(record);
	}
	/**
	 * 重置密码
	 */
	@Override
	public int updatePassWord(Driver driver) {
		String password = null;
		String phone = driver.getMobile();
		if(0 == VerificationUtil.length(driver.getMobile())){
			return 0;
		}
		password=phone.substring(phone.length()-6,phone.length());
		String MD5password = MD5.makeMd5(password);
		driver.setPassword(MD5password);
		return driverDao.updateByPrimaryKeySelective(driver);
	}

	@Override
	public Map<String, List<String>> img(String id) {
		Driver driver = driverDao.selectByPrimaryKey(id);
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		List<String> licensePicList = new ArrayList<String>();
		List<String> photoList = new ArrayList<String>();
		List<String> bgPicList = new ArrayList<String>();
		if(null != driver){
			if(null != driver.getLicense_pic() && !driver.getLicense_pic().isEmpty()){
				String a[] = driver.getLicense_pic().split(",");
				for (int i = 0; i < a.length; i++) {
					licensePicList.add(SystemVar.SERVER_IMG_URL+SystemVar.LICENSE_PIC+a[i]);
				}
			}
			if(null != driver.getPhoto() && !driver.getPhoto().isEmpty()){
				String b[] = driver.getPhoto().split(",");
				for (int i = 0; i < b.length; i++) {
					photoList.add(SystemVar.SERVER_IMG_URL+SystemVar.PHOTO+b[i]);
				}
			}
			if(null != driver.getBg_pic() && !driver.getBg_pic().isEmpty()){
				String c[] = driver.getBg_pic().split(",");
				for (int i = 0; i < c.length; i++) {
					bgPicList.add(SystemVar.SERVER_IMG_URL+SystemVar.BG_PIC+c[i]);
				}
			}
			map.put("licensePic", licensePicList);
			map.put("photo", photoList);
			map.put("bgPic", bgPicList);
		}
		return map;
	}
	
	@Override
	public int updateRecover(String id) {
		Driver driver = driverDao.selectByPrimaryKey(id);
		driver.setIs_check(ParameterConstant.IS_CHECK);
		return driverDao.updateByPrimaryKeySelective(driver);
	}

	@Override
	public int deleteForEver(String id) {
		return driverDao.deleteByPrimaryKey(id);
	}

	@Override
	public List<DriverVo> selectDetail(DriverRepository example) {
		List<Driver> list = driverDao.selectByExample(example);
		List<DriverVo> listVo = new ArrayList<>();
		for(Driver driver : list){
			String license_type_name = getName(driver.getLicense_type());
			String driver_source_name = getName(driver.getDriver_source());
			String city_name = getName(driver.getCity_id());
			DriverVo driverVo = new DriverVo(driver,license_type_name,driver_source_name,city_name);
			listVo.add(driverVo);
			}
		return listVo;
	}
}
