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
import com.tmtc.dao.ShopOrderDao;
import com.tmtc.dao.UserDetailDao;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Company;
import com.tmtc.po.Dictionary;
import com.tmtc.po.DictionaryRepository;
import com.tmtc.po.Product;
import com.tmtc.po.ShopOrder;
import com.tmtc.po.ShopOrderRepository;
import com.tmtc.po.UserDetail;
import com.tmtc.po.UserDetailRepository;
import com.tmtc.service.ShopOrderService;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.vo.ShopOrderVo;

@Service
public class ShopOrderServiceImpl implements ShopOrderService {

	@Autowired
	ShopOrderDao shopOrderDao;
	@Autowired
	UserDetailDao userDetailDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	DictionaryDao dictionaryDao;
	@Autowired
	CompanyDao companyDao;

	@Override
	public int count(ShopOrderRepository example) {
		return shopOrderDao.countByExample(example);
	}

	@Override
	public int delete(String id) {
		return shopOrderDao.deleteByPrimaryKey(id);
	}

	@Override
	public int delete(ShopOrderRepository example) {
		return shopOrderDao.deleteByExample(example);
	}

	@Override
	public int insert(ShopOrder record) {
		return shopOrderDao.insert(record);
	}

	@Override
	public List<ShopOrder> select(ShopOrderRepository example) {
		return shopOrderDao.selectByExample(example);
	}

	@Override
	public ShopOrder selectByPrimaryKey(String id) {
		return shopOrderDao.selectByPrimaryKey(id);
	}

	@Override
	public int update(ShopOrder record) {
		return shopOrderDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public boolean updateOrderPay(ShopOrder shopOrder) {
		int i = 0;
		shopOrder.setOrder_status(ParameterConstant.SHOP_ORDER_PAY);
		i += shopOrderDao.updateByPrimaryKeySelective(shopOrder);
		String sub_order_no = shopOrder.getSub_order_no();
		String[] split = sub_order_no.split(",");

		for(String s : split) {
			ShopOrder subShopOrder = new ShopOrder();
			subShopOrder.setId(s);
			subShopOrder.setOrder_status(ParameterConstant.SHOP_ORDER_PAY);
			subShopOrder.setPay_type(shopOrder.getPay_type());// 根据父订单更新子订单的支付方式
			i += update(subShopOrder);
		}
		return split.length + 1 == i;
	}


	@Override
	public int update(ShopOrder record, ShopOrderRepository example) {
		return shopOrderDao.updateByExample(record, example);
	}

	@Override
	public PageResult selectByPage(ShopOrderRepository example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(String id, Integer order_status, String consignee, String area, String address, String mobile) {
		ShopOrder shopOrder = new ShopOrder();
		shopOrder.setId(id);
		shopOrder.setOrder_status(order_status);
		shopOrder.setConsignee(consignee);
		shopOrder.setArea(area);
		shopOrder.setAddress(address);
		shopOrder.setMobile(mobile);
		return shopOrderDao.updateByPrimaryKeySelective(shopOrder);
	}

	@Override
	public PageResult select(Integer page, Integer rows, String user_name, String order_no, String consignee,
			String mobile, Integer order_status, Integer pay_type, String start, String end, Integer is_bill) throws ParseException {
		ShopOrderRepository shopOrderRepository = new ShopOrderRepository();
		ShopOrderRepository.Criteria criteria = shopOrderRepository.createCriteria();
		shopOrderRepository.setPageSize(rows);
		shopOrderRepository.setRowIndex((page - 1) * rows);
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		if (0 != VerificationUtil.length(user_name)) {
			UserDetailRepository userDetailRepository = new UserDetailRepository();
			UserDetailRepository.Criteria criteria2 = userDetailRepository.createCriteria();
			criteria2.andUsernameLike("%" + user_name + "%");
			criteria2.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
			List<UserDetail> userDetailList = userDetailDao.selectByExample(userDetailRepository);
			List<Long> userIdList = new ArrayList<Long>();
			for (UserDetail userDetail : userDetailList) {
				userIdList.add(Long.valueOf(userDetail.getId()));
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
		if (0 != VerificationUtil.integerIsNull(pay_type)) {
			criteria.andPay_typeEqualTo(pay_type);
		}
		if (0 != VerificationUtil.integerIsNull(is_bill)) {
			criteria.andIs_billEqualTo(is_bill);
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
		shopOrderRepository.setOrderByClause("order_time desc");
		List<ShopOrder> list = shopOrderDao.selectByExample(shopOrderRepository);
		List<ShopOrderVo> listVo = new ArrayList<ShopOrderVo>();
		for (ShopOrder shopOrder : list) {
			String user_id = shopOrder.getUser_id();
			String pro_id = shopOrder.getPro_id();
			Integer city_id = shopOrder.getCity_id();
			Integer orderStatus = shopOrder.getOrder_status();
			Integer payType = shopOrder.getPay_type();

			String userName = "";
			String proName = "";
			String cityName = "";
			String orderStatusName = "";
			String payTypeName = "";

			if (0 != VerificationUtil.length(user_id)) {
				userName = getUserName(user_id);
			}
			if (0 != VerificationUtil.length(pro_id)) {
				proName = getProName(pro_id);
			}
			if (0 != VerificationUtil.integerIsNull(city_id)) {
				cityName = getName(city_id);
			}
			if (0 != VerificationUtil.integerIsNull(orderStatus)) {
				orderStatusName = getName(orderStatus);
			}
			if (0 != VerificationUtil.integerIsNull(payType)) {
				payTypeName = getName(payType);
			}
			ShopOrderVo shopOrderVo = new ShopOrderVo(shopOrder, null,userName, proName, cityName, orderStatusName,
					payTypeName);
			listVo.add(shopOrderVo);
		}
		return new PageResult(shopOrderDao.countByExample(shopOrderRepository), listVo, 1);
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
	public List<Company> selectDetail(String id) {

		List<Company> companyList = null;
		ShopOrder shopOrder = shopOrderDao.selectByPrimaryKey(id);
		if (null != shopOrder) {
			String pro_id = shopOrder.getPro_id();
			companyList = shopOrderDao.selectCompanyById(pro_id);
			for (Company company : companyList) {
				List<Product> productList = shopOrderDao.selectProductByCompanyId(company.getId(), pro_id);
				company.setProductList(productList);
			}
		}
		return companyList;
	}

	/*
	 * @Override public PageResult selectSubById(Integer page, Integer rows,
	 * String id) { ShopOrder shopOrder1 = shopOrderDao.selectByPrimaryKey(id);
	 * List<Long> listId = new ArrayList<Long>(); if(null != shopOrder1){ String
	 * a[] = shopOrder1.getSub_order_no().split(","); for (int i = 0; i <
	 * a.length; i++) { listId.add(Long.valueOf(a[i])); } } ShopOrderRepository
	 * shopOrderRepository = new ShopOrderRepository();
	 * ShopOrderRepository.Criteria criteria =
	 * shopOrderRepository.createCriteria();
	 * shopOrderRepository.setPageSize(rows);
	 * shopOrderRepository.setRowIndex((page-1)*rows); criteria.andIdIn(listId);
	 * List<ShopOrder> list = shopOrderDao.selectByExample(shopOrderRepository);
	 * List<ShopOrderVo> listVo = new ArrayList<ShopOrderVo>(); for(ShopOrder
	 * shopOrder:list){ String user_id = shopOrder.getUser_id(); String pro_id =
	 * shopOrder.getPro_id(); Integer city_id = shopOrder.getCity_id(); Integer
	 * orderStatus = shopOrder.getOrder_status(); Integer payType =
	 * shopOrder.getPay_type();
	 * 
	 * String userName = null; String proName = null; String cityName = null;
	 * String orderStatusName = null; String payTypeName = null;
	 * 
	 * if(0 != VerificationUtil.length(user_id)){ userName =
	 * getUserName(user_id); } if(0 != VerificationUtil.length(pro_id)){ proName
	 * = getProName(pro_id); } if(0 != VerificationUtil.integerIsNull(city_id)){
	 * cityName = getName(city_id); } if(0 !=
	 * VerificationUtil.integerIsNull(orderStatus)){ orderStatusName =
	 * getName(orderStatus); } if(0 != VerificationUtil.integerIsNull(payType)){
	 * payTypeName = getName(payType); } ShopOrderVo shopOrderVo = new
	 * ShopOrderVo(shopOrder, userName, proName, cityName, orderStatusName,
	 * payTypeName); listVo.add(shopOrderVo); } return new
	 * PageResult(shopOrderDao.countByExample(shopOrderRepository),listVo,1); }
	 */

}
