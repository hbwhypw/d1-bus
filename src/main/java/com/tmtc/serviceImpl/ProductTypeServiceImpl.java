package com.tmtc.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.constant.SystemVar;
import com.tmtc.dao.ProductTypeDao;
import com.tmtc.frame.PageResult;
import com.tmtc.frame.ServiceException;
import com.tmtc.po.ProductType;
import com.tmtc.po.ProductTypeRepository;
import com.tmtc.service.ProductTypeService;
import com.tmtc.utils.IdWorker;
import com.tmtc.utils.UploadImg;
@Service
public class ProductTypeServiceImpl implements ProductTypeService{
	
	@Autowired
	ProductTypeDao productTypeDao;
	
	@Override
	public int count(ProductTypeRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		ProductType productType = new ProductType();
		productType.setId(id);
		productType.setIs_check(ParameterConstant.IS_NOT_CHECK);
		return productTypeDao.updateByPrimaryKeySelective(productType);
	}

	@Override
	public int delete(ProductTypeRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(ProductType record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProductType> select(ProductTypeRepository example) {
		return productTypeDao.selectByExample(example);
	}

	@Override
	public ProductType selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(ProductType record) {
		return productTypeDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(ProductType record, ProductTypeRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageResult selectByPage(ProductTypeRepository example) {
		return new PageResult(productTypeDao.countByExample(example),productTypeDao.selectByExample(example),1);
	}

	@Override
	public int insert(ProductType productType, CommonsMultipartFile typ_picFile) throws ServiceException {
		String id = IdWorker.nextId();
		Date createTime = new Date();
		Integer is_check = ParameterConstant.IS_CHECK;
		productType.setId(id);
		productType.setCreate_time(createTime);
		productType.setIs_check(is_check);
		String typ_pic = null;
		if(null != typ_picFile){
			typ_pic = UploadImg.upload(typ_picFile, SystemVar.LOCAL_IMG_URL + SystemVar.PRODUCT_TYPE);
		}
		productType.setTyp_pic(typ_pic);
		return productTypeDao.insert(productType);
	}

	@Override
	public int update(ProductType productType, CommonsMultipartFile typ_picFile) throws ServiceException{
		String typ_pic = null;
		if(null != typ_picFile){
			typ_pic = UploadImg.upload(typ_picFile, SystemVar.LOCAL_IMG_URL + SystemVar.PRODUCT_TYPE);
		}
		productType.setTyp_pic(typ_pic);
		return productTypeDao.updateByPrimaryKeySelective(productType);
	}

	@Override
	public int deleteForEver(String id) {
		Long Id = Long.valueOf(id);
		return productTypeDao.deleteByPrimaryKey(Id);
	}

	@Override
	public String selectPic(String id) {
		Long Id = Long.valueOf(id);
		ProductType product = productTypeDao.selectByPrimaryKey(Id);
		String type_pid = null;
		if(null != product){
			if(null != product.getTyp_pic() && !product.getTyp_pic().isEmpty()){
				type_pid = SystemVar.SERVER_IMG_URL + SystemVar.PRODUCT_TYPE + product.getTyp_pic();
			}
		}
		return type_pid;
	}

}
