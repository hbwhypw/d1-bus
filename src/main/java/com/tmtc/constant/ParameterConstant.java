package com.tmtc.constant;

public class ParameterConstant {
	
	/**
	 * pingpp 管理平台对应的 API key
	 */
	public static String apiKey = "sk_live_enP4WTGKarzDHu58COr9i5OO";
								   
	/**
	 * 私钥
	 */
	public static final String PRIVATE_KEY = "TMTCD1BUSTECHNOLOGYDEPARTMENT";
	/**
	 * 个人端默认公司
	 */
	public static final String C_COMPANY_ID = "686479680425041920";
	/**
	 * 网易公司ID
	 */
	public static final String WANGYI_COMPANY_ID = "689738890101268480";
	
	public static final int DEFAULT_SEX = 1303;
	/**
	 * 默认头像
	 */
	public static final String DEFAULT_PORTRAIT = "201601/1452479655749.jpg";
	/**
	 * 默认昵称
	 */
	public static final String DEFAULT_NICKNAME = "昵称";
	/**
	 * 百度ID
	 */
	public static final String BAIDU = "666453794363678720";
	/**
	 * 注册来源（PC）
	 */
	public static final int REGISTER_SOURCE_PC = 1501;
	/**
	 * 注册来源（安卓）
	 */
	public static final int REGISTER_SOURCE_ANDROID = 1502;
	/**
	 * 注册来源（IOS）
	 */
	public static final int REGISTER_SOURCE_IOS = 1503;
	/**
	 * 注册来源（企业后台）
	 */
	public static final int REGISTER_SOURCE_COMPANY = 1504;
	/**
	 * 注册来源（微信）
	 */
	public static final int REGISTER_SOURCE_WECHAT = 1505;
	/**
	 * 是否有效（有效）
	 */
	public static final int IS_CHECK = 1;
	
	/**
	 * 是否有效（无效）
	 */
	public static final int IS_NOT_CHECK = 0;
	
	/**
	 * 用户锁定
	 */
	public static final int IS_TWO_CHECK = 2;
	
	/**
	 * 是   1
	 */
	public static final int TRUE = 1;
	
	/**
	 * 否   0
	 */
	public static final int FALSE = 0;
	
	
	
	/**
	 * 行驶状态(未发车)
	 */
	public static final int CAR_STATUS_NO = 2601;
	/**
	 * 行驶状态(行驶中)
	 */
	public static final int CAR_STATUS_IS = 2602;
	/**
	 * 行驶状态(已结束)
	 */
	public static final int CAR_STATUS_END = 2603;
	/**
	 * 所属公司（TMTC）
	 */
	public static final int FROM_COMPANY_TMTC = 2001;
	/**
	 * 所属公司（加盟公司）
	 */
	public static final int FROM_COMPANY_JOIN = 2002;
	/**
	 * 是否根节点（是）
	 */
	public static final int IS_ROOT = 1;
	/**
	 * 是否根节点（否）
	 */
	public static final int NOT_ROOT = 0;
	/**
	 * 是否子节点（是）
	 */
	public static final int IS_SUB = 1;
	/**
	 * 是否子节点（否）
	 */
	public static final int NOT_SUB = 0;
	/**
	 * 是否可操作（是）
	 */
	public static final int IS_AVAILABLE = 1;
	/**
	 * 是否可操作（否）
	 */
	public static final int NOT_AVAILABLE = 0;
	/**
	 * 广告类型（启动页）
	 */
	public static final int A_ADPIC_TYPE = 1901;
	/**
	 * 广告类型（banner）
	 */
	public static final int B_ADPIC_TYPE = 1902;
	/**
	 * 广告类型（活动）
	 */
	public static final int ADPIC_TYPE_ACTIVITY = 1907;
	
	/**
	 * 锁定次数
	 */
	public static final int LOCK_CNT = 5;
	
	/**
	 * 未出行订单
	 */
	public static final int ORDER_STATUS_NOT = 2801;
	
	/**
	 * 已完成订单
	 */
	public static final int ORDER_STATUS = 2802;
	
	/**
	 * 用户取消订单
	 */
	public static final int ORDER_STATUS_USER_CANCEL = 2803;
	
	/**
	 * 管理员取消订单
	 */
	public static final int ORDER_STATUS_ADMIN_CANCEL = 2804;
	/**
	 * 未付款订单
	 */
	public static final int ORDER_STATUS_NOT_PAY = 2805;
	/**
	 * 过期订单
	 */
	public static final int ORDER_STATUS_DATED = 2806;
	
	/**
	 * 是否处理(已处理)
	 */
	public static final int IS_HANDLE = 1;
	
	/**
	 * 是否处理(未处理)
	 */
	public static final int NOT_HANDLE = 0;
	
	/**
	 * 验证码失效时间（5分钟）
	 */
//	public static final long TIME = 30L * 24L * 60L * 60L * 1000L; // 测试时间
	 public static final long TIME = 5 * 60 * 1000; // 上线时间

	/**
	 * 用户类型 集团用户
	 */
	public static final int USER_TYPE_COMPANY = 1401;

	/**
	 * 用户类型 学生用户
	 */
	public static final int USER_TYPE_STUDENT = 1402;

	/**
	 * 用户类型 普通用户
	 */
	public static final int USER_TYPE_NORMAL = 1403;

	/**
	 * 用户类型 家长用户
	 */
	public static final int USER_TYPE_PARENTS = 1404;

	/**
	 * 用户类型 司机用户
	 */
	public static final int USER_TYPE_DRIVER = 1405;

	/**
	 * 用户类型 企业付费用户
	 */
	public static final int USER_TYPE_COMPANY_NORMAL_100 = 1406;
	
	public static final int USER_TYPE_COMPANY_NORMAL_20 = 1407;
	
	/**
	 * 排序默认值
	 */
	public static final int SORT_DEFALUT = 0;
	
	/**
	 * 未行驶
	 */
	public static final int NOT_DRIVING = 2601;
	
	/**
	 * 行驶中
	 */
	public static final int DRIVING = 2602;
	
	/**
	 * 结束行驶
	 */
	public static final int END_DRIVING = 2603;
	
	/**
	 * 积分领取
	 */
	public static final int EXP_GET = 1722;
	
	/**
	 * 刷卡领取积分
	 */
	public static final int EXP_CRAD = 1701;
	
	/**
	 * 已经使用
	 */
	public static final int USE = 1;
	
	/**
	 * 没有使用
	 */
	public static final int NOT_USE = 0;
	/**
	 * 积分销售
	 */
	public static final int SELL_TYPE_EXP = 3001;
	/**
	 * 商城销售
	 */
	public static final int SELL_TYPE_SHOP = 3002;
	/**
	 * 商城首页banner
	 */
	public static final int ADPIC_TYPE_MAIN_BANNER = 1903;
	/**
	 * 长条产品广告
	 */
	public static final int ADPIC_TYPE_LONG = 1904;
	/**
	 * 方块产品广告
	 */
	public static final int ADPIC_TYPE_SQUARE = 1905;
	
	/**
	 * 商品订单未付款
	 */
	public static final int SHOP_ORDER_NOT_PAY = 3401;
	
	/**
	 * 商品订单已付款
	 */
	public static final int SHOP_ORDER_PAY = 3402;

	/**
	 * 支付方式-支付宝
	 */
	public static final int PAY_TYPE_ALIPAY = 3501;

	/**
	 * 支付方式-微信
	 */
	public static final int PAY_TYPE_WECHAR = 3502;

	/**
	 * 支付方式-银联
	 */
	public static final int PAY_TYPE_BACK = 3503;
	
	/**
	 * 支付方式-余额
	 */
	public static final int PAY_TYPE_BALANCE = 3504;
	
	/**
	 * 客户取消订单
	 */
	public static final int C_CANCEL_SHOP_ORDER = 3403;
	
	/**
	 * 管理员取消订单
	 */
	public static final int A_CANCEL_SHOP_ORDER = 3404;
	
	/**
	 * 订单过期
	 */
	public static final int SHOP_ORDER_OVER = 3405;
	
	/**
	 * 运费
	 */
	public static final double TRANSPORT_PAY = 0D;
	
	/**
	 * 默认公司
	 */
	public static final String COMPANY_ID = "663289712357810176";
	/**
	 * 上车
	 */
	public static final Integer USER_STATUS_GETON = 3601;
	/**
	 * 下车
	 */
	public static final Integer USER_STATUS_GETOFF = 3602;
	/**
	 * 线路下单获取积分
	 */
	public static final Integer ORDER_EXP = 1;
	/**
	 * 扫码直接生成状态为已完成订单
	 */
	public static final Integer LINE_ORDER_TYPE_DIRECT = 3701;
	/**
	 * 生成订单为为出行订单，切需要付费
	 */
	public static final Integer LINE_ORDER_TYPE_PAY = 3702;
	
	/**
	 * 刷卡直接生成的订单，已完成订单
	 */
	public static final Integer LINE_ORDER_TYPE_PAY_CARD_NUM = 3703;
	
	/**
	 * 已付费扫描
	 */
	public static final Integer SCAN_TYPE_FINISH = 3801;
	/**
	 * 未付费扫描
	 */
	public static final Integer SCAN_TYPE_NO = 3802;
	
//	public static final double SCOPE = 0.05;
//	/**
//	 * (车辆自动到站)站点误差范围
//	 */
//	public static final double SCOPE_STATION = 0.005;
	/**
	 * 企业用户，直接到扫码页面/企业付费用户，已经支付还未上车，直接跳到扫码页面
	 */
	public static final Integer SCAN_STATUS_SCAN = 1;
	/**
	 * 企业付费用户，没下单，跳到支付页面
	 */
	public static final Integer SCAN_STATUS_PAY = 2;
	/**
	 * 总座位数跟乘车座位数的差距
	 */
	public static final Integer SEATGAP = 2;
	/**
	 * 北京的code值
	 */
	public static final Integer BEIJING = 1001;
	/**
	 * 深圳的code值
	 */
	public static final Integer SHENZHEN = 1002;
	/**
	 * 管理员重置密码
	 */
	public static final String RESERTPW = "123456";
	/**
	 * 关于我们
	 */
	public static final String ABOUT_OUR = "3";
	public static final String ABOUT_OUR_URL = "http://192.168.2.103:8080/app/aboutOur.jsp";
	/**
	 * 奖励活动
	 */
	public static final String ACTIVITY = "2";
	public static final String ACTIVITY_URL = "http://192.168.2.103:8080/app/activity.jsp";
	/**
	 * 产品介绍
	 */
	public static final String PRODUCT_INTRODUCE = "1";
	public static final String PRODUCT_INTRODUCE_URL = "http://192.168.2.103:8080/app/productIntroduce.jsp";
	/**
	 * 客户服务
	 */
	public static final String CLIENT = "4";
	public static final String CLIENT_URL = "http://192.168.2.103:8080/app/client.jsp";
	
	/**
	 * 充值状态未付款
	 */
	public static final int CZ_ORDER_STATUS_NULL = 4001;
	/**
	 * 充值状态已完成
	 */
	public static final int CZ_ORDER_STATUS_FINISH = 4002;
	/**
	 * 充值状态过期
	 */
	public static final int CZ_ORDER_STATUS_OVER = 4003;
	/**
	 * 卡激活时间
	 */
	public static final int INVOKE_TIME = 30;
	/**
	 * 可提前7天激活
	 */
	public static final int VALID_TIME = 7;
	/**
	 * 默认性别
	 */
	public static final int DEDAULT_SEX = 1303;
    /**
     * 万科刷卡用户 线路优惠价 300分
     */
	public static final int PUSH_CARD_PRICE = 300;
	/**
	 * link_num默认前面加
	 */
	public static final String LINK_NUM = "d1-bus";
	
}
