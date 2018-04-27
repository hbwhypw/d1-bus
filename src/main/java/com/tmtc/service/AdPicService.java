package com.tmtc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.tmtc.frame.ServiceException;
import com.tmtc.po.AdPic;
import com.tmtc.po.AdPicRepository;

public interface AdPicService extends IService<AdPic, AdPicRepository>,PageService<AdPicRepository>{
	int insert(AdPic record,CommonsMultipartFile[] pic,HttpServletRequest request)throws ServiceException;
	int update(AdPic record,CommonsMultipartFile[] pic,HttpServletRequest request)throws ServiceException;
	List<String> selectPic(String id);
	int updateRecover(String id);
	List<AdPic> selectActivity(AdPicRepository example);
}
