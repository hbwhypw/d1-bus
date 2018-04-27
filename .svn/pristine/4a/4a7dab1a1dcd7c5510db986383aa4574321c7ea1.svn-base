package com.tmtc.utils;

import com.tmtc.frame.ServiceExceptionEnum;
import com.tmtc.frame.ServiceRuntimeException;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Creater: hbwhypw
 * Date: 2015/8/22 14:44
 * Function: 属性文件工具类
 */
public class PropertiesUtil {
	
	private static final String MESSAGE = "message";
	
	private static final String SYSTEM = "system";
	
	private static final String STATIC_FILE = "staticFile";
	
    /**
     * 获取属性文件资源
     * @param propertyName 属性文件名
     * @return
     */
    private static ResourceBundle getProperty(String propertyName) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(propertyName);
        return resourceBundle;
    }

    /**
     * 获取属性文件中属性的值
     * @param propertyName 属性文件名
     * @param key 属性名称
     * @return
     */
    public static String getPropertyValue(String propertyName, String key) {
        try {
            String value = getProperty(propertyName).getString(key);
            return value == null ? null : new String(value.getBytes("ISO8859-1"), "utf-8");
        } catch (IOException e) {
            throw new ServiceRuntimeException(ServiceExceptionEnum.READ_CONFIG_ERROR.message, ServiceExceptionEnum.READ_CONFIG_ERROR.code);
        }
    }
    
    public static String getMessage(String key){
    	return getPropertyValue(MESSAGE,key);
    }
    
    public static String getSystem(String key){
    	return getPropertyValue(SYSTEM,key);
    }
    
    public static String getStaticFile(String key){
    	return getPropertyValue(STATIC_FILE,key);
    }
    
    

}
