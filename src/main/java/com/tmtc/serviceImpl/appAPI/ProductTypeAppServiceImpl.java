package com.tmtc.serviceImpl.appAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.constant.SystemVar;
import com.tmtc.dao.ProductTypeDao;
import com.tmtc.frame.PageResult;
import com.tmtc.po.ProductType;
import com.tmtc.po.ProductTypeRepository;
import com.tmtc.service.appAPI.ProductTypeAppService;
@Service
public class ProductTypeAppServiceImpl implements ProductTypeAppService{
	
	@Autowired
	ProductTypeDao productTypeDao;
	
	@Override
	public int count(ProductTypeRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
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
		List<ProductType> list = productTypeDao.selectByExample(example);
		for(ProductType productType:list){
			productType.setTyp_pic(SystemVar.SERVER_IMG_URL+SystemVar.PRODUCT_TYPE+productType.getTyp_pic());
		}
		return list;
	}

	@Override
	public ProductType selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(ProductType record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ProductType record, ProductTypeRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageResult selectByPage(ProductTypeRepository example) {
		// TODO Auto-generated method stub
		return null;
	}

}
