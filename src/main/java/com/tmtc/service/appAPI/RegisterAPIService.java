package com.tmtc.service.appAPI;

import com.tmtc.po.User;
import com.tmtc.po.UserDetail;
import com.tmtc.po.VerificationCode;

public interface RegisterAPIService {
	
	/**
	 * 重置密码
	 * @param user
	 * @return
	 */
	boolean updateUser(User user);

	/**
	 * 添加用户（只有手机号和密码）
	 * @return 
	 */
	boolean addUserDetail(UserDetail userDetail);
	
	/**
	 * 向数据库添加验证码
	 * @return 
	 */
	boolean addVerificationCode(VerificationCode verificationCode);
	
	/**
	 * 通过手机号查询用户信息
	 * @param phone
	 * @return
	 */
	User selectPhone(String phone);
	
	/**
	 * 查询验证码
	 * @param phone
	 * @return
	 */
	VerificationCode selectVerificationCode(String phone);
	/**
	 * 注册
	 * @param username
	 * @param cityName
	 * @return
	 */
	int add(String username,String cityName,String ip_address);
	/**
	 * 注册
	 * @param username
	 * @param cityName
	 * @return
	 */
	public String addUser(String username,String cityName,String ip_address,Integer login_source);
}
