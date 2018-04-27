package com.tmtc.utils;

import java.math.BigDecimal;
import java.math.MathContext;

import com.tmtc.constant.SystemVar;

public class XYCalculate {

	/**
	 * 
	 * @param x
	 *            x坐标
	 * @param y
	 *            y坐标
	 * @return xy数组，xy[0] 代表x—min,xy[1] x-max,xy[2] y-min,xy[3] y-max
	 */
	public static double[] xyCalculate(Double x, Double y) throws Exception {
		BigDecimal _x = new BigDecimal(x);
		BigDecimal _y = new BigDecimal(y);
		double[] xy = new double[4];
		BigDecimal distance = new BigDecimal(SystemVar.DISTANCE);
		xy[0] = _x.subtract(distance, MathContext.DECIMAL64).doubleValue();
		xy[1] = _x.add(distance, MathContext.DECIMAL64).doubleValue();
		xy[2] = _y.subtract(distance, MathContext.DECIMAL64).doubleValue();
		xy[3] = _y.add(distance, MathContext.DECIMAL64).doubleValue();
		return xy;
	}

}
