package com.tmtc.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.constant.SystemVar;
import com.tmtc.dao.CompanyDao;
import com.tmtc.dao.DictionaryDao;
import com.tmtc.dao.ProductDao;
import com.tmtc.dao.ProductTypeDao;
import com.tmtc.frame.PageResult;
import com.tmtc.frame.ServiceException;
import com.tmtc.po.Company;
import com.tmtc.po.Dictionary;
import com.tmtc.po.DictionaryRepository;
import com.tmtc.po.Product;
import com.tmtc.po.ProductRepository;
import com.tmtc.po.ProductType;
import com.tmtc.service.ProductService;
import com.tmtc.utils.UploadImg;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.vo.ProductVo;
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	@Autowired
	DictionaryDao dictionaryDao;
	@Autowired
	CompanyDao companyDao;
	@Autowired
	ProductTypeDao productTypeDao;
	
	@Override
	public int count(ProductRepository example) {
		return productDao.countByExample(example);
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public int delete(ProductRepository example) {
		return 0;
	}

	@Override
	public int insert(Product record) {
		return productDao.insertSelective(record);
	}

	@Override
	public List<Product> select(ProductRepository example) {
		List<Product> listProduct = productDao.selectByExample(example);
		List<Product> list = new ArrayList<Product>();
		for(Product product:listProduct){
			if(null != product.getPro_picture() && !product.getPro_picture().isEmpty()){
				product.setPro_picture(SystemVar.SERVER_IMG_URL+SystemVar.PRO_PICTURE+product.getPro_picture());
				list.add(product);
			}
		}
		return list;
	}

	@Override
	public Product selectByPrimaryKey(String id) {
		return null;
	}

	@Override
	public int update(Product record) {
		return productDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Product record, ProductRepository example) {
		return 0;
	}

	@Override
	public PageResult selectByPage(ProductRepository example) {
		List<Product> list = productDao.selectByExampleWithBLOBs(example);
		List<ProductVo> listVo = new ArrayList<>();
		for(Product product : list){
			String pro_type_name = getProductTypeName(product.getPro_type());
			String sell_type_name = getName(product.getSell_type());
			String city_name = getName(product.getCity_id());
			String company_name = getCompanyName(product.getCompany_id());
			ProductVo productVo = new ProductVo(product,pro_type_name,sell_type_name,city_name,company_name);
			listVo.add(productVo);
			}
		return new PageResult(productDao.countByExample(example), listVo, 1);
	}
	
	private String getName(int code){
		String name = null;
		DictionaryRepository dictionaryRepository = new DictionaryRepository();
		DictionaryRepository.Criteria criteria = dictionaryRepository.createCriteria();
		criteria.andCodeEqualTo(code);
		List<Dictionary> listDictionary = dictionaryDao.selectByExample(dictionaryRepository);
		if(0 != VerificationUtil.size(listDictionary)){
			name = listDictionary.get(0).getName();
		}
		return name;
	}
	
	private String getCompanyName(String company_id){
		String company_name = null;
		Company company = companyDao.selectByPrimaryKey(company_id);
		if(null != company){
			company_name = company.getName();
		}
		return company_name;
	}

	private String getProductTypeName(String productTypeId){
		Long id = Long.valueOf(productTypeId);
		String pro_type_name = null;
		ProductType product = productTypeDao.selectByPrimaryKey(id);
		if(null != product){
			pro_type_name = product.getName();
		}
		return pro_type_name;
	}
	
	@Override
	public int insert(Product record, MultipartFile[] pro_pictureFile, HttpServletRequest request) throws ServiceException {
		String pro_pictureUrl = UploadImg.upload(pro_pictureFile, SystemVar.LOCAL_IMG_URL+SystemVar.PRO_PICTURE);
		if(StringUtils.isNotEmpty(pro_pictureUrl)){
			record.setPro_picture(pro_pictureUrl);
		}
		return productDao.insert(record);
	}

	@Override
	public int update(Product record, MultipartFile[] pro_pictureFile, HttpServletRequest request) throws ServiceException {
		String pro_pictureUrl = UploadImg.upload(pro_pictureFile, SystemVar.LOCAL_IMG_URL+SystemVar.PRO_PICTURE);
		if(StringUtils.isNotEmpty(pro_pictureUrl)){
			record.setPro_picture(pro_pictureUrl);
		}
		return productDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<String> img(String id) {
		Product product = productDao.selectByPrimaryKey(id);
		List<String> list = new ArrayList<String>();
		if(null != product){
			if(null != product.getPro_picture() && !product.getPro_picture().isEmpty()){
				String a[] = product.getPro_picture().split(",");
				for (int i = 0; i < a.length; i++) {
					list.add(SystemVar.SERVER_IMG_URL+SystemVar.PRO_PICTURE+a[i]);
				}
			}
		}
		return list;
	}
	
	@Override
	public int updateRecover(String id) {
		Product product = productDao.selectByPrimaryKey(id);
		product.setIs_check(ParameterConstant.IS_CHECK);
		return productDao.updateByPrimaryKeySelective(product);
	}

	@Override
	public int deleteForEver(String id) {
		return productDao.deleteByPrimaryKey(id);
	}

	@Override
	public List<ProductVo> selectDetail(ProductRepository example) {
		List<Product> list = productDao.selectByExampleWithBLOBs(example);
		List<ProductVo> listVo = new ArrayList<>();
		for(Product product : list){
			String pro_type_name = getProductTypeName(product.getPro_type());
			String sell_type_name = getName(product.getSell_type());
			String city_name = getName(product.getCity_id());
			String company_name = getCompanyName(product.getCompany_id());
			ProductVo productVo = new ProductVo(product,pro_type_name,sell_type_name,city_name,company_name);
			listVo.add(productVo);
			}
		return listVo;
	}

	@Override
	public int updateAudit(String id) {
		Product product = productDao.selectByPrimaryKey(id);
		product.setIs_check(ParameterConstant.IS_CHECK);
		return productDao.updateByPrimaryKeySelective(product);
	}
}
