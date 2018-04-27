package com.tmtc.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.tmtc.frame.ServiceException;
import com.tmtc.po.ProductType;
import com.tmtc.po.ProductTypeRepository;

public interface ProductTypeService extends IService<ProductType, ProductTypeRepository>,PageService<ProductTypeRepository>{
	int insert(ProductType productType,CommonsMultipartFile typ_picFile)throws ServiceException;
	int update(ProductType productType,CommonsMultipartFile typ_picFile)throws ServiceException;
	int deleteForEver(String id);
	String selectPic(String id);
}
