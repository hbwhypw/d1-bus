package com.tmtc.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证类
 * 
 * @author qiukai
 *
 */
public class VerificationUtil {

//	private static final Pattern TAG_PATTERN = Pattern.compile("/#([^\\#|.]+)#/");

	private static final Pattern MOBILE_PATTERN = Pattern.compile("^1[3-8]\\d{9}$");

	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9-_.]+@[A-Za-z0-9-_.]+.[A-Za-z]{2,5}$");

	private static final Pattern IDCARD_PATTERN = Pattern.compile("^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$");
	
//	private static final Pattern AT_PATTERN = Pattern.compile("/@[\\u4e00-\\u9fa5\\w\\-]+/");

	/**
	 * 验证身份证是否正确
	 * @param idcard
	 * @return
	 */
	public static boolean checkIdcard(String idcard) {
		try {
			Matcher matcher = IDCARD_PATTERN.matcher(idcard);
			return matcher.matches();
		} catch (Exception e) {
		}
		return false;
	}
	
	/**
	 * 验证手机号码是否正确
	 * @param email
	 * @return
	 */
	public static boolean checkMobilePhone(String mobile) {
		try {
			Matcher matcher = MOBILE_PATTERN.matcher(mobile);
			return matcher.matches();
		} catch (Exception e) {
		}
		return false;
	}
	
	/**
	 * 验证邮箱地址是否正确
	 * 
	 * @param email
	 * @return
	 */
	public static boolean checkEmail(String email) {
		try {
			Matcher matcher = EMAIL_PATTERN.matcher(email);
			return matcher.matches();
		} catch (Exception e) {

		}
		return false;
	}
	
	/**
	 * 返回字符串长度，如果字符串为空则返回0；
	 * 
	 * @param string
	 * @return
	 */
	public static int length(String string) {
		return string == null ? 0 : string.length();
	}
	
	/**
	 * 返回Integer长度，如果integer为空则返回0；
	 * 
	 * @param Integer
	 * @return
	 */
	public static int integerIsNull(Integer integer) {
		return integer == null ? 0 : integer;
	}

	/**
	 * 返回list长度，如果list为空则返回0；
	 * @param list
	 * @return
	 */
	public static int size(List<? extends Object> list){
		return list == null ? 0 : list.size();
	}

}