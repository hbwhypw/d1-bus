package com.tmtc.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.dao.CompanyDao;
import com.tmtc.dao.DictionaryDao;
import com.tmtc.dao.ProductDao;
import com.tmtc.dao.ExpOrderDao;
import com.tmtc.dao.UserDetailDao;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Company;
import com.tmtc.po.Dictionary;
import com.tmtc.po.DictionaryRepository;
import com.tmtc.po.Product;
import com.tmtc.po.ExpOrder;
import com.tmtc.po.ExpOrderRepository;
import com.tmtc.po.UserDetail;
import com.tmtc.po.UserDetailRepository;
import com.tmtc.service.ExpOrderService;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.vo.CompanyProVo;
import com.tmtc.vo.ExpOrderVo;

@Service
public class ExpOrderServiceImpl implements ExpOrderService {

	@Autowired
	ExpOrderDao expOrderDao;
	
	@Autowired
	UserDetailDao userDetailDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	DictionaryDao dictionaryDao;
	
	@Autowired
	CompanyDao companyDao;

	@Override
	public int count(ExpOrderRepository example) {
		return 0;
	}

	@Override
	public int delete(String id) {
		return expOrderDao.deleteByPrimaryKey(id);
	}

	@Override
	public int delete(ExpOrderRepository example) {
		return 0;
	}

	@Override
	public int insert(ExpOrder record) {
		return expOrderDao.insert(record);
	}

	@Override
	public List<ExpOrder> select(ExpOrderRepository example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExpOrder selectByPrimaryKey(String id) {
		return expOrderDao.selectByPrimaryKey(id);
	}

	@Override
	public int update(ExpOrder record) {
		return expOrderDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(ExpOrder record, ExpOrderRepository example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageResult selectByPage(ExpOrderRepository example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(String id, Integer order_status, String consignee, String area, String address, String mobile) {
		ExpOrder expOrder = new ExpOrder();
		expOrder.setId(id);
		expOrder.setOrder_status(order_status);
		expOrder.setConsignee(consignee);
		expOrder.setArea(area);
		expOrder.setAddress(address);
		expOrder.setMobile(mobile);
		return expOrderDao.updateByPrimaryKeySelective(expOrder);
	}

	@Override
	public PageResult select(Integer page, Integer rows, String user_name, String order_no, String consignee,
			String mobile, Integer order_status, String start, String end) throws ParseException {
		ExpOrderRepository expOrderRepository = new ExpOrderRepository();
		ExpOrderRepository.Criteria criteria = expOrderRepository.createCriteria();
		expOrderRepository.setPageSize(rows);
		expOrderRepository.setRowIndex((page - 1) * rows);
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		if (0 != VerificationUtil.length(user_name)) {
			UserDetailRepository userDetailRepository = new UserDetailRepository();
			UserDetailRepository.Criteria criteria2 = userDetailRepository.createCriteria();
			criteria2.andUsernameLike("%" + user_name + "%");
			criteria2.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
			List<UserDetail> userDetailList = userDetailDao.selectByExample(userDetailRepository);
			List<String> userIdList = new ArrayList<String>();
			for (UserDetail userDetail : userDetailList) {
				userIdList.add(userDetail.getId());
			}
			criteria.andUser_idIn(userIdList);
		}
		if (0 != VerificationUtil.length(order_no)) {
			criteria.andOrder_noEqualTo(order_no);
		}
		if (0 != VerificationUtil.length(consignee)) {
			criteria.andConsigneeLike("%" + consignee + "%");
		}
		if (0 != VerificationUtil.length(mobile)) {
			criteria.andMobileLike("%" + mobile + "%");
		}
		if (0 != VerificationUtil.integerIsNull(order_status)) {
			criteria.andOrder_statusEqualTo(order_status);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (0 != VerificationUtil.length(start)) {
			Date start_time = sdf.parse(start);
			criteria.andOrder_timeGreaterThan(start_time);
		}
		if (0 != VerificationUtil.length(end)) {
			Date end_time = sdf.parse(end);
			criteria.andOrder_timeLessThan(end_time);
		}
		List<ExpOrder> list = expOrderDao.selectByExample(expOrderRepository);
		List<ExpOrderVo> listVo = new ArrayList<ExpOrderVo>();
		for (ExpOrder expOrder : list) {
			String user_id = expOrder.getUser_id();
			String pro_id = expOrder.getPro_id();
			Integer city_id = expOrder.getCity_id();
			Integer orderStatus = expOrder.getOrder_status();

			String userName = "";
			String proName = "";
			String cityName = "";
			String orderStatusName = "";

			if (0 != VerificationUtil.length(user_id)) {
				userName = getUserName(user_id);
			}
			if (0 != VerificationUtil.length(pro_id)) {
				String a[] = pro_id.split(",");
				for (int i = 0; i < a.length; i++) {
					if (i == a.length - 1) {
						proName += getProName(a[i]);
					} else {
						proName += getProName(a[i]) + ",";
					}
				}
			}
			if (0 != VerificationUtil.integerIsNull(city_id)) {
				cityName = getName(city_id);
			}
			if (0 != VerificationUtil.integerIsNull(orderStatus)) {
				orderStatusName = getName(orderStatus);
			}
			ExpOrderVo expOrderVo = new ExpOrderVo(expOrder, null, userName, proName, cityName, orderStatusName);
			listVo.add(expOrderVo);
		}
		return new PageResult(expOrderDao.countByExample(expOrderRepository), listVo, 1);
	}

	private String getUserName(String userId) {
		String userName = null;
		UserDetail userDetail = userDetailDao.selectByPrimaryKey(userId);
		if (null != userDetail) {
			userName = userDetail.getUsername();
		}
		return userName;
	}

	private String getProName(String pro_id) {
		String proName = null;
		Product product = productDao.selectByPrimaryKey(pro_id);
		if (null != product) {
			proName = product.getPro_name();
		}
		return proName;
	}

	private String getName(Integer code) {
		String name = null;
		DictionaryRepository dictionaryRepository = new DictionaryRepository();
		DictionaryRepository.Criteria criteria = dictionaryRepository.createCriteria();
		criteria.andCodeEqualTo(code);
		List<Dictionary> list = dictionaryDao.selectByExample(dictionaryRepository);
		if (0 != VerificationUtil.size(list)) {
			name = list.get(0).getName();
		}
		return name;
	}

	@Override
	public CompanyProVo selectDetail(String id) {
		Company company = null;
		ExpOrder expOrder = expOrderDao.selectByPrimaryKey(id);
		CompanyProVo companyProVo = new CompanyProVo();
		if (null != expOrder) {
			String pro_id = expOrder.getPro_id();
			company = expOrderDao.selectCompanyById(pro_id);
			Product product = productDao.selectByPrimaryKey(pro_id);
			companyProVo.setCompany(company);
			companyProVo.setProduct(product);
		}
		return companyProVo;
	}

}
