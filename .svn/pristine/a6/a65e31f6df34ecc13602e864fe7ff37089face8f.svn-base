package com.tmtc.controller.appAPI;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.constant.MessageVar;
import com.tmtc.constant.ParameterConstant;
import com.tmtc.po.User;
import com.tmtc.po.UserDetail;
import com.tmtc.po.VerificationCode;
import com.tmtc.service.appAPI.RegisterAPIService;
import com.tmtc.utils.IP;
import com.tmtc.utils.IdWorker;
import com.tmtc.utils.SendVerificationCode;
import com.tmtc.utils.VerificationUtil;

/**
 * 注册接口 未完成---------------------------------------------------------------
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/App/register")
public class RegisterAppController extends BaseController {

	@Autowired
	RegisterAPIService registerAPIService;

	/**
	 * 找回密码 /App/register/findPWD
	 * 
	 * @param request
	 * @param phone
	 *            手机号（String 类型）
	 * @param verificationCode
	 *            验证码（String类型）
	 * @param pwd
	 *            密码 （String类型32位16进制数）
	 * @return
	 */
	@RequestMapping("/findPWD")
	@ResponseBody
	public Map<String, Object> findPWD(HttpServletRequest request, @RequestParam String phone,
			@RequestParam String verificationCode, @RequestParam String pwd) {

		if (!VerificationUtil.checkMobilePhone(phone)) {
			return getMap(request, MessageVar.PHONE_NUM_ERROR, STATUS_ERROR);
		}
		VerificationCode verificationCode2 = registerAPIService.selectVerificationCode(phone);
		if (ParameterConstant.TIME < (System.currentTimeMillis() - verificationCode2.getCreate_time())) {
			return getMap(request, MessageVar.VERIFICATION_CODE_OVER, STATUS_ERROR);
		}
		if (32 != VerificationUtil.length(pwd)) {
			return getMap(request, MessageVar.PWD_ERROR, STATUS_ERROR);
		}
		if (!verificationCode.equals(verificationCode2.getCode())) {
			return getMap(request, MessageVar.VERIFICATION_CODE_FALSE, STATUS_ERROR);
		}

		User user = registerAPIService.selectPhone(phone);

		if (null == user || 0 == VerificationUtil.length(user.getId())) {
			return getMap(request, MessageVar.PHONE_NULL_RIGISTER, STATUS_ERROR);
		}
		user.setPassword(pwd);
		user.setLock_cnt(0);
		user.setLogin_cnt(0);
		if (registerAPIService.updateUser(user)) {
			return getMap(request, MessageVar.FINDPW_SUCCESS);
		}
		return getMap(request, MessageVar.FIND_ERROR, STATUS_ERROR);
	}

	/**
	 * /App/register/register? 注册第二步
	 * 
	 * @param phone
	 *            手机号（String 类型）
	 * @param pwd密码（String类型）
	 * @param rePwd重复密码（String类型）
	 * @param register_source重复密码（String类型）
	 * @return
	 */
	@RequestMapping("/register")
	@ResponseBody
	public Map<String, Object> register(HttpServletRequest request, @RequestParam String phone,
			@RequestParam String pwd, @RequestParam String rePwd, @RequestParam int register_source) {

		if (VerificationUtil.checkMobilePhone(phone)) {
			return getMap(request, MessageVar.PHONE_NUM_ERROR, STATUS_ERROR);
		}
		if (null != registerAPIService.selectPhone(phone)) {
			return getMap(request, MessageVar.SEND_VERIFICATION_CODE_ERROR, STATUS_ERROR);
		}
		VerificationCode verificationCode = registerAPIService.selectVerificationCode(phone);
		if (ParameterConstant.TIME < (System.currentTimeMillis() - verificationCode.getCreate_time())) {
			return getMap(request, MessageVar.VERIFICATION_CODE_OVER, STATUS_ERROR);
		}
		if (32 != VerificationUtil.length(pwd) || 32 != VerificationUtil.length(rePwd) || pwd.equals(rePwd)) {
			return getMap(request, MessageVar.PWD_ERROR, STATUS_ERROR);
		}
		UserDetail userDetail = new UserDetail();
		userDetail.setId(IdWorker.nextId());
		// 需要添加注册来源

		if (!registerAPIService.addUserDetail(userDetail)) {
			return getMap(request, MessageVar.RIGISTER_ERROR, STATUS_ERROR);
		}
		return getMap(request, MessageVar.RIGISTER_ERROR);
	}

	/**
	 * 注册第一步验证手机号 /registerApp/add?
	 * @param request
	 * @param phone	手机号
	 * @param verificationCode	验证码
	 * @param cityName	城市名
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(HttpServletRequest request, @RequestParam String phone,
			@RequestParam String verificationCode,@RequestParam String cityName) {

		// 获取ip地址
		String ip_address = IP.getIP(request);
		if (VerificationUtil.checkMobilePhone(phone)) {
			return getMap(request, MessageVar.PHONE_NUM_ERROR, STATUS_ERROR);
		}
		if (null != registerAPIService.selectPhone(phone)) {
			return getMap(request, MessageVar.SEND_VERIFICATION_CODE_ERROR, STATUS_ERROR);
		}
		VerificationCode verificationCode2 = registerAPIService.selectVerificationCode(phone);
		if (null == verificationCode2) {
			return getMap(request, MessageVar.PHONE_ONT_VERIFICATION, STATUS_ERROR);
		} else {
			if (ParameterConstant.TIME < (System.currentTimeMillis() - verificationCode2.getCreate_time())) {
				return getMap(request, MessageVar.VERIFICATION_CODE_OVER, STATUS_ERROR);
			}
		}
		if (!verificationCode.equals(verificationCode2.getCode())) {
			return getMap(request, MessageVar.VERIFICATION_CODE_FALSE, STATUS_ERROR);
		}
		registerAPIService.add(phone, cityName,ip_address);
		return getMap(request, MessageVar.VERIFICATION_CODE_TRUE);
	}

	/**
	 * 获取验证码 /App/register/getVerificationCode?
	 * 
	 * @param phone
	 *            手机号（String类型）
	 */
	@RequestMapping("/getVerificationCode")
	@ResponseBody
	public Map<String, Object> getVerificationCode(HttpServletRequest request, @RequestParam String phone) {

		if (!VerificationUtil.checkMobilePhone(phone)) {
			return getMap(request, MessageVar.PHONE_NUM_ERROR, STATUS_ERROR);
		}
		VerificationCode verificationCode = registerAPIService.selectVerificationCode(phone);
		if (null != verificationCode) {
			if (ParameterConstant.TIME > (System.currentTimeMillis() - verificationCode.getCreate_time())) {
				return getMap(request, MessageVar.SEND_GO, STATUS_ERROR);
			}
		}
		// 发送手机短信
		int sendSMS = SendVerificationCode.sendSMS(phone);
		if (0 == sendSMS) {
			return getMap(request, MessageVar.SEND_ERROR, STATUS_ERROR);
		}
		VerificationCode verificationCode1 = new VerificationCode(IdWorker.nextId(), phone, String.valueOf(sendSMS),
				System.currentTimeMillis(), ParameterConstant.IS_CHECK);
		if (!registerAPIService.addVerificationCode(verificationCode1)) {
			return getMap(request, MessageVar.SEND_ERROR, STATUS_ERROR);
		}
		return getMap(request, MessageVar.SEND_SUCCESS);
	}

	/**
	 * 获取验证码 /App/register/getVerificationCodeW?
	 * 
	 * @param phone
	 *            手机号（String类型）
	 */
	@RequestMapping("/getVerificationCodeW")
	@ResponseBody
	public Map<String, Object> getVerificationCodeW(HttpServletRequest request, @RequestParam String phone) {
		User user = registerAPIService.selectPhone(phone);
		if (user == null || 0 == VerificationUtil.length(user.getId())) {
			return getMap(request, MessageVar.PHONE_NULL_RIGISTER, STATUS_ERROR);
		}
		return getVerificationCode(request, phone);
	}
	
}
