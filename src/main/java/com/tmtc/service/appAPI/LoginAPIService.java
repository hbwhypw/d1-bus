package com.tmtc.service.appAPI;

import com.tmtc.po.UserDetail;
import com.tmtc.po.UserLogin;

public interface LoginAPIService {

	/**
	 * 验证用户登录是否正确
	 * @param name
	 * @param company_id
	 * @param user_type
	 * @param login_source
	 * @param password
	 * @param ip_address
	 * @param city_id
	 * @param is_driver
	 * @return
	 */
	String saveLogin(String name, String company_id, Integer user_type, Integer login_source, String password,
			String ip_address, Integer city_id, Integer is_driver);
	
	/**
	 * 添加用户登录session
	 * @param id
	 * @return
	 */
	UserLogin addUserLogin(String id);

	/**
	 * 查询用户登录的session
	 * @param session
	 * @return
	 */
	UserLogin findLogin(String session);
	
	/**
	 * 查询用户详细信息
	 * @param id
	 * @return
	 */
	UserDetail selectUserDetail(String id);
}
