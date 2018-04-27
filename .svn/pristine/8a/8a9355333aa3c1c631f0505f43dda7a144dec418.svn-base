package com.tmtc.serviceImpl.appAPI;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.constant.SystemVar;
import com.tmtc.dao.ProductDao;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Product;
import com.tmtc.po.ProductRepository;
import com.tmtc.service.appAPI.ProductAppService;
import com.tmtc.utils.VerificationUtil;
@Service
public class ProductAppServiceImpl implements ProductAppService{

	@Autowired
	ProductDao productDao;
	
	@Override
	public int count(ProductRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(ProductRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Product record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> select(ProductRepository example) {
		List<Product> listProduct = productDao.selectByExampleWithBLOBs(example);
		List<Product> list = new ArrayList<Product>();
		for(Product product:listProduct){
			if(0 != VerificationUtil.length(product.getPro_picture())){
				String a[] = product.getPro_picture().split(",");
				String str = SystemVar.SERVER_IMG_URL+SystemVar.PRO_PICTURE+a[0];
				product.setPro_picture(str);
			}
			list.add(product);
		}
		return list;
	}

	@Override
	public Product selectByPrimaryKey(String id) {
		Product product = productDao.selectByPrimaryKey(id);
		if(null != product && ParameterConstant.IS_NOT_CHECK != product.getIs_check()){
			if(null != product.getPro_picture() && !product.getPro_picture().isEmpty()){
				String a[] = product.getPro_picture().split(",");
				String url = "";
				for (int i = 1; i < a.length; i++) {
					if(i != a.length-1){
						url += SystemVar.SERVER_IMG_URL+SystemVar.PRO_PICTURE+a[i]+",";
					}else{
						url += SystemVar.SERVER_IMG_URL+SystemVar.PRO_PICTURE+a[i];
					}
				}
				product.setPro_picture(url);
			}
		}
		return product;
	}

	@Override
	public int update(Product record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Product record, ProductRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageResult selectByPage(ProductRepository example) {
		// TODO Auto-generated method stub
		return null;
	}

}
