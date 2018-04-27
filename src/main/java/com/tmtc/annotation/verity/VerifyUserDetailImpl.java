package com.tmtc.annotation.verity;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.constant.SystemVar;
import com.tmtc.dao.UserDao;
import com.tmtc.dao.UserDetailDao;
import com.tmtc.frame.ServiceRuntimeException;
import com.tmtc.po.User;
import com.tmtc.po.UserDetail;
import com.tmtc.po.UserDetailRepository;
import com.tmtc.po.UserDetailRepository.Criteria;
import com.tmtc.utils.DateUtil;
import com.tmtc.utils.MakeQRCode;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.utils.secret.MD5;

@Component
@Aspect
public class VerifyUserDetailImpl extends VerifyUserBase {

	@Autowired
	UserDao userDao;

	@Autowired
	UserDetailDao userDetailDao;

	// Controller层切点
	@Pointcut("@annotation(com.tmtc.annotation.verity.VerifyUserDetail)")
	public void aspect() {
	}

	@Before("aspect()")
	public UserDetail doBefore(JoinPoint joinPoint) {
		UserDetail userDetail = null;
		try {
			userDetail = (UserDetail) joinPoint.getArgs()[0];
		} catch (Exception e) {
			throw new ServiceRuntimeException("参数顺序不对");
		}
		if (null == userDetail) {
			throw new ServiceRuntimeException("用户信息有误,");
		}
		vUserDetail(userDetail);
		return userDetail;
	}
	
	public void vUserDetail(UserDetail userDetail) {
		vLinkNum(userDetail);
		vRegisterTime(userDetail);
		vRegisterSource(userDetail);
		vUserName(userDetail);
		vNickName(userDetail);
		vRealName(userDetail);
		vQrCode(userDetail);
		vSex(userDetail);
		vUserType(userDetail);
		vPortrait(userDetail);
		vCardNum(userDetail);
		vBalance(userDetail);
		vExpScore(userDetail);
		vLastOrderTime(userDetail);
	}

	public void vUserDetailImport(UserDetail userDetail) {
        vExpScore(userDetail);
        vBalance(userDetail);
        vCardNum(userDetail);
        vLinkNum(userDetail);
		vLastOrderTime(userDetail);
	}


	private void vLastOrderTime(UserDetail userDetail){
		if (null == userDetail.getLast_order_time()) {
			userDetail.setLast_order_time(DateUtil.AddDate(new Date(), ParameterConstant.INVOKE_TIME));
		}
	}
	
	private void vExpScore(UserDetail userDetail){
		if (0 == VerificationUtil.integerIsNull(userDetail.getExp_score())) {
			userDetail.setExp_score(0);
		}
	}
	
	private void vBalance(UserDetail userDetail) {
		if (0 == VerificationUtil.integerIsNull(userDetail.getBalance())) {
			userDetail.setBalance(0);
		}
	}

	private void vCardNum(UserDetail userDetail) {
		if (0 == VerificationUtil.length(userDetail.getCard_num()) || "0".equals(userDetail.getCard_num())) {
			userDetail.setCard_num("0");
		} else {
			User user = userDao.selectByPrimaryKey(userDetail.getId());
			String string = userDao.selectCompanyCardNum(user.getCompany_id(), userDetail.getCard_num());
			if (0 != VerificationUtil.length(string)) {
				throw new ServiceRuntimeException("卡号重复");
			}
		}
	}

	private void vPortrait(UserDetail userDetail) {
		if (0 == VerificationUtil.length(userDetail.getPortrait())) {
			userDetail.setPortrait(ParameterConstant.DEFAULT_PORTRAIT);
		}
	}

	private void vUserType(UserDetail userDetail) {
		if (0 == VerificationUtil.integerIsNull(userDetail.getUser_type())) {
			userDetail.setUser_type(ParameterConstant.USER_TYPE_COMPANY_NORMAL_100);
		}
	}

	private void vSex(UserDetail userDetail) {
		if (0 == VerificationUtil.integerIsNull(userDetail.getSex())) {
			userDetail.setSex(ParameterConstant.DEFAULT_SEX);
		}
	}

	private void vQrCode(UserDetail userDetail) {
		String qr_code = userDetail.getQr_code();
		String qr_code_secret = userDetail.getQr_code_secret();
		if (0 == VerificationUtil.length(qr_code) || 0 == VerificationUtil.length(qr_code_secret)) {
			String id = userDetail.getId();
			String md5 = id + "," + ParameterConstant.PRIVATE_KEY + "," + String.valueOf(System.currentTimeMillis());
			String makeMd5 = MD5.makeMd5(md5);
			String qrCodeUrl = MakeQRCode.makeQRCode(id + "," + makeMd5,
					SystemVar.LOCAL_IMG_URL + SystemVar.USER_QR_CODE, id);
			userDetail.setQr_code(qrCodeUrl);
			userDetail.setQr_code_secret(makeMd5);
		}
	}

	/**
	 * 生成二维码
	 * 
	 * @param id 
	 * @return
	 */
	public Map<String, String> createQR_code(String id) {
		Map<String, String> map = new HashMap<>();
		String md5 = id + "," + ParameterConstant.PRIVATE_KEY + "," + String.valueOf(System.currentTimeMillis());
		String makeMd5 = MD5.makeMd5(md5);
		String qrCodeUrl = MakeQRCode.makeQRCode(id + "," + makeMd5, SystemVar.LOCAL_IMG_URL + SystemVar.USER_QR_CODE,
				id);
		map.put("qr_code", qrCodeUrl);
		map.put("qr_code_secret", makeMd5);
		return map;
	}

	private void vRealName(UserDetail userDetail) {
		if (0 == VerificationUtil.length(userDetail.getReal_name())) {
			userDetail.setReal_name("");
		}
	}

	private void vNickName(UserDetail userDetail) {
		if (0 == VerificationUtil.length(userDetail.getNick_name())) {
			userDetail.setNick_name(ParameterConstant.DEFAULT_NICKNAME);
		}
	}

	private void vUserName(UserDetail userDetail) {
		String userName = userDetail.getUsername();
		if (0 == VerificationUtil.length(userDetail.getUsername())) {
			userDetail.setUsername("");
		} else {
			if (!VerificationUtil.checkMobilePhone(userName)) {
				throw new ServiceRuntimeException("手机号有误！");
			}
			UserDetailRepository userDetailRepository = new UserDetailRepository();
			Criteria criteria = userDetailRepository.createCriteria();
			criteria.andUsernameEqualTo(userName);
			criteria.andIs_checkIn(integerList);
			List<UserDetail> list = userDetailDao.selectByExample(userDetailRepository);
			switch (VerificationUtil.size(list)) {
			case 0:
				break;
			case 1:
				throw new ServiceRuntimeException("该手机号已存在！");
			default:
				throw new ServiceRuntimeException("用户表数据有错，开发人员请尽快解决");
			}
		}
	}

	private void vRegisterSource(UserDetail userDetail) {
		if (null == userDetail.getRegister_source()) {
			userDetail.setRegister_source(ParameterConstant.REGISTER_SOURCE_COMPANY);
		}
	}

	private void vRegisterTime(UserDetail userDetail) {
		if (null == userDetail.getRegister_time()) {
			userDetail.setRegister_time(new Date());
		}
	}

	/**
	 * 自动生成关联账号
	 * 
	 * @return
	 */
	private void vLinkNum(UserDetail userDetail) {
		if (0 == VerificationUtil.length(userDetail.getLink_num())) {
			String linkNum = userDetailDao.selectMaxLinkNum();
			if (0 != VerificationUtil.length(linkNum)) {
				int num = Integer.parseInt(linkNum.substring(SystemVar.LINK_NUM.length())) + 1;
				linkNum = SystemVar.LINK_NUM + num;
			}
			userDetail.setLink_num(linkNum);
		}
	}
}
