package com.tmtc.utils;

public class OrderNumUtil {

	private static final String JF = "JF";
	
	private static final String ZX = "ZX";
	
	private static final String XL = "XL";
	
	private static final String CZ = "CZ";
	
	/**
	 * 生成充值订单
	 * @return
	 */
	public static String getOrderByCZ(){
		return CZ + DateUtil.getDateString() + IdWorker.nextThree();
	}
	
	/**
	 * 生成积分订单
	 * @return
	 */
	public static String getOrderByJF(){
		return JF + DateUtil.getDateString() + IdWorker.nextThree();
	}
	
	/**
	 * 生成在线订单
	 * @return
	 */
	public static String getOrderByZX(){
		return ZX + DateUtil.getDateString() + IdWorker.nextThree();
	}
	/**
	 * 生成线路订单
	 * @return
	 */
	public static String getOrderByXL(){
		return XL + DateUtil.getDateString() + IdWorker.nextThree();
	}
}
