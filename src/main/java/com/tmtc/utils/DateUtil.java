package com.tmtc.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Date: 2015/10/21 10:28
 * 
 * @author : hbwhypw Function: 日期工具类
 */
public class DateUtil {

	private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

	private static SimpleDateFormat sdfymdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private static SimpleDateFormat sdfslashymdhms = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	private static SimpleDateFormat sdfymd = new SimpleDateFormat("yyyy-MM-dd");

	private static SimpleDateFormat sdfslashymd = new SimpleDateFormat("yyyy/MM/dd");

	private static SimpleDateFormat sdfymdhms1 = new SimpleDateFormat("yyyyMMddHHmmss");

	private static SimpleDateFormat sdfymdhm = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	/**
	 * 获取当前日期格式化字符串，默认yyyyMMddHHmmss格式
	 * 
	 * @return String
	 */
	public static String getDateString() {
		return sdfymdhms1.format(new Date());
	}

	/**
	 * 获取当前日期
	 * 
	 * @return Date
	 */
	public static Date getCurrentDate() {
		return new Date();
	}

	/**
	 * 获取当前日期格式化字符串，默认yyyy-MM-dd HH:mm:ss格式
	 * 
	 * @return String
	 */
	public static String getCurrentDateString() {
		return sdfymdhms.format(new Date());
	}

	/**
	 * 获取当前日期指定格式化字符串
	 * 
	 * @param format
	 *            日期格式，形如yyyy-MM-dd HH:mm:ss
	 * @return String
	 */
	public static String getCurrentDateString(String format) {
		return new SimpleDateFormat(format).format(new Date());
	}

	/**
	 * 获取指定日期的格式化字符串，默认yyyy-MM-dd HH:mm:ss格式
	 * 
	 * @param date
	 *            指定日期
	 * @return String
	 */
	public static String getDateString(Date date) {
		return sdfymdhms.format(date);
	}

	/**
	 * 获取指定日期的格式化字符串，默认yyyy-MM-dd HH:mm:ss格式
	 * 
	 * @param date
	 *            指定日期
	 * @return String
	 */
	public static String getStringDate(Date date) {
		return sdfymd.format(date);
	}

	/**
	 * 获取指定日期指定格式化的字符串
	 * 
	 * @param date
	 *            指定日期
	 * @param format
	 *            日期格式，形如yyyy-MM-dd HH:mm:ss
	 * @return String
	 */
	public static String getDateString(Date date, String format) {
		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * 将"yyyy-MM-dd HH:mm:ss"字符串转成date类型
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLongDate(String date) {
		Date parse = null;
		try {
			parse = sdfymdhms.parse(date);
		} catch (ParseException e) {
//			e.printStackTrace();
			return null;
		}
		return parse;
	}

	public static Date getShortDate(String date) {
		Date parse = null;
		try {
			parse = sdfymd.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parse;
	}

	/**
	 * 尝试根据字符串时间转换日期类型
	 * 
	 * @param date
	 * @return
	 */
	public static Date tryGetDate(String date) {
		Date parse = null;
		try {
			parse = sdfslashymd.parse(date);
		} catch (ParseException e) {
			try {
				parse = sdfymd.parse(date);
			} catch (ParseException e1) {
				try {
					parse = sdfslashymdhms.parse(date);
				} catch (ParseException e2) {
					try {
						parse = sdfymdhms.parse(date);
					} catch (ParseException e3) {
						logger.error(e3.getMessage());
					}
				}
			}
		}
		return parse;
	}

	/**
	 * 得到明天
	 * 
	 * @param date
	 * @return 返回日期
	 */
	public static Date getTomorrow(Date date) {
		return AddDate(date, 1);
	}

	/**
	 * 添加日期
	 * 
	 * @param date
	 *            Date类型 起始时间
	 * @param i
	 *            int类型 添加的时间单位天
	 * @return 返回日期
	 */
	public static Date AddDate(Date date, int i) {
		// 把日期往后增加一天.整数往后推,负数往前移动
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, i);
		// 这个时间就是日期往后推一天的结果
		return calendar.getTime();
	}

	/**
	 * String 转换成日期和时间
	 * 
	 * @param date
	 *            (string 类型，格式yyyy-MM-dd HH:mm)
	 * @return 日期类型或者null
	 */
	public static Date stringToDateTime(String date) {
		Date date1 = null;
		try {
			date1 = sdfymdhm.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date1;
	}

	/**
	 * String 转换成时间
	 * 
	 * @param date
	 *            (string 类型，格式HH:mm)
	 * @return 日期类型或者null
	 */
	public static Date stringToTime(String date) {
		Date date1 = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			date1 = sdf.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date1;
	}

	/**
	 * String 转换成日期
	 * 
	 * @param dateString
	 *            (string 类型，格式yyyy-MM-dd)
	 * @return 日期类型或者null
	 */
	public static Date stringToDate(String dateString) {
		Date date = null;
		if (13 == VerificationUtil.length(dateString)) {
			date = new Date(Long.parseLong(dateString));
		}
		try {
			date = sdfymd.parse(dateString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	// public static void main(String[] args) {
	// System.out.println("1447989029639".length());
	// }

}
