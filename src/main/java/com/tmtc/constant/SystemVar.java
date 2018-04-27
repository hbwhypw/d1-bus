package com.tmtc.constant;

import com.tmtc.utils.PropertiesUtil;

/**
 * Created:  hbwhypw
 * Date: 2015/10/19 14:55
 * Function:
 */
public class SystemVar {
    private static String getSys(String key) {
        return PropertiesUtil.getSystem(key);
    }

    private static String getFile(String key) {
        return PropertiesUtil.getStaticFile(key);
    }

    /***
     * 图片网站 根地址
     */
    public static final String SERVER_IMG_URL = getSys("ServerImgUrl");
    /**
     * 图片本地存储 根地址
     */
    public static final String LOCAL_IMG_URL = getSys("LocalImgUrl");
    /**
     * ios 访问令牌
     */
    public static final String IOS_APIKEY = getSys("IOS_apiKey");
    /**
     * ios 令牌密钥
     */
    public static final String IOS_SECRETKEY = getSys("IOS_secretKey");
    /**
     * android 访问令牌
     */
    public static final String ANDROID_APIKEY = getSys("Android_apiKey");

    /**
     * android 令牌密钥
     */
    public static final String ANDROID_SECRETKEY = getSys("Android_secretKey");

    /**
     * driver 访问令牌
     */
    public static final String DRIVER_APIKEY = getSys("Driver_apiKey");

    /**
     * driver 令牌密钥
     */
    public static final String DRIVER_SECRETKEY = getSys("Driver_secretKey");

    /**
     * 公司Logo
     */
    public static final String COMPANY_LOGO = getFile("img.company.logo");
    /**
     * 公司营业执照
     */
    public static final String COMPANY_LICENSE = getFile("img.company.license");

    /**
     * 用户二维码
     */
    public static final String USER_QR_CODE = getFile("img.user.qr_code");
    /**
     * 用户头像
     */
    public static final String USER_PORTRAIT = getFile("img.user.portrait");
    /**
     * 用户背景
     */
    public static final String USER_BACKGROUND = getFile("img.user.background");
    /**
     * 车辆照片
     */
    public static final String CAR_PIC = getFile("img.car.car_pic");
    /**
     * 车辆行驶本照片
     */
    public static final String REGISTRATION_PIC = getFile("img.car.car_registration_pic");
    /**
     * 外观照片
     */
    public static final String APPEARANCE_PIC = getFile("img.car.appearance_pic");
    /**
     * 内饰照片
     */
    public static final String TRIM_PIC = getFile("img.car.trim_pic");
    /**
     * 广告图片
     */
    public static final String PIC = getFile("img.adPic.pic");
    /**
     * 驾照图片
     */
    public static final String LICENSE_PIC = getFile("img.driver.license_pic");
    /**
     * 司机头像
     */
    public static final String PHOTO = getFile("img.driver.photo");
    /**
     * 司机背景图片
     */
    public static final String BG_PIC = getFile("img.driver.bg_pic");
    /**
     * 产品图片
     */
    public static final String PRO_PICTURE = getFile("img.product.pro_picture");
    /**
     * 产品图片
     */
    public static final String USER_IMPORT = getFile("excel.user.import");
    /**
     * 产品类型图片
     */
    public static final String PRODUCT_TYPE = getFile("img.productType");
    /**
     * 加减误差范围
     */
    public static final double DISTANCE = Double.valueOf(getSys("distance")); 

//    /**
//     * 票价
//     */
//    public static final int  PRICE   =  Integer.valueOf(getSys("price"));
    
    /**
     * 用户关联账号前缀
     */
    public static final String LINK_NUM = getSys("link_num");
    
    /**
     * 兑吧key
     */
    public static final String DUI_BA_KEY = getSys("duiba.key");
    
    /**
     * 兑吧secret
     */
    public static final String DUI_BA_SECRET = getSys("duiba.secret");
    /**
     * 活动访问路径
     */
    public static final String ACTIVE_SERVER_URL = getSys("Active_Server_url");

}
