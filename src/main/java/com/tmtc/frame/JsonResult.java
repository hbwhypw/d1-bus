package com.tmtc.frame;


import com.tmtc.utils.PropertiesUtil;

/**
 * @author ypw
 */
public class JsonResult {
    private int code;
    private String msg;
    private Object data;
    public static final String SUCCESS = PropertiesUtil.getPropertyValue("system","json.message.success");
    public static final String FAIL = PropertiesUtil.getPropertyValue("system","json.message.fail");

    public JsonResult() {
        code = 1;
        msg = SUCCESS;
        data = null;
    }

    public JsonResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
