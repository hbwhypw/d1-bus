package com.tmtc.controller.appAPI;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.constant.MessageVar;
import com.tmtc.constant.ParameterConstant;
import com.tmtc.po.Driver;
import com.tmtc.po.VerificationCode;
import com.tmtc.service.appAPI.DriverAppService;
import com.tmtc.service.appAPI.RegisterAPIService;
import com.tmtc.utils.VerificationUtil;

/**
 * 司机端找回密码
 * 
 * @author zxs
 *
 */
@Controller
@RequestMapping("/App/driver")
public class DriverAppController extends BaseController {

	@Autowired
	RegisterAPIService registerAPIService;
	@Autowired
	DriverAppService driverAppService;

	/**
	 * 司机端找回密码 /App/driver/findPWD？
	 * 
	 * @param request
	 * @param phone
	 *            手机号
	 * @param verificationCode
	 *            验证码
	 * @param pwd
	 *            新密码
	 * @return
	 */
	@RequestMapping("/findPWD")
	@ResponseBody
	public Map<String, Object> findPWD(HttpServletRequest request, @RequestParam String phone,
			@RequestParam String verificationCode, @RequestParam String pwd) {
		if (!VerificationUtil.checkMobilePhone(phone)) {
			return getMap(request, MessageVar.PHONE_NUM_ERROR,STATUS_ERROR);
		}
		VerificationCode verificationCode2 = registerAPIService.selectVerificationCode(phone);
		if (ParameterConstant.TIME < (System.currentTimeMillis() - verificationCode2.getCreate_time())) {
			return getMap(request, MessageVar.VERIFICATION_CODE_OVER,STATUS_ERROR);
		}
		if (32 != VerificationUtil.length(pwd)) {
			return getMap(request, MessageVar.PWD_ERROR,STATUS_ERROR);
		}
		if (!verificationCode.equals(verificationCode2.getCode())) {
			return getMap(request, MessageVar.VERIFICATION_CODE_FALSE,STATUS_ERROR);
		}
		List<Driver> driverList = driverAppService.selectByPhone(phone);
		Driver driver = null;
		if (0 != VerificationUtil.size(driverList)) {
			driver = driverList.get(0);
		}
		if (null == driver || 0 == VerificationUtil.length(driver.getId())) {
			return getMap(request, MessageVar.PHONE_NULL_RIGISTER,STATUS_ERROR);
		}

		driver.setPassword(pwd);
		if (driverAppService.updatePW(driver)) {
			return getMap(request, MessageVar.FINDPW_SUCCESS);
		}
		return getMap(request, MessageVar.FIND_ERROR,STATUS_ERROR);
	}

	/**
	 * 司机端修改密码 /App/driver/updatePWD？
	 * 
	 * @param request
	 * @param oldpassword
	 *            老密码
	 * @param newpassword
	 *            新密码
	 * @return
	 */
	@RequestMapping("/updatePWD")
	@ResponseBody
	public Map<String, Object> updatePWD(HttpServletRequest request, @RequestParam String oldpassword,
			@RequestParam String newpassword) {
		String driverid = getUserId(request);
		Driver driver = driverAppService.selectByPrimaryKey(driverid);
		// 验证旧密码
		if (driver == null) {
			return getMap(request, MessageVar.DRIVER_UPDATE_NULL,STATUS_ERROR);
		}
		if (driver.getPassword().equals(oldpassword)) {
			// 更新新密码
			Driver newdriver = new Driver();
			newdriver.setId(driverid);
			newdriver.setPassword(newpassword);
			if (driverAppService.update(newdriver) == 1) {
				return getMap(request, MessageVar.DRIVER_UPDATE_SUCCESS);
			}
			return getMap(request, MessageVar.DRIVER_UPDATE_ERROR,STATUS_ERROR);
		}
		return getMap(request, MessageVar.DRIVER_UPDATE_ERROR,STATUS_ERROR);
	}
}
