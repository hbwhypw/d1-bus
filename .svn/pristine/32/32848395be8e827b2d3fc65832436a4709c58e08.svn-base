package com.tmtc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.tmtc.frame.ServiceException;
import com.tmtc.po.Product;
import com.tmtc.po.ProductRepository;
import com.tmtc.vo.ProductVo;

public interface ProductService extends IService<Product, ProductRepository>,PageService<ProductRepository>{
	int insert(Product record,MultipartFile[] pro_pictureFile,HttpServletRequest request)throws ServiceException;
	int update(Product record,MultipartFile[] pro_pictureFile,HttpServletRequest request)throws ServiceException;
	List<String> img(String id);
	int updateRecover(String id);
	int updateAudit(String id);
	int deleteForEver(String id);
	List<ProductVo> selectDetail(ProductRepository example);
}
