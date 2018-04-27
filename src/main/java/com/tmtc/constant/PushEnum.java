package com.tmtc.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Function:
 * @auther: hbwhypw
 * Date: 2015/10/23 15:02
 */
public class PushEnum {
    public static class DeviceType {
        public static final Integer WEB = 1;
        public static final Integer PC = 2;
        public static final Integer Android =3;
        public static final Integer IOS =4;

        public static Map<Integer, String> desc = new HashMap<Integer, String>();
        static {
            desc.put(WEB, "网页");
            desc.put(PC, "电脑");
            desc.put(Android, "Android");
            desc.put(IOS, "ios");
        }
        public static String desc(Integer value) {
            return getDesc(desc,value);
        }
    }

    public static class Pushable {
        public static final Integer IS = 0;
        public static final Integer NOT = 1;
        public static Map<Integer, String> desc = new HashMap<Integer, String>();

        static {
            desc.put(IS, "可推送");
            desc.put(NOT, "不可推送");
        }
    }

    private static String getDesc(Map<Integer, String> desc, Integer value) {
        if(value == null){
            return null;
        }
        if (!desc.containsKey(value)) {
            throw new IllegalArgumentException(value + " doesn't exist!");
        }
        return desc.get(value);
    }
}
