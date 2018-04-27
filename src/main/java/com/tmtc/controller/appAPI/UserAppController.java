package com.tmtc.controller.appAPI;

import com.tmtc.constant.MessageVar;
import com.tmtc.constant.ParameterConstant;
import com.tmtc.constant.SystemVar;
import com.tmtc.po.User;
import com.tmtc.po.UserDetail;
import com.tmtc.po.UserDetailRepository;
import com.tmtc.po.VerificationCode;
import com.tmtc.service.UserDetailService;
import com.tmtc.service.UserService;
import com.tmtc.service.appAPI.RegisterAPIService;
import com.tmtc.utils.IdWorker;
import com.tmtc.utils.SendVerificationCode;
import com.tmtc.utils.VerificationUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created: hbwhypw Date: 2015/10/15 10:29 Function: 用户接口层
 */
@Controller
@RequestMapping("/App/user")
public class UserAppController extends BaseController {
	@Autowired
	UserDetailService userDetailService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RegisterAPIService registerAPIService;

	/**
	 * 查询用户信息  /App/user/query
	 */
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(HttpServletRequest request, HttpServletResponse response) {
		UserDetail userDetail = userDetailService.selectByPrimaryKey(getUserId(request));
		return getMap(request, "", userDetail);
	}

	/**
	 * 修改密码  /App/user/changepwd
	 * 
	 * @param oldpassword
	 *            老密码
	 * @param newpassword
	 *            新密码
	 */
	@RequestMapping("/changepwd")
	@ResponseBody
	public Map<String, Object> changepwd(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String oldpassword, @RequestParam String newpassword) {
		Map<String, Object> result;
		String userid = getUserId(request);
		User user = userService.selectByPrimaryKey(userid);
		// 验证旧密码
		if (user == null) {
			result = getMap(request, MessageVar.USER_QUERY_IDISNULL,STATUS_ERROR);
		}
		if (user.getPassword().equals(oldpassword)) {
			// 更新新密码
			User newuser = new User();
			newuser.setId(userid);
			newuser.setPassword(newpassword);
			if (userService.update(newuser) == 1) {
				result = getMap(request, "success");
			} else {
				result = getMap(request, MessageVar.USER_CHANGEPWD_ERROR,STATUS_ERROR);
			}
		} else {
			result = getMap(request, MessageVar.PWD_ERROR,STATUS_ERROR);
		}
		return result;
	}

	/**
	 * 修改昵称 url：/App/user/changenick
	 * 
	 * @param nickname
	 *            昵称
	 */
	@RequestMapping("/changenick")
	@ResponseBody
	public Map<String, Object> changeNick(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String nickname) {
		UserDetail userDetail = new UserDetail();
		userDetail.setId(getUserId(request));
		userDetail.setNick_name(nickname);
		if (userDetailService.update(userDetail) == 1) {
			return getMap(request, "成功", STATUS_SUCCESS);
		} else {
			return getMap(request, "失败", STATUS_ERROR);
		}
	}


	/**
	 * 更换手机号 第一步 获取验证码 /App/user/getVerificationCode
	 * @param phone 手机号
	 */
	@RequestMapping("/getVerificationCode")
	@ResponseBody
	public Map<String, Object> getVerificationCode(HttpServletRequest request, @RequestParam String phone) {

		if (!VerificationUtil.checkMobilePhone(phone)) {
			return getMap(request, MessageVar.PHONE_NUM_ERROR, STATUS_ERROR);
		}
		//验证手机号是否存在
		UserDetailRepository userDetailRepository = new UserDetailRepository();
		UserDetailRepository.Criteria criteria = userDetailRepository.createCriteria();
		criteria.andUsernameEqualTo(phone);
		List<UserDetail> list = userDetailService.select(userDetailRepository);
		if(0 != VerificationUtil.size(list)){
			return getMap(request, MessageVar.SEND_VERIFICATION_CODE_ERROR, STATUS_ERROR);
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
	 * 更换手机号 第二步 确认更换 url：/App/user/changephone
	 * 
	 * @param phone
	 *            手机号
	 * @param password
	 *            密码
	 * @param code
	 *            验证码
	 */
	@RequestMapping("/changephone")
	@ResponseBody
	public Map<String, Object> changePhone(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String phone, @RequestParam String password, @RequestParam String code) {
		Map<String, Object> result = new HashMap<>();
		String userid = getUserId(request);
		User user = userService.selectByPrimaryKey(userid);
		// 验证旧密码
		if (user == null) {
			return getMap(request, MessageVar.USER_QUERY_IDISNULL,STATUS_ERROR);
		}
		if (password.equals(user.getPassword())) {
			// 验证码
			VerificationCode verificationCode = registerAPIService.selectVerificationCode(phone);
			if (verificationCode.getCode().equals(code)) {
				
				//验证手机号是否存在
				UserDetailRepository userDetailRepository = new UserDetailRepository();
				UserDetailRepository.Criteria criteria = userDetailRepository.createCriteria();
				criteria.andUsernameEqualTo(phone);
				List<UserDetail> list = userDetailService.select(userDetailRepository);
				if(0 != VerificationUtil.size(list)){
					return getMap(request, MessageVar.SEND_VERIFICATION_CODE_ERROR, STATUS_ERROR);
				}
				if (userDetailService.updatePhone(getUserId(request), phone) == 1) {
					result = getMap(request, MessageVar.SEND_VERIFICATION_CODE_SUCCESS, STATUS_SUCCESS);
				} else {
					result = getMap(request, MessageVar.USER_CHANGEPHONE_UPDATE_FAIL,STATUS_ERROR);
				}
			} else {
				result = getMap(request, MessageVar.USER_CHANGEPHONE_CODEERROR,STATUS_ERROR);
			}
		} else {
			result = getMap(request, MessageVar.PWD_ERROR,STATUS_ERROR);
		}
		return result;
	}

	/**
	 * 我的二维码 url：/App/user/qrcode
	 */
	@RequestMapping("/qrcode")
	@ResponseBody
	public Map<String, Object> getQr_code(HttpServletRequest request, HttpServletResponse response) {
		UserDetail userDetail = userDetailService.selectByPrimaryKey(getUserId(request));
		if (userDetail != null) {
			return getMap(request, "", SystemVar.SERVER_IMG_URL+SystemVar.USER_QR_CODE+userDetail.getQr_code());
		}
		return getMap(request, MessageVar.USER_QRCODE_FAIL,STATUS_ERROR);
	}
	
	/**
	 * 激活	/App/user/invoke
	 * return 0、激活失败；1、激活成功；2、可用，无需激活
	 */
	@RequestMapping("/invoke")
	@ResponseBody
	public Map<String,Object> invoke(HttpServletRequest request,HttpServletResponse response) {
		String userid = getUserId(request);
		int num = userDetailService.updateInvoke(userid);
		
		Date last_order_time = null;
		UserDetail userDetail = userDetailService.selectByPrimaryKey(userid);
		if(null != userDetail){
			last_order_time = userDetail.getLast_order_time();
		}
		
		if(1 == num){
    		return getMap(request, MessageVar.INVOKE_SUCCESS,1,last_order_time);
    	}
    	if(2 == num){
    		return getMap(request, MessageVar.INVOKE_NO,2,last_order_time);
    	}
    	return getMap(request, MessageVar.INVOKE_ERROR,0,last_order_time);
	}
}
