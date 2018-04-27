package com.tmtc.utils;

/**
 * Creater: hbwhypw Date: 2015/9/18 11:48 Function:
 */
public class IdWorker {
	private final static long twepoch = 1288834974657L;
	// 机器标识位数
	private final static long workerIdBits = 5L;
	// 数据中心标识位数
	private final static long datacenterIdBits = 5L;
	// 机器ID最大值
	private final static long maxWorkerId = ~(-1L << workerIdBits);
	// 数据中心ID最大值
	private final static long maxDatacenterId = ~(-1L << datacenterIdBits);
	// 毫秒内自增位
	private final static long sequenceBits = 12L;
	// 机器ID偏左移12位
	private final static long workerIdShift = sequenceBits;
	// 数据中心ID左移17位
	private final static long datacenterIdShift = sequenceBits + workerIdBits;
	// 时间毫秒左移22位
	private final static long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

	private final static long sequenceMask = ~(-1L << sequenceBits);

	private static long lastTimestamp = -1L;

	private static long sequence = 0L;
	/**
	 * 机器id (位数<=5)
	 */
	private final static long workerId = Long.parseLong(PropertiesUtil.getPropertyValue("system", "workerId"));
	/**
	 * 数据中心编号 (位数<=5)
	 */
	private final static long datacenterId = Long.parseLong(PropertiesUtil.getPropertyValue("system", "datacenterId"));

	static {
		if (workerId > maxWorkerId || workerId < 0) {
			throw new IllegalArgumentException("worker Id can't be greater than %d or less than 0");
		}
		if (datacenterId > maxDatacenterId || datacenterId < 0) {
			throw new IllegalArgumentException("datacenter Id can't be greater than %d or less than 0");
		}
	}

	/**
	 * 获取id
	 * 
	 * @return id
	 */
	public static synchronized String nextId() {
		long timestamp = timeGen();
		if (timestamp < lastTimestamp) {
			try {
				throw new Exception("Clock moved backwards.  Refusing to generate id for " + (lastTimestamp - timestamp)
						+ " milliseconds");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (lastTimestamp == timestamp) {
			// 当前毫秒内，则+1
			sequence = (sequence + 1) & sequenceMask;
			if (sequence == 0) {
				// 当前毫秒内计数满了，则等待下一秒
				timestamp = tilNextMillis(lastTimestamp);
			}
		} else {
			sequence = 0;
		}
		lastTimestamp = timestamp;
		// ID偏移组合生成最终的ID，并返回ID
		long nextId = ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift)
				| (workerId << workerIdShift) | sequence;

		return String.valueOf(nextId);
	}

	private static long tilNextMillis(final long lastTimestamp) {
		long timestamp = timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = timeGen();
		}
		return timestamp;
	}

	private static long timeGen() {
		return System.currentTimeMillis();
	}

	private static int nowNum = 100;

	private static int minNum = 100;

	private static int maxNum = 999;

	private static long endTimestamp = 0L;

	private static long interval = 1001L;

	/**
	 * 一秒   中生成不同的3位数字
	 * @return
	 */
	public static synchronized String nextThree() {
		long timeGen = timeGen();
		if (timeGen - endTimestamp > interval) {
			endTimestamp = timeGen;
			return String.valueOf(nowNum++);
		} else {
			nowNum++;
			if (nowNum >= maxNum) {
				while (true) {
					if (timeGen() - endTimestamp > interval) {
						endTimestamp = timeGen;
						break;
					}
				}
				nowNum = minNum;
				return String.valueOf(nowNum);
			} else {
				return String.valueOf(nowNum);
			}
		}
	}
}
