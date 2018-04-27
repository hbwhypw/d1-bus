package com.tmtc.utils;

public class ConvertUtil {

	/**
	 * 数组拆分转成String类型的
	 * 
	 * @param arr[] String类型数组
	 * @return 如果返回空则为转换失败
	 */
	public static String arrayToString(String[] arr) {
		if (null == arr || 0 == arr.length) {
			return null;
		}
		int length = arr.length;
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < length; i++) {
			s.append(arr[i]);
			if ((i + 1) == arr.length) {
				return s.toString();
			}
			s.append(",");
		}
		return null;
	}
	
	/**
	 * 将String类型转换成long类型
	 * 
	 * @param str String类型
	 * @return 转换失败将返回0，转换成功long类型的值
	 */
	public static long stringToLong(String str) {
		if (0 == VerificationUtil.length(str)) {
			return 0;
		}
		long l = 0;
		try {
			l = Long.valueOf(str);
		} catch (Exception e) {
			return 0;
		}
		return l;
	}
}
