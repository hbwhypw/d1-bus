package com.tmtc.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.tmtc.frame.ServiceException;
import com.tmtc.po.Driver;
import com.tmtc.po.DriverRepository;
import com.tmtc.vo.DriverVo;

public interface DriverService extends IService<Driver, DriverRepository>,PageService<DriverRepository>{
	int insert(Driver record,CommonsMultipartFile[] license_picFile,CommonsMultipartFile[] photoFile,CommonsMultipartFile[] bg_picFile,HttpServletRequest request)throws ServiceException;
	int update(Driver record,CommonsMultipartFile[] license_picFile,CommonsMultipartFile[] photoFile,CommonsMultipartFile[] bg_picFile,HttpServletRequest request)throws ServiceException;
	int updatePassWord(Driver driver);
	Map<String, List<String>> img(String id);
	int updateRecover(String id);
	int deleteForEver(String id);
	List<DriverVo> selectDetail(DriverRepository example);
}
