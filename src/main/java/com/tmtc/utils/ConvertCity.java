package com.tmtc.utils;

import com.tmtc.constant.ParameterConstant;

public class ConvertCity {

	
	public static int gerCity_code(String cityName) {
		
		if(0 == VerificationUtil.length(cityName)){
			return ParameterConstant.BEIJING;
		}
		if(2 != cityName.length()){
			cityName = cityName.substring(0,2);
		}
		
		if("深圳".equals(cityName)){
			return ParameterConstant.SHENZHEN;
		}else{
			return ParameterConstant.BEIJING;
		}
	}
}
