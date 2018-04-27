package com.tmtc.controller;

import com.tmtc.frame.BasePage;
import com.tmtc.frame.JsonResult;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * Created:  hbwhypw
 * Date: 2015/9/23 10:04
 * Function:
 */
public class BaseController extends BasePage {

    public static final String ADD = "add";
    public static final String UPDATE = "update";
    /**
     * 绑定错误处理
     * @param bindingResult 绑定结果
     * @return 异常信息
     */
    protected JsonResult handlerErrors(BindingResult bindingResult){
        List<ObjectError> ObjectError = bindingResult.getAllErrors();
        StringBuilder errorString = new StringBuilder();
        for (ObjectError objectError : ObjectError) {
            errorString.append(objectError.getDefaultMessage()).append(" \n");
        }
        return new JsonResult(-1, errorString.toString(), null);
    }
}
